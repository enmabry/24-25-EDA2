package entregas.baquedanoBryan.Reto006;

public class IndiceOrdenado extends Indice {

    public IndiceOrdenado(int capacidadMaxima) {
        super(capacidadMaxima); 
    }

    @Override
    public void agregar(String valor, int posicion) {
        int indiceValor = -1;
        int i = 0;

        while (i < cantidadValores && indiceValor == -1) {
            if (valores[i].equals(valor)) {
                indiceValor = i;
            }
            i++;
        }

        if (indiceValor == -1) {
            valores[cantidadValores] = valor;
            indiceValor = cantidadValores;
            cantidadValores++;
        }

        posiciones[indiceValor][contadores[indiceValor]] = posicion;
        contadores[indiceValor]++;

        ordenar();
    }
    
    
    
    private void ordenar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ordenar'");
    }

    public int[] buscar(String valor){}
    public boolean contiene(String valor){}
    public String[] obtenerTodos(){}
    
}
