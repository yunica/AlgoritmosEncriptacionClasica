package controller;

import bean.Mensaje;
import java.util.ArrayList;

public class CesarAlgoritmo {

    //String[]tabla ={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    String tabla = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

    public String Encriptar(Mensaje bean, int contador) {
        if (contador > (tabla.length() - 1)) {
            contador = contador % (tabla.length() - 1);
        }
        String salidaCod = "";
        for (int i = 0; i < bean.getMensaje().length(); i++) {
            bean.setMensaje(bean.getMensaje().toUpperCase());
            String as = String.valueOf(bean.getMensaje().charAt(i));

            if (as.equals(" ")) {
                salidaCod = salidaCod + " ";
            } else {
                int numero = tabla.indexOf(as) + contador;

                if (numero > (tabla.length() - 1)) {
                    numero = numero - tabla.length();
                }

                salidaCod = salidaCod + tabla.charAt(numero);
            }
        }
        return salidaCod;
    }

    public String Desencriptar(Mensaje bean, int contador) {
        if (contador > (tabla.length() - 1)) {
            contador = contador % (tabla.length() - 1);
        }
        String SalidaDec = "";
        for (int i = 0; i < bean.getCriptograma().length(); i++) {
            bean.setCriptograma(bean.getCriptograma().toUpperCase());
            String as = String.valueOf(bean.getCriptograma().charAt(i));
            if (as.equals(" ")) {
                SalidaDec = SalidaDec + " ";
            } else {
                int numero = tabla.indexOf(as) - contador;
                if (numero < 0) {
                    numero = numero + tabla.length();
                }
                SalidaDec = SalidaDec + tabla.charAt(numero);
            }
        }
        return SalidaDec;
    }

}
