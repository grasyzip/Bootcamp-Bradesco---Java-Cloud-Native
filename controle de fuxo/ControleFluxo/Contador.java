import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);

        System.out.println("Digite o primeiro parâmetro:");
        int parametroUm = terminal.nextInt(); // Alterado para capturar um inteiro

        System.out.println("Digite o segundo parâmetro:");
        int parametroDois = terminal.nextInt(); // Alterado para capturar um inteiro

        try {
            // Chamando o método que contém a lógica de contagem
            contar(parametroUm, parametroDois);
        } catch (ParametrosInvalidosException exception) {
            // Mensagem de erro caso a exceção seja lançada
            System.out.println("Erro: " + exception.getMessage());
        }

        terminal.close();
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        // Validando se o primeiro parâmetro é maior que o segundo
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }

        // Calculando a quantidade de iterações
        int contagem = parametroDois - parametroUm;

        // Laço for para realizar a impressão dos números
        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }
}
