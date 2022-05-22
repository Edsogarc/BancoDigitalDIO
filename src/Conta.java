
public abstract class Conta implements IConta {
	
	protected static final int agencia_padrao = 1;
	
	private static int sequencial = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	
	public Conta(Cliente cliente) {
		this.agencia = Conta.agencia_padrao;
		this.numero = sequencial++;
		this.cliente = cliente;
		this.saldo = saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public void Sacar(double valor) {
		saldo = saldo - valor;
		
	}

	@Override
	public void Depositar(double valor) {
		saldo = saldo + valor;
		
	}

	@Override
	public void Transferir(double valor, Conta contaDestino) {
		this.Sacar(valor);
		contaDestino.Depositar(valor);
	}
	
	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Conta: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
	
	
}
