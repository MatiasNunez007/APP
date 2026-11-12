package interfaz;

import java.util.Scanner;

public class Validacion {
    private static Scanner sc = new Scanner (System.in);

    public static String leerString(String mensaje){
        String nombre;
        System.out.print(mensaje);
        nombre = sc.nextLine();
        while(nombre == null || nombre.trim().isEmpty()){
            System.out.println("Entrada no válida. Inténtelo de nuevo.");
            System.out.print(mensaje);
            nombre = sc.nextLine();
        }
        return nombre;
    }
    //Leer un int validando que no sean letras
    public static int leerInt(String mensaje){
        while(!sc.hasNextInt()){
            System.out.println("Entrada no válida. Por favor, escriba un número entero.");
            if(sc.nextLine().trim().isEmpty() && sc.hasNextLine()){
                sc.nextLine();
            }
            System.out.print(mensaje);
        }
        return sc.nextInt();
    }

    //Leer un double validando que no sean letras
    public static double leerDouble(String mensaje){
        while(!sc.hasNextDouble()){
            System.out.println("Entrada no válida. Por favor, escriba un valor numérico.");
            if(sc.nextLine().trim().isEmpty() && sc.hasNextLine()){
                sc.nextLine();
            }
            System.out.print(mensaje);
        }
        return sc.nextDouble();
    }

    //-------------------- DOUBLES ---------------------//

    //Leer double positivo
    public static double leerDoublePositivo(String mensaje){
        double dato;
        System.out.print(mensaje);
        dato = leerDouble(mensaje);
        while(dato <= 0){
            System.out.println("Entrada no válida. El número debe ser positivo, inténtelo de nuevo.");
            System.out.println(mensaje);
            dato = leerDouble(mensaje);

        }
        sc.nextLine();
        return dato;
    }

    //Leer double mayor que algun valor
    public static double leerDoubleMayor(String mensaje, double base){
        double dato;
        System.out.print(mensaje + "(Superior a " + base + "): ");
        dato = leerDouble(mensaje + "(Superior a " + base + "): ");
        while(dato <= base){
            System.out.println("El número ingresado no supera a " + base + ". Inténtelo de nuevo.");
            System.out.print(mensaje + "(Superior a " + base + "): ");
            dato = leerDouble(mensaje + "(Superior a " + base + "): ");

        }
        sc.nextLine();
        return dato;
    }
    //Leer double mayor o igual que algun valor
    public static double leerDoubleMayorIgual(String mensaje, double base){
        double dato;
        System.out.print(mensaje + "(Mínimo " + base + "): ");
        dato = leerDouble(mensaje + "(Mínimo " + base + "): ");
        while(dato < base){
            System.out.println("El número ingresado debe ser al menos " + base + ". Inténtelo de nuevo.");
            System.out.print(mensaje + "(Mínimo " + base + ")");
            dato = leerDouble(mensaje + "(Mínimo " + base + ")");

        }
        sc.nextLine();
        return dato;
    }

    //Leer double menor que algun valor
    public static double leerDoubleMenor(String mensaje, double techo){
        double dato;
        System.out.print(mensaje + "(Inferior a " + techo + "): ");
        dato = leerDouble(mensaje + "(Inferior a " + techo + "): ");
        while(dato >= techo){
            System.out.println("El número ingresado debe ser menor a " + techo + ". Inténtelo de nuevo.");
            System.out.print(mensaje + "(Inferior a " + techo + "): ");
            dato = leerDouble(mensaje + "(Inferior a " + techo + "): ");

        }
        sc.nextLine();
        return dato;
    }
    //Leer double menor o igual que algun valor
    public static double leerDoubleMenorIgual(String mensaje, double techo){
        double dato;
        System.out.print(mensaje + "(Máximo " + techo + "): ");
        dato = leerDouble(mensaje + "(Máximo " + techo + "): ");
        while(dato > techo){
            System.out.println("El número ingresado no puede superar " + techo + ". Inténtelo de nuevo.");
            System.out.print(mensaje + "(Máximo " + techo + "): ");
            dato = leerDouble(mensaje + "(Máximo " + techo + "): ");

        }
        sc.nextLine();
        return dato;
    }

