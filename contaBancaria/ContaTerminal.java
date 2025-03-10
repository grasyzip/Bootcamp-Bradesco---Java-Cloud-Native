import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Banco Digital!");

        System.out.println("Por favor, digite o número da Agência:");
        String agencia = scanner.nextLine();

        System.out.println("Por favor, digite o número da Conta:");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha deixada pelo nextInt

        System.out.println("Por favor, digite o nome do Titular:");
        String titular = scanner.nextLine();

        System.out.println("Por favor, digite o saldo inicial da Conta:");
        double saldo = scanner.nextDouble();

        // Mensagem final formatada
        System.out.println("\nOlá " + titular + ", obrigado por criar uma conta em nosso banco!");
        System.out.println("Sua agência é " + agencia + ", conta " + numeroConta + " e seu saldo inicial de R$ " + String.format("%.2f", saldo) + " já está disponível para saque.");

        scanner.close();
    }
}
