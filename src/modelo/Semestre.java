/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author ivina
 */
public class Semestre {
    
    private int id;
    private int Curso;
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();
    private String nome;
    private Integer numero;

    public Semestre(int id, int Curso, String nome, Integer numero) {
        this.id = id;
        this.Curso = Curso;
        this.nome = nome;
        this.numero = numero;
    }

    
    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurso() {
        return Curso;
    }

    public void setCurso(int Curso) {
        this.Curso = Curso;
    }
      
    public void imprimirSemestre(){
        System.out.println("Id do semestre "+ this.getId());
        System.out.println(""+ this.getNome());
        for (int i = 0; i < disciplinas.size(); i++){
            disciplinas.get(i).imprimirDisciplina();
        }
    }
    
    
}
