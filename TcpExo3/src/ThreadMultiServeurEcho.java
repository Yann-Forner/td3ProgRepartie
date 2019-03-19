import java.io.IOException;
import java.net.ServerSocket;

public class ThreadMultiServeurEcho {
    ServerSocket serveur;
    public ThreadMultiServeurEcho(ServerSocket serveur) {
        this.serveur=serveur;
    }

    public void run() {
        while(true){
            try {
                new Thread( new ThreadServeurEcho(serveur.accept())).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
