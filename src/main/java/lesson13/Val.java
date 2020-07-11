package lesson13;

public class Val implements Expr {

    private final int val;

    public Val(int val) {
        this.val = val;
    }

    @Override
    public int evaluate() {
        return val;
    }
}
