
package app;

import java.sql.SQLException;
import java.util.Scanner;
import controler.ClientCtl;
import model.ClientMdl;

public class App {
    public static void main(String[] args) throws SQLException, Exception {

        try (Scanner scanner = new Scanner(System.in)) {
            ClientCtl clientCtl = new ClientCtl();
            ClientMdl clientMdl = new ClientMdl();
            
            int vMenu;

            while(true) {
                System.out.println(
                    "\n\n Menu: \n\n"+
                    " 1 - ( C ) Incluir novo cliente \n"+
                    " 2 - ( R ) Listar clientes \n"+
                    " 3 - ( U ) Alterar cliente \n"+
                    " 4 - ( D ) Deletar cliente \n"+
                    " 5 - Sair"
                );
                System.out.print("\n Opcao: ");
                vMenu = scanner.nextInt();
                
            switch(vMenu) {
                case 1:
                    // create
                    String nome;
                    int idade;

                    System.out.print(" Qual o nome do cliente : ");
                    nome = scanner.next();

                    System.out.print(" Qual a idade do cliente: ");
                    idade = scanner.nextInt();

                    clientMdl.setNome(nome);
					clientMdl.setIdade(idade);

                    if (clientCtl.insert(clientMdl)) {
                        System.out.println("\n\n Cliente inserido OK. ");
                    } else {
                        System.out.println("\n\n Erro para inserir o cliente \n Confirme as informacoes! \n");
                    }
                    break;
                    case 2:
                        // read        
                        for(ClientMdl cliList : clientCtl.getAll()) {
                            System.out.println(" Id: "+ cliList.getId());
                            System.out.println(" Nome: "+ cliList.getNome());
                            System.out.println(" Idade: "+ cliList.getIdade()+"\n");
                        }
                        break;
                    case 3:
                        // update
                        System.out.print(" Digite o ID do cliente para Atualizar: ");
                        int id = scanner.nextInt();
    
                        System.out.print(" Novo nome: ");
                        nome = scanner.next();
    
                        System.out.print(" Nova idade: ");
                        idade = scanner.nextInt();
    
                        if (clientCtl.update(id, nome, idade) != true) {
                             System.out.println(" \n\n Erro para alterar o cliente \n Confirme as informacoes! \n");
                        } else {
                            clientCtl.update(id, nome, idade);
                            System.out.println("\n\n Atualizado com sucesso\n");
                        }
                        break;    
                    case 4:
                        // delete
                        System.out.print(" Digitar o ID para deletar o cliente: ");
                        id = scanner.nextInt();

                        if (clientCtl.delete(id) != true) {
                            System.out.println("\n\n Erro para deletar o cliente \n Confirme as informacoes! \n");
                        } else {
                            clientCtl.delete(id);
                            System.out.println("\n\n Delete OK. \n");
                        }
                        break;
                    case 5:
                        // sair
                        System.out.println("\n\n Sair \n");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\n\n Opticao invalida! \n");
            }
            String vMenuVerificar = "S";
                 
            switch(vMenuVerificar) {
                case "S":
                    break;
                case "N":
                    System.exit(0);
                    break;           
                }
            }
        }
    }
}
