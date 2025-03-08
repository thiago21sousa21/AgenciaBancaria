package programa;

import utilitarios.Utils;

public class Conta {
	private static int contador = 1;
	private int numeroConta;
	private Pessoa pessoa;
	private double saldo;
	
	public Conta(Pessoa pessoa) {
		this.numeroConta = contador;
		this.pessoa = pessoa;
		contador+=1;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		String s = "";
		s+= "numero da conta: " + this.getNumeroConta() + "\n";
		s+= pessoa.toString();
		s+= "saldo: " + Utils.doubleToString(this.getSaldo()) + "\n";
		return s;
	}
	
	public void depositar(double valor) {
		if(valor > 0) {
			setSaldo(valor + getSaldo());
			System.out.println("Seu deposito foi realizado com sucesso");
		} else {
			System.out.println("Não foi possivel realizar seu deposito");
		}
	}
	
	public void sacar(double valor) {
		if(valor > 0 && getSaldo() >= valor) {
			setSaldo(getSaldo()-valor);
			System.out.println("Seu saque foi realizado com sucesso");
		} else {
			System.out.println("Você não tem saldo suficiente");
		}
	}
	
	public void transferir(Conta contaParaDeposito, double valor) {
		if(valor > 0 && getSaldo() >= valor) {
			setSaldo(getSaldo()-valor);
			contaParaDeposito.setSaldo(contaParaDeposito.getSaldo()+valor);
			System.out.println("Transferência realizada com sucesso");
		}else {
			System.out.println("Não foi possivel realizar a transferência");
		}
	}
}
