import java.util.ArrayList;
import java.util.Scanner;

public class Clientes {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

	public static void addCliente(){
		Cliente cliente;
		Data data_nasc;
        End end;

		// Inicializa objetos
		cliente = new Cliente();
		data_nasc = new Data();
        end = new End();
		
		// Recebe os dados
		System.out.print("Digite CPF: ");
		cliente.setCPF(sc.nextLine());
		
		System.out.print("Digite nome: ");
		cliente.setNome(sc.nextLine());
		
		System.out.print("Digite data de nascimento - dia: ");
		data_nasc.setDia(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de nascimento - mes: ");
		data_nasc.setMes(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de nascimento - ano: ");
		data_nasc.setAno(Integer.parseInt(sc.nextLine()));

		cliente.setData_nasc(data_nasc);

        System.out.print("Digite rua: ");
		end.setRua(sc.nextLine());
		
		System.out.print("Digite numero: ");
		end.setNum(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite bairro: ");
		end.setBairro(sc.nextLine());

        System.out.print("Digite cidade: ");
		end.setCidade(sc.nextLine());

        cliente.setEndereco(end);

		System.out.println();

		// Adiciona Cliente na lista Clientees
		listaClientes.add(cliente);

		System.out.print("Cliente cadastrado com sucesso.\n");
	}

	public static void imprimeClientes(){
		// Verifica lista vazia
		if(listaClientes.isEmpty()){
			System.out.print("Nao existem clientes cadastrados, pressione uma tecla para continuar!");
			sc.nextLine();
		}else{
			// Imprime lista Clientes
			System.out.println(listaClientes.toString());
			System.out.print("Pressione uma tecla para continuar!");
			sc.nextLine();
		}
	}

	public static void excluiCliente(){
		Cliente aux1 = new Cliente();

		String verifica;
		System.out.print("Informe o CPF do cliente para exclusao: ");
		verifica = sc.nextLine();
		for (int i = 0; i<listaClientes.size(); i++){
			aux1 = listaClientes.get(i);
			//Verifica se o ID corresponde a algum Cliente presente na lista de Clientees
			if(verifica.equals(aux1.getCPF())){  //Verificar sintaxe
				listaClientes.remove(i);
			   	System.out.print("Exclusao realizada com sucesso.\n");
			}else{
				System.out.print("O CPF não corresponde a nenhum cliente cadastrado.");
				break;
			}   
		}
	}
	
	public static void verificaCliente(){
		Cliente aux1 = new Cliente();

		String verifica;
		System.out.print("Informe o RG do cliente para verificação do cadastro: ");
		verifica = sc.nextLine();
		for (int i = 0; i<listaClientes.size(); i++){
			aux1 = listaClientes.get(i);
			//Verifica se o ID corresponde a algum Cliente presente na lista de Clientees
			if(verifica.equals(aux1.getCPF())){  //Verificar sintaxe
			   System.out.print("Confirmação realizada com sucesso.\n");
			}else{
				System.out.print("O RG não corresponde a nenhum cliente cadastrado.");
				break;
			}   
		}
	}


	public static void dadosClientees(){
		int op = 1;
		
		while (op != 0){
			System.out.println("_______________________");
			System.out.println("(1) Cadastrar cliente");
			System.out.println("(2) Imprimir clientes cadastrados");
            //System.out.println("(3) Altera endereco");
            //System.out.println("(4) Altera renda");
			System.out.println("(5) Exclui cliente");
			System.out.println("(0) Voltar");
			System.out.println("_______________________");
			System.out.print("Digite aqui sua opcao: ");
			op = Integer.parseInt(sc.nextLine());

			switch (op) {
                case 1:
                    addCliente();
                    break;

                case 2:
                    imprimeClientes();
                    break;

				case 5:
					excluiCliente();

                case 0:
                    break;

                default:
                    System.out.print("Opcao invalida! Pressione uma tecla para continuar.");
                    sc.nextLine();
                    break;
            }
		}
	}
}