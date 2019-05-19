public class Arvore {
    private No root;

    Arvore(){
        this.root = null;
    }

    void insere_root(No no){
        this.root = no;
    }

    No meu_nome_eh_root(){
        return this.root;
    }

    boolean vazio(){
        if (this.root == null){
            return true;
        }else {
            return false;
        }
    }

    String procurar(int dado){
        No no = this.root;
        String retorno;
        while (no != null){
            if (no.retorna_dado() == dado){
                retorno = "Dado " + dado + " encontrado!";
                return retorno;
            }else {
                if (dado < no.retorna_dado()){
                    no = no.esquerda();
                }else {
                    no = no.direita();
                }
            }
        }
        retorno = "Dado " + dado + " não encontrado";
        return retorno;
    }

    void inordem(No no){
        if (no != null){
            inordem(no.esquerda());
            System.out.println(no.retorna_dado());
            inordem(no.direita());
        }
    }

    void preordem(No no){
        if (no != null){
            System.out.println(no.retorna_dado());
            preordem(no.esquerda());
            preordem(no.direita());
        }
    }

    void posordem(No no){
        if (no != null){
            posordem(no.esquerda());
            posordem(no.direita());
            System.out.println(no.retorna_dado());
        }
    }

    void insere_elemento(int dado) {

        if (vazio()){
            insere_root(new No(dado));
        }else {
            No no = meu_nome_eh_root();
            No aux = null;

            while (no != null) {
                aux = no;
                if (dado < no.retorna_dado()) {
                    no = no.esquerda();
                } else {
                    no = no.direita();
                }
            }
            if (dado < aux.retorna_dado()) {
                aux.insere_esquerda(new No(dado));
            } else {
                aux.insere_direita(new No(dado));
            }
        }
    }

    void remover(int dado){
        if (remove_elemento(dado)){
            System.out.println("Elemento removido");
        }else {
            System.out.println("Elemento inexistente");
        }
    }

    boolean remove_elemento(int dado){
        if (vazio()){
            System.out.println("Árvore vazia");
            return false;
        }else {

            No no = meu_nome_eh_root();
            No aux = null;

            while (no != null && no.retorna_dado() != dado) {
                aux = no;
                if (dado < no.retorna_dado()) {
                    no = no.esquerda();
                } else {
                    no = no.direita();
                }
            }

            if (no == null){
                return false;
            }

            if (no.direita() == null && no.esquerda() == null){
                if (no == meu_nome_eh_root()){
                    insere_root(null);
                    return true;
                }
                if (aux.esquerda() == no){
                    aux.altesq(null);
                    return true;
                } else {
                    aux.altdir(null);
                    return true;
                }
            }

            if (no.esquerda() != null && no.direita() != null){
                No dir = no.direita();

                if (aux.esquerda() == no){
                    no.alt_dado(busca(dir, aux.esquerda()));
                    aux.altesq(no);

                }else {
                    no.alt_dado(busca(dir, aux.direita()));
                    aux.altdir(no);
                }

                return true;
            }else {
                if (no.direita() == null){
                    if (no == meu_nome_eh_root()){
                        insere_root(no.esquerda());
                        return true;
                    }
                    if (aux.esquerda() == no){
                        aux.altesq(no.esquerda());
                        return true;
                    } else {
                        aux.altdir(no.esquerda());
                        return true;
                    }
                } else {
                    if (no == meu_nome_eh_root()) {
                        insere_root(no.direita());
                        return true;
                    }
                    if (aux.esquerda() == no) {
                        aux.altesq(no.direita());
                        return true;
                    } else {
                        aux.altdir(no.direita());
                        return true;
                    }
                }
            }
        }
    }

    static int busca(No no, No aux){
        No pai = aux;

        while (no.esquerda() != null){
            pai = no;
            no = no.esquerda();
        }

        if (pai != aux){
            pai.altesq(no.direita());
        }else {
            pai.altdir(null);
        }

        return no.retorna_dado();

    }

    int nivel(No no){
        if (no == null){
            return -1;
        }else {
            int esq = nivel(no.esquerda()) + 1;
            int dir = nivel(no.direita()) + 1;
            if (esq >= dir){
                return esq;
            }else {
                return dir;
            }
        }
    }

    int altura(){
        if (vazio()){
            return -1;
        } else {
            return nivel(meu_nome_eh_root());
        }
    }
}
