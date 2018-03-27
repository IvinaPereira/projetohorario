/*
Importante:

Então, a clonagem profunda exige satisfação de seguir as regras .

* Não é necessário copiar separadamente as primitivas.
* Todas as classes de membros na classe original devem apoiar a clonagem 
    e no método clone da classe original em contexto deve chamar 
    super.clone () em todas as classes de membros.
* Se qualquer classe de membro não suporta clonagem, então, no método clone,
    é preciso criar uma nova instância dessa classe de membro e copiar todos 
    os seus atributos um a um para um novo objeto de classe de membro. 
    Esse novo objeto de classe de membro será configurado no objeto clonado.
 */
package sia;

import java.util.ArrayList;
import java.util.Random;
import modelo.Disciplina;

/**
 *
 * @author ivina
 */
public class Individuo implements Comparable<Individuo>, Cloneable {

    Disciplina gene[][];
    Random rand = new Random();
    int diasSemana = 5;
    int encontros = 2;
    int nivelAptidao = 0;
    boolean copia;
    int qtdCopias = 0;

    public Individuo() {

    }

    public Individuo(boolean boleano) {
        if (boleano) {
            gerarGene();
            gerarNivelAptidao();
            imprimirInd();
        }
        this.copia = false;
    }

    public Individuo(String nome) {

    }

    public Individuo(Individuo copia) {
        this.gene = copia.getGene();
        this.nivelAptidao = copia.getNivelAptidao();
        this.copia = false;
    }

    public Individuo(Disciplina[][] gene) {
        this.gene = gene;
        gerarNivelAptidao();
    }

    public Disciplina[][] getGene() {
        return gene;
    }

    public void setGene(Disciplina[][] gene) {
        this.gene = gene;
    }

    public void gerarGene() {
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
    }

    public int getNivelAptidao() {
        return nivelAptidao;
    }

    public void setNivelAptidao(int nivelAptidao) {
        this.nivelAptidao = nivelAptidao;
    }  
    
    public boolean getCopia() {
        return copia;
    }

    public void setCopia(boolean cop) {
        this.copia = cop;
//        System.out.println("copia adicionada" + this.copia);
    }

    public Disciplina getUmGene(int pos1, int pos2) {
        return this.gene[pos1][pos2];
    }

    public int getCopias() {
        return qtdCopias;
    }

    public void gerarNivelAptidao() {
        //se a disciplina no dia for a mesma, então -5
        //se a disciplina nao tiver todas as aulas -5
        int nivel = 0;
//        System.out.println("chama funcao 1");
//        System.out.println("*****************nivel " + nivel);
        nivel += funcao1();
//        System.out.println("*****************nivel " + nivel);
//        System.out.println("chama funcao 2");
        nivel += funcao2();
//        System.out.println("*****************nivel " + nivel);
//        System.out.println("chama funcao 3");
//        nivel += funcao3();
//        System.out.println("nivel total" + nivel);
        System.out.println("copia pra poder gerar quantidade " + this.copia);
        if ( nivel > 0 ) {
            this.qtdCopias = nivel / 10;
        }
        this.nivelAptidao = nivel;
    }

    //se a disciplina está no mesmo dia
    public int funcao1() {
        int nivel = 0;
        for (int i = 0; i < encontros - 1; i++) {
            for (int j = 0; j < diasSemana; j++) {
//                System.out.println("print do i e j -- "+ i +""+j);
                if (this.gene[i][j].getId().equals(this.gene[i + 1][j].getId())) {
                    nivel -= 4;
                    System.out.println("Ocorrencia de " + this.gene[i][j].getNome() + " subtraindo -4");
//                        System.out.println("Ocorrencia de " + this.gene[i+1][j].getNome());
                } else {
                    System.out.println("somando mais +4");
                    nivel += 4;
                }
            }
        }
//        System.out.println("nivel retornado funcao 2" + nivel);
        return nivel;
    }

