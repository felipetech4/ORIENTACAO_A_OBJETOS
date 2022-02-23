import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import classes.Produto;
import classes.Venda;

public class Programa 
{
    public static void main(String[] args) throws InterruptedException, IOException
    {   
        Scanner in = new Scanner(System.in);

        int opcao;

        ArrayList <Produto> produtos = new ArrayList<>();

        ArrayList <Venda> vendas = new ArrayList<>();


        do 
        {
            clean(in);
            System.out.println("-----------------------------------------");
            System.out.println("*****   SUPERMERCADO COCO SERRANO   *****");
            System.out.println("-----------------------------------------");
            System.out.println("1 - Incluir produto");
            System.out.println("2 - Listagem de produtos");
            System.out.println("3 - Consultar produto");
            System.out.println("4 - Realizar venda");
            System.out.println("5 - Vendas por período - Detalhado");
            System.out.println("0 - Sair");
            System.out.print("\nOpção: ");

            opcao = in.nextInt();
            in.nextLine();
            
            switch (opcao) 
            {
                case 1:
                    clean(in);
                    
                    System.out.println("-----------------------------------");
                    System.out.println("          INCLUIR PRODUTO          ");
                    System.out.println("-----------------------------------");

                    
                    System.out.print("Informe o nome do produto: ");
                    String nome = in.nextLine();

                    System.out.print("\nCódigo: ");
                    String cod = in.nextLine();

                    System.out.print("\nValor: R$");
                    double valor = in.nextDouble();

                    System.out.print("\nQuantidade em estoque: ");
                    int estoque = in.nextInt();
                    in.nextLine();

                    Produto p1 = new Produto(nome, cod, valor, estoque);
                    

                    produtos.add(p1);

                    System.out.println("-----------------------------------");
                    System.out.println("    PRODUTO INCLUÍDO COM SUCESSO   ");
                    System.out.println("-----------------------------------");

                    voltarMenu(in);

                    break;
            
                case 2:
                    clean(in);
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    System.out.println("                                        PRODUTOS CADASTRADOS                                         ");
                    System.out.println("-----------------------------------------------------------------------------------------------------");

                    double maior = 0;
                    double menor = 10000000;
                    double valorr = 0;
                    double aux = 0;

                    for (int i = 0; i < produtos.size(); ++i)
                    {
                        new Produto();
                        produtos.get(i);
                        valorr += produtos.get(i).getValor();
                        aux = produtos.get(i).getValor();

                        if (menor > aux)
                        {
                            menor = produtos.get(i).getValor();
                        }

                        if (maior < aux)
                        {
                            maior = produtos.get(i).getValor();
                        }

                        System.out.printf("\nCódigo: %s | ", produtos.get(i).getCod());
                        System.out.printf("Produto: %s | ", produtos.get(i).getNome());
                        System.out.printf("Valor unitário: R$%s | ", produtos.get(i).getValor());
                        System.out.printf("Quantidade em estoque: %s \n\n", produtos.get(i).getEstoque()); 
                    }

                    double media = valorr / produtos.size();

                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    System.out.printf("Maior valor: R$%.2f                   ", maior);
                    System.out.printf("Menor valor: R$%.2f                   ", menor);
                    System.out.printf("Valor médio: R$%.2f                   \n", media);

                    voltarMenu(in);
                    break;
                
                case 3:
                    clean(in);
                    System.out.println("----------------------------------------");
                    System.out.println("           CONSULTA DE PRODUTOS         ");
                    System.out.println("----------------------------------------");
            
                    System.out.print("Código do produto a consultar: ");
                    String consultCod = in.nextLine();

                    for (int i = 0; i < produtos.size(); i++)
                    {
                    Produto novoP1 = new Produto();
                    novoP1 = produtos.get(i);

                    if (consultCod.equals(novoP1.getCod()))
                    {
                            clean(in);
                            System.out.println("----------------------------------------");
                            System.out.print("     PRODUTO ENCONTRADO: ");
                            System.out.printf("%s \n", novoP1.getNome());
                            System.out.println("----------------------------------------");
                            System.out.printf("Código: %s \n", novoP1.getCod());
                            System.out.printf("\nValor: R$%s \n", novoP1.getValor());
                            System.out.printf("\nQuantidade em estoque: %s \n", novoP1.getEstoque());
                            System.out.println("----------------------------------------");
                    }                       
                    }

                    voltarMenu(in);
                    break;
                
                case 4:
                    clean(in);

                    System.out.println("----------------------------------------");
                    System.out.println("              REALIZAR VENDA            ");
                    System.out.println("----------------------------------------");
    
                    System.out.print("Código do produto a vender: ");
                    String codVend = in.nextLine();
    
                    if (produtos.size() < 1)
                    {
                        clean(in);
                        System.out.println("----------------------------------------");
                        System.out.println("      NÃO HÁ PRODUTOS CADASTRADOS       ");
                        System.out.println("----------------------------------------");
                        
                        break;
                    }
    
                    int i = -1;
                    for (Produto pp : produtos)
                    {
                        if (pp.getCod().equals(codVend))
                        {
                            i = produtos.indexOf(pp);
                            break;
                        }
                    }
                        if (i == -1)
                        {
                            clean(in);
                            System.out.println("----------------------------------------");
                            System.out.println("         PRODUTO NÃO ENCONTRADO         ");
                            System.out.println("----------------------------------------"); 
                            break;
                        }
    
                        clean(in);
                        System.out.println("----------------------------------------");
                        System.out.println("              REALIZAR VENDA            ");
                        System.out.println("----------------------------------------");
                        System.out.printf("\nVocê selecionou o produto %s!", produtos.get(i).getNome());
                        System.out.printf("\n\n(QUANTIDADE DISPONÍVEL: %s un.)\n", produtos.get(i).getEstoque());
                        System.out.printf("\nQuantas unidades de %s vender: ", produtos.get(i).getNome());
                        int qtdVend = in.nextInt();
                        in.nextLine();

                        System.out.printf("\nData da venda (DD/MM/AAAA): ");
                        String dataVenda = in.nextLine();
                        
                        if (qtdVend > produtos.get(i).getEstoque())
                        {
                            clean(in);
                            System.out.println("----------------------------------------");
                            System.out.println("          ESTOQUE INSUFICIENTE          ");
                            System.out.println("----------------------------------------");
    
                            voltarMenu(in);
                            break;
                        }
    
                        clean(in);
                        System.out.printf("%s %s(s) vendido(a) com sucesso! \n", qtdVend, produtos.get(i).getNome());
    
                        produtos.get(i).diminuirQuant(qtdVend);
    
                        Venda v = new Venda(dataVenda, qtdVend, produtos.get(i));
                        vendas.add(v);
                    
                        voltarMenu(in);
                        break;

                case 5:
                clean(in);
                
                //Não consegui fazer
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    System.out.println("                                      VENDAS POR PERÍODO - DETALHADO                                 ");
                    System.out.println("-----------------------------------------------------------------------------------------------------");

                        for (Venda vv : vendas)
                        {
                            System.out.println(vv);
                        }

                voltarMenu(in);
                break;
            }

            if (opcao < 0 || opcao > 5)
            {
                System.out.println("\nOpção Inválida");
                voltarMenu(in);
            }
    
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException 
    {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
        System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }

    private static void clean(Scanner in) throws InterruptedException, IOException 
    {
        if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
        System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
    
}
