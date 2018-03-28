package modelo;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ivina
 */
public class Curso {

    private String nome;
    private int qtdSemestre;
    private int id;
    private ArrayList<Semestre> semestres;
    
    public Curso(String nome, int qtdSemestre) {
        this.nome = nome;
        this.qtdSemestre = qtdSemestre;
        this.id = 1;
    }
      
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdSemestre() {
        return qtdSemestre;
    }

    public void setQtdSemestre(int qtdSemestre) {
        this.qtdSemestre = qtdSemestre;
    }

    public ArrayList<Semestre> getSemestres() {
        return semestres;
    }

    public void setSemestres(ArrayList<Semestre> semestres) {
        this.semestres = semestres;
    }
    
    public void imprimirCurso() {
        System.out.println("Imprimindo o curso");
        System.out.println(this.getNome());
        System.out.println("Semestres "+ this.getQtdSemestre());
        for(int i = 0; i < this.semestres.size(); i++){
            this.semestres.get(i).imprimirSemestre();
        }
    }
    
}
