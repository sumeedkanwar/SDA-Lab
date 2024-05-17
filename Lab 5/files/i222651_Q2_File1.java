import java.net.*;
import java.text.*;
import java.util.*;

public class DReceiver {
    public static void main(String[] args)throws Exception {
        DatagramSocket ds = new DatagramSocket(3000);

        while(true) {
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, 1024);
            ds.receive(dp);

            String str = new String(dp.getData(), 0, dp.getLength());
            if (str.startsWith("Connected")) {
                System.out.println("Client: " + dp.getAddress().getHostAddress() + " - " + str.substring("Connected".length()));
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                String response = sdf.format(new Date());
                DatagramPacket replyPacket = new DatagramPacket(response.getBytes(), response.length(), dp.getAddress(), dp.getPort());
                System.out.println(response);
                ds.send(replyPacket);
            }
        }
    }
}
