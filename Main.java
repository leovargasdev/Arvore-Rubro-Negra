import java.util.Scanner;
import java.util.*;

class Main{

    public static void main (String [] agrs){

        Arvore tree = new Arvore();

        Random gerador = new Random();

        int num = 0, op =0;

        long inicio, aux, media = 0, total;

        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("1 -> Inserir.");

            System.out.println("2 -> Inserir eleatoriamente.");

            System.out.println("3 -> Buscar prox 50.");

            System.out.println("0 -> Sair.");

            op = scanner.nextInt();

            if( op == 1 ){

                System.out.print("Digite a quantidade de Nodos:");

                num = scanner.nextInt();

                int nodo;

                for(int i = 0; i < num; i++) {

                    System.out.print("Nodo: ");

                    nodo = scanner.nextInt();

                    tree.add(tree.Raiz,nodo);

                    System.out.println();

                }

                tree.Imprimir(tree.Raiz);

            } else if (op == 2){
                System.out.print("\tDigite a quantidade de Nodos:");

                num = scanner.nextInt();

                inicio = System.nanoTime();

                for(int i = 0; i < num; i++) {

                  aux = System.nanoTime();

                  //tree.add(tree.Raiz,gerador.nextInt(2147483647));

                  tree.add(tree.Raiz,gerador.nextInt(2147));

                  media += System.nanoTime() - aux;

                }

                media /= num;

                System.out.printf("Média inserção: %.10f\n\n", (media/ 10e9));

                total = System.nanoTime() - inicio;

                System.out.printf("Tempo total: %.10f\n\n", (total/ 10e9));

            } else if (op == 3){

                System.out.print("Digite o Nodo para Prox50: ");

                num = scanner.nextInt();

                //tree.prox50(tree.Raiz,num,0);


            }

            System.out.println("\n\n---------------------------------\n\n");

        } while (op != 0);

    }

}
