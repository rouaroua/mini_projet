package sockets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8888;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connected to the chat server.");

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Gérer l'entrée utilisateur et l'envoyer au serveur
            String userInputLine;
            while ((userInputLine = userInput.readLine()) != null) {
                out.println(userInputLine);
                String serverResponse = serverInput.readLine();
                System.out.println("Server: " + serverResponse);
            }

            // Fermer les flux et le socket lorsque l'utilisateur quitte
            out.close();
            userInput.close();
            serverInput.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





