public class HashGenerator {

    public static int generarHashSimple(String datos) {
        int hash = 0;
        for (int i = 0; i < datos.length(); i++) {
            char caracter = datos.charAt(i);
            int ascii = (int) caracter;
            hash += ascii * (i + 1); 
        }
        hash = hash % 100000000; 
        return hash;
    }

    public static String convertirAHexadecimal(int hash) {
        return Integer.toHexString(hash);
    }
}
