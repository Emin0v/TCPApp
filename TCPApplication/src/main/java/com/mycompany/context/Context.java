package com.mycompany.context;

import com.mycompany.bean.User;
import java.util.Scanner;

/**
 *
 * @author Eminov
 */
public class Context {

    public void register() {
        User u = User.instance();
        String name = requireText("Enter name");
        u.setName(name);
        String surname = requireText("Enter surname");
        u.setSurname(surname);
    }

    public void contact() {
        register();
        User u = User.instance();
        String fileAddresss = requireText("Please enter file address = C:\\Users\\Eminov\\Pictures\\1.jpg");
        u.setFileAddress(fileAddresss);
        System.out.println("--------------");

        String ipAndPort = requireText("Please enter ip and port : for example-->127.0.0.1:5678");

        String[] arr = ipAndPort.split(":");
        String ip = arr[0];
        Integer port = Integer.parseInt(arr[1]);

        u.setIp(ip);
        u.setPort(port);
    }

    public static String requireText(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title);
        String answer = sc.nextLine();

        return answer;
    }

}
