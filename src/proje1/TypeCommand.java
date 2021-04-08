/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje1;

import java.util.Stack;
import javax.swing.JTextArea;

/**
 *
 * @author DELL
 */
public class TypeCommand implements UndoableCommand{
    public JTextArea textArea;
    private String backup="";
    public Stack<Character> characters = new Stack<Character>();
   
    public TypeCommand(JTextArea textArea){
       this.textArea=textArea;
    }
    @Override
    public void undo() {
       if(!characters.isEmpty()){
           characters.pop();
       }
       for(int j=0;j<characters.size();j++){
           backup+=characters.elementAt(j);
       }
       textArea.setText(backup);
    }
    @Override
    public void execute() {
       if(textArea.getText().length()!=0){
           for(int x=0;x<textArea.getText().length();x++){
            characters.push(textArea.getText().charAt(x)); 
       }
       }
       
    }
}
