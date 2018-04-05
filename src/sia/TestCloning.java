/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia;

import java.util.ArrayList;

/**
 *
 * @author ivina
 */
public class TestCloning {


    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();
        
        numeros.add(2);
        numeros.add(4);
        numeros.add(6);
        numeros.add(8);
        numeros.add(10);
        
        for (int i = 0; i < numeros.size(); i++){
            System.out.println("numero "+numeros.get(i));
        }
        
        numeros.remove(1);
        numeros.add(1,5);
        System.out.println("");
        for (int i = 0; i < numeros.size(); i++){
            System.out.println("numero "+numeros.get(i));
        }
        
        
        
    }
    

}

