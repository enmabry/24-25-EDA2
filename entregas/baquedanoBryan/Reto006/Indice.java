package entregas.baquedanoBryan.Reto006;

public abstract class Indice {
    protected String[] valores;
    protected int[][] posiciones;
    protected int[] contadores;
    protected int cantidadValores;

    public abstract void agregar(String valor, int posicion);
    public abstract int[] buscar(String valor);
    public abstract boolean contiene(String valor);
    public abstract String[] obtenerTodos();
    
}
