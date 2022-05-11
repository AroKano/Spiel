package ui;

import network.GameServer;
import java.util.Random;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class ZahlenratenUI {


    private int playerID;
    private int otherPlayer;
    private ClientSideConnection csc;



    public static void main(String[] args) {
        ZahlenratenUI p = new ZahlenratenUI();

        p.connectToServer();

        System.out.println("");
        System.out.println("Welcome to Guess the Number!");
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String playerName = scanner.next();

        System.out.println("Welcome " + playerName);
        System.out.println("");
        System.out.println("Let's play a game");



    }

    public void connectToServer() {
        csc = new ClientSideConnection();
    }

    private class ClientSideConnection {
        private Socket socket;
        private DataInputStream dataIn;
        private DataOutputStream dataOut;

        public ClientSideConnection() {
            System.out.println("---Client---");
            try {
                socket = new Socket("localhost", 25565);
                dataIn = new DataInputStream(socket.getInputStream());
                dataOut = new DataOutputStream(socket.getOutputStream());
                playerID = dataIn.readInt();
                System.out.println("Connected to server as Player #" + playerID + ".");
            } catch (IOException ex) {
                System.out.println("IO Exception from ClientSideConnection constructor");
            }
        }
    }

    public void zaehlung() {
        int runde;
        for (runde = 1; runde < rundenzahl.length; runde++) {
            System.out.println("Runde: " + runde);
            System.out.print(name + ", Bitte gebe hier eine Zahl ein: ");
            int randNum = (int) (Math.random() * 5);
            int ratezahl = Konsole.getInputInt();

            while (true) {
                if (ratezahl == randNum) {
                    System.out.println("Die Zahl ist richtig!");
                    punkte++;
                    System.out.println("Du hast einen Punktestand von " + punkte);
                } else if (ratezahl != randNum)
                    System.out.println("Die Zahl ist falsch!");
                break;
            }
        }
    }
    public static void raten() {
        Random rand = new Random();
        Scanner guess = new Scanner(System.in);

        int randomNumber = rand.nextInt(100) + 1;

        System.out.println("Enter your Guess (1-100:");

        int playerGuess = guess.nextInt();
    }



}
