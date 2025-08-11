import java.util.Scanner;

public class SistemaEvaluacion {

    // Función para calcular el promedio
    public static double calcularPromedio(double[] notas) {
        double suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma = suma + notas[i];
        }
        double promedio = suma / notas.length;
        return promedio;
    }

    // Función para obtener literal según el promedio
    public static char obtenerLiteral(double promedio) {
        if (promedio >= 90) {
            return 'A';
        } else if (promedio >= 80) {
            return 'B';
        } else if (promedio >= 70) {
            return 'C';
        } else if (promedio >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    // Función para saber si aprueba
    public static boolean estaAprobado(char literal) {
        if (literal == 'A' || literal == 'B' || literal == 'C') {
            return true;
        } else {
            return false; // D y F no aprueban
        }
    }

    // Procedimiento para mostrar el resultado
    public static void mostrarResultado(String nombre, double[] notas) {
        double promedio = calcularPromedio(notas);
        char literal = obtenerLiteral(promedio);
        boolean aprobado = estaAprobado(literal);

        System.out.println("\nEstudiante: " + nombre);
        System.out.print("Notas: [");
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i]);
            if (i < notas.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.printf("Promedio: %.2f\n", promedio);
        System.out.println("Literal: " + literal);

        if (aprobado) {
            System.out.println("Resultado: Aprobado ");
        } else {
            System.out.println("Resultado: Reprobado ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Preguntar cuántos estudiantes hay
        System.out.print("Ingrese la cantidad de estudiantes: ");
        int cantidadEstudiantes = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        String[] nombres = new String[cantidadEstudiantes];
        double[][] todasNotas = new double[cantidadEstudiantes][]; // arreglo doble

        // Ingresar datos de cada estudiante
        for (int i = 0; i < cantidadEstudiantes; i++) {
            System.out.println("\nEstudiante #" + (i + 1));
            System.out.print("Ingrese el nombre: ");
            nombres[i] = sc.nextLine();

            // este número es la CANTIDAD DE NOTAS que va a ingresar
            System.out.print("Ingrese CUÁNTAS notas va a ingresar para este estudiante: ");
            int cantidadNotas = sc.nextInt();

            todasNotas[i] = new double[cantidadNotas];
            for (int j = 0; j < cantidadNotas; j++) {
                System.out.print("Ingrese la nota #" + (j + 1) + ": ");
                todasNotas[i][j] = sc.nextDouble();
            }
            sc.nextLine(); // limpiar buffer
        }

        // Mostrar resultados
        System.out.println("\n--- RESULTADOS ---");
        for (int i = 0; i < cantidadEstudiantes; i++) {
            mostrarResultado(nombres[i], todasNotas[i]);
        }

        sc.close();
    }
}
