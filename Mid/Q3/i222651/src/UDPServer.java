import java.net.*;
import java.util.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(3000);
        byte[] receiveData = new byte[1024];
        List<InetAddress> clientAddresses = new ArrayList<>();
        List<Integer> clientPorts = new ArrayList<>();

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            ds.receive(receivePacket);

            String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            if (!clientAddresses.contains(clientAddress)) {
                clientAddresses.add(clientAddress);
                clientPorts.add(clientPort);
            }

            System.out.println("Client " + clientAddress.getHostAddress() + ":" + clientPort + " says: " + clientMessage);

            if (clientMessage.equalsIgnoreCase("GoodBye")) {
                int clientIndex = clientAddresses.indexOf(clientAddress);
                clientAddresses.remove(clientIndex);
                clientPorts.remove(clientIndex);
                System.out.println("Client " + clientAddress.getHostAddress() + ":" + clientPort + " disconnected.");
                continue;
            }

            String response = " " + clientMessage;
            DatagramPacket sendPacket = new DatagramPacket(response.getBytes(), response.length(), clientAddress, clientPort);
            ds.send(sendPacket);
        }
    }
}
