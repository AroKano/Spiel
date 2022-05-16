package network;

import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.Scanner;


public class GameServer {
    private ServerSocket ss;
    private int numPlayers;
    private ServerSideConnection player1;
    private ServerSideConnection player2;
    private int turnsMade;
    private int maxTurns;
    private int randomNumber;
    private int player1Guess;
    private int player2Guess;

    public GameServer() {
        System.out.println("----Game Server----");
        numPlayers = 0;
        turnsMade = 0;
        maxTurns = 4;

        Random rand = new Random();


            randomNumber = rand.nextInt(100) + 1;
            System.out.println("Value #"+ randomNumber);





        try {
            ss = new ServerSocket(25565);
        } catch (IOException ex){
            System.out.println("IOException from GameServer Constructor");
        }
    }



    public void acceptConnections() {
        try {
            System.out.println("Waiting for connections...");
            while (numPlayers < 2) {
                Socket s = ss.accept();
                numPlayers++;
                System.out.println("Player #" + numPlayers + " has connected.");
                ServerSideConnection ssc = new ServerSideConnection(s,numPlayers);
                if(numPlayers == 1) {
                    player1 = ssc;
                } else {
                    player2 = ssc;
                }
                Thread t = new Thread(ssc);
                t.start();
            }
            System.out.println("We now have 2 Players. No longer accepting connections");
        } catch (IOException ex) {
            System.out.println("IOException from acceptConnections()");
        }
    }

    public class ServerSideConnection implements Runnable {
        private Socket socket;
        private DataInputStream dataIn;
        private DataOutputStream dataOut;
        private int playerID;

        public ServerSideConnection(Socket s, int id) {
            socket = s;
            playerID = id;
            try {
                dataIn = new DataInputStream(socket.getInputStream());
                dataOut = new DataOutputStream(socket.getOutputStream());
            } catch (IOException ex) {
                System.out.println("IOException from run() SSC");
            }
        }

        public void run() {
            try {
                dataOut.writeInt(playerID);
                dataOut.writeInt(maxTurns);
                dataOut.writeInt(randomNumber);
                dataOut.flush();

                while (true) {
                    if (playerID == 1) {
                        player1Guess = dataIn.readInt();
                        System.out.println("Player 1 guessed the number " + player1Guess);
                    } else {
                        player2Guess = dataIn.readInt();
                        System.out.println("Player 2 guessed the number " + player2Guess);
                    }

                }
            } catch (IOException ex) {
                System.out.println("IOException from run() ServerSideConnection");
            }
        }
    }

    public static void main(String[] args) {
        GameServer gs = new GameServer();
        gs.acceptConnections();
    }
}
