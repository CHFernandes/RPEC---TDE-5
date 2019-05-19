import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);
        int input;
        System.out.println("Digite um número de valores para a entrada estrutura de dados: ");
        input = scanner.nextInt();
        Random gerador = new Random();

        Arvore ent = new Arvore();
        int vetor[] = new int[input];

        long starta1 = System.currentTimeMillis();
        insere_arvore(ent, input, gerador);
        long elapseda1 = System.currentTimeMillis() - starta1;

        long startv1 = System.currentTimeMillis();
        insere_vetor(vetor, gerador);
        long elapsedv1 = System.currentTimeMillis() - startv1;

        System.out.println("Digite um número de valores para a busca na estrutura de dados: ");

        input = scanner.nextInt();
        long starta2 = System.currentTimeMillis();
        busca_arvore(ent, input, gerador);
        long elapseda2 = System.currentTimeMillis() - starta2;

        long startv2 = System.currentTimeMillis();
        busca_vetor(vetor, input, gerador);
        long elapsedv2 = System.currentTimeMillis() - startv2;

        System.out.println("Sistema levou: " + elapseda1 + " milisegundos para a execução do método inserção em árvore");
        System.out.println("Sistema levou: " + elapsedv1 + " milisegundos para a execução do método inserção em vetor");
        System.out.println("Sistema levou: " + elapseda2 + " milisegundos para a execução do método busca em árvore");
        System.out.println("Sistema levou: " + elapsedv2 + " milisegundos para a execução do método busca em vetor");
    }

    static void insere_arvore(Arvore ent, int input, Random gerador){
        for(int i = 0; i <= input; i++){
            ent.insere_elemento(gerador.nextInt());
        }
    }

    static void busca_arvore(Arvore ent, int input, Random gerador){
        for(int i = 0; i <= input; i++){
            System.out.println(ent.procurar(gerador.nextInt()));
        }
    }

    static void busca_vetor(int vetor[], int input, Random gerador){
        for (int i = input; i >= 0; i--){
            int gerado = gerador.nextInt();
            for (int o = vetor.length -1 ; o >= 0; o--){
                if (gerado == vetor[o]){
                    System.out.println("Dado " + gerado + " encontrado!");
                }
            }
        }
    }

    static void insere_vetor(int vetor[], Random gerador){

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = gerador.nextInt();
        }

        int atual;
        int indice;

        for (int i = vetor.length - 1; i>= 0; i--){
            atual = vetor[i];
            indice = i;

            while (indice < vetor.length - 1 && atual > vetor[indice + 1]){
                vetor[indice] = vetor[indice + 1];
                indice++;
            }
            vetor[indice] = atual;
        }
    }
}
