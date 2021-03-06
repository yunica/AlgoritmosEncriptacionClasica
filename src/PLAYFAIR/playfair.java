package PLAYFAIR;

import bean.Mensaje;

public class playfair {

    String MENSAJE = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
    String Matriz[][];

    public playfair() {
        Matriz = new String[5][5];

    }

    public void Encriptar(Mensaje bean) {
        String txtclaro = bean.getMensaje().toUpperCase();
        String txtclave = bean.getClave().toUpperCase();
        String alfabeto;
        txtclaro = txtclaro.replace("J", "I");
        txtclaro = txtclaro.replace("Ñ", "N");
        txtclaro = txtclaro.replace(" ", "");
        txtclave = txtclave.replace("J", "I");
        txtclave = txtclave.replace("Ñ", "N");
        // System.out.println(txtclaro);
        txtclaro = CreanuevoTexto(txtclaro, 3, "");
        txtclave = CreanuevoTexto(txtclave, 1, "");
        alfabeto= CreanuevoTexto("", 2,txtclave);
        
        
        System.out.println("TEXTO CLARO MODIFICADO :\t"+txtclaro);
        System.out.println("CLAVE MODIFICADO :\t"+txtclave);
        System.out.println("ALFABETO MODIFICADO :\t"+alfabeto);
        CrearMatriz(txtclave);
        
        String Criptograma ="";
       String Stralterno="";
       int alterno=0;
       for (int i = 0; i < txtclaro.length(); i++) {
          String as = String.valueOf(txtclaro.charAt(i));
          
                if (alterno == 1) {
                    posicion p = EncontrarLetra(Stralterno, Matriz);
                    posicion p1 = EncontrarLetra(as, Matriz);
                    
                   
                    alterno = 0;
                    Stralterno = "";
                    Criptograma = Criptograma +  reglas(p, p1, Matriz);
                } else {
                    Stralterno = as;
                    alterno = 1;
                }
       
       }   
        System.out.println("\n"+Criptograma);

    }

    public void Desencriptar() {

    }

    private String CreanuevoTexto(String LETRA, int tipo, String nuevaClave) {
        String NMensaje = "";
        if (tipo == 1) {//clave
            for (int i = 0; i < LETRA.length(); i++) {
                String a = String.valueOf(LETRA.charAt(i));
                if (a != " ") {
                    NMensaje = NMensaje + a;
                }
                LETRA = LETRA.replace(a, " ");
            }
           
        }
        if (tipo == 2) {//ALFABETO
            NMensaje = MENSAJE;
            String a = "";
            for (int i = 0; i < nuevaClave.length(); i++) {
                NMensaje = NMensaje.replace(String.valueOf(nuevaClave.charAt(i)), "");
            }
       
        }
        if (tipo == 3) {//MENSAJE_CLARO
            NMensaje = LETRA.replace(" ", "");
            if (NMensaje.length() % 2 == 1) {
                NMensaje = NMensaje + "X";
            }
        }

        NMensaje = NMensaje.replace(" ", "");
        return NMensaje;//System.out.println(nuevaClave);
    }

    private void CrearMatriz(String clave) {
        String nuevaClave = CreanuevoTexto(clave, 1, "");
        String nuevoMensj = CreanuevoTexto("", 2, nuevaClave);
        nuevoMensj = nuevaClave + nuevoMensj;
        int l = 0;
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                Matriz[j][k] = String.valueOf(nuevoMensj.charAt(l));
                l++;
            }

        }
        System.out.println("MATRIZ :\n");
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                System.out.print(Matriz[j][k] + " ");
            }
            System.out.println("");

        }

//        posicion p = EncontrarLetra("U", Matriz);
//        System.out.println(p.getX());
//        System.out.println(p.getY());
//        posicion p = EncontrarLetra("A", Matriz);
//        System.out.println(p.getX() + " " + p.getY());
//        posicion p1 = EncontrarLetra("D", Matriz);
//        System.out.println(p1.getX() + " " + p1.getY());
        //reglas(p, p1, Matriz);
        
        
        
    }

    //Reglas 
    private String reglas(posicion p1, posicion p2, String[][] matr) {
        //Primera regla
        String X = "";
        String Y = "";
        if (p1.getY() == p2.getY()) { //misma fila
            if (p1.getX() > 3) {
                X = matr[p1.getY()][0];
            } else {
                X = matr[p1.getY()][p1.getX() + 1];
            }

            if (p2.getX() > 3) {
                Y = matr[p2.getY()][0];
            } else {
                Y = matr[p2.getY()][p2.getX() + 1];
            }

//            System.out.println("misma fila");
//            System.out.println(X+Y);
        } else if (p1.getX() == p2.getX()) { //misma columna
            if (p1.getY() > 3) {
                X = matr[0][p1.getX()];
            } else {
                X = matr[p1.getY() + 1][p1.getX()];
            }

            if (p2.getY() > 3) {
                Y = matr[0][p2.getX()];
            } else {
                Y = matr[p2.getY()+1][p2.getX()];
            }
            
//            System.out.println("misma columna");
//            System.out.println(X+Y);

        } else { //diagonal inversa
            X = matr[p1.getY()][p2.getX()];
            Y =matr[p2.getY()][p1.getX()];
            
//            System.out.println("diferente");
//            System.out.println(X+Y);
        }
        return X+Y;

    }

    private posicion EncontrarLetra(String letra, String[][] matr) {
        posicion p = new posicion();
        p.setLetra(letra);
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                if (matr[j][k].equals(letra)) {
                    p.setX(k);
                    p.setY(j);
                }
            }
        }
        return p;
    }

}
