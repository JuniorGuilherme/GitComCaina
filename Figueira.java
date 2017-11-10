public class Figueira {
    int matricula;
    Nodo raiz;
    Figueira esquerda;
    Figueira direita;

    public void inserir(Nodo n) {
        //Verifica se a arvore é nula.
        if (this.raiz != null) {
            //Verifica se o valor(matricula) é menor que o valor(matricula da subarvore atual)
            if (n.matricula>this.raiz.matricula) {
                if (this.direita == null) {
                    System.out.println("Matricula: " + n.matricula + ", inserida a direita de " + this.raiz.matricula);
                    this.direita = new Figueira();
                }
                this.direita.inserir(n);
            } else if (n.matricula<this.raiz.matricula) {
                if (this.esquerda == null) {
                    System.out.println("Matricula: " + n.matricula + ", inserida a esquerda de " + this.raiz.matricula);
                    this.esquerda = new Figueira();
                }
                this.esquerda.inserir(n);
            }
        } else {
            this.raiz = n;
        }
    }

    public Nodo busca(int mat) {
        if (this.raiz != null) {
            if (this.raiz.matricula != mat) {
                if (mat > this.raiz.matricula) {
                    if (this.direita != null) {
                        return this.direita.busca(mat);
                    } else {
                        return null;
                    }
                } else {
                    if (this.esquerda != null) {
                        return this.esquerda.busca(mat);
                    } else {
                        return null;
                    }
                }
            } else {
                return this.raiz;
            }
        }else {
            return null;
        }
    }

    public void remocao(int mat) {

        if (this.raiz == null) {
            System.out.println("Arvore vazia.");
            return;
        }

        if(mat <this.raiz.matricula){
            this.esquerda.remocao(mat);
        }
        else{
            if(mat>this.raiz.matricula){
                this.direita.remocao(mat);
            }
            else{
                Nodo aux = this.raiz;
                if(this.esquerda==null && this.direita == null){ //SE NAO TIVER FILHOS
                    System.out.println("Matricula: "+this.raiz.matricula+(" removida."));
                    this.raiz = null;
                }
                else{ //SO TEM FILHO DA DIREITA
                    if(this.esquerda==null){
                        System.out.println("Matricula: "+this.raiz.matricula+(" removida."));
                        this.raiz=this.direita.raiz;
                        this.direita=null;
                    }
                    else{ //SO TEM FILHO DA ESQUERDA
                        if(this.direita== null){
                            System.out.println("Matricula: "+this.raiz.matricula+(" removida."));
                            this.raiz = this.esquerda.raiz;
                            this.esquerda = null;
                        }
                        else{ //POSUUI DOIS FILHOS
                            System.out.println("Matricula: "+this.raiz.matricula+(" removida."));
                            Figueira fAux = this.retornaMax(this.direita);
                            this.raiz.matricula=fAux.raiz.matricula;
                            fAux=null;
                        }
                    }
                }
            }
        }

    }

    public Figueira retornaMax(Figueira f){
        if(f==null){
            System.out.println("Erro encontrado");
            return null;
        }else if(f.esquerda!=null){
            f=retornaMax(f.esquerda);
            return f;
        }else{
            return f;
        }
    }

    public void emFixa(){
        if(this.raiz== null){
            return;
        }
        if (this.esquerda != null){
            this.esquerda.emFixa();
        }
        System.out.println("Matricula: "+this.raiz.matricula);

        if(this.direita != null){
            this.direita.emFixa();
        }
    }


    public void preFixa(){
        if(this.raiz== null){
            return;
        }
        System.out.println("Matricula: "+this.raiz.matricula);
        if (this.esquerda != null){
            this.esquerda.preFixa();
        }

        if(this.direita != null){
            this.direita.preFixa();
        }
    }

    public void posFixa(){
        if(this.raiz== null){
            return;
        }

        if (this.esquerda != null){
            this.esquerda.posFixa();
        }

        if(this.direita != null){
            this.direita.posFixa();
        }
        System.out.println("Matricula: "+this.raiz.matricula);
    }
}
