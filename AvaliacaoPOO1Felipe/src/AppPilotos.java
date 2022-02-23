import java.io.IOException;
import java.util.Scanner;

import apppilotos.Pessoa;
import apppilotos.Piloto;

public class AppPilotos 
{
    public static void main(String[] args) throws InterruptedException, IOException 
    {
        final int MAX_ELEMENTOS = 20;
        int opcao, qtdCadastrados = 0;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);
        Pessoa[] vetor = new Pessoa[MAX_ELEMENTOS];
        int NovoMax = MAX_ELEMENTOS;

        do 
        {
            limpar(in);
            System.out.println("\n**\nMENU\n**\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) 
            {
                limpar(in);
                if (MAX_ELEMENTOS == NovoMax)
                {
                    // Se não tem mais espaço no vetor, caio fora
                    if (qtdCadastrados == MAX_ELEMENTOS) 
                    {
                        System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                        voltarMenu(in);
                        continue;
                    }
                }else
                {
                    // Se não tem mais espaço no vetor atualizado, caio fora
                    if (qtdCadastrados == NovoMax)
                    {
                        System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                        voltarMenu(in);
                        continue;
                    }
                }

                //Cadastre seu piloto aqui
                System.out.println("\nINFORME OS DADOS DO PILOTO");
                
                System.out.println("\nNome:");
                String nome = in.nextLine();

                System.out.println("\nCPF:");
                String cpf = in.nextLine();

                // Ou mais ou menos dígitos, pede o valor de cpf novamente
                while (cpf.length() != 11)
                {
                    limpar(in);
                    System.out.println("-ERRO- CPF DEVE CONTER 11 DÍGITOS");
                    System.out.println("\nCPF:");
                    cpf = in.nextLine();
                }

                System.out.println("\nBreve:");
                String breve = in.nextLine();

                System.out.println("\nMatrícula:");
                String matricula = in.nextLine();

                Pessoa p1 = new Piloto();
                p1.pilotoAbstrato().setNome(nome);
                p1.pilotoAbstrato().setCpf(cpf);
                p1.pilotoAbstrato().setBreve(breve);
                p1.pilotoAbstrato().setMatricula(matricula);

                pilotos [qtdCadastrados] = p1;
                qtdCadastrados++;
                
                limpar(in);
                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(in);
            } else if (opcao == 2) 
            {
                limpar(in);
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) 
                {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                // Exiba os pilotos aqui
                System.out.println("PILOTOS CADASTRADOS:");

                for(int i = 0; i < qtdCadastrados; i++ )
                {
                    System.out.printf("\nPiloto: %s", pilotos[i].pilotoAbstrato().getNome());
                    System.out.printf("\nCPF: %s", pilotos[i].pilotoAbstrato().getCpf());
                    System.out.printf("\nBreve: %s", pilotos[i].pilotoAbstrato().getBreve());
                    System.out.printf("\nMatrícula: %s", pilotos[i].pilotoAbstrato().getMatricula());      
                    System.out.println("\n----------------------------------------------------\n");              
                }

                voltarMenu(in);
            } else if (opcao == 3) 
            {
                boolean equal = false;
                int achar = 0;
                limpar(in);

                System.out.println("\nINFORME O CPF: ");
                String cpff = in.nextLine();

                // Busca o cpf dentro do vetor, igual ao que o usuário informou
                for(int i = 0; i < qtdCadastrados; i++)
                {
                    if(pilotos[i].getCpf().equals(cpff))
                    {
                        equal = true;
                        achar = i;
                        i = qtdCadastrados;
                    }
                }
                if(equal)
                {
                    limpar(in);
                    System.out.printf("\nPiloto: %s LOCALIZADO(A) PELO CPF: %s\n", pilotos[achar].getNome(), 
                    pilotos[achar].getCpf());
                }else
                {
                    limpar(in);
                    System.out.println("\n-ERRO: CPF NÃO CADASTRADO-");
                }
                voltarMenu(in);
            } else if (opcao == 4) 
            {
                limpar(in);
                System.out.println("\n\nINFORME O NOVO ESPAÇO DE ARMAZENAMENTO DESEJADO:");
                int valor = in.nextInt();
                in.nextLine();

                NovoMax = valor;
                // Copia o conteúdo do vetor antigo para o vetor temporário 
                vetor = new Pessoa[NovoMax];
                for (int i = 0; i < pilotos.length; i++)
                {
                    vetor[i] = pilotos[i];
                }

                // Reseta o vetor antigo e o atualiza com o novo espaço
                pilotos = new Pessoa[NovoMax];

                // Copia o conteúdo do vetor temporário para o vetor atualizado
                for (int i = 0; i < vetor.length; i++)
                {
                    pilotos[i] = vetor[i];
                }

                limpar(in);
                System.out.println("\nESPAÇO DE ARMAZENAMENTO CRIADO COM SUCESSO!\n");
                voltarMenu(in);

            }
            else if (opcao != 0) 
            {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException 
    {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }

    private static void limpar(Scanner in) throws InterruptedException, IOException 
    {
        // Limpa toda a tela, deixando apenas a informação do usuário
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}
