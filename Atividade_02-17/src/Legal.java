public class Legal extends Person {
    int staffCount;

    public Legal(String name, float anualIncome, int staffCount) {
        super(name, anualIncome);

        this.staffCount = staffCount;
    }

    public float getTaxes() {
        int taxPercentage = 16;

        if (this.staffCount > 10) {
            taxPercentage = 14;
        }

        return (this.anualIncome / 100 * taxPercentage);
    }
}
