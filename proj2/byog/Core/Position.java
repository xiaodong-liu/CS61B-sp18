package byog.Core;

import static byog.Core.WorldGenerator.*;

public class Position {
    private int W;
    private int H;

    public Position(int w, int h) {
        W = w;
        H = h;
    }

    public static Position randomPerimeterPosition(Room r) {
        int type
    }

    public static Position randomPosition() {
        int x = RANDOM.nextInt(WIDTH);
        int y = RANDOM.nextInt(HEIGHT);

        return new Position(x, y);
    }

    public Position move(Position other) {
        return new Position(W + other.W, H + other.H);
    }

    public boolean isSame(Position destination) {
        return W == destination.W && H == destination.H;
    }
}
