package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    private TERenderer ter;
    private TETile[][] world;
    private TETile[] character = {Tileset.NOTHING, Tileset.WALL, Tileset.FLOWER, Tileset.FLOOR, Tileset.GRASS,
            Tileset.LOCKED_DOOR, Tileset.MOUNTAIN, Tileset.PLAYER, Tileset.SAND, Tileset.TREE,
            Tileset.UNLOCKED_DOOR, Tileset.WATER};
    private static final Random RANDOM = new Random(2000);

    //initialize the HexWorld
    public HexWorld(int width, int height) {
        //initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        ter = new TERenderer();
        ter.initialize(width, height);

        //initialize tiles
        world = new TETile[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                world[i][j] = character[0];
            }
        }
    }

    public void addHexagon(int x_position, int y_position, int length, int key) {
        addHexagon(0, length, x_position, y_position, key);
    }

    private void addHexagon(int current, int length, int x_position, int y_position, int i) {
        if (current == length) {
            return;
        }
        for (int x = 0; x < length + 2 * current; x++) {
            world[x + x_position + length - current - 1][y_position + current] = character[i];
        }

        addHexagon(current + 1, length, x_position, y_position, i);

        for (int x = 0; x < length + 2 * current; x++) {
            world[x + x_position + length - current - 1][y_position + 2 * length - 1 - current] = character[i];
        }
    }

    public void drawToScreen() {
        ter.renderFrame(world);
    }

    public void tesselation(int x_position, int y_position) {
        tesselation(x_position, y_position + 6, 3);
        tesselation(x_position + 5, y_position + 3, 4);
        tesselation(x_position + 10, y_position, 5);
        tesselation(x_position + 15, y_position + 3, 4);
        tesselation(x_position + 20, y_position + 6, 3);
    }

    private void tesselation(int x_position, int y_position, int numbers) {
        for (int i = 0; i < numbers; i++) {
            addHexagon(x_position, y_position + 6 * i, 3, RANDOM.nextInt(10) + 1);
        }
    }

}
