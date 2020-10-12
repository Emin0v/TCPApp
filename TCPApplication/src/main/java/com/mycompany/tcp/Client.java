package com.mycompany.tcp;

import com.mycompany.bean.User;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Eminov
 */
public class Client implements Runnable {

    public void run() {
        User u = User.instance();
        try (
                Socket socket = new Socket(u.getIp(), u.getPort());
                ) {
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            File file = new File(u.getFileAddress());
            byte[] arr = new byte[(int)file.length()];
            FileInputStream inputStream = new FileInputStream(file);
            inputStream.read(arr);
            
            dataOutputStream.writeInt(arr.length);
            dataOutputStream.write(arr);
            socket.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
