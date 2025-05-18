import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("       CREACIÓN DE NUEVA ACTA");
        System.out.println("======================================\n");

        System.out.print("🔢 Ingrese la capacidad máxima de alumnos: ");
        int capacidad = sc.nextInt();
        sc.nextLine(); 

        System.out.print("📅 Ingrese la fecha de cierre del acta (ej. 2025-05-18): ");
        String fecha = sc.nextLine();

        Acta acta = new Acta(capacidad, fecha);
        System.out.println("\n✅ Acta creada exitosamente.\n");

        int opcion;

        do {
            System.out.println("============== MENÚ PRINCIPAL ==============");
            System.out.println("1️⃣  Agregar alumno");
            System.out.println("2️⃣  Editar alumno");
            System.out.println("3️⃣  Mostrar alumnos");
            System.out.println("4️⃣  Cerrar acta");
            System.out.println("5️⃣  Verificar integridad");
            System.out.println("6️⃣  Salir");
            System.out.println("============================================");

            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.println("\n-- Agregar nuevo alumno --");
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Nota: ");
                    int nota = sc.nextInt();
                    sc.nextLine();
                    acta.agregarAlumno(nombre, apellido, nota);
                    break;

                case 2:
                    System.out.println("\n-- Editar alumno --");
                    acta.mostrarAlumnos();
                    System.out.print("Ingrese el número del alumno a editar: ");
                    int indice = sc.nextInt() - 1;
                    sc.nextLine();

                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("Nuevo apellido: ");
                    String nuevoApellido = sc.nextLine();
                    System.out.print("Nueva nota: ");
                    int nuevaNota = sc.nextInt();
                    sc.nextLine();

                    acta.editarAlumno(indice, nuevoNombre, nuevoApellido, nuevaNota);
                    break;

                case 3:
                    System.out.println("\n-- Lista de alumnos --");
                    acta.mostrarAlumnos();
                    break;

                case 4:
                    System.out.println("\n-- Cierre del acta --");
                    acta.cerrarActa();
                    break;

                case 5:
                    System.out.println("\n-- Verificación de integridad --");
                    acta.verificarIntegridad();
                    break;

                case 6:
                    System.out.println("\n👋 Programa finalizado.");
                    break;

                default:
                    System.out.println("⚠️  Opción no válida.");
            }

            System.out.println();

        } while (opcion != 6);

        sc.close();
    }
}
