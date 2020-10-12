package com.mycompany.main;

import com.mycompany.bean.User;
import com.mycompany.context.Context;
import com.mycompany.tcp.Client;
import com.mycompany.tcp.Server;

/**
 *
 * @author Eminov
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        
        Context c = new Context();
        c.contact();
        
        User u = User.instance();
        
        Thread t= new Thread(new Server());
        t.start();
        
        Thread.sleep(5000);
        
        Thread t2 = new Thread(new Client());
        t2.start();
        
        
    }
}
