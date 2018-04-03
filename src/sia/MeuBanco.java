/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia;

import java.lang.reflect.Array;
import java.util.ArrayList;
import modelo.Curso;
import modelo.Disciplina;
import modelo.Professor;
import modelo.Semestre;

/**
 *
 * @author ivina
 */
public class MeuBanco {

    private ArrayList<Curso> cursos = new ArrayList<>();
    private ArrayList<Professor> professores = new ArrayList<>();

    public MeuBanco() {
        this.professores = gerarProfessores();
        gerarCursos();
//        imprimirCursos();
//        cursoSistemas.imprimirCurso();
    }
    
    public ArrayList<Curso> getCursos() {
        return this.cursos;
    }

    public ArrayList getProf() {
        return this.professores;
    }


    private void gerarCursos() {
        cursos.add(gerarSistemas());
        cursos.add(gerarArquitetura());
//        gerarADS();
//        gerarADM();
//        gerarEngCivil();
//        gerarEngProd();
//        gerarPsicologia();
//        gerarDireito();
//        gerarMarketing();
    }

    private Curso gerarSistemas() {
        Curso curso = new Curso("Sistemas de Informação", 8);

        ArrayList<Semestre> sems = new ArrayList<>();

        Semestre primeiro = new Semestre(0, 0, "Primeiro", 1);

        ArrayList<Disciplina> disc = new ArrayList<>();
        Disciplina prog = new Disciplina("Programação", 2, 0, professores.get(2));
        disc.add(prog);
        Disciplina filo = new Disciplina("Filosofia", 1, 1, professores.get(1));
        disc.add(filo);
        Disciplina discreta = new Disciplina("Discreta", 2, 2, professores.get(3));
        disc.add(discreta);
        Disciplina fsi = new Disciplina("Fundamentos", 2, 3, professores.get(0));
        disc.add(fsi);
        Disciplina calculo = new Disciplina("Calculo", 2, 4, professores.get(6));
        disc.add(calculo);
        Disciplina ing = new Disciplina("Inglês", 1, 5, professores.get(1));
        disc.add(ing);

        primeiro.setDisciplinas(disc);
        sems.add(primeiro);      
        sems.add(gerarSegundoSistemas(0));
        sems.add(gerarTerceiroSistemas(0));
        sems.add(gerarQuartoSistemas(0));
        sems.add(gerarQuintoSistemas(0));
        sems.add(gerarSextoSistemas(0));
        sems.add(gerarSetimoSistemas(0));
        sems.add(gerarOitavoSistemas(0));

        curso.setSemestres(sems);

        return curso;
    }

    private Curso gerarArquitetura() {
        Curso curso = new Curso("Arquitetura", 2);

        ArrayList<Semestre> sems = new ArrayList<>();

        sems.add(gerarPrimeiroArquitetura(1));
        sems.add(gerarSegundoArquitetura(1));

        curso.setSemestres(sems);

        return curso;
    }

