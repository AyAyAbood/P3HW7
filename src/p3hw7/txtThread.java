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
public class txtThread implements Runnable {

    private File file;

    @Override
    public void run() {
        Scanner sc;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
                Thread.sleep(1000);
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            Logger.getLogger(txtThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public txtThread(File file) {
        this.file = file;
    }
}
