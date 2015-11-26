/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.management.remote.rmi.RMIServer;
import rmi.Comand;
import rmi.RMI;

/**
 *
 * @author usuario
 */
public class Server extends UnicastRemoteObject implements RMI{
    public Server() throws RemoteException{
        super();
    } 

    @Override
    public String getComand(String text) throws RemoteException {
        String result;
        Comand comando = new Comand(text);
        result = comando.executeComand();
        return result;
    }
    public static void main(String args[]){
        try{
            Registry reg = LocateRegistry.createRegistry(22);//puerto para comunicacion
            reg.rebind("server", new Server());
            System.out.println("server started");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
