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
public class Inddois implements Comparable<Inddois> {

    MeuBanco banco = new MeuBanco();

    ArrayList<Semestre> semestres = new ArrayList<>();
    ArrayList<Curso> gene = new ArrayList<>();
    ArrayList<Curso> cursosBanco = new ArrayList<>();
    Random rand = new Random();
    int nivelAptidao = 0;
    boolean copia;
    int qtdCopias = 0;

    //para disciplinas
    private int aulasSemana = 10;

    public Inddois() {
        this.cursosBanco = banco.getCursos();
        gerarGene();
//        imprimirGene();
        gerarNivelAptidaoCursos();
        imprimirGene();
    }

    public Inddois(boolean boleano) {
        if (boleano) {
            gerarGene();
            gerarNivelAptidaoCursos();
//            imprimirInd();
        }
        this.copia = false;
    }

    public boolean getCopia() {
        return copia;
    }

    public void setCopia(boolean copia) {
        this.copia = copia;
    }

    public int getQtdCopias() {
        return qtdCopias;
    }

    public void setQtdCopias(int qtdCopias) {
        this.qtdCopias = qtdCopias;
    }

    public void setGene(ArrayList<Curso> gene) {
        this.gene = gene;
    }

    public ArrayList<Curso> getGene() {
        return gene;
    }

    public int getNivelAptidao() {
        return nivelAptidao;
    }

    public void setNivelAptidao(int nivelAptidao) {
        this.nivelAptidao = nivelAptidao;
    }
    
    private void gerarGene() {

        //for que percorre os cursos da instituição
        for (Curso cursoBanco : cursosBanco) {

            ArrayList<Semestre> semestresGerados = new ArrayList<>();

            //for que percorre os semestres dos cursos
            for (Semestre semestreBanco : cursoBanco.getSemestres()) {

                int id = semestreBanco.getId();
                int curso_id = semestreBanco.getCurso();
                String nome = semestreBanco.getNome();
                int numero = semestreBanco.getNumero();

                Semestre sem = new Semestre(id, curso_id, nome, numero);

                ArrayList<Disciplina> disciplinas = gerarDisciplinas(semestreBanco);
                sem.setDisciplinas(disciplinas);

                semestresGerados.add(sem);
            }
            Curso curso = new Curso(cursoBanco.getNome(), cursoBanco.getQtdSemestre());
            curso.setSemestres(semestresGerados);
            gene.add(curso);
        }
    }

    private ArrayList<Disciplina> gerarDisciplinas(Semestre semestre) {
        ArrayList<Disciplina> disciplinas = semestre.getDisciplinas();
        ArrayList<Disciplina> gene = new ArrayList<>();

        for (int n = 0; n < 10; n++) {
            gene.add(n, new Disciplina());
        }
//        System.out.println("");
        int cont, i;
        for (Disciplina disciplina : disciplinas) {
            cont = 0;
            while (disciplina.getAulas() > cont) {
                i = rand.nextInt(aulasSemana);
                if (gene.get(i).getNome() == null) {
                    gene.remove(i);
                    gene.add(i, disciplina);
                    cont++;
                }
            }
        }
        return gene;
    }

    public void gerarNivelAptidaoCursos() {
//        System.out.println("GERANDO APTIDAO DOS INDIVIDUOS");
        int nivelHorarios = 0;
        int nivelCurso;
        for (Curso curso : gene) {
            nivelCurso = 0;
//            System.out.println("Curso de " + curso.getNome());
            nivelCurso = gerarNivelSemestres(curso);
            curso.setNivelAptidao(nivelCurso);
            nivelHorarios += nivelCurso;
        }

        this.nivelAptidao = nivelHorarios;
//        if (nivel > 0) {
//            this.qtdCopias = nivel / 10;
//        }
//        this.nivelAptidao = nivel;
    }

