/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia;

/**
 *
 * @author ivina
 */
public class Setor implements Cloneable {

    private int id;
    private String name;

    public Setor(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Setor() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Setor deepCopy(Setor input) {
        Setor copy = new Setor();
        copy.setName(input.getName());//.. copy primitives, deep copy objects again

        return copy;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    //Accessor/mutators methods will go there
}
