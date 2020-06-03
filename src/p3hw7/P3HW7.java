/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3hw7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AboOod_shbika99
 */
public class P3HW7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        MyThread t1 = new MyThread(100000, "user1.txt");
        t1.setName("t1");
        t1.setPriority(Thread.MIN_PRIORITY);
        
        MyThread t2 = new MyThread(100000, "user2.txt");
        t2.setName("t2");
        t2.setPriority(Thread.MAX_PRIORITY);
        
        t1.start();
        t2.start();
         */
        ExecutorService s = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 2; i++) {
            int count = i;
            s.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread" + count);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String user = "user" + count + ".txt";
                    File f = new File(user);
                    Scanner sc = null;
                    try {
                        sc = new Scanner(f);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(P3HW7.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    while (sc.hasNextLine()) {
                        System.out.println(sc.nextLine());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            });
        }
        s.shutdown();
    }

    public static void getData(String ff) {
        File f = new File(ff);
        synchronized (f) {
            try {
                Scanner sc = new Scanner(f);
                while (sc.hasNextLine()) {
                    System.out.println(sc.nextLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
