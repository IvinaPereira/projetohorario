/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia;

import java.util.ArrayList;
import modelo.Curso;
import modelo.Disciplina;
import modelo.Professor;
import modelo.Semestre;
import static sia.Menu.cursos;

/**
 *
 * @author ivina
 */
public class MeuBanco {

    private ArrayList<Disciplina> disciplinasCurso;
    private ArrayList<Semestre> semestres;
    private ArrayList<Professor> professores;
    private Curso cursoSistemas;

    public MeuBanco() {
        gerarCursos();
        this.professores = gerarProfessores();
        gerarSemestres(this.cursoSistemas);
        gerarDisciplinasPrimeiro();
        gerarDisciplinasSegundo();
        cursoSistemas.imprimirCurso();
    }

    
    public Curso getCurso() {
        return this.cursoSistemas;
    }

    public static void gerarCursos() {
        Curso curso = new Curso("Sistemas de Informação", 2);
        cursos.add(curso);
    }

    public void gerarSemestres(Curso curso) {
        ArrayList<Semestre> semestres = new ArrayList<>();

        int cursoId = this.cursoSistemas.getId();
        Semestre primeiro = new Semestre(1, cursoId, "Primeiro", 1);
        primeiro.setDisciplinas(gerarDisciplinasPrimeiro());
        semestres.add(primeiro);

        Semestre segundo = new Semestre(2, cursoId, "Segundo", 2);
        primeiro.setDisciplinas(gerarDisciplinasSegundo());
        semestres.add(segundo);
        cursoSistemas.setSemestres(semestres);

    }

    public ArrayList gerarProfessores() {
        ArrayList<Professor> prof = new ArrayList<>();
        //disponibilidade dos professores, 1 - Sim // 0 - Não
        int[][] disponibilidade = {{1, 0, 1, 0, 0}, {1, 1, 0, 0, 1}};
        Professor cesar = new Professor("César", disponibilidade, 1);
        prof.add(cesar);
        disponibilidade = new int[][]{{0, 0, 0, 0, 0}, {0, 1, 1, 1, 1}};
        Professor regio = new Professor("Régio", disponibilidade, 2);
        prof.add(regio);
        disponibilidade = new int[][]{{1, 1, 1, 1, 1}, {0, 1, 1, 0, 0}};
        Professor michelan = new Professor("Michelan", disponibilidade, 3);
        prof.add(michelan);
        disponibilidade = new int[][]{{1, 1, 1, 1, 1}, {0, 1, 1, 0, 1}};
        Professor leonardo = new Professor("Leonardo", disponibilidade, 4);
        prof.add(leonardo);
        disponibilidade = new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 1}};
        Professor eduardo = new Professor("Eduardo", disponibilidade, 5);
        prof.add(eduardo);

        disponibilidade = new int[][]{{1, 0, 1, 0, 0}, {1, 1, 0, 0, 1}};
        Professor viviane = new Professor("Viviane", disponibilidade, 6);
        prof.add(viviane);
        disponibilidade = new int[][]{{0, 0, 1, 1, 0}, {0, 1, 1, 1, 1}};
        Professor edimo = new Professor("Édimo", disponibilidade, 7);
        prof.add(edimo);
        disponibilidade = new int[][]{{1, 1, 1, 1, 1}, {0, 1, 1, 0, 0}};
        Professor piedley = new Professor("Piedley", disponibilidade, 8);
        prof.add(piedley);
        disponibilidade = new int[][]{{1, 1, 1, 1, 1}, {0, 1, 1, 0, 1}};
        Professor marcos = new Professor("Marcos", disponibilidade, 9);
        prof.add(marcos);
        disponibilidade = new int[][]{{0, 1, 1, 0, 0}, {1, 0, 1, 0, 1}};
        Professor fabricio = new Professor("Fabricio", disponibilidade, 10);
        prof.add(fabricio);
        
        for (int i = 0; i < prof.size(); i++){
            System.out.println(prof.get(i).getNome());
        }
        while (true){
            
        }
//        return prof;
    }
    
        public ArrayList<Disciplina> gerarDisciplinasPrimeiro() {
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
        disciplinasCurso.addAll(disc);
        return disc;
    }

    public ArrayList<Disciplina> gerarDisciplinasSegundo() {
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
        disciplinasCurso.addAll(disc);
        return disc;
    }
}
