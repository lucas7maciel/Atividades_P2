public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("\n\n");

        TV tv1 = new TV("Tv da sala", 1000, 32);
        TV tv2 = new TV("Tv do quarto", 800, 40);

        System.out.println("TVs:");
        System.out.println(String.format("%s possui %d polegadas", tv1.getBrand(), tv1.getInches()));
        System.out.println(String.format("%s possui %d polegadas\n", tv2.getBrand(), tv2.getInches()));

        Stove stove1 = new Stove("Forno da cozinha", 500, 2);
        Stove stove2 = new Stove("Forno da churrasqueira", 750, 4);

        System.out.println("Fornos:");
        System.out.println(String.format("%s possui %d bocas", stove1.getBrand(), stove1.getBurners()));
        System.out.println(String.format("%s possui %d bocas\n", stove2.getBrand(), stove2.getBurners()));

        Refrigerator refrigerator1 = new Refrigerator("Frigorifico da cozinha", 300, 3);
        Refrigerator refrigerator2 = new Refrigerator("Frigorifico do quarto", 550, 2);

        System.out.println("Frigorificos:");
        System.out.println(String.format("%s possui %d metros", refrigerator1.getBrand(), refrigerator1.getSize()));
        System.out.println(String.format("%s possui %d metros\n", refrigerator2.getBrand(), refrigerator2.getSize()));

        ShoppingCart cart = new ShoppingCart(1);

        cart.addProduct(tv1);
        cart.addProduct(tv2);
        cart.addProduct(stove2);
        cart.addProduct(stove2);
        cart.addProduct(refrigerator1);
        cart.addProduct(refrigerator2);

        System.out.println();

        cart.removeProduct(stove1);
        cart.removeProduct(refrigerator1);

        System.out.println("\n" + cart.getContents());
        System.out.println(String.format("Preco total: R$%.2f", cart.getTotalPrice()));
        System.out.println(String.format("Quantidade de itens: %d\n", cart.getItemsCount()));

        System.out.println(String.format("Id do cliente: %d", cart.getCustomerId()));
    }
}
