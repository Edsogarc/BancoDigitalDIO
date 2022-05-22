import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Conta cc = new ContaCorrente(cliente1);
		Conta poupanca = new ContaPoupanca(cliente2);
		
		boolean op = true;
		while(op) {
			System.out.print("Digite 1 Conta Corrente, 2 Poupança ou 0 para sair: ");
			int x = scan.nextInt();
			if(x == 1) {
				System.out.print("Nome do Titular: ");
				String nome = scan.next();
				cliente1.setNome(nome);
				cc = new ContaCorrente(cliente1);
				System.out.print("Digite 1 Depositar, 2 Transferir ou 0 para sair: ");
				int n = scan.nextInt();
				if(n == 1) {
					System.out.print("Digite o valor de Deposito: ");
					double valor = scan.nextDouble();
					cc.Depositar(valor);
				} else if(n == 2) {
					System.out.print("Digite o valor de Transferência: ");
					double valor1 = scan.nextDouble();
					cc.Transferir(valor1, poupanca);
				} else {
					op = false;
				}
			}else if(x == 2) {
				System.out.print("Nome do Titular: ");
				String nome = scan.next();
				cliente2.setNome(nome);
				poupanca = new ContaPoupanca(cliente2);
				System.out.println("Digite 1 Depositar, 2 Transferir ou 0 para sair: ");
				int n = scan.nextInt();
				if(n == 1) {
					System.out.print("Digite o valor de Deposito: ");
					double valor = scan.nextDouble();
					poupanca.Depositar(valor);
				} else if(n == 2) {
					System.out.print("Digite o valor de Transferência: ");
					double valor1 = scan.nextDouble();
					poupanca.Transferir(valor1, cc);
				} else {
					op = false;
				}
			}else {
				op = false;
			}
		}
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}
}