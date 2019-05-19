public class No {
    private No esquerda;
    private No direita;
    private int dado;

    No(int dado){
        this.dado = dado;
        this.direita = null;
        this.esquerda = null;
    }

    void insere_esquerda(No esquerda){
        this.esquerda = esquerda;
    }

    void insere_direita(No direita){
        this.direita = direita;
    }

    int retorna_dado(){
        return this.dado;
    }

    void alt_dado(int dado){
        this.dado = dado;
    }

    No esquerda(){
        return this.esquerda;
    }

    No direita(){
        return this.direita;
    }

    void altesq(No novo){
        this.esquerda = novo;
    }

    void altdir(No novo){
        this.direita = novo;
    }
}
