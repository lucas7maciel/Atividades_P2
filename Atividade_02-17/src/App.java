import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in); 
        int taxPayers;

        System.out.print("\nInforme o numero de contribuentes: ");

        taxPayers = scanner.nextInt();
        List<Person> people = new ArrayList<>(taxPayers);

        System.out.print("\n");

        for (int i = 0; i < taxPayers; i++) {
            System.out.println(String.format("Dados do contribuente #%d:", i + 1));

            //
            System.out.print("Pessoa fisica ou juridica (F/J)? ");
            String profile = "";

            while (!profile.equals("F") && !profile.equals("J")) {
                profile = scanner.nextLine().toUpperCase();
            }

            //
            System.out.print("Qual o seu nome? ");
            String name = "";

            while (name.equals("")) {
                name = scanner.nextLine();
            }

            //
            System.out.print("Qual seu lucro anual? ");
            float anualIncome = scanner.nextFloat();

            // Pessoa jurídica
            if (profile.equals("J")) {
                System.out.print("Numero de funcionarios? ");
                int staffCount = scanner.nextInt();

                people.add(new Legal(name, anualIncome, staffCount));
            } 
            // Pessoa física
            else if (profile.equals("F")) {
                System.out.print("Despesas de saude? ");
                float healthExpenditures = scanner.nextFloat();

                people.add(new Natural(name, anualIncome, healthExpenditures));
            }

            System.out.print("\n");
        }

        scanner.close();

        System.out.println("Impostos pagos:");
        float total = 0;

        for (Person person : people) {
            System.out.println(String.format("%s: R$ %.2f", person.name, person.getTaxes()));

            total += person.getTaxes();
        }

        System.out.println(String.format("\nTotal: R$ %.2f", total));
    }
}
