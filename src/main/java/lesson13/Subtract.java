package lesson13;

public class Subtract implements Expr {

    private final Expr d1;
    private final Expr d2;

    public Subtract(Expr d1, Expr d2) {
        this.d1 = d1;
        this.d2 = d2;
    }

    @Override
    public int evaluate() {
        return d1.evaluate() - d2.evaluate();
    }
}
