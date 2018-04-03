package modelo;

public class Professor implements Cloneable{

    private String nome;
    private int[] disponibilidade;
    private int id;

    public Professor(String nome, int[] disponivel, int id) {
        this.nome = nome;
        this.disponibilidade = disponivel;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int[] getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(int[] disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getDisponivel(int dia) {
        System.out.println("disponibilidADE DIA "+ dia + " " + this.disponibilidade[dia]);
        if (this.disponibilidade[dia] == 1) {
        System.out.println("");
            return true;
        }
        System.out.println("");
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