    private int gerarNivelSemestres(Curso curso) {
        int nivelSemestre = 0;
        int nivelCurso = 0;
//        System.out.println("Curso de " + curso.getNome());
        for (Semestre semestre : curso.getSemestres()) {
//            System.out.println(semestre.getNome()+ " semestreeeeeeeeeeeeeeeeeeeeeeeeeee ");
            nivelSemestre = 0;
//            System.out.println("nivel inicial do semestre "+ nivelSemestre);
//            System.out.println("valor da funcao 1 "+ funcao1(semestre));
            nivelSemestre += funcao1(semestre);
//            System.out.println("nivel do semestre dpois da 1 - "+ nivelSemestre);
//            System.out.println("valor da funcao 2 "+ funcao2(semestre));
            nivelSemestre += funcao2(semestre);
//            System.out.println("nivel do semestre dpois da 2 - "+ funcao2(semestre));
            semestre.setNivelAptidao(nivelSemestre);
//            System.out.println("get na aptidao do smeestre "+ semestre.getNivelAptidao());
            nivelCurso += nivelSemestre;
//            System.out.println("nivel do curso "+ nivelCurso);
        }

        return nivelCurso;
//        if (nivel > 0) {
//            this.qtdCopias = nivel / 10;
//        }
//        this.nivelAptidao = nivel;
    }

    //se a disciplina está no mesmo dia
    public int funcao1(Semestre semestre) {
        int nivel = 0;
        for (int i = 0; i < 5; i++) {
//            System.out.println("print do i e j -- "+ i +""+j);
            if (semestre.getDisciplinas().get(i).equals(semestre.getDisciplinas().get(i + 5))) {
                nivel -= 4;
//                    System.out.println("Ocorrencia de " + this.gene[i][j].getNome() + " subtraindo -4");
//                        System.out.println("Ocorrencia de " + this.gene[i+1][j].getNome());
            } else {
//                    System.out.println("somando mais +4");
                nivel += 4;
            }

        }
//        System.out.println("nivel retornado funcao 2" + nivel);
        return nivel;
    }

    //verifica se professor está disponivel
    public int funcao2(Semestre semestre) {
        int nivel = 0;
//        System.out.println(semestre.getNome() + " semestre" + semestre.getCurso());
        for (int i = 0; i < 10; i++) {
//            System.out.println("disciplina " + semestre.getDisciplinas().get(i).getNome());
            if (semestre.getDisciplinas().get(i).getNome() != null) {
                if (semestre.getDisciplinas().get(i).getProfessor().getDisponivel(i)) {
                    nivel += 3;
                } else {
                    nivel -= 3;
                }
            } else {
//                System.out.println("igual a null");
            }
        }
//        System.out.println("nivel retornado" + nivel);
        return nivel;
    }

    public Inddois clonar(Inddois input) {
        Inddois copy = new Inddois(false);
        copy.setGene(clonargene(input.getGene()));//.. copy primitives, deep copy objects again
        copy.setCopia(false);//.. copy primitives, deep copy objects again
        copy.setNivelAptidao(input.getNivelAptidao());//.. copy primitives, deep copy objects again
        return copy;
    }

    public ArrayList<Curso> clonargene(ArrayList<Curso> curso) {
        ArrayList<Curso> genee = new ArrayList<>();
        for (int i = 0; i < this.gene.size(); i++) {
            genee.add(curso.get(i).clonar(curso.get(i)));
        }
        return genee;
    }

    @Override
    public int compareTo(Inddois individuo) {
        if (this.nivelAptidao < individuo.nivelAptidao) {
            return 1;
        }
        if (this.nivelAptidao > individuo.nivelAptidao) {
            return -1;
        }
        return 0;
    }

    public void imprimirGene() {
        System.out.println("Endereco da memoria " + this);
        System.out.println("Aptidao do horario --- " + this.nivelAptidao);
        for (Curso curso : gene) {
            curso.imprimirCurso();
        }
    }

}
