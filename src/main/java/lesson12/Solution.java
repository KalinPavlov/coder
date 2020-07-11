package lesson12;

public class Solution {

    private static final char STILL = '.';
    private static final char RIGHT = 'R';
    private static final char LEFT = 'L';

    private static final int NO_FORCE = 0;

    public static char[] pushDominoes(char[] dominoes) {
        int[] forces = new int[dominoes.length];
        int maxForce = dominoes.length;

        int force = NO_FORCE;
        for (int index = 0; index < dominoes.length; index++) {
            char domino = dominoes[index];
            if (domino == RIGHT) {
                force = maxForce;
            } else if (domino == LEFT) {
                force = NO_FORCE;
            } else {
                force = Math.max(NO_FORCE, force - 1);
            }
            forces[index] = force;
        }

        for (int index = dominoes.length - 1; index >= 0; index--) {
            char domino = dominoes[index];
            if (domino == LEFT) {
                force = maxForce;
            } else if (domino == RIGHT) {
                force = NO_FORCE;
            } else {
                force = Math.max(NO_FORCE, force - 1);
            }
            forces[index] -= force;
        }

        for (int index = 0; index < forces.length; index++) {
            int f = forces[index];
            if (f == NO_FORCE) {
                dominoes[index] = STILL;
            } else if (f > NO_FORCE) {
                dominoes[index] = RIGHT;
            } else {
                dominoes[index] = LEFT;
            }
        }

        return dominoes;
    }
}
