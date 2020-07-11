package lesson13;

public class Negate implements Expr {

    private final Expr expr;

    public Negate(Expr expr) {
        this.expr = expr;
    }

    @Override
    public int evaluate() {
        return -expr.evaluate();
    }
}
