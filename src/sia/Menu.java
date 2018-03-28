/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import modelo.Curso;
import modelo.Disciplina;
import modelo.Professor;
import modelo.Semestre;
import sia.Individuo;
import sia.Populacao;

/**
 *
 * @author ivina
 */
public class Menu {

    static ArrayList<Disciplina> disciplinas = new ArrayList<>();
    static ArrayList<Professor> professores = new ArrayList<>();
    static ArrayList<Curso> cursos = new ArrayList<>();
    static ArrayList<Semestre> semestres = new ArrayList<>();

    
    public static void main(String[] args) throws CloneNotSupportedException {
        
        MeuBanco banco = new MeuBanco();
        
//        gerarCursos();
//        gerarSemestres();
//        gerarProfessores();
//        gerarDisciplinasPrimeiro();
//        gerarDisciplinasSegundo();
//        cursos.get(0).imprimirCurso();
//        gerarInd();
//        System.out.println("\n\nchamar o gerar pop");
//        gerarPop();
    }

    public static void gerarInd() throws CloneNotSupportedException {
        Individuo ind = new Individuo(true);
        ind.imprimirInd();
        Individuo copia = new Individuo(false);
        copia = copia.clonar(ind);
        System.out.println("imprimindo a copia");
        copia.imprimirInd();
        copia.setUmGene(0, 0, semestres.get(0).getDisciplinas().get(0));
        System.out.println("imprimindo a copia alterada");
        copia.imprimirInd();
        System.out.println("imprimindo o original");
        ind.imprimirInd();

//        ind.mutarGene();
//        ind.imprimirInd();
    }

    public static void gerarPop() throws CloneNotSupportedException {
        int cont = 0;
        Populacao pop = new Populacao();
        ArrayList<Integer> melhores = new ArrayList<>();
        ArrayList<Integer> medias = new ArrayList<>();
        Individuo ind = new Individuo("");
        int media;
//        while (cont < 6){
        while (pop.horarios.get(0).getNivelAptidao() < 50) {
////            for (int i = 0; i < 10; i++) {
            media = pop.getMedia();
            medias.add(media);
            System.out.println("\n\nmedia " + media);
            Collections.sort(pop.getHorarios());
            pop.imprimirPop();
            System.out.println("Tamanho da populacao" + pop.size());
            pop.atribuirCp(media);
            System.out.println("\n\nprint se copia ou nao");
            pop.imprimirPop();
            System.out.println("Tamanho da populacao" + pop.size());
            pop.gerarCopias();

            System.out.println("\n\nprint com as copias");
            pop.imprimirPop();
            System.out.println("Tamanho da populacao" + pop.size());
            Collections.sort(pop.getHorarios());

            System.out.println("\n\nprint com as copias ordenadas");
            pop.imprimirPopEndereco();

            System.out.println("Tamanho da populacao" + pop.size());
            System.out.println("Tamanho da populacao" + pop.size());
            pop.mutarPop();
            System.out.println("\n\nimprimindo pop depois de mutada");
            pop.imprimirPopEndereco();
            System.out.println("\n\nimprimindo pop depois de mutada ORDENADA");
            Collections.sort(pop.getHorarios());
            pop.imprimirPop();
            pop.retiraRuins();
            System.out.println("\n\nimprimindo so os bons");
            pop.imprimirPopEndereco();
            cont++;
//            ind = pop.getMelhor();
            System.out.println("melhor individuo da vez");
            pop.getMelhor().imprimirIndi();
//            
            melhores.add(pop.getMelhor().getNivelAptidao());
        }
//        Collections.sort(pop.getHorarios());

        System.out.println("MELHORES INDIVIDUOS");
        System.out.println("MELHORES INDIVIDUOS");
        System.out.println("MELHORES INDIVIDUOS");
        melhores.forEach((melhor) -> {
            System.out.println(melhor);
        });

        System.out.println("MEDIAS DOS INDIVIDUOS");
        System.out.println("MEDIAS DOS INDIVIDUOS");
        System.out.println("MEDIAS DOS INDIVIDUOS");
        medias.forEach((med) -> {
            System.out.println(med);
        });
//        System.out.println("Melhor individuo " +ind.getNivelAptidao());
//        ind.imprimirInd();
//        ind.gerarNivelAptidao();
//        System.out.println("Melhor individuo " +ind.getNivelAptidao());
//        System.out.println("Quantidade de horarios " + pop.getTamanho());
        System.out.println("Quantidade de iteracoes " + cont);
//        pop.imprimirPop();
//            

    }

