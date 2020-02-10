package byog.Core;

import java.util.Random;

public class WorldGenerator {

    static final int WIDTH = 50;
    static final int HEIGHT = 40;
    static final Position ORIGIN = new Position(0, 0);
    static final Position DIAGONAL = new Position(WIDTH, HEIGHT);
    static final long seed = 123456;
    static final Random RANDOM = new Random(seed);
}

