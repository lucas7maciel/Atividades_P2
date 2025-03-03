import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os dados da sua conta");

        System.out.print("Numero: ");
        int number = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Nome: ");
        String holder = scanner.nextLine();

        System.out.print("Saldo: ");
        double balance = scanner.nextDouble();

        System.out.print("Limite de saque: ");
        double withdrawLimit = scanner.nextDouble();

        Account account;

        try {
            account = new Account(number, holder, balance, withdrawLimit);
        } catch (Exception e) {
            System.err.println("\nFalha ao criar conta: " + e.getMessage());
            System.out.println("Execute o programa novamente com os dados preenchidos corretamente");
            return;
        }

        System.out.println("\nEscolha entre as seguintes opcoes:");
        System.out.println("0 - Acabar operacao");
        System.out.println("1 - Depositar");
        System.out.println("2 - Sacar");

        while (true) {
            System.out.print("\nOperacao: ");
            int command = scanner.nextInt();

            if (command == 0) {
                break;
            }

            if (command == 1) {
                System.out.print("Digite o valor que deseja depositar: ");
                double value = scanner.nextDouble();

                account.deposit(value);

                System.out.println(String.format("Voce depositou R$%.2f e agora tem R$%.2f na conta", value, account.balance));
            }

            if (command == 2) {
                System.out.print("Digite o valor que deseja sacar: ");
                double value = scanner.nextDouble();

                try {
                    account.withdraw(value);
                    System.out.println(String.format("Voce sacou R$%.2f e agora tem R$%.2f na conta", value, account.balance));
                } catch(Exception e) {
                    System.err.println("Falha ao sacar: " + e.getMessage());
                }
            }
        }

        System.out.println(String.format("\nOperacao finalizada, saldo final: R$%.2f", account.balance));

        scanner.close();
    }
}
