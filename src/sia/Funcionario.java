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
public class Funcionario implements Cloneable{
 
        private int empoyeeId;
        private String employeeName;
        private ArrayList<Setor> setores;
        private Setor setor;

        public Funcionario(int id, String name, Setor dept) {
            this.empoyeeId = id;
            this.employeeName = name;
//            this.setor = dept;
            this.setor = dept;
        }

        public ArrayList<Setor> getSetores() {
            return setores;
        }

        public void setSetores(ArrayList setor) {
            this.setores = setor;
        }
        
//        public Setor getUmSetor(int pos) {
//            return setor.get(pos);
//        }
//
//        public void setUmSetor(int pos, Setor setor) {
//            this.setor.add(pos, setor);
//        }
        
        //Modified clone() method in Employee class

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

        
        @Override
        protected Object clone() throws CloneNotSupportedException {
            Funcionario clone = (Funcionario) super.clone();
            clone.setSetor((Setor) clone.getSetor().clone());
            clone.setSetor((Setor) clone.getSetor().clone());
            return clone;
        }

}
