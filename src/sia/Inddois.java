/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia;

import java.util.ArrayList;
import java.util.Random;
import modelo.Curso;
import modelo.Disciplina;
import modelo.Semestre;

/**
 *
 * @author ivina
 */
public class Inddois {

    ArrayList<Semestre> semestres;
    Random rand = new Random();
    private Curso curso;
    int nivelAptidao = 0;
    boolean copia;
    int qtdCopias = 0;
    
    //para disciplinas
    private int encontros = 2;
    private int diasSemana = 5;
    

    public Inddois(Curso curso){
        this.curso = curso;
        gerarGene();
        gerarNivelAptidao();
    }

    private void gerarGene() {
        for (int i = 0; i < curso.getQtdSemestre(); i++){
            gerarDisciplinas(curso.getSemestres().get(i));
        }
        

    }
    
    private ArrayList<Disciplina> gerarDisciplinas(Semestre semestre){
        semestre.getDisciplinas();
        ArrayList<Disciplina> disciplinas = Menu.semestres.get(0).getDisciplinas();
        Disciplina genee[][] = new Disciplina[encontros][diasSemana];
        int cont, i, j;
        for (Disciplina disciplina : disciplinas) {
            cont = 0;
            while (disciplina.getAulas() > cont) {
                i = rand.nextInt(encontros);
                j = rand.nextInt(diasSemana);
                if (genee[i][j] == null) {
                    genee[i][j] = disciplina;
                    cont++;
                }
            }
        }
        this.gene = genee;
        return disciplinas;
    }

    private void gerarNivelAptidao() {
        
    }

}
