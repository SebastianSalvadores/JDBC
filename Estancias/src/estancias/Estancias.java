/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias;

import estancias.entidades.Casa;
import estancias.entidades.Comentario;
import estancias.entidades.Estancia;
import estancias.entidades.Familia;
import estancias.servicios.CasaService;
import estancias.servicios.ComentarioService;
import estancias.servicios.EstanciaService;
import estancias.servicios.FamiliaService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class Estancias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        FamiliaService familiaService = new FamiliaService();
        CasaService casaService = new CasaService();
        EstanciaService estanciaService = new EstanciaService();
        ComentarioService comentarioService = new ComentarioService();
        ArrayList<Familia> familias;
        ArrayList<Casa> casas;
        ArrayList<Estancia> estancias;

        int opc = 0;
        do {
            System.out.println("SQL - Estancias en el Exterior - MENU"
                    + "\n1. Listar familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años."
                    + "\n2. Listar casas para el periodo entre el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido."
                    + "\n3. Listar familias por email (Hotmail)"
                    + "\n4. Listar casas for fecha y cantidad de dias."
                    + "\n5. Listar clientes que realizaron una estancia y la descripción de la casa donde la realizaron."
                    + "\n6. Listar estancias que han sido reservadas por un cliente, mostrar el nombre, país y ciudad del cliente y información de la casa"
                    + "\n7. Actualizar y listar precios devaluacion en el Reino Unido."
                    + "\n8. Listar cantidad de casas por país."
                    + "\n9. Listar casas del Reino Unido de las que se ha dicho de ellas que están ‘limpias’."
                    + "\n10. Insertar nuevos datos en la tabla estancias."
                    + "\n11. Salir");
            try{
                System.out.println("Ingrese una opcion:");
                opc = leer.nextInt();
            }catch(InputMismatchException ime){
                
            }
            switch (opc) {
                case 1:
                    familias = familiaService.listarA();
                    for (Familia familia : familias) {
                        System.out.println(familia.toString());
                    }
                    break;

                case 2:
                    casas = casaService.listarB();
                    for (Casa casa : casas) {
                        System.out.println(casa);
                    }
                    break;

                case 3:
                    familias = familiaService.listarC();
                    for (Familia familia : familias) {
                        System.out.println(familia.toString());
                    }
                    break;

                case 4:
                    System.out.println("Ingrese fecha de busqueda.");
                    System.out.println("Ingrese dia: ");
                    int dia = leer.nextInt();
                    System.out.println("Ingrese mes: ");
                    int mes = leer.nextInt();
                    System.out.println("Ingrese año: ");
                    int anio = leer.nextInt();
                    LocalDate fecha = LocalDate.of(anio, mes, dia);
                    System.out.println("Ingrese cantidad de dias:");
                    int cantDias = leer.nextInt();
                    casas = casaService.listarD(fecha, cantDias);
                    for (Casa casa : casas) {
                        System.out.println(casa.toString());
                    }
                    break;

                case 5:
                    estancias = estanciaService.listarE();
                    for (Estancia estancia : estancias) {
                        System.out.println(estancia.getCliente().toString() + ", " + estancia.getCasa().toString());
                    }
                    break;

                case 6:
                    estancias = estanciaService.listarF();
                    for (Estancia estancia : estancias) {
                        System.out.println(estancia.toString());
                    }
                    break;

                case 7:
                    casaService.modificarPrecios();
                    casas = casaService.listarCasasUK();
                    for (Casa casa : casas) {
                        System.out.println(casa.toString());
                    }
                    break;

                case 8:
                    casaService.contarCasasPorPais();
                    break;

                case 9:
                    ArrayList<Comentario> comentarios = comentarioService.listarI();
                    for (Comentario comentario : comentarios) {
                        System.out.println(comentario.toString());
                    }
                    break;

                case 10:
                    estanciaService.guardarEstancia();
                    break;
                    
                case 11:
                    break;
                    
                default:
                    System.out.println("Opcion incorrecta.");
            }
            if (opc != 11) {
                System.out.println("\nPresione enter para continuar.");
                leer.next();
            }
        } while (opc != 11);
    }

}