    public static void gerarDisciplinasPrimeiro() {
        ArrayList<Disciplina> disc = new ArrayList<>();
        Disciplina filo = new Disciplina("Filosofia", 1, 1, professores.get(1));
        disc.add(filo);
        Disciplina discreta = new Disciplina("Discreta", 2, 2, professores.get(4));
        disc.add(discreta);
        Disciplina fsi = new Disciplina("Fundamentos", 2, 3, professores.get(0));
        disc.add(fsi);
        Disciplina calculo = new Disciplina("Calculo", 2, 4, professores.get(3));
        disc.add(calculo);
        Disciplina ing = new Disciplina("Inglês", 1, 5, professores.get(2));
        disc.add(ing);
        Disciplina prog = new Disciplina("Programação", 2, 6, professores.get(2));
        disc.add(prog);
        semestres.get(0).setDisciplinas(disc);
        disciplinas.addAll(disc);
    }

    public static void gerarDisciplinasSegundo() {
        ArrayList<Disciplina> disc = new ArrayList<>();
        Disciplina filo = new Disciplina("FCC", 1, 1, professores.get(1));
        disc.add(filo);
        Disciplina discreta = new Disciplina("Logica", 2, 2, professores.get(4));
        disc.add(discreta);
        Disciplina fsi = new Disciplina("ADM", 2, 3, professores.get(0));
        disc.add(fsi);
        Disciplina calculo = new Disciplina("ProgII", 2, 4, professores.get(3));
        disc.add(calculo);
        Disciplina ing = new Disciplina("AEDI", 1, 5, professores.get(2));
        disc.add(ing);
        Disciplina prog = new Disciplina("Português", 2, 6, professores.get(2));
        disc.add(prog);
        semestres.get(1).setDisciplinas(disc);
        disciplinas.addAll(disc);
    }

    public static void gerarProfessores() {
        //disponibilidade dos professores, 1 - Sim // 2 - Não
        int[][] disponibilidade = {{1, 0, 1, 0, 0}, {1, 1, 0, 0, 1}};
        Professor cesar = new Professor("César", disponibilidade, 1);
        professores.add(cesar);
        disponibilidade = new int[][]{{0, 0, 0, 0, 0}, {0, 1, 1, 1, 1}};
        Professor regio = new Professor("Régio", disponibilidade, 2);
        professores.add(regio);
        disponibilidade = new int[][]{{1, 1, 1, 1, 1}, {0, 1, 1, 0, 0}};
        Professor michelan = new Professor("Michelan", disponibilidade, 3);
        professores.add(michelan);
        disponibilidade = new int[][]{{1, 1, 1, 1, 1}, {0, 1, 1, 0, 1}};
        Professor leonardo = new Professor("Leonardo", disponibilidade, 4);
        professores.add(leonardo);
        disponibilidade = new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 1}};
        Professor eduardo = new Professor("Eduardo", disponibilidade, 5);
        professores.add(eduardo);

        disponibilidade = new int[][]{{1, 0, 1, 0, 0}, {1, 1, 0, 0, 1}};
        Professor viviane = new Professor("Viviane", disponibilidade, 6);
        professores.add(viviane);
        disponibilidade = new int[][]{{0, 0, 1, 1, 0}, {0, 1, 1, 1, 1}};
        Professor edimo = new Professor("Édimo", disponibilidade, 7);
        professores.add(edimo);
        disponibilidade = new int[][]{{1, 1, 1, 1, 1}, {0, 1, 1, 0, 0}};
        Professor piedley = new Professor("Piedley", disponibilidade, 8);
        professores.add(piedley);
        disponibilidade = new int[][]{{1, 1, 1, 1, 1}, {0, 1, 1, 0, 1}};
        Professor marcos = new Professor("Marcos", disponibilidade, 9);
        professores.add(marcos);
        disponibilidade = new int[][]{{0, 1, 1, 0, 0}, {1, 0, 1, 0, 1}};
        Professor fabricio = new Professor("Fabricio", disponibilidade, 10);
        professores.add(fabricio);
    }

    public static void gerarCursos() {
        Curso curso = new Curso("Sistemas de Informação", 2);
        cursos.add(curso);
    }

    public static void gerarSemestres() {
        int cursoId = cursos.get(0).getId();
        Semestre primeiro = new Semestre(1, cursoId, "Primeiro", 1);
        semestres.add(primeiro);

        Semestre segundo = new Semestre(2, cursoId, "Segundo", 2);
        semestres.add(segundo);
        cursos.get(0).setSemestres(semestres);
        
        
    }

}
