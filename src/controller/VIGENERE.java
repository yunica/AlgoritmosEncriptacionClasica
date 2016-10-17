package controller;

import bean.Mensaje;
import java.lang.reflect.Array;

public class VIGENERE {

    String MENSAJE = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

    String[] MATRIZ;

    public VIGENERE() {
        MATRIZ = new String[]{
            "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ",
            "BCDEFGHIJKLMNÑOPQRSTUVWXYZA",
            "CDEFGHIJKLMNÑOPQRSTUVWXYZAB",
            "DEFGHIJKLMNÑOPQRSTUVWXYZABC",
            "EFGHIJKLMNÑOPQRSTUVWXYZABCD",
            "FGHIJKLMNÑOPQRSTUVWXYZABCDE",
            "GHIJKLMNÑOPQRSTUVWXYZABCDEF",
            "HIJKLMNÑOPQRSTUVWXYZABCDEFG",
            "IJKLMNÑOPQRSTUVWXYZABCDEFGH",
            "JKLMNÑOPQRSTUVWXYZABCDEFGHI",
            "KLMNÑOPQRSTUVWXYZABCDEFGHIJ",
            "LMNÑOPQRSTUVWXYZABCDEFGHIJK",
            "MNÑOPQRSTUVWXYZABCDEFGHIJKL",
            "NÑOPQRSTUVWXYZABCDEFGHIJKLM",
            "ÑOPQRSTUVWXYZABCDEFGHIJKLMN",
            "OPQRSTUVWXYZABCDEFGHIJKLMNÑ",
            "PQRSTUVWXYZABCDEFGHIJKLMNÑO",
            "QRSTUVWXYZABCDEFGHIJKLMNÑOP",
            "RSTUVWXYZABCDEFGHIJKLMNÑOPQ",
            "STUVWXYZABCDEFGHIJKLMNÑOPQR",
            "TUVWXYZABCDEFGHIJKLMNÑOPQRS",
            "UVWXYZABCDEFGHIJKLMNÑOPQRST",
            "VWXYZABCDEFGHIJKLMNÑOPQRSTU",
            "WXYZABCDEFGHIJKLMNÑOPQRSTUV",
            "XYZABCDEFGHIJKLMNÑOPQRSTUVW",
            "YZABCDEFGHIJKLMNÑOPQRSTUVWX",
            "ZABCDEFGHIJKLMNÑOPQRSTUVWXY"};

    }

    public String Encriptar(Mensaje bean) {
        String salidaCod = "";
        String letraMensaje, letraClave;
        String nuevaclave = convertirclave(bean.getClave(), bean.getMensaje().length()).toUpperCase();

        bean.setMensaje(bean.getMensaje().toUpperCase());
        bean.setClave(bean.getClave().toUpperCase());

        for (int i = 0; i < bean.getMensaje().length(); i++) {
            letraMensaje = String.valueOf(bean.getMensaje().charAt(i));
            letraClave = String.valueOf(nuevaclave.charAt(i));
            if (letraMensaje.equals(" ")) {
                salidaCod = salidaCod + " ";
            } else {
                int M = MENSAJE.indexOf(letraMensaje);
                int K = MENSAJE.indexOf(letraClave);

                salidaCod = salidaCod + MATRIZ[M].charAt(K);
            }
        }
        return salidaCod;
    }

    public String Desencriptar(Mensaje bean) {
        String salidaCod = "";
        String letraCriptograma, letraClave;
        String nuevaclave = convertirclave(bean.getClave(), bean.getMensaje().length()).toUpperCase();

        bean.setCriptograma(bean.getCriptograma().toUpperCase());
        bean.setClave(bean.getClave().toUpperCase());

        for (int i = 0; i < bean.getCriptograma().length(); i++) {
            letraCriptograma = String.valueOf(bean.getCriptograma().charAt(i));
            letraClave = String.valueOf(nuevaclave.charAt(i));
            if (letraCriptograma.equals(" ")) {
                salidaCod = salidaCod + " ";
            } else {
                int K = MENSAJE.indexOf(letraClave);
                for (int a = 0; a < MENSAJE.length(); a++) {
                    if (String.valueOf(MATRIZ[a].charAt(K)).equals(letraCriptograma)) {
                        salidaCod = salidaCod + String.valueOf(MENSAJE.charAt(a));

                    }
                }

            }
        }
        return salidaCod;
    }

    private String convertirclave(String bean, int numero) {
        String clave = bean;
        String as = "";
        int b = clave.length();
        for (int i = 0; i < numero; i++) {
            int j = i;
            if (j > (b - 1)) {
                j = j % b;
            }
            as = as + String.valueOf(clave.charAt(j));
        }

        return as;
    }

}
