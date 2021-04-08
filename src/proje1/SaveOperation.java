/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje1;

import java.awt.FileDialog;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author DELL
 */
public class SaveOperation implements FileOperation{
    public JTextArea textArea;
    public JFrame jFrame;

    
    public SaveOperation(JFrame jFrame,JTextArea textArea){
        this.textArea=textArea;
        this.jFrame=jFrame;
    }
    @Override
    public void operation() {
         String filename = "";
        FileDialog fileD = new FileDialog(jFrame, "Save File", FileDialog.SAVE); //Dosya kaydetme işlemi için fileDialog nesnesi tanımlanır
        fileD.setVisible(true);
        if (fileD.getFile() != null) {
            filename = fileD.getDirectory() + fileD.getFile(); //File path'i filename değişkenine atanır
        }

        try (FileWriter writer = new FileWriter(filename)) { //Dosyanın üzerine yazma işlemi yapılır
            writer.write(textArea.getText());
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
