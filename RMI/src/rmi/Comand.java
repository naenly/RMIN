/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author usuario
 */
public class Comand {
    String comand;

    public Comand(String comand) {
        this.comand = comand;
    }

    public String getComand() {
        return comand;
    }

    public void setComand(String comand) {
        this.comand = comand;
    }
    public String executeComand(){
        String str="";
        String resultado=null;
        String ejecuta = null;
        try{
            Process proceso = Runtime.getRuntime().exec(this.comand);//cmd /c tree
            //variables para mostrar en pantalla el resultado del comando
            InputStreamReader entrada = new InputStreamReader(proceso.getInputStream());
            BufferedReader stdInput = new BufferedReader(entrada);
            //Si el comando tiene una salida la mostramos
            if((resultado=stdInput.readLine()) != null){
                ejecuta = "Comando ejecutado Correctamente";
                while ((resultado=stdInput.readLine()) != null){
                    str = str + resultado + "\n";
                }
            }else{
                ejecuta = "No se a producido ninguna salida";
            }
        }catch (IOException e){
            System.out.println("Error en: "+e);
        }
        return ejecuta + "\n" + str;
    }
    /*public static void main(String args[]){
        Comand comando = new Comand("cmd /c dir");
        System.out.println(comando.executeComand());
    }*/
}
