import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

public class SimpleHTTPServer {
    public static void main(String[] args) throws IOException {
        final ServerSocket server = new ServerSocket(8081); //creating a server socket for port 8081
        System.out.println("Listening for connection on port 8081");
        while (true) {
            try (Socket clientSocket = server.accept()) { //conditionally accepting the server request
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today; //Prepare an HTTP response
                clientSocket.getOutputStream().write(httpResponse.getBytes("UTF-8")); //Send HTTP response to the client socket
            }
            /*
            //This mechanism is to read the input from client Socket
            InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            String line = reader.readLine();
            while (!line.isEmpty()) {
                System.out.println(line);
                line = reader.readLine();
             }
                */
        }
    }
}
