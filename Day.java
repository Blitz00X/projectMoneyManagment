public class Day {
    private String date;
    private double categoryA;
    private double categoryB;
    private double categoryC;
    private double categoryD;
    private double categoryE;
    private double sum;
    private double left;

    public Day(String date, double a, double b, double c, double d, double e, double total) {
        this.date = date;
        this.categoryA = a;
        this.categoryB = b;
        this.categoryC = c;
        this.categoryD = d;
        this.categoryE = e;
        this.sum = a + b + c + d + e;
        this.left = total - this.sum;
    }

    public String getDate() {
        return date;
    }

    public double getCategoryA() {
        return categoryA;
    }

    public double getCategoryB() {
        return categoryB;
    }

    public double getCategoryC() {
        return categoryC;
    }

    public double getCategoryD() {
        return categoryD;
    }

    public double getCategoryE() {
        return categoryE;
    }

    public double getSum() {
        return sum;
    }

    public double getLeft() {
        return left;
    }
}
