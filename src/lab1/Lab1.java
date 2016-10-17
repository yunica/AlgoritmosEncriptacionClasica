package lab1;

import bean.Mensaje;
import controller.CesarAlgoritmo;
import controller.Polybius;
import controller.VIGENERE;
import gui.general;
import java.util.ArrayList;

public class Lab1 {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {

        System.out.println(" ===  ALGORITMO CESAR =====");
        Mensaje mensj = new Mensaje();
        CesarAlgoritmo cesar = new CesarAlgoritmo();
        mensj.setMensaje("EL PATIO de mi casa es particular WXYZ");

        mensj.setCriptograma(cesar.Encriptar(mensj, 3));
        mensj.setMensaje(cesar.Desencriptar(mensj, 3));

        System.out.println(mensj.getMensaje());
        System.out.println(mensj.getCriptograma());

        System.out.println("\n ===  ALGORITMO POLYBIUS =====");
        Polybius p = new Polybius();
        Mensaje mensj2 = new Mensaje();
        mensj2.setMensaje("EL PATIO de mi casa es particular WXYZ");

        mensj2.setCriptograma(p.encriptar(mensj2, 2));
        mensj2.setMensaje(p.Desencriptar(mensj2, 2));

        System.out.println(mensj2.getMensaje());
        System.out.println(mensj2.getCriptograma());

        System.out.println("\n ===  ALGORITMO VIGENERE =====");
        Mensaje mensj3 = new Mensaje();
        VIGENERE v = new VIGENERE();
        mensj3.setClave("cifra");
        mensj3.setMensaje("hola amigos");
        
        mensj3.setCriptograma(v.Encriptar(mensj3));
        mensj3.setMensaje(v.Desencriptar(mensj3));
        
        System.out.println(mensj3.getMensaje());
        System.out.println(mensj3.getCriptograma());
        
        
        //GUI
        general g = new general();
        g.setVisible(true);
        
        
    }

}
