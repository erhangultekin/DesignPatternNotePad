/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje1.pattern;

import proje1.*;

/**
 *
 * @author DELL
 */
public class CloseOperation implements FileOperation{

    @Override
    public void operation() {
       System.exit(0);
    }
    
}
