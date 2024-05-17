import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your message (type 'GoodBye' to exit): ");
            String message = scanner.nextLine();
            byte[] sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, 3000);
            ds.send(sendPacket);

            if (message.equalsIgnoreCase("GoodBye")) {
                System.out.println("Client disconnected.");
                break;
            }

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            ds.receive(receivePacket);

            String serverMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server says:" + serverMessage);
        }

        ds.close();
        scanner.close();
    }
}
