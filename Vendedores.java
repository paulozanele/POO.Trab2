import java.util.ArrayList;
import java.util.Scanner;

public class Vendedores {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Vendedor> listaVendedores = new ArrayList<Vendedor>();

	public static void addVendedor(){
		Vendedor vendedor;
		Data data_nasc, data_adm;

		// Inicializa objetos
		vendedor = new Vendedor();
		data_nasc = new Data();
        data_adm = new Data();
		
		// Recebe os dados
		System.out.print("Digite RG: ");
		vendedor.setRG(sc.nextLine());
		
		System.out.print("Digite nome: ");
		vendedor.setNome(sc.nextLine());
		
		System.out.print("Digite data de nascimento - dia: ");
		data_nasc.setDia(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de nascimento - mes: ");
		data_nasc.setMes(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de nascimento - ano: ");
		data_nasc.setAno(Integer.parseInt(sc.nextLine()));

		vendedor.setData_nasc(data_nasc);

		System.out.print("Digite data de admissao - dia: ");
		data_adm.setDia(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de admissao - mes: ");
		data_adm.setMes(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de admissao - ano: ");
		data_adm.setAno(Integer.parseInt(sc.nextLine()));

		vendedor.setData_nasc(data_adm);

		System.out.print("Digite tempo de treinamento restante: ");
		vendedor.setTempo_trein_rest(Integer.parseInt(sc.nextLine()));

		addGerente(vendedor);

		System.out.println();

		// Adiciona Vendedor na lista Vendedores
		listaVendedores.add(vendedor);

		System.out.print("Vendedor cadastrado com sucesso.\n");
	}

	public static void recebeVendedores(){
		// Recebe os vendedores do arquivo
	}

    public static Vendedor addGerente(Vendedor vendedor){
        int i;
        Gerente aux1, aux2;
        Vendedor novo = vendedor;

        // Inicializa objetos
        aux1 = new Gerente();

        System.out.print("Digite RG do gerente:");
        aux1.setRG(sc.nextLine());

        for(i=0; i<Gerentes.listaGerentes.size(); i++){
            aux2 = Gerentes.listaGerentes.get(i);
            if(aux1.getRG().equals(aux2.getRG())){
                    novo.setResp(aux2);
                    System.out.print("Gerente associado com sucesso.");
            }else
                System.out.print("\nErro: RG inválido.\n");
        }
        return novo;
    }

	public static void imprimeVendedores(){
		// Verifica lista vazia
		if(listaVendedores.isEmpty()){
			System.out.print("Nao existem vendedores cadastrados, pressione uma tecla para continuar!");
			sc.nextLine();
		}else{
			// Imprime lista Vendedores
			System.out.println(listaVendedores.toString());
			System.out.print("Pressione uma tecla para continuar!");
			sc.nextLine();
		}
	}

	public static void removeVendedor(){
		Vendedor aux1 = new Vendedor();

		String verifica;
		System.out.print("Informe o RG do vendedor para exclusao: ");
		verifica = sc.nextLine();
		for (int i = 0; i<listaVendedores.size(); i++){
			aux1 = listaVendedores.get(i);
			//Verifica se o ID corresponde a algum vendedor presente na lista de vendedores
			if(verifica.equals(aux1.getRG())){  //Verificar sintaxe
				listaVendedores.remove(i);
			   	System.out.print("Exclusao realizada com sucesso.\n");
			}else{
				System.out.print("O RG não corresponde a nenhum Vendedor cadastrado.");
				break;
			}   
		}
	}
	
	public static void verificaVendedor(){
		Vendedor aux1 = new Vendedor();

		String verifica;
		System.out.print("Informe o RG do Vendedor para verificação do cadastro: ");
		verifica = sc.nextLine();
		for (int i = 0; i<listaVendedores.size(); i++){
			aux1 = listaVendedores.get(i);
			//Verifica se o ID corresponde a algum vendedor presente na lista de Vendedores
			if(verifica.equals(aux1.getRG())){  //Verificar sintaxe
			   System.out.print("Confirmação realizada com sucesso.\n");
			}else{
				System.out.print("O RG não corresponde a nenhum Vendedor cadastrado.");
				break;
			}   
		}
	}

	public static void dadosVendedores(){
		int op = 1;
		
		while (op != 0){
			System.out.println("_______________________");
			System.out.println("(1) Cadastrar vendedor");
			System.out.println("(2) Imprimir vendedores cadastrados");
            //System.out.println("(3) Altera salario");
			System.out.println("(4) Remove vendedor");
			System.out.println("(0) Voltar");
			System.out.println("_______________________");
			System.out.print("Digite aqui sua opcao: ");
			op = Integer.parseInt(sc.nextLine());

			switch (op) {
                case 1:
                    addVendedor();
                    break;

                case 2:
                    imprimeVendedores();
                    break;

				case 4:
					removeVendedor();
					break;

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
