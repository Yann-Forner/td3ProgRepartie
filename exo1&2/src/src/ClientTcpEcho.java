package src;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientTcpEcho extends Socket {

    public ClientTcpEcho(){
        try {
            this.connect(new InetSocketAddress("10.203.9.149",50013));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void sendMsg(String msg,BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.write(msg);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

}
