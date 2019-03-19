import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        ServerSocket serveur =null;
        Socket client;
        BufferedReader in ;
        BufferedWriter out;
        try {
            serveur = new ServerSocket(50013);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            try {
                client = serveur.accept();
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                System.out.println(client.getInetAddress());
                String test="";
                while(!test.equals("exit")){
                    test= in.readLine();
                    out.write(test.toUpperCase());
                    out.newLine();
                    out.flush();

                }
                client.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
