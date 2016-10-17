/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import PLAYFAIR.playfair;
import bean.Mensaje;
import controller.VIGENERE;

/**
 *
 * @author sk8er_000
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        String MENSAJE = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
//        for (int i = 0; i < MENSAJE.length(); i++) {
//            for (int j = i; j < 27; j++) {
//                
//                System.out.print(String.valueOf(MENSAJE.charAt(j)));
//                if (String.valueOf(MENSAJE.charAt(j)).equals("Z")) {
//                    for(int k = 0; k<i;k++){
//                        System.out.print(String.valueOf(MENSAJE.charAt(k)));
//                    }
//                }
//            }
//            System.out.println("");
//        }
//        String a = "hola";
//        String as = "";
//        int b = a.length();
//
//        for (int i = 0; i < 17; i++) {
//            int j = i; 
//            if(j>(b-1)){
//                j=j%b;
//            }
//             as = as + String.valueOf(a.charAt(j));
//             
//        }
//        System.out.println(as);
//        System.out.println(b);
//        
//        System.out.println(a.indexOf("h"));
//            Mensaje mensj = new Mensaje();
//            mensj.setClave("cifra");
//            mensj.setMensaje("hola amigos");
//            VIGENERE v = new VIGENERE();
//            mensj.setCriptograma(v.Encriptar(mensj));
//            System.out.println(v.Desencriptar(mensj) + "desencriptado");
        String text = "hola como estamos  ";
        Mensaje mensj = new Mensaje();
        mensj.setMensaje("hola como estamos I J ");
        System.out.println(text.replace(" ", ""));
        playfair p = new playfair();
        p.Encriptar(mensj);
        
        p.CrearMatriz("BACHATA");
        
        
    }
    
}
