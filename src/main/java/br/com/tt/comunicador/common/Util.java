package br.com.tt.comunicador.common;

import javax.swing.*;
import java.util.Scanner;

public class Util {

    private Util(){
    }

    public static void print(String texto){
        System.out.println(texto);
        //JOptionPane.showMessageDialog(null, texto);
    }

    public static String read(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
        //return JOptionPane.showInputDialog("");
    }

}
