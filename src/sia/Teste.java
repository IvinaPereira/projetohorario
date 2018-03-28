/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia;

import java.util.ArrayList;
import java.util.Random;
import modelo.Disciplina;

/**
 *
 * @author ivina
 */
public class Teste {

    public static void main(String[] args) throws CloneNotSupportedException {
        Menu.gerarProfessores();
        Menu.gerarCursos();
        Menu.gerarSemestres();
        Menu.gerarDisciplinasPrimeiro();

        Ind ind = new Ind();
        System.out.println("\nindividuo 1");
        System.out.println(ind);
        System.out.println("Disciplina " + ind.gene[0][0].getNome());
        System.out.println("Disciplina " + ind.gene[0][1].getNome());
        System.out.println("Disciplina " + ind.gene[0][2].getNome());
        System.out.println("Disciplina " + ind.gene[0][3].getNome());
        System.out.println("Disciplina " + ind.gene[0][4].getNome());
        System.out.println("Disciplina " + ind.gene[1][0].getNome());
        System.out.println("Disciplina " + ind.gene[1][1].getNome());
        System.out.println("Disciplina " + ind.gene[1][2].getNome());
        System.out.println("Disciplina " + ind.gene[1][3].getNome());
        System.out.println("Disciplina " + ind.gene[1][4].getNome());

        Ind ind2 = (Ind) ind.clone();
        System.out.println("\nindividuo 2");
        System.out.println(ind2);
        System.out.println("Disciplina " + ind2.gene[0][0].getNome());
        System.out.println("Disciplina " + ind2.gene[0][1].getNome());
        System.out.println("Disciplina " + ind2.gene[0][2].getNome());
        System.out.println("Disciplina " + ind2.gene[0][3].getNome());
        System.out.println("Disciplina " + ind2.gene[0][4].getNome());
        System.out.println("Disciplina " + ind2.gene[1][0].getNome());
        System.out.println("Disciplina " + ind2.gene[1][1].getNome());
        System.out.println("Disciplina " + ind2.gene[1][2].getNome());
        System.out.println("Disciplina " + ind2.gene[1][3].getNome());
        System.out.println("Disciplina " + ind2.gene[1][4].getNome());

        Ind ind3 = new Ind();
        System.out.println("\nindividuo 3");
        System.out.println(ind3);
        System.out.println("Disciplina " + ind3.gene[0][0].getNome());
        System.out.println("Disciplina " + ind3.gene[0][1].getNome());
        System.out.println("Disciplina " + ind3.gene[0][2].getNome());
        System.out.println("Disciplina " + ind3.gene[0][3].getNome());
        System.out.println("Disciplina " + ind3.gene[0][4].getNome());
        System.out.println("Disciplina " + ind3.gene[1][0].getNome());
        System.out.println("Disciplina " + ind3.gene[1][1].getNome());
        System.out.println("Disciplina " + ind3.gene[1][2].getNome());
        System.out.println("Disciplina " + ind3.gene[1][3].getNome());
        System.out.println("Disciplina " + ind3.gene[1][4].getNome());

        ind2.gene = (Disciplina[][]) ind3.gene.clone();
        ind2 = (Ind) ind3.clone();
//        for (int i = 0; i < ind.encontros; i++) {
//            for (int j = 0; j < ind.diasSemana; j++) {
//                try {
//                    ind2.gene[i][j] = (Disciplina) ind3.gene[i][j].clone();
//                } catch (CloneNotSupportedException e) {
//                    throw new Error("Exception in the Clone");
//                }
//            }
//        }

        System.out.println("\nindividuo 2");
        System.out.println(ind2);
        System.out.println("Disciplina " + ind2.gene[0][0].getNome());
        System.out.println("Disciplina " + ind2.gene[0][1].getNome());
        System.out.println("Disciplina " + ind2.gene[0][2].getNome());
        System.out.println("Disciplina " + ind2.gene[0][3].getNome());
        System.out.println("Disciplina " + ind2.gene[0][4].getNome());
        System.out.println("Disciplina " + ind2.gene[1][0].getNome());
        System.out.println("Disciplina " + ind2.gene[1][1].getNome());
        System.out.println("Disciplina " + ind2.gene[1][2].getNome());
        System.out.println("Disciplina " + ind2.gene[1][3].getNome());
        System.out.println("Disciplina " + ind2.gene[1][4].getNome());

        ind2.gene[0][0] = ind2.gene[1][4];
        
        System.out.println("\nindividuo 3");
        System.out.println(ind3);
        System.out.println("Disciplina " + ind3.gene[0][0].getNome());
        System.out.println("Disciplina " + ind3.gene[0][1].getNome());
        System.out.println("Disciplina " + ind3.gene[0][2].getNome());
        System.out.println("Disciplina " + ind3.gene[0][3].getNome());
        System.out.println("Disciplina " + ind3.gene[0][4].getNome());
        System.out.println("Disciplina " + ind3.gene[1][0].getNome());
        System.out.println("Disciplina " + ind3.gene[1][1].getNome());
        System.out.println("Disciplina " + ind3.gene[1][2].getNome());
        System.out.println("Disciplina " + ind3.gene[1][3].getNome());
        System.out.println("Disciplina " + ind3.gene[1][4].getNome());
        
        
        System.out.println("\nindividuo 1");
        System.out.println(ind);
        System.out.println("Disciplina " + ind.gene[0][0].getNome());
        System.out.println("Disciplina " + ind.gene[0][1].getNome());
        System.out.println("Disciplina " + ind.gene[0][2].getNome());
        System.out.println("Disciplina " + ind.gene[0][3].getNome());
        System.out.println("Disciplina " + ind.gene[0][4].getNome());
        System.out.println("Disciplina " + ind.gene[1][0].getNome());
        System.out.println("Disciplina " + ind.gene[1][1].getNome());
        System.out.println("Disciplina " + ind.gene[1][2].getNome());
        System.out.println("Disciplina " + ind.gene[1][3].getNome());
        System.out.println("Disciplina " + ind.gene[1][4].getNome());
    }

    private static class Ind implements Cloneable {

        Disciplina gene[][];
        int encontros = 2;
        int diasSemana = 5;

        public Ind() {
            gerarGene();
        }

        public void gerarGene() {
        Random rand = new Random();
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

        public Disciplina[][] getGene() {
            return gene;
        }

        public void setGene(Disciplina[][] gene) {
            this.gene = gene;
        }

        public int getEncontros() {
            return encontros;
        }

        public void setEncontros(int encontros) {
            this.encontros = encontros;
        }

        public int getDiasSemana() {
            return diasSemana;
        }

        public void setDiasSemana(int diasSemana) {
            this.diasSemana = diasSemana;
        }

        
        @Override
        protected Object clone() throws CloneNotSupportedException {
            Ind cloned = (Ind) super.clone();
            cloned.setGene((Disciplina[][]) cloned.getGene().clone());
            cloned.setDiasSemana((int) cloned.getDiasSemana());
            cloned.setEncontros((int) cloned.getEncontros());
            return cloned;
        }
    }

}
