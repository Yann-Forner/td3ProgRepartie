import java.io.*;
import java.net.Socket;

public class ThreadServeurEcho extends Thread {
    private Socket client;
    public ThreadServeurEcho(Socket client) {
        this.client = client;
        this.run();
    }

    @Override
    public void run() {
        try{
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        System.out.println(client.getInetAddress());
        String test="";
        while(!test.equals("exit")){
            test= in.readLine();
            out.write(test.toUpperCase());
            out.newLine();
            out.flush();

        }
        client.close();

    } catch (
    IOException e) {
        e.printStackTrace();
    }
        super.run();
    }
}
