import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        ServerSocket serveur =null;
        try {
            serveur = new ServerSocket(50013);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ThreadMultiServeurEcho core =new ThreadMultiServeurEcho(serveur);
        core.run();
    }
}
