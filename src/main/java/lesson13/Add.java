package lesson13;

public class Add implements Expr {

    private final Expr s1;
    private final Expr s2;

    public Add(Expr s1, Expr s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public int evaluate() {
        return s1.evaluate() + s2.evaluate();
    }
}
