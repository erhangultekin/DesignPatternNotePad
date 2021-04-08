/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import java.awt.FileDialog;
import javax.swing.JFrame;


/**
 *
 * @author DELL
 */
public class OpenOperation implements FileOperation{
    public JTextArea textArea;
    public JFrame jFrame;
    
    public OpenOperation(JFrame jFrame,JTextArea textArea){
        this.textArea=textArea;
        this.jFrame=jFrame;
    }
    @Override
    public void operation() {
        String filename = "";
        FileDialog fileD = new FileDialog(jFrame, "Open File", FileDialog.LOAD); //Dosya açma işlemi için fileDialog nesnesi tanımlanır
        fileD.setVisible(true);
        if (fileD.getFile() != null) {
            filename = fileD.getDirectory() + fileD.getFile();  //File path'i filename değişkenine atanır
        }
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) { //Kullanıcıdan alınan değerler textArea'ya yazılır
            String icerik = "";
            while (scanner.hasNextLine()) {
                icerik += scanner.nextLine() + "\n";
            }
            textArea.setText(icerik);
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
