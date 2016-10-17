package controller;

import bean.Mensaje;

public class Polybius {

    String MENSAJE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    String[] letras = {
        "AA", "AB", "AC", "AD", "AE", "AF",
        "BA", "BB", "BC", "BD", "BE", "BF",
        "CA", "CB", "CC", "CD", "CE", "CF",
        "DA", "DB", "DC", "DD", "DE", "DF",
        "EA", "EB", "EC", "ED", "EE", "EF",
        "FA", "FB", "FC", "FD", "FE", "FF"};

    String[] numeros = {
        "11", "12", "13", "14", "15", "16",
        "21", "22", "23", "24", "25", "26",
        "31", "32", "33", "34", "35", "36",
        "41", "42", "43", "44", "45", "46",
        "51", "52", "53", "54", "55", "56",
        "61", "62", "63", "64", "65", "66"};

    public String encriptar(Mensaje bean, int tipo) {

        String salidaCod = "";
        for (int i = 0; i < bean.getMensaje().length(); i++) {
            bean.setMensaje(bean.getMensaje().toUpperCase());
            String as = String.valueOf(bean.getMensaje().charAt(i));

            if (as.equals(" ")) {
                salidaCod = salidaCod + " ";
            } else {
                if (as == "Ñ") {
                    as = "N";
                }
                int numero = MENSAJE.indexOf(as);
                if (tipo == 1) { //LETRAS
                    salidaCod = salidaCod + letras[numero];
                } else { //NUMEROS
                    salidaCod = salidaCod + numeros[numero];
                }

            }
        }
        return salidaCod;

    }

    public String Desencriptar(Mensaje bean, int tipo) {
        String SalidaDec = "";
        String Stralterno = "";
        int intAlterno = 0;
        int num;
        for (int i = 0; i < bean.getCriptograma().length(); i++) {
            bean.setCriptograma(bean.getCriptograma().toUpperCase());
            String as = String.valueOf(bean.getCriptograma().charAt(i));

            if (as.equals(" ")) {
                SalidaDec = SalidaDec + " ";
                intAlterno = 0;
            } else {
                if (intAlterno == 1) {
                    Stralterno = Stralterno + as;
                    intAlterno = 0;
                    //System.out.print(Stralterno+" ");
                    if (tipo == 1) { //LETRAS
                        num = buscarnumero(Stralterno,1);
                    } else { //NUMEROS
                       num = buscarnumero(Stralterno,2);
                    }                
                    Stralterno="";
                    SalidaDec = SalidaDec + String.valueOf(MENSAJE.charAt(num));
                } else {
                    Stralterno = as;
                    intAlterno = 1;
                }
             
            }
        }
        return SalidaDec;
    }

    private int buscarnumero(String letra, int tipo) {
        int n = 0;
        String [] comparador;
        for (int i = 0; i < MENSAJE.length(); i++) {
            if (tipo == 1) { //LETRAS
               comparador = letras;
            } else { //NUMEROS
               comparador = numeros;
            }
            //System.out.print(letra);
            if (letra.equals(comparador[i])){
               // System.out.print(i+ " ");
                n=i;
                break;
            }

        }

        return n;
    }
}
