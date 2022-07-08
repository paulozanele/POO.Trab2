import java.util.ArrayList;
import java.util.Scanner;

public class Gerentes {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Gerente> listaGerentes = new ArrayList<Gerente>();

	public static void addGerente(){
		Gerente gerente;
		Data data_nasc, data_adm;

		// Inicializa objetos
		gerente = new Gerente();
		data_nasc = new Data();
        data_adm = new Data();
		
		// Recebe os dados
		System.out.print("Digite RG: ");
		gerente.setRG(sc.nextLine());
		
		System.out.print("Digite nome: ");
		gerente.setNome(sc.nextLine());
		
		System.out.print("Digite data de nascimento - dia: ");
		data_nasc.setDia(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de nascimento - mes: ");
		data_nasc.setMes(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de nascimento - ano: ");
		data_nasc.setAno(Integer.parseInt(sc.nextLine()));

		gerente.setData_nasc(data_nasc);

        System.out.print("Digite data de admissao - dia: ");
		data_adm.setDia(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de admissao - mes: ");
		data_adm.setMes(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de admissao - ano: ");
		data_adm.setAno(Integer.parseInt(sc.nextLine()));

        gerente.setData_adm(data_adm);

        System.out.print("Digite salario: ");
		gerente.setSalario(Integer.parseInt(sc.nextLine()));

        System.out.print("Digite anos de experiencia: ");
		gerente.setAnos_xp(Integer.parseInt(sc.nextLine()));

		System.out.println();

		// Adiciona gerente na lista Gerentes
		listaGerentes.add(gerente);

		System.out.print("Gerente cadastrado com sucesso.\n");
	}

	public static void imprimeGerentes(){
		// Verifica lista vazia
		if(listaGerentes.isEmpty()){
			System.out.print("Nao existem gerentes cadastrados, pressione uma tecla para continuar!");
			sc.nextLine();
		}else{
			// Imprime lista Gerentes
			System.out.println(listaGerentes.toString());
			System.out.print("Pressione uma tecla para continuar!");
			sc.nextLine();
		}
	}

	public static void removeGerente(){
        int i, j;
        Gerente novo, aux1, aux2;
        Vendedor aux3;

        // Inicializa objetos
        novo = new Gerente();
        aux1 = new Gerente();
        aux2 = new Gerente();
        aux3 = new Vendedor();
        
        System.out.print("Digite RG do gerente: ");
        aux1.setRG(sc.nextLine());

        for(i=0; i<listaGerentes.size(); i++){
            aux2 = listaGerentes.get(i);
            if(aux1.getRG().equals(aux2.getRG())){
                // Procura Gerente do vendedor na lista Vendedores
                for(j=0; j<Vendedores.listaVendedores.size(); j++){
                    aux3 = Vendedores.listaVendedores.get(j);
                    aux2 = aux3.getResp();
                    if(aux1.getRG().equals(aux2.getRG())){
                        // Atualiza Gerente do vendedor do cliente para null, da lista Onibus
                        Vendedores.listaVendedores.get(j).setResp(novo);
                    }
                }
                // Remove Gerente da lista Gerentes
                listaGerentes.remove(i);
                System.out.print("Gerente removido com sucesso.");
            }else
                System.out.print("\nErro: CNH invalida.\n");
        }
    }
	
	public static void verificaGerente(){
		Gerente aux1 = new Gerente();

		String verifica;
		System.out.print("Informe o RG do gerente para verificação do cadastro: ");
		verifica = sc.nextLine();
		for (int i = 0; i<listaGerentes.size(); i++){
			aux1 = listaGerentes.get(i);
			//Verifica se o ID corresponde a algum gerente presente na lista de Gerentees
			if(verifica.equals(aux1.getRG())){  //Verificar sintaxe
			   System.out.print("Confirmação realizada com sucesso.\n");
			}else{
				System.out.print("O RG não corresponde a nenhum Gerente cadastrado.");
				break;
			}   
		}
	}

	public static void dadosGerentees(){
		int op = 1;
		
		while (op != 0){
			System.out.println("_______________________");
			System.out.println("(1) Cadastrar gerente");
			System.out.println("(2) Imprimir gerentes cadastrados");
            //System.out.println("(3) Altera salario");
			System.out.println("(4) Remove gerente");
			System.out.println("(0) Voltar");
			System.out.println("_______________________");
			System.out.print("Digite aqui sua opcao: ");
			op = Integer.parseInt(sc.nextLine());

			switch (op) {
                case 1:
                    addGerente();
                    break;

                case 2:
                    imprimeGerentes();
                    break;

				case 4:
					removeGerente();

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