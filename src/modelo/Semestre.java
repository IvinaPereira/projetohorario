/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Random;
import sia.Inddois;
import sia.Individuo;

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
    
    private int nivelAptidao;
            

    public Semestre(int id, int Curso, String nome, Integer numero) {
        this.id = id;
        this.Curso = Curso;
        this.nome = nome;
        this.numero = numero;
    }

    public Semestre(int id, int Curso, Integer numero) {
        this.id = id;
        this.Curso = Curso;
        this.numero = numero;
    }

    public Semestre() {
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

    public int getNivelAptidao() {
        return nivelAptidao;
    }

    public void setNivelAptidao(int nivelAptidao) {
        this.nivelAptidao = nivelAptidao;
    }

    public Semestre clonar(Semestre input) {
        Semestre copy = new Semestre();
        copy.setDisciplinas(clonargene(input.getDisciplinas()));//.. copy primitives, deep copy objects again
        copy.setCurso(input.getCurso());
        copy.setId(input.getId());
        copy.setNome(input.getNome());
        copy.setNivelAptidao(input.getNivelAptidao());//.. copy primitives, deep copy objects again
        return copy;
    }

    public ArrayList<Disciplina> clonargene(ArrayList<Disciplina> disc) {
        ArrayList<Disciplina> genee = new ArrayList<>();
        for (int i = 0; i < this.disciplinas.size(); i++) {
            genee.add(disc.get(i).deepCopy(disc.get(i)));
        }
        return genee;
    }

    public void mutarDisciplinas() {
        Random rand = new Random();
        System.out.print("aptidao antiga " + this.nivelAptidao);
        ArrayList<Disciplina> genee = new ArrayList<>();
        genee.addAll(this.disciplinas);
        
        for (int i = 0; i < 10; i++) {
            System.out.println("DISCIPLINAS QUE FORAM RECEBIDAS NO MUTAR");
            System.out.println(genee.get(i).getNome());
        }
        int num1 = rand.nextInt(10);
        int num2 = rand.nextInt(10);

        if (num1 != num2 ) {
            System.out.println("******************************************************");
            System.out.println("******************************************************");
            System.out.println("Vai trocar "+ genee.get(num1).getNome() + " por "+ genee.get(num2).getNome());
            System.out.println("******************************************************");
            System.out.println("******************************************************");
            Disciplina d = genee.get(num1);
            genee.remove(num1);
            genee.add(num1,genee.get(num2));
            genee.remove(num2);
            genee.add(num2,d);
        }
        this.setDisciplinas(genee);
//        gerarNivelAptidao();
//        System.out.println("aptidao nova" + this.nivelAptidao);
//        System.out.println("horario");
//        this.imprimirInd();
    }
        
//    public Disciplina deepCopy(Disciplina input) {
//        Disciplina copy = new Disciplina();
//        copy.setNome(input.getNome());//.. copy primitives, deep copy objects again
//        copy.setId(input.getId());//.. copy primitives, deep copy objects again
//        copy.setAulas(input.getAulas());//.. copy primitives, deep copy objects again
//        copy.setProfessor(input.getProfessor());//.. copy primitives, deep copy objects again
//        return copy;
//    }
//        
    public void imprimirSemestre() {
        System.out.println("" + this.getNome()+ " Semestre ----- Aptidao - "+ this.getNivelAptidao());
        for (int i = 0; i < disciplinas.size(); i++) {
            if(i == 5){
                System.out.println("");
            }
            disciplinas.get(i).imprimirDisciplina();
        }
        System.out.println("");
    }
}
