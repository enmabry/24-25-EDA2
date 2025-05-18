import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la capacidad máxima de alumnos: ");
        int capacidad = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Ingrese la fecha de cierre del acta (ej. 2025-05-18): ");
        String fecha = sc.nextLine();

        Acta acta = new Acta(capacidad, fecha);

        int opcion;

        do {
            System.out.println("\n----- MENÚ -----");
            System.out.println("1. Agregar alumno");
            System.out.println("2. Editar alumno");
            System.out.println("3. Mostrar alumnos");
            System.out.println("4. Cerrar acta");
            System.out.println("5. Verificar integridad");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
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
                    acta.mostrarAlumnos();
                    break;

                case 4:
                    acta.cerrarActa();
                    break;

                case 5:
                    acta.verificarIntegridad();
                    break;

                case 6:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 6);

        sc.close();
    }
}