    //Leer double dentro de un rango
    public static double leerDoubleRango(String mensaje, double base, double techo){
        double dato;
        System.out.print(mensaje + "(Rango de " + base + " a " + techo + "): ");
        dato = leerDouble(mensaje + "(Rango de " + base + " a " + techo + "): ");
        while(dato < base  || dato > techo){
            System.out.println("El número está fuera del rango permitido (" + base + " a " + techo + "). Inténtelo de nuevo.");
            System.out.print(mensaje + "(Rango de " + base + " a " + techo + "): ");
            dato = leerDouble(mensaje + "(Rango de " + base + " a " + techo + "): ");
        }
        sc.nextLine();
        return dato;
    }

    //-------------------- ENTEROS ---------------------//

    //Leer int positivo
    public static int leerIntPositivo(String mensaje){
        int dato;
        System.out.print(mensaje);
        dato = leerInt(mensaje);
        while(dato <= 0){
            System.out.println("Entrada no válida. El número debe ser positivo, inténtelo de nuevo.");
            System.out.print(mensaje);
            dato = leerInt(mensaje);

        }
        sc.nextLine();
        return dato;
    }

    //Leer int mayor que algun valor
    public static int leerIntMayor(String mensaje, int base){
        int dato;
        System.out.print(mensaje + "(Superior a " + base + "): ");
        dato = leerInt(mensaje + "(Superior a " + base + "): ");
        while(dato <= base){
            System.out.println("El número ingresado no supera a " + base + ". Inténtelo de nuevo.");
            System.out.print(mensaje + "(Superior a " + base + "): ");
            dato = leerInt(mensaje + "(Superior a " + base + "): ");

        }
        sc.nextLine();
        return dato;
    }
    //Leer int mayor o igual que algun valor
    public static int leerIntMayorIgual(String mensaje, int base){
        int dato;
        System.out.print(mensaje + "(Mínimo " + base + "): ");
        dato = leerInt(mensaje + "(Mínimo " + base + "): ");
        while(dato < base){
            System.out.println("El número ingresado debe ser al menos " + base + ". Inténtelo de nuevo.");
            System.out.print(mensaje + "(Mínimo " + base + "): ");
            dato = leerInt(mensaje + "(Mínimo " + base + "): ");

        }
        sc.nextLine();
        return dato;
    }

    //Leer int menor que algun valor
    public static int leerIntMenor(String mensaje, int techo){
        int dato;
        System.out.print(mensaje + "(Inferior a " + techo + "): ");
        dato = leerInt(mensaje + "(Inferior a " + techo + "): ");
        while(dato >= techo){
            System.out.println("El número ingresado debe ser menor a " + techo + ". Inténtelo de nuevo.");
            System.out.print(mensaje + "(Inferior a " + techo + "): ");
            dato = leerInt(mensaje + "(Inferior a " + techo + "): ");

        }
        sc.nextLine();
        return dato;
    }
    //Leer int menor o igual que algun valor
    public static int leerIntMenorIgual(String mensaje, int techo){
        int dato;
        System.out.print(mensaje + "(Máximo " + techo + "): ");
        dato = leerInt(mensaje + "(Máximo " + techo + "): ");
        while(dato > techo){
            System.out.println("El número ingresado no puede superar " + techo + ". Inténtelo de nuevo.");
            System.out.print(mensaje + "(Máximo " + techo + "): ");
            dato = leerInt(mensaje + "(Máximo " + techo + "): ");

        }
        sc.nextLine();
        return dato;
    }

    //Leer int dentro de un rango
    public static int leerIntRango(String mensaje, int base, int techo){
        int dato;
        System.out.print(mensaje + "(Rango de " + base + " a " + techo + "): ");
        dato = leerInt(mensaje + "(Rango de " + base + " a " + techo + "): ");
        while(dato < base  || dato > techo){
            System.out.println("El número está fuera del rango permitido (" + base + " a " + techo + "). Inténtelo de nuevo.");
            System.out.print(mensaje + "(Rango de " + base + " a " + techo + "): ");
            dato = leerInt(mensaje + "(Rango de " + base + " a " + techo + "): ");
        }
        sc.nextLine();
        return dato;
    }

    //Enteros y doubles: leer numero positivo-mayor que algo-mayor/igual - menor que algo-menor/igual-leer dentro de un rango
}