public class Natural extends Person {
    float healthExpenditures;

    public Natural(String name, float anualIncome, float healthExpenditures) {
            super(name, anualIncome);

            this.healthExpenditures = healthExpenditures;
        }

    @Override
    public float getTaxes() {
        int taxPercentage = 25;

        if (this.anualIncome < 20000) {
            taxPercentage = 15;
        }

        float taxes = (this.anualIncome / 100 * taxPercentage) - (this.healthExpenditures / 2);

        if (taxes < 0) {
            return 0;
        }

        return taxes;
    }
}
