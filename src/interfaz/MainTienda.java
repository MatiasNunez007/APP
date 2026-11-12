package interfaz;

import modelo.AppStore;
import modelo.Juego;

import javax.swing.*;
import java.util.Scanner;

public class MainTienda {
    private static Scanner sc = new Scanner(System.in);
    private static AppStore tienda = new AppStore();

    public static void main() {
        int opc;
        tienda.inicializarDatos();
        do {
            menu();
            opc = Validacion.leerIntRango("> Seleccione una opción del menú: ", 1, 7);
            //opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1: { //INGRESAR
                    ingresarJuego();
                }
                break;

                case 2: { //MOSTRAR
                    imprimirJuegos();
                }
                break;

                case 3: {// BUSCAR
                    buscarJuego();
                }
                break;

                case 4: { //COMPRAR
                    comprar();
                }
                break;

                case 5: { //VENDER
                    vender();
                }
                break;

                case 6: { //JUEGO MAS VENDIDO
                    mostrarJuegoMasVendido();
                }
                break;

                case 7: { //SALIR
                    System.out.println("¡Muchas gracias por utilizar la tienda! Cerrando el sistema...");
                }
                break;

                default:
                    System.out.println("[!] La opción ingresada no es válida.");
            }


        } while (opc != 7);
        sc.close();

    }

    //------------------------- METODOS ----------------------//

    public static void menu() {
        System.out.println("========== Tienda AppStore UDLA ==========");
        System.out.println("1. Registrar nuevo juego");
        System.out.println("2. Listar todos los juegos");
        System.out.println("3. Consultar un juego");
        System.out.println("4. Realizar compra");
        System.out.println("5. Realizar venta");
        System.out.println("6. Ver juego con más ventas");
        System.out.println("7. Salir del programa");
    }
    public static void ingresarJuego() {
        System.out.println("======= Registro de datos del juego =======");
        if (tienda.estaLlena()) {
            JOptionPane.showMessageDialog(null, "El catálogo de la tienda está lleno. No se pueden registrar más juegos.");
            return;
        }
        String nombre = Validacion.leerString("Escriba el nombre del juego (obligatorio): ");
        if (tienda.buscarJuego(nombre) != null) {
            JOptionPane.showMessageDialog(null, "Ya se encuentra registrado un juego llamado: " + nombre);
            return;
        }
        String categoria = Validacion.leerString("Escriba la categoría del juego (obligatorio): ");
        int tamanio = Validacion.leerIntPositivo("Escriba el tamaño del juego: ");
        double precio = Validacion.leerDoublePositivo("Escriba el precio del juego: ");
        int licenciasDisponibles = Validacion.leerIntPositivo("Escriba la cantidad inicial de licencias: ");
        if (tienda.agregarJuego(new Juego(nombre, categoria, tamanio, precio, licenciasDisponibles))) {
            JOptionPane.showMessageDialog(null, "El juego se ha registrado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error: no se pudo registrar el juego.");
        }
    }

    public static void imprimirJuegos() {
        Juego juegos[] = tienda.getJuegos();
        if (juegos[0] == null) {
            System.out.println("No se encontraron juegos registrados.");
            return;
        }
        for (Juego j : juegos) {
            if (j != null) {
                System.out.println(j);
            } else {
                System.out.println("Fin de la lista de juegos.");
                return;
            }

        }
    }

    public static void buscarJuego(){
        String nombreBuscado = Validacion.leerString("Escriba el nombre del juego a buscar (obligatorio): ");
        Juego j = tienda.buscarJuego(nombreBuscado);
        if(j != null){
            System.out.println(j);
        }else{
            System.out.println("No existe ningún juego con ese nombre.");
        }
    }

    public static void vender(){
        System.out.println("========= VENTA DE JUEGO =========");
        String nombre = Validacion.leerString("Escriba el nombre del juego a vender (obligatorio): ");
        Juego j = tienda.buscarJuego(nombre);
        if (j == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún juego llamado: " + nombre);
            return;
        }
        if (j.getLicenciasDisponibles() == 0) {
            JOptionPane.showMessageDialog(null, "Actualmente no quedan licencias disponibles para " + j.getNombre() + ".");
            return;
        }
        System.out.println("Cantidad de licencias en stock para " + j.getNombre() + ": " + j.getLicenciasDisponibles());
        int cantidad = Validacion.leerIntPositivo("Escriba cuántas licencias desea vender: ");
        double totalVenta = tienda.vender(nombre, cantidad);
        if(totalVenta == 0){
            JOptionPane.showMessageDialog(null, "No se pudo completar la operación de venta.");
            //System.out.println("No fue posible realizar la venta.");
        }else{
            JOptionPane.showMessageDialog(null, "Venta exitosa: " + cantidad + " licencias de " + nombre + '\n'+
                    "Total recaudado: $" + totalVenta);
            //System.out.println("Usted ha vendido " + cantidad + "licencias del juego " + nombre);
            //System.out.println("Ganancia: $" + totalVenta);
        }
    }

    public static void comprar(){
        System.out.println("========= COMPRA DE JUEGO =========");
        String nombre = Validacion.leerString("Escriba el nombre del juego a comprar (obligatorio): ");
        Juego j = tienda.buscarJuego(nombre);
        if (j == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún juego llamado: " + nombre);
            return;
        }
        int cantidad = Validacion.leerIntPositivo("Escriba cuántas licencias desea comprar: ");
        if(tienda.comprar(nombre, cantidad)){
            JOptionPane.showMessageDialog(null, "Compra exitosa: se adquirieron " + cantidad + " licencias de " + nombre);
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo completar la operación de compra.");
        }

    }

    public static void mostrarJuegoMasVendido() {
        String juegoMasVendido = tienda.juegoMasVendido();
        if(!juegoMasVendido.equals("")){
            JOptionPane.showMessageDialog(null, "El título con mayor cantidad de ventas es: " + juegoMasVendido);
        }else{
            JOptionPane.showMessageDialog(null, "Aún no hay juegos registrados en la tienda.");

        }

    }


}