public class Pair {
    int ball;
    int strike;

    public Pair(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    @Override
    public String toString() {
        return String.format("Ball : %s, Strike : %s", this.ball, this.strike);
    }
}