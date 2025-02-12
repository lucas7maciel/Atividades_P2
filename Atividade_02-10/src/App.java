public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\n");

        Product product1 = new Product("Nome 1", 0.5);
        Product product2 = new Product("Nome 2", 1.5);
        Product product3 = new Product("Nome 3", 2.5);

        ShoppingCart shoppingCart = new ShoppingCart(1);

        shoppingCart.addProduct(product1);
        shoppingCart.addProduct(product2);
        shoppingCart.addProduct(product3);

        System.out.println("\n" + shoppingCart.getContents());
        System.out.println(String.format("Preco total: R$%.2f", shoppingCart.getTotalPrice()));
        System.out.println(String.format("Quantidade de itens: %d\n", shoppingCart.getItemsCount()));

        shoppingCart.removeProduct(product2);

        System.out.println("\n" + shoppingCart.getContents());
        System.out.println(String.format("Preco total: R$%.2f", shoppingCart.getTotalPrice()));
        System.out.println(String.format("Quantidade de itens: %d\n", shoppingCart.getItemsCount()));

        System.out.println(String.format("Id do cliente: %d", shoppingCart.getCustomerId()));
    }
}
