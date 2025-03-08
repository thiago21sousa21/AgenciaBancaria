package programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;
	
	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes() {
		String s = "";
		s+= "------------------------------------------------------------" + "\n";
		s+= "--------------- Bem vindo ao Aguin's Banco ---------------" + "\n";
		s+= "------------------------------------------------------------" + "\n";
		s+= "--------***** Selecione a opção que desejar: *****----------" + "\n";
		s+= "------------------------------------------------------------" + "\n";
		s+= "Opção 1 - Criar conta" + "\n";
		s+= "Opção 2 - Depositar" + "\n";
		s+= "Opção 3 - Sacar" + "\n";
		s+= "Opção 4 - Transferir" + "\n";
		s+= "Opção 5 - Listar" + "\n";
		s+= "Opção 6- Sair" + "\n";
		System.out.println(s);
		
		int option = input.nextInt();
		
		switch (option) {
		case 1: 
			criarConta();
			break;
		case 2: 
			depositar();
			break;
		case 3: 
			sacar();
			break;
		case 4: 
			transferir();
			break;
		case 5: 
			listar();
			break;
		case 6: 
			System.out.println("Obrigado pela preferência!");
			System.exit(0);
		default:
			System.out.println("Opção inválida");
		}
	}
	
	public static void criarConta() {
	    Scanner input = new Scanner(System.in); // Certifique-se de ter um Scanner

	    // Buscar dados da pessoa para inserir na classe Pessoa
	    System.out.println("Digite seu nome: ");
	    String nome = input.nextLine(); // Mantém nextLine() para capturar nome completo

	    System.out.println("Digite seu CPF: ");
	    String cpf = input.next(); // Continua usando next() para CPF, pois não tem espaços

	    input.nextLine(); // Consumir o caractere de nova linha pendente

	    System.out.println("Digite seu email: ");
	    String email = input.nextLine(); // Usa nextLine() para capturar e-mails completos

	    Pessoa pessoa = new Pessoa(nome, cpf, email);

	    // Criar a conta
	    Conta conta = new Conta(pessoa);
	    contasBancarias.add(conta);

	    System.out.println("A conta foi criada com sucesso!\n");
	    System.out.println(conta.toString());

	    operacoes();
	}

	
	public static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for( Conta c : contasBancarias) {
				if(c.getNumeroConta() == numeroConta) {
					return c;
				}
			}
		}
		return conta;
	}
	
	public static void depositar() {
		System.out.println("Digite o numero da conta: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if (conta != null) {
			System.out.println("Digite o valor a ser depositado: ");
			double valor = input.nextDouble();
			
			conta.depositar(valor);
		} else {
			System.out.println("Conta não encontrada");
		}
		
		operacoes();
	}
	
	public static void sacar () {
		
		System.out.println("Digite o numero da conta: ");
		int numeroConta = input.nextInt();
		Conta conta = encontrarConta(numeroConta);
		if (conta != null) {
			System.out.println("Digite o valor a ser sacado: ");
			double valor = input.nextDouble();
			conta.sacar(valor);
		} else {
			System.out.println("Conta não encontrada");
		}
		operacoes();
	}
	
	public static void transferir() {
		System.out.println("Digite o numero da conta que vai transferir:");
		int numeroContaRemetente = input.nextInt();
		Conta remetente = encontrarConta(numeroContaRemetente);
		if (remetente != null) {
			System.out.println("Digite o numero da conta que vai receber:");
			int numeroDestinatario = input.nextInt();
			Conta destinatario = encontrarConta(numeroDestinatario);
			if (destinatario != null) {
				System.out.println("Digite o valor a ser transferido: ");
				double valor = input.nextDouble();
				remetente.transferir(destinatario, valor);				
			} else {
				System.out.println("Conta destino não encontrada");
			}		
			
		} else {
			System.out.println("Conta não encontrada");
		}
		operacoes();
	}
	
	public static void listar() {
		if(contasBancarias.size() > 0) {
			for ( Conta conta : contasBancarias) {
				System.out.println(conta);
			}
		}else {
			System.out.println("Não há contas cadastradas");
		}
		operacoes();
	}
}
