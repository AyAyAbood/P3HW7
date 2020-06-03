/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3hw7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AboOod_shbika99
 */
public class MyThread extends Thread{
    private int sleep;
    private String file;
    @Override
    public void run(){
            try {
                super.run();
                File f = new File(file);
                Scanner sc = new Scanner(f);
                while(sc.hasNextLine())
                    System.out.println(sc.nextLine());
                    Thread.sleep(sleep);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public MyThread(int sleep, String file){
        super();
        this.sleep = sleep;
        this.file = file;
    }
}
