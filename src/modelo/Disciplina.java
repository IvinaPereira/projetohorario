package modelo;

import sia.Setor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ivina
 */
public class Disciplina implements Cloneable {

    private Integer id;
    private String nome;
    private Integer aulasSemana;
    private Professor professor;

    public Disciplina(String nome, Integer aulas, Integer id, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.aulasSemana = aulas;
        this.professor = professor;
    }

    public Disciplina(String nome, Integer aulas, Integer id) {
        this.id = id;
        this.nome = nome;
        this.aulasSemana = aulas;
    }

    public Disciplina(String nome, Integer aulas) {
        this.nome = nome;
        this.aulasSemana = aulas;
    }

    public Disciplina() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Integer getAulas() {
        return aulasSemana;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    

    public void setAulas(Integer aulas) {
        this.aulasSemana = aulas;
    }

    public void imprimirDisciplina() {
        System.out.print(" - " + this.nome);
    }
    
    public Disciplina deepCopy(Disciplina input) {
        Disciplina copy = new Disciplina();
        copy.setNome(input.getNome());//.. copy primitives, deep copy objects again
        copy.setId(input.getId());//.. copy primitives, deep copy objects again
        copy.setAulas(input.getAulas());//.. copy primitives, deep copy objects again
        copy.setProfessor(input.getProfessor());//.. copy primitives, deep copy objects again
        return copy;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Disciplina cloned = (Disciplina) super.clone();
        cloned.setProfessor((Professor) cloned.getProfessor().clone());
        return cloned;
    }

}
