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
        mergeSort(0, cantidadValores - 1);
    }

    private void mergeSort(int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;
            mergeSort(izquierda, medio);
            mergeSort(medio + 1, derecha);
            merge(izquierda, medio, derecha);
        }
    }

    private void merge(int izquierda, int medio, int derecha) {
        String[] valoresTemp = new String[derecha - izquierda + 1];
        int[][] posicionesTemp = new int[derecha - izquierda + 1][];
        int[] contadoresTemp = new int[derecha - izquierda + 1];

        for (int i = izquierda; i <= derecha; i++) {
            valoresTemp[i - izquierda] = valores[i];
            posicionesTemp[i - izquierda] = posiciones[i].clone();
            contadoresTemp[i - izquierda] = contadores[i];
        }

        int i = izquierda;
        int j = medio + 1;
        int k = izquierda;

        while (i <= medio && j <= derecha) {
            if (valoresTemp[i - izquierda].compareTo(valoresTemp[j - izquierda]) <= 0) {
                valores[k] = valoresTemp[i - izquierda];
                posiciones[k] = posicionesTemp[i - izquierda];
                contadores[k] = contadoresTemp[i - izquierda];
                i++;
            } else {
                valores[k] = valoresTemp[j - izquierda];
                posiciones[k] = posicionesTemp[j - izquierda];
                contadores[k] = contadoresTemp[j - izquierda];
                j++;
            }
            k++;
        }

        while (i <= medio) {
            valores[k] = valoresTemp[i - izquierda];
            posiciones[k] = posicionesTemp[i - izquierda];
            contadores[k] = contadoresTemp[i - izquierda];
            i++;
            k++;
        }

        while (j <= derecha) {
            valores[k] = valoresTemp[j - izquierda];
            posiciones[k] = posicionesTemp[j - izquierda];
            contadores[k] = contadoresTemp[j - izquierda];
            j++;
            k++;
        }
    }

    @Override
    public int[] buscar(String valor) {
        int inicio = 0;
        int fin = cantidadValores - 1;
        int indiceValor = -1;


        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (valores[medio].equals(valor)) {
                indiceValor = medio;
                break;
            } else if (valores[medio].compareTo(valor) > 0) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }

        if (indiceValor == -1) {
            return new int[0];
        }

        int[] resultado = new int[contadores[indiceValor]];
        for (int i = 0; i < contadores[indiceValor]; i++) {
            resultado[i] = posiciones[indiceValor][i];
        }

        return resultado;
    }

    public boolean contiene(String valor) {
    }

    public String[] obtenerTodos() {
    }

}
