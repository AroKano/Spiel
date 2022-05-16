package ui;

import java.util.Random;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;
import java.awt.event.*;

import network.ProtocolEngine;


public class Player {


    private static final String EXIT = "exit";

    private static final String START = "start";

    private int playerID;
    private int otherPlayer;
    private int randomNumber;
    private int maxTurns;
    private int turnsMade;
    private int myPoints;
    private int enemyPoints;
    private int playerGuess;


    private PrintStream outStream;
    private BufferedReader inBufferedReader;
    private String playerName;

    private String partnerName;

    private ClientSideConnection csc;
    private ProtocolEngine protocolEngine;

    public Player() {
        randomNumber = 0;
        turnsMade = 0;
        myPoints = 0;
        enemyPoints = 0;
    }


    public static void main(String[] args) throws IOException {

        Player usercmd = new Player();


        usercmd.connectToServer();

        System.out.println("");
        System.out.println("Welcome to Guess the Number!");
        System.out.println("");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String playerName = scanner.next();

        System.out.println("Welcome " + playerName);
        System.out.println("");
        System.out.println("Let's play a game");

        Player user = new Player(playerName, System.out, System.in);

        user.printUsage();
        user.runCommandLoop();

    }

    public Player(String playerName, PrintStream os, InputStream is) throws IOException {
        this.playerName = playerName;
        this.outStream = os;
        this.inBufferedReader = new BufferedReader(new InputStreamReader(is));
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
                maxTurns = dataIn.readInt() / 2;
                randomNumber = dataIn.readInt();
                System.out.println("maxTurns: " + maxTurns);
                System.out.println("Value #1 is " + randomNumber);
            } catch (IOException ex) {
                System.out.println("IO Exception from ClientSideConnection constructor");
            }
        }

        public void sendGuessedNum(int n) {
            try {
                dataOut.writeInt(n);
                dataOut.flush();
            } catch (IOException ex) {
                System.out.println("IOExecption from sendGuessedNum() CSC");
            }
        }
    }

    public void printUsage() {
        StringBuilder b = new StringBuilder();

        b.append("\n");
        b.append("Type any command to run the program!");
        b.append("\n");
        b.append("valid commands:");
        b.append("\n");
        b.append(START);
        b.append("-> to start the game");
        b.append("\n");
        b.append(EXIT);
        b.append("-> to exit");

        this.outStream.println(b.toString());

    }

    public void runCommandLoop() {
        boolean again = true;

        while (again) {
            boolean rememberCommand = true;
            String cmdLineString = null;

                // read user input
            try {
                cmdLineString = inBufferedReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // finish that loop if less than nothing came in
                if (cmdLineString == null) break;

                // trim whitespaces on both sides
                cmdLineString = cmdLineString.trim();

                // extract command
                int spaceIndex = cmdLineString.indexOf(' ');
                spaceIndex = spaceIndex != -1 ? spaceIndex : cmdLineString.length();

                // got command string
                String commandString = cmdLineString.substring(0, spaceIndex);

                // extract parameters string - can be empty
                String parameterString = cmdLineString.substring(spaceIndex);
                parameterString = parameterString.trim();

                // start command loop
                switch (commandString) {

                    case START:
                        this.doStart(parameterString);
                        // redraw
                        break;
                    case "q": // convenience
                    case EXIT:
                        again = false;
                        try {
                            this.doExit();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break; // end loop

                    default:
                        this.outStream.println("unknown command:" + cmdLineString);
                        this.printUsage();
                        rememberCommand = false;
                        break;
                }
            }
        }




    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                           ui method implementations                                        //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void doExit() throws IOException {
        // shutdown engines which needs to be
        this.protocolEngine.close();
    }

    private void doStart (String parameterString) {

        Scanner guess = new Scanner(System.in);

        int rounds = 0;
        while (true) {
            rounds++;
            System.out.println("Round " + rounds + ":");
            System.out.println("Enter your Guess (1-100):");

            playerGuess = guess.nextInt();

            if (playerGuess == randomNumber) {
                System.out.println("Correct!");
                myPoints++;
                System.out.println("Dein Punktestand beträgt: " + myPoints);
                break;
            } else if (randomNumber > playerGuess) {
                System.out.println("Wrong, higher!");
            } else {
                System.out.println("Wrong, lower!");
            }

            csc.sendGuessedNum(playerGuess);
        }
        guess.close();
    }

    }





