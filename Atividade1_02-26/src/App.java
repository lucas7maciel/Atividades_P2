import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Seja bem vindo ao hotel!");
        System.out.println("Escolha entre as seguintes opcoes:");
        System.out.println("0 - Sair");
        System.out.println("1 - Fazer reserva");
        System.out.println("2 - Editar reserva");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nDigite a opcao: ");
            int command = scanner.nextInt();

            if (command == 0) {
                break;
            }

            if (command == 1) {
                System.out.print("Numero do quarto: ");
                int roomNumber = scanner.nextInt();

                scanner.nextLine();

                System.out.println("Data de check-in (dd-mm-yyyy): ");
                String checkIn = scanner.nextLine();

                System.out.println("Data de check-out (dd-mm-yyyy): ");
                String checkOut = scanner.nextLine();

                try {
                    Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
                    reservation.printData();
                } catch (Exception e) {
                    System.err.println("Erro ao criar reserva: " + e.getMessage());
                }
            }

            if (command == 2) {
                System.out.print("Digite o numero do quarto que deseja editar: ");
                int numberRoom = scanner.nextInt();

                try {
                    Reservation reservation = Reservation.findRoom(numberRoom);

                    if (reservation == null) {
                        throw new Exception("Quarto nao encontrado");
                    }

                    scanner.nextLine();

                    System.out.println("Data de check-in (dd-mm-yyyy): ");
                    String checkIn = scanner.nextLine();

                    System.out.println("Data de check-out (dd-mm-yyyy): ");
                    String checkOut = scanner.nextLine();

                    reservation.setDate(checkIn, checkOut);
                    reservation.printData();

                } catch (Exception e) {
                    System.err.println("Falha ao atualizar reserva: " + e.getMessage());
                }
            }
        }

        System.out.println("\nObrigado por requisitar nossos serviços!");

        scanner.close();

    }
}
