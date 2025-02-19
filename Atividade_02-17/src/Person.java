abstract class Person {
    String name;
    float anualIncome;

    public Person(String name, float anualIncome) {
        this.name = name;
        this.anualIncome = anualIncome;
    }

    public abstract float getTaxes();
}
