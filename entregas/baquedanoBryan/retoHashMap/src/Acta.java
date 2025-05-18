public class Acta {
    protected Alumno[] alumnos;
    protected int cantidadAlumnos;
    protected String fechaCierre;
    protected String hashHexOriginal;
    protected boolean cerrada;

    public Acta(int capacidadMaxima, String fechaCierre) {
        alumnos = new Alumno[capacidadMaxima];
        cantidadAlumnos = 0;
        this.fechaCierre = fechaCierre;
        hashHexOriginal = "";
        cerrada = false;
    }

    public String generarStringDatos() {
        String resultado = "";

        for (int i = 0; i < cantidadAlumnos; i++) {
            Alumno a = alumnos[i];
            resultado += a.apellido + "|" + a.nota + ";";
        }

        resultado += fechaCierre;
        return resultado;
    }

    public void agregarAlumno(String nombre, String apellido, int nota) {
        if (cantidadAlumnos < alumnos.length) {
            alumnos[cantidadAlumnos] = new Alumno(nombre, apellido, nota);
            cantidadAlumnos++;
            System.out.println("Alumno agregado correctamente.");
        } else {
            System.out.println("No se puede agregar más alumnos. Capacidad máxima alcanzada.");
        }
    }

    public void editarAlumno(int indice, String nuevoNombre, String nuevoApellido, int nuevaNota) {
        if (indice >= 0 && indice < cantidadAlumnos) {
            alumnos[indice].nombre = nuevoNombre;
            alumnos[indice].apellido = nuevoApellido;
            alumnos[indice].nota = nuevaNota;
            System.out.println("Alumno editado correctamente.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void cerrarActa() {
        if (cerrada) {
            System.out.println("El acta ya está cerrada.");
            return;
        }

        String datos = generarStringDatos();
        int hashNumerico = HashGenerator.generarHashSimple(datos);
        hashHexOriginal = HashGenerator.convertirAHexadecimal(hashNumerico);
        cerrada = true;

        System.out.println("Acta cerrada exitosamente.");
        System.out.println("Código de verificación (hex): " + hashHexOriginal);
    }

    public boolean verificarIntegridad() {
        if (!cerrada) {
            System.out.println("El acta no ha sido cerrada aún. No se puede verificar.");
            return false;
        }

        String datosActuales = generarStringDatos();
        int hashActualNumerico = HashGenerator.generarHashSimple(datosActuales);
        String hashActualHex = HashGenerator.convertirAHexadecimal(hashActualNumerico);

        if (hashActualHex.equals(hashHexOriginal)) {
            System.out.println("El acta no ha sido modificada. Es válida.");
            return true;
        } else {
            System.out.println("El acta ha sido modificada después del cierre. ¡No es válida!");
            System.out.println("Hash original: " + hashHexOriginal);
            System.out.println("Hash actual:   " + hashActualHex);
            return false;
        }
    }

    public void mostrarAlumnos() {
        if (cantidadAlumnos == 0) {
            System.out.println("No hay alumnos cargados en el acta.");
            return;
        }

        System.out.println("Listado de alumnos:");
        for (int i = 0; i < cantidadAlumnos; i++) {
            Alumno a = alumnos[i];
            System.out.println((i + 1) + ". " + a.nombre + " " + a.apellido + " - Nota: " + a.nota);
        }
    }

}