    public int funcao2() {
        int nivel = 0;
        for (int i = 0; i < encontros; i++) {
            for (int j = 0; j < diasSemana; j++) {
//                System.out.println("print do i e j -- "+ i +""+j);
                if (this.gene[i][j].getProfessor().getDia(i, j)) {
                    nivel += 3;
                    System.out.println("Professor " + this.gene[i][j].getProfessor().getNome() + " tem disponibilidade -- somando +3");
                } else {
                    System.out.println("Professor " + this.gene[i][j].getProfessor().getNome() + " não tem disponibilidade -- subtraindo -3");
                    nivel -= 3;
                }
            }
        }
        System.out.println("nivel retornado" + nivel);
        return nivel;
    }

    @Override
    public int compareTo(Individuo individuo) {
        if (this.nivelAptidao < individuo.nivelAptidao) {
            return 1;
        }
        if (this.nivelAptidao > individuo.nivelAptidao) {
            return -1;
        }
        return 0;
    }

    public void imprimirInd() {
//        System.out.println("***Primeiro semestre de sistemas***");
        for (int i = 0; i < encontros; i++) {
            for (int j = 0; j < diasSemana; j++) {
                System.out.print("  " + this.gene[i][j].getNome() + " - ");
//                System.out.print(this.gene[i][j].getProfessor().getNome() + "  ||");
            }
            System.out.println("");
        }
        System.out.print("¨" + this.nivelAptidao + "¨");
//        gerarNivelAptidao();
        System.out.print("¨" + this.nivelAptidao + "¨");

        System.out.print("¨" + this.copia + "¨");
        System.out.println("Copias -------- " + this.qtdCopias);
        System.out.println("");
    }

    public void imprimirIndi() {
        System.out.println("***Primeiro semestre de sistemas***");
        for (int i = 0; i < encontros; i++) {
            for (int j = 0; j < diasSemana; j++) {
                System.out.print("  " + this.gene[i][j].getNome() + " - ");
                System.out.print(this.gene[i][j].getProfessor().getNome() + "  ||");
            }
            System.out.println("");
        }
        System.out.print("¨" + this.nivelAptidao + "¨");
        System.out.print("¨" + this.copia + "¨");
        System.out.println("Copias -------- " + this.qtdCopias);
        System.out.println("");
    }

    //mutar 3 dias
    public void mutarGene() {
        System.out.print("aptidao antiga " + this.nivelAptidao);
        Disciplina[][] genee;
        genee = (Disciplina[][]) this.getGene().clone();
        int encontroAleatorio = rand.nextInt(this.encontros);
        int diaAleatorio = rand.nextInt(this.diasSemana);
        int encontroAleatorio2 = rand.nextInt(this.encontros);
        int diaAleatorio2 = rand.nextInt(this.diasSemana);

        if (encontroAleatorio != encontroAleatorio2 || diaAleatorio != diaAleatorio2) {
            Disciplina d = genee[encontroAleatorio][diaAleatorio];
            genee[encontroAleatorio][diaAleatorio] = genee[encontroAleatorio2][diaAleatorio2];
            genee[encontroAleatorio2][diaAleatorio2] = d;
        }
        this.setGene(genee);
        gerarNivelAptidao();
        System.out.println("aptidao nova" + this.nivelAptidao);
        System.out.println("horario");
        this.imprimirInd();
    }

    public Individuo clonar(Individuo input) {
        Individuo copy = new Individuo(false);
        copy.setGene(clonargene(input.getGene()));//.. copy primitives, deep copy objects again
        copy.setCopia(false);//.. copy primitives, deep copy objects again
        copy.setNivelAptidao(input.getNivelAptidao());//.. copy primitives, deep copy objects again
        return copy;
    }

    public Disciplina[][] clonargene(Disciplina[][] disc) {
        Disciplina genee[][] = new Disciplina[encontros][diasSemana];
        for (int i = 0; i < encontros; i++) {
            for (int j = 0; j < diasSemana; j++) {
                genee[i][j] = disc[i][j].deepCopy(disc[i][j]);
            }
        }
        return genee;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Individuo cloned = (Individuo) super.clone();
        cloned.setGene((Disciplina[][]) cloned.getGene().clone());
        return cloned;
    }

    void setUmGene(int i, int i0, Disciplina get) {
        this.gene[i][i0] = get;
    }

}
