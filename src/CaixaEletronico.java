import java.util.Scanner;

public class CaixaEletronico {
    private double saldo;
    private String senha;

    // Construtor
    public CaixaEletronico(String senhaInicial) {
        this.saldo = 0.0;
        this.senha = senhaInicial;
    }

    // Método para autenticar usuário
    public boolean autenticar(String senhaInformada) {
        return senhaInformada.equals(this.senha);
    }

    // Métodos de operação do caixa eletrônico
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
        } else {
            System.out.println("Valor de saque inválido.");
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando a instância do caixa eletrônico com a senha "1234"
        CaixaEletronico caixa = new CaixaEletronico("1234");

        System.out.println("Bem-vindo ao Caixa Eletrônico!");
        System.out.print("Digite sua senha: ");
        String senhaInformada = scanner.nextLine();

        if (!caixa.autenticar(senhaInformada)) {
            System.out.println("Senha incorreta. Tente novamente.");
            return;
        }

        int opcao = 0;
        while (opcao != 4) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Consultar saldo");
            System.out.println("4 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser depositado: R$ ");
                    double valorDep = scanner.nextDouble();
                    caixa.depositar(valorDep);
                    break;
                case 2:
                    System.out.print("Digite o valor a ser sacado: R$ ");
                    double valorSac = scanner.nextDouble();
                    caixa.sacar(valorSac);
                    break;
                case 3:
                    caixa.consultarSaldo();
                    break;
                case 4:
                    System.out.println("Saindo... até logo!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
