package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("il Client è partito");
        Socket s = new Socket("localhost", 63000);
        System.out.println("il client si è collegato");
        BufferedReader in= new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        BufferedReader inTastiera= new BufferedReader(new InputStreamReader(System.in));
        
        String nomeScelto=inTastiera.readLine();
        out.writeBytes(nomeScelto+"\n");

        String stringaRicevuta=in.readLine();
        System.out.println("La dtringa ricevuta"+ stringaRicevuta);
        System.out.println("inserisci il tuo nome");

        
        s.close();
    }
}