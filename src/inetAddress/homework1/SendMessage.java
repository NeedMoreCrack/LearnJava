package inetAddress.homework1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class SendMessage {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10088;
        while(true){
            System.out.println("Send Message:");
            String message = String.valueOf(new Scanner(System.in).next());
            if(message.equals("exit")){
                break;
            }
            byte[] bytes = message.getBytes();

            DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);
            ds.send(dp);
        }
    }
}
