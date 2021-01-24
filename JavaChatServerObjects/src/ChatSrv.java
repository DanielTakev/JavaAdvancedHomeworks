import java.io.*;
import java.net.*;

public class ChatSrv {
    static final int PORT = 9090;
    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(PORT);
        System.out.println("Server Started");
        Clients clients = new Clients();
        try {
            while(true) {
                // Blocks until a connection occurs:
                Socket socket = s.accept();
                try {
                    new ServeOneClient(socket, clients);
                    System.out.println("Joined a new client - total number " + clients.numberOfClients());
                } catch(IOException e) {
                    // If it fails, close the socket,
                    // otherwise the thread will close it:
                    socket.close();
                }
            }
        } finally {
            s.close();
        }
    }
}