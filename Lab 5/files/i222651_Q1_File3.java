import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args)throws Exception {
        ServerSocket ss = new ServerSocket(3333);
        Socket s = ss.accept();
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        String str = "";
        while(!str.equals("stop")) {
            str = dis.readUTF();
            if (str.equals("file"))
            {
                String fileName = dis.readUTF();
                FileOutputStream fileOutputStream = new FileOutputStream(fileName);

                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = dis.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                    if (dis.available() == 0) {
                        break;
                    }
                }

                fileOutputStream.close();

                dout.writeUTF("File received");
                dout.flush();
            }
            else {
                System.out.println("client says: " + str);
                int count = 0;
                for(int i = 0; i < str.length(); i++) {
                    if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u' || str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O' || str.charAt(i) == 'U') {
                        count++;
                    }
                }
                dout.writeUTF("Total number of vowels = " + count);
                dout.flush();
            }
        }
        dis.close();
        s.close();
        ss.close();
    }
}
