import java.net.*;

public class DSender {
    public static void main(String[] args)throws Exception {
        DatagramSocket ds = new DatagramSocket();
        String str = "Connected from Client1";
        InetAddress ip = InetAddress.getByName("localhost");

        DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 3000);
        ds.send(dp);
        ds.close();
    }
}