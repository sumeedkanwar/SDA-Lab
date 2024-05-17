import java.io.*;
import java.net.*;

public class MyClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 3333);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        while (!str.equals("stop")) {
            System.out.print("Enter a string or file path or type 'stop' to end: ");
            str = br.readLine();

            File file = new File(str);
            if (file.isFile()) {
                dout.writeUTF("file");
                dout.writeUTF(file.getName());
                dout.flush();

                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                    dout.write(buffer, 0, bytesRead);
                }

                fileInputStream.close();
                dout.flush();
            } else {
                dout.writeUTF(str);
                dout.flush();
                String str2 = din.readUTF();
                System.out.println("Server says: " + str2);
            }
        }

        dout.close();
        s.close();
    }
}
