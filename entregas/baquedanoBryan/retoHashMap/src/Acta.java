public class Acta {
    protected Alumno[] alumnos;
    protected int cantidadAlumnos;
    protected String fechaCierre;
    protected int hashOriginal;
    protected boolean cerrada;

    public Acta(int capacidadMaxima, String fechaCierre) {
        alumnos = new Alumno[capacidadMaxima];
        cantidadAlumnos = 0;
        this.fechaCierre = fechaCierre;
        hashOriginal = 0;
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

}
