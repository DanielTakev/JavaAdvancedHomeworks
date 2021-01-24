import java.io.*;
import java.net.*;

class ServeOneClient extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    Clients clients;
    ObjectInputStream objectInputStream;

    public ServeOneClient(Socket s,Clients clients)  throws IOException {
        socket = s;
        this.clients = clients;
        in = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()));
        out = new PrintWriter( new BufferedWriter(
                new OutputStreamWriter(
                        socket.getOutputStream()
                )
        ),
                true);

        objectInputStream = new ObjectInputStream(socket.getInputStream());
        clients.addC(out);
        start();
    }
    public void run() {
        try {
            while (true) {
                Messages message = null;
                try {
                    message = (Messages)objectInputStream.readObject();
                } catch (ClassNotFoundException e) {};

                String str = message.toString();

                if (str.equals("END")) break;
                System.out.println(str); // Write to the server console
                clients.sendClient(str); // Sending to clients
            }

        } catch (IOException e) {  }
        finally {
            try {
                clients.rmvC(out);
                System.out.println("Disconnect a client. Total number " + clients.numberOfClients());
                socket.close();
            } catch(IOException e) {}
        }
    }
}