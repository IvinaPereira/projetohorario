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

//    public static void main(String[] args) throws CloneNotSupportedException {
//        Setor hr = new Setor(1, "Recursos Humanos");
//        Setor hr2 = new Setor(2, "Desenvolvimento");
//        ArrayList setores = new ArrayList();
//        setores.add((Setor) hr.clone());
//        setores.add((Setor) hr2.clone());
//
//        Funcionario original = new Funcionario(1, "Admin", setores);
//        Funcionario cloned = (Funcionario) original.clone();
//
//        //Let change the department name in cloned object and we will verify in original object
//        cloned.getUmSetor(0).setName("Finance");
// 
//        System.out.println(original.getUmSetor(0).getName());
//        System.out.println(original.getUmSetor(1).getName());
//        System.out.println("----------");
//        
//        System.out.println(cloned.getUmSetor(0).getName());
//        System.out.println(cloned.getUmSetor(1).getName());
//    }
//    
//        public static void main(String[] args) throws CloneNotSupportedException {
//        Setor hr = new Setor(1, "Human Resource");
//        Funcionario original = new Funcionario(1, "Admin", hr);
//        Funcionario cloned = (Funcionario) original.clone();
// 
//        //Let change the department name in cloned object and we will verify in original object
//        cloned.getSetor().setName("Finance");
// 
//        System.out.println(original.getSetor().getName());
//        System.out.println(cloned.getSetor().getName());
//        }
    public static void main(String[] args) {
//        ArrayList<Setor> one = new ArrayList<>();
        Setor[] one = new Setor[3];
//add elements
        
        Setor hr = new Setor(1, "Human Resource");
        Setor hr2 = new Setor(2, "Finanças");
        Setor hr3= new Setor(3, "Desenvolvimento");
        
        one[0] = hr;
        one[1] = hr2;
        one[2] = hr3;
        
//        one.add(hr);
//        one.add(hr2);
//        one.add(hr3);
        
        Setor[] two = new Setor[3];
//        for (Setor t : one) {
//            Setor copy = t.deepCopy(t);
//            two.add(copy);
//        }
        for (int i = 0; i< one.length ; i++) {
            Setor copy = one[i].deepCopy(one[i]);
            two[i] = copy;
        }
        
        for (Setor t : one) {
            System.out.println(t +" "+ t.getName());
        }
        for (Setor t : two) {
            System.out.println(t +" "+ t.getName());
        }
        
//        two.get(0).setName("SAC");
        two[0].setName("SAC");
        
        System.out.println("depois da mudanca");
        
        for (Setor t : one) {
            System.out.println(t +" "+ t.getName());
        }
        for (Setor t : two) {
            System.out.println(t +" "+ t.getName());
        }
        
        
        //        com cópia como o seguinte:
    }
    

}

