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
    private int nivelAptidao;
    private ArrayList<Semestre> semestres;
    
    public Curso(String nome, int qtdSemestre) {
        this.nome = nome;
        this.qtdSemestre = qtdSemestre;
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

    public int getNivelAptidao() {
        return nivelAptidao;
    }

    public void setNivelAptidao(int nivelAptidao) {
        this.nivelAptidao = nivelAptidao;
    }
       
    public void imprimirCurso() {
        System.out.println("\n"+this.getNome() + " --- Semestres "+ this.getQtdSemestre()+"");
        System.out.println("Aptidao ----- "+ this.nivelAptidao+ "\n");
        for(int i = 0; i < this.semestres.size(); i++){
            this.semestres.get(i).imprimirSemestre();
            System.out.println("");
        }
    }
    
}
