import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        int op, mat;
        Figueira figueira =new Figueira();
        do{
            System.out.println("MENU FIGUEIRA");
            System.out.println("1- Inserir");
            System.out.println("2- Remover");
            System.out.println("3- Buscar");
            System.out.println("4- Imprimir");
            System.out.println("10- Sair");
            System.out.println("Digite a opção:");
            op=tc.nextInt();
            switch (op){
                case 1:{
                    System.out.println("Digite a matricula:");
                    mat=tc.nextInt();
                    Nodo n = new Nodo(mat);
                    figueira.inserir(n);
                }
                break;
                case 3:{
                    System.out.println("Encontrar matricula:");
                    mat=tc.nextInt();
                    if(figueira.busca(mat)!=null){
                        System.out.println("Matricula encontrada.");
                    }
                }
                break;
                case 4:{
                    int op2;
                    do{
                        System.out.println("Menu de Impressao");
                        System.out.println("1- Em Ordem");
                        System.out.println("2- Pre Ordem");
                        System.out.println("3- Pos Ordem");
                        System.out.println("4- Sair");
                        op2 = tc.nextInt();

                        switch (op2){
                            case 1:{
                                figueira.emFixa();
                            }
                            break;
                            case 2:{
                                figueira.preFixa();
                            }
                            break;
                            case 3:{
                                figueira.posFixa();
                            }
                        }
                    }while (op2!=4);
                }
                break;
                case 2:{
                    System.out.println("Digite a matricula a ser excluida:");
                    mat=tc.nextInt();
                    figueira.remocao(mat);
                }
            }
        }while(op!=10);
    }
}
