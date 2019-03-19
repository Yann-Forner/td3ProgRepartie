package src;

import java.io.*;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) {
        ClientTcpEcho client = new ClientTcpEcho();

        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader1 = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            bufferedReader1= new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (;;){
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            try {
                client.sendMsg(bufferedReader.readLine(),bufferedWriter);
                if(bufferedReader.readLine().equals("close")){
                    bufferedReader1.close();
                    bufferedWriter.close();
                }

                System.out.println(bufferedReader1.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}