// Classe base Conta
abstract class Conta {
    protected String numeroConta;
    protected String titular;
    protected double saldo;

    public Conta(String numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso na conta " + numeroConta);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso na conta " + numeroConta);
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido.");
        }
    }

    public void transferir(double valor, Conta contaDestino) {
        if (valor > 0 && valor <= saldo) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferência de R$ " + valor + " realizada com sucesso da conta " + numeroConta + " para a conta " + contaDestino.numeroConta);
        } else {
            System.out.println("Saldo insuficiente ou valor de transferência inválido.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }
}

// Classe ContaCorrente
class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String numeroConta, String titular, double limite) {
        super(numeroConta, titular);
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= (saldo + limite)) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso na conta corrente " + numeroConta);
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido.");
        }
    }
}

// Classe ContaPoupanca
class ContaPoupanca extends Conta {
    private double taxaJuros;

    public ContaPoupanca(String numeroConta, String titular, double taxaJuros) {
        super(numeroConta, titular);
        this.taxaJuros = taxaJuros;
    }

    public void aplicarJuros() {
        saldo += saldo * taxaJuros / 100;
        System.out.println("Juros aplicados na conta poupança " + numeroConta);
    }
}

// Classe principal para testar as contas
public class Banco {
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente("12345", "João", 500.0);
        ContaPoupanca contaPoupanca = new ContaPoupanca("67890", "Maria", 5.0);

        contaCorrente.depositar(1000);
        contaCorrente.sacar(200);
        contaCorrente.transferir(300, contaPoupanca);

        contaPoupanca.aplicarJuros();
        System.out.println("Saldo da conta poupança: R$ " + contaPoupanca.getSaldo());
    }
}