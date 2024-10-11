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
        Socket s = new Socket("localhost", 9000);
        System.out.println("il client si è collegato");
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        BufferedReader inTastiera = new BufferedReader(new InputStreamReader(System.in));
       
        System.out.println("inserisci il tuo nome");

        
       
        do {
            
            String nomeScelto = inTastiera.readLine();
            out.writeBytes(nomeScelto + "\n");
            String stringaRicevuta=in.readLine();

            if (stringaRicevuta.equals("!"))
                break;
 
            System.out.println("La stringa ricevuta " + stringaRicevuta);
          

        } while (true);
        s.close();
    }
}