public class Account {
    int number;
    String holder;
    double balance, withdrawLimit;

    public Account(int number, String holder, double balance, double withdrawLimit) throws Exception {
        if (withdrawLimit < 0) {
            throw new Exception("Limite de saque nao pode ser menor que 0");
        }

        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        if (amount > this.withdrawLimit) {
            throw new Exception("Valor escolhido acima do limite de saque");
        }

        if (amount > this.balance) {
            throw new Exception("Saldo insuficiente");
        }

        this.balance -= amount;
    }
}
