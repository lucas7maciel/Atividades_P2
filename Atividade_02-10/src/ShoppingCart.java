import java.util.ArrayList;

public class ShoppingCart {
    private int customerId;
    private ArrayList<Product> productList;

    public ShoppingCart(int customerId) {
        this.customerId = customerId;
        this.productList = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        this.productList.add(product);
        System.out.println(String.format("%s adicionado!", product.getName()));
    }

    public void removeProduct(Product product) {
        int productIndex = this.productList.indexOf(product);

        if (productIndex == -1) {
            System.out.println(String.format("%s nao se encontra na lista", product.getName()));
        } else {
            this.productList.remove(productIndex);
            System.out.println(String.format("%s removido com sucesso!", product.getName()));
        }


    }

    public String getContents() {
        String products = "O carrinho contem os seguintes produtos:\n";

        for (Product product: this.productList) {
            products += String.format("%s: R$%.2f\n", product.getName(), product.getPrice());
        }

        return products;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public int getItemsCount() {
        return this.productList.size();
    }

    public double getTotalPrice() {
        double totalPrice = 0;

        for (Product product: this.productList) {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }
}
