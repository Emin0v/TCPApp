package com.mycompany.tcp;

import com.mycompany.bean.User;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Eminov
 */
public class Server implements Runnable {

    public void run() {
        User u = User.instance();
        try (
                ServerSocket socket = new ServerSocket(u.getPort());) {
            while (true) {
                Socket connection = socket.accept();
                System.out.println("Please wait ...");
                DataInputStream d = new DataInputStream(connection.getInputStream());
                byte[] msg = readMessage(d);

                FileOutputStream f = new FileOutputStream("C:\\Users\\Eminov\\Desktop\\win.jpg");
                f.write(msg);
                f.flush();
                f.close();
                System.out.println("*** Congrulations ***");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static byte[] readMessage(DataInputStream din) throws Exception {
        int msgLength = din.readInt();
        byte[] msg = new byte[msgLength];
        din.readFully(msg);
        return msg;
    }
    
}
