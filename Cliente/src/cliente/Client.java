/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import rmi.RMI;

public class Client {
    public static void main(String args[]){
        Client client = new Client();
        client.connectServer();
    }
    private void connectServer() {
        try{
            Registry reg = LocateRegistry.getRegistry("127.0.0.1",22);
            RMI rmi = (RMI) reg.lookup("server");
            System.out.println("Connected to server");
            String text = rmi.getComand("cmd /c dir");
            System.out.println(text);     
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
