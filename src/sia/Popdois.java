/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia;

import java.util.ArrayList;

/**
 *
 * @author ivina
 */

//tem que adicionar sempre individuos novos?

public class Popdois {

    ArrayList<Inddois> horarios = new ArrayList<>();
    int tamanho = 5;

    public Popdois() {
        System.out.println("PRIMEIRA POPULACAO");
        ArrayList<Inddois> individuos = new ArrayList<>();
        for (int i = 0; i < tamanho; i++) {
            System.out.println("\nCriando o individuo" + (i + 1));
            Inddois ind = new Inddois();
            individuos.add(ind);
        }
        this.horarios.addAll(individuos);
    }

//    public Popdois(ArrayList<Inddois> populacaoantiga) {
//        System.out.println("POPULACAO NOVA");
//        int inicial = populacaoantiga.size();
//        for (int i = inicial; i < tamanho; i++) {
//            Inddois ind = new Inddois(true);
//            populacaoantiga.add(ind);
//        }
//        this.horarios = populacaoantiga;
//    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public ArrayList<Inddois> getHorarios() {
        return horarios;
    }

    public Inddois getHorario(int posicao) {
        return this.horarios.get(posicao);
    }

    public void retiraRuins() {
        ArrayList<Inddois> popMelhor = new ArrayList<>();
        for (int i = 0; i < this.tamanho; i++) {
            popMelhor.add(this.horarios.get(i));
        }
        this.horarios = popMelhor;
    }

    public void imprimirPop() {
//        System.out.println("____________________________");
        System.out.println("____________________________");
        System.out.println("_____POPULACAO_____");
//        System.out.println("____________________________");
//        System.out.println("____________________________");
        this.horarios.forEach((horario) -> {
            horario.imprimirGene();
//            System.out.println("-----------------------------");
//            System.out.println("");
        });
    }

    public void imprimirPopEndereco() {
//        System.out.println("____________________________");
        System.out.println("____________________________");
        System.out.println("_____POPULACAO_____");
//        System.out.println("____________________________");
//        System.out.println("____________________________");
        this.horarios.forEach((horario) -> {
            System.out.println(horario);
//            horario.imprimirInd();
//            horario.imprimirInd();
//            System.out.println("-----------------------------");
//            System.out.println("");
        });
    }

    public void gerarCopias() {
        int copias = 0;
        for (int i = 0; i < this.horarios.size(); i++) {
            if (this.horarios.get(i).getCopia()) {
                copias = this.horarios.get(i).getQtdCopias();
                while (copias > 0) {
                    Inddois copy = new Inddois();
                    copy = copy.clonar(this.horarios.get(i));
                    copy.setCopia(false);
                    horarios.add(copy);
                    copias--;
                }
            }
        }
    }

    //altera o gene dos individuos
//    public void mutarPop() {
//        for (int i = 0; i < horarios.size(); i++) {
//            if (!this.horarios.get(i).getCopia()) {
////                System.out.println("\nImprimindo o individuo antes de mutar");
////                this.horarios.get(i).imprimirInd();
//                this.horarios.get(i).mutarGene();
////                System.out.println("\nImprimindo o individuo depois da mutação");
////                this.horarios.get(i).imprimirInd();
//            } else {
////                System.out.println("\nImprimindo o individuo que nao foi mutado");
////                this.horarios.get(i).imprimirInd();
//            }
//        }
//    }

    public int getMedia() {
        int valor = 0;
        for (int i = 0; i < this.horarios.size(); i++) {
            valor += this.horarios.get(i).getNivelAptidao();
        }
        System.out.println("media na pop " + valor / this.horarios.size());
        return valor / this.horarios.size();
    }

    void atribuirCp(int media) {
        int cont = 0;
        for (int i = 0; i < this.horarios.size(); i++) {
//            System.out.println("aptidao " + this.horarios.get(i).getNivelAptidao());
            if (this.horarios.get(i).getNivelAptidao() > media) {
                this.horarios.get(i).setCopia(true);
                cont = 1;
            } else {
                this.horarios.get(i).setCopia(false);
            }
            if (cont == 0) {
                this.horarios.get(0).setCopia(true);
            }
        }
    }

    public Inddois getMelhor() {
        return this.horarios.get(0);
    }

    int size() {
        return this.horarios.size();
    }
}