    private ArrayList gerarProfessores() {
        ArrayList<Professor> profs = new ArrayList<>();
        //disponibilidade dos professores, 1 - Sim // 0 - Não
        //6
        int[] disponibilidade = {1, 0, 1, 1, 0, 1, 1, 0, 0, 1};
        Professor prof = new Professor("César", disponibilidade, 0);
        profs.add(prof);

        //4
        disponibilidade = new int[]{0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
        prof = new Professor("Régio", disponibilidade, 1);
        profs.add(prof);

        //10
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Michelan", disponibilidade, 2);
        profs.add(prof);

        //6
        disponibilidade = new int[]{1, 1, 1, 1, 1, 0, 0, 1, 0, 1};
        prof = new Professor("Eduardo", disponibilidade, 3);
        profs.add(prof);

        //5
        disponibilidade = new int[]{1, 0, 1, 0, 0, 1, 1, 0, 0, 1};
        prof = new Professor("Paula", disponibilidade, 4);
        profs.add(prof);

        //9
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Édimo", disponibilidade, 5);
        profs.add(prof);

        //6
        disponibilidade = new int[]{0, 1, 1, 0, 1, 1, 0, 1, 0, 1};
        prof = new Professor("Raniere", disponibilidade, 6);
        profs.add(prof);

        //5
        disponibilidade = new int[]{1, 1, 1, 1, 1, 0, 1, 1, 0, 0};
        prof = new Professor("Piedley", disponibilidade, 7);
        profs.add(prof);

        //6
        disponibilidade = new int[]{1, 1, 1, 1, 1, 0, 1, 1, 0, 1};
        prof = new Professor("Rafael", disponibilidade, 8);
        profs.add(prof);

        //9
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Fabricio", disponibilidade, 9);
        profs.add(prof);

        //9
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Tadeu", disponibilidade, 10);
        profs.add(prof);

        return profs;
    }

    private Semestre gerarPrimeiroSistemas(int curso) {
        //adicionar semestre: id - Curso_id - nome - numero  
        Semestre primeiro = new Semestre(0, curso, "Primeiro", 1);

        ArrayList<Disciplina> disc = new ArrayList<>();
        Disciplina prog = new Disciplina("Programação", 2, 0, professores.get(2));
        disc.add(prog);
        Disciplina filo = new Disciplina("Filosofia", 1, 1, professores.get(1));
        disc.add(filo);
        Disciplina discreta = new Disciplina("Discreta", 2, 2, professores.get(3));
        disc.add(discreta);
        Disciplina fsi = new Disciplina("Fundamentos", 2, 3, professores.get(0));
        disc.add(fsi);
        Disciplina calculo = new Disciplina("Calculo", 2, 4, professores.get(6));
        disc.add(calculo);
        Disciplina ing = new Disciplina("Inglês", 1, 5, professores.get(1));
        disc.add(ing);

        primeiro.setDisciplinas(disc);
        return primeiro;
    }

    private Semestre gerarPrimeiroArquitetura(int curso) {
        //adicionar semestre: id - Curso_id - nome - numero  
        Semestre primeiro = new Semestre(0, curso, "Primeiro", 1);

        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        Disciplina disc = new Disciplina("Desenho de Observação", 1, 0, professores.get(2));
        disciplinas.add(disc);
        disc = new Disciplina("Geometria Descritiva", 2, 1, professores.get(1));
        disciplinas.add(disc);
        disc = new Disciplina("Plástica I", 2, 2, professores.get(3));
        disciplinas.add(disc);
        disc = new Disciplina("História da Arte", 1, 3, professores.get(0));
        disciplinas.add(disc);
        disc = new Disciplina("Introdução a Arq", 1, 4, professores.get(6));
        disciplinas.add(disc);
        disc = new Disciplina("Sistemas Estruturais", 1, 5, professores.get(1));
        disciplinas.add(disc);
        disc = new Disciplina("Representação Gráfica", 1, 6, professores.get(1));
        disciplinas.add(disc);

        primeiro.setDisciplinas(disciplinas);
        return primeiro;
    }

    private Semestre gerarSegundoArquitetura(int curso) {
        //adicionar semestre: id - Curso_id - nome - numero  
        Semestre primeiro = new Semestre(1, curso, "Segundo", 2);

        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        Disciplina disc = new Disciplina("Historia da Arquitetura", 2, 0, professores.get(2));
        disciplinas.add(disc);
        disc = new Disciplina("Conforto ambiental", 1, 1, professores.get(1));
        disciplinas.add(disc);
        disc = new Disciplina("Resistencia", 1, 2, professores.get(3));
        disciplinas.add(disc);
        disc = new Disciplina("Ergonomia", 1, 3, professores.get(0));
        disciplinas.add(disc);
        disc = new Disciplina("Plástica II", 1, 4, professores.get(6));
        disciplinas.add(disc);
        disc = new Disciplina("Desenho Arquitetonico", 2, 5, professores.get(1));
        disciplinas.add(disc);
        disc = new Disciplina("Legislação Urbana", 1, 6, professores.get(1));
        disciplinas.add(disc);

        primeiro.setDisciplinas(disciplinas);
        return primeiro;
    }

    private Semestre gerarSegundoSistemas(int curso) {
        //adicionar semestre: id - Curso_id - nome - numero  
        Semestre segundo = new Semestre(1, curso, "Segundo", 2);

        ArrayList<Disciplina> disc = new ArrayList<>();
        Disciplina fcc = new Disciplina("FCC", 2, 6, professores.get(2));
        disc.add(fcc);
        Disciplina logica = new Disciplina("Logica", 2, 7, professores.get(3));
        disc.add(logica);
        Disciplina adm = new Disciplina("ADM", 1, 8, professores.get(7));
        disc.add(adm);
        Disciplina progii = new Disciplina("ProgII", 2, 9, professores.get(9));
        disc.add(progii);
        Disciplina aedi = new Disciplina("AEDI", 2, 10, professores.get(5));
        disc.add(aedi);
        Disciplina port = new Disciplina("Português", 1, 11, professores.get(0));
        disc.add(port);

        segundo.setDisciplinas(disc);
        return segundo;
    }

    private Semestre gerarTerceiroSistemas(int curso) {
        //adicionar semestre: id - Curso_id - nome - numero  
        Semestre segundo = new Semestre(2, curso, "Terceiro", 3);

        ArrayList<Disciplina> disc = new ArrayList<>();
        Disciplina fcc = new Disciplina("TGS", 1, 12, professores.get(7));
        disc.add(fcc);
        Disciplina logica = new Disciplina("AEDII", 2, 13, professores.get(5));
        disc.add(logica);
        Disciplina adm = new Disciplina("SistemasO", 2, 14, professores.get(2));
        disc.add(adm);
        Disciplina progii = new Disciplina("Metodologia", 1, 15, professores.get(0));
        disc.add(progii);
        Disciplina aedi = new Disciplina("Banco I", 2, 16, professores.get(10));
        disc.add(aedi);
        Disciplina port = new Disciplina("POO I", 2, 17, professores.get(9));
        disc.add(port);

        segundo.setDisciplinas(disc);
        return segundo;
    }

    private Semestre gerarQuartoSistemas(int curso) {
        //adicionar semestre: id - Curso_id - nome - numero  
        Semestre quarto = new Semestre(3, curso, "Quarto", 4);

        ArrayList<Disciplina> disc = new ArrayList<>();
        Disciplina d = new Disciplina("APISI", 2, 18, professores.get(4));
        disc.add(d);
        d = new Disciplina("Arquitetura", 2, 19, professores.get(9));
        disc.add(d);
        d = new Disciplina("EngenhariaI", 1, 20, professores.get(4));
        disc.add(d);
        d = new Disciplina("RedesI", 2, 21, professores.get(8));
        disc.add(d);
        d = new Disciplina("POOII", 2, 22, professores.get(10));
        disc.add(d);
        d = new Disciplina("Linguagens", 1, 23, professores.get(10));
        disc.add(d);

        quarto.setDisciplinas(disc);
        return quarto;
    }

    private Semestre gerarQuintoSistemas(int curso) {
        //adicionar semestre: id - Curso_id - nome - numero  
        Semestre quinto = new Semestre(4, curso, "Quinto", 5);

        ArrayList<Disciplina> disc = new ArrayList<>();
        Disciplina d = new Disciplina("Multimidia", 1, 24, professores.get(9));
        disc.add(d);
        d = new Disciplina("POD", 1, 25, professores.get(5));
        disc.add(d);
        d = new Disciplina("ProjetoBD", 2, 26, professores.get(10));
        disc.add(d);
        d = new Disciplina("RedesII", 2, 27, professores.get(8));
        disc.add(d);
        d = new Disciplina("EngenhariaII", 2, 28, professores.get(4));
        disc.add(d);
        d = new Disciplina("Estatistica", 2, 29, professores.get(3));
        disc.add(d);

        quinto.setDisciplinas(disc);
        return quinto;
    }

    private Semestre gerarSextoSistemas(int curso) {
        //adicionar semestre: id - Curso_id - nome - numero  
        Semestre quarto = new Semestre(5, curso, "Sexto", 6);

        ArrayList<Disciplina> disc = new ArrayList<>();
        Disciplina d = new Disciplina("Cooperativos", 2, 30, professores.get(5));
        disc.add(d);
        d = new Disciplina("BDOO", 2, 31, professores.get(10));
        disc.add(d);
        d = new Disciplina("APISII", 2, 32, professores.get(8));
        disc.add(d);
        d = new Disciplina("Segurança", 1, 33, professores.get(6));
        disc.add(d);
        d = new Disciplina("Interface", 1, 34, professores.get(9));
        disc.add(d);

        quarto.setDisciplinas(disc);
        return quarto;
    }

    private Semestre gerarSetimoSistemas(int curso) {
        //adicionar semestre: id - Curso_id - nome - numero  
        Semestre quarto = new Semestre(6, curso, "Sétimo", 7);

        ArrayList<Disciplina> disc = new ArrayList<>();
        Disciplina d = new Disciplina("Economia", 1, 35, professores.get(7));
        disc.add(d);
        d = new Disciplina("ComputacaoG", 2, 36, professores.get(5));
        disc.add(d);
        d = new Disciplina("InteligenciaA", 2, 37, professores.get(2));
        disc.add(d);
        d = new Disciplina("GestãoE", 1, 38, professores.get(7));
        disc.add(d);
        d = new Disciplina("Gerenciamento", 1, 39, professores.get(9));
        disc.add(d);
        d = new Disciplina("Legislacao", 1, 40, professores.get(1));
        disc.add(d);
        d = new Disciplina("TCCI", 1, 41, professores.get(0));
        disc.add(d);

        quarto.setDisciplinas(disc);
        return quarto;
    }

    private Semestre gerarOitavoSistemas(int curso) {
        //adicionar semestre: id - Curso_id - nome - numero  
        Semestre quarto = new Semestre(7, curso, "Oitavo", 8);

        ArrayList<Disciplina> disc = new ArrayList<>();
        Disciplina d = new Disciplina("Gestão", 2, 42, professores.get(6));
        disc.add(d);
        d = new Disciplina("Tópicos", 2, 43, professores.get(2));
        disc.add(d);
        d = new Disciplina("Contabilidade", 1, 44, professores.get(6));
        disc.add(d);
        d = new Disciplina("Sociologia", 1, 45, professores.get(1));
        disc.add(d);
        d = new Disciplina("TCCII", 1, 46, professores.get(0));
        disc.add(d);
        d = new Disciplina("Comércio", 1, 47, professores.get(7));
        disc.add(d);

        quarto.setDisciplinas(disc);
        return quarto;
    }

    public void imprimirCursos() {
        cursos.forEach((curso) -> {
            curso.imprimirCurso();
        });
    }

}
