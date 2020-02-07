package byog.lab5;

public class TestHexWorld {

    public static void main(String[] args) {
        HexWorld hex = new HexWorld(80, 50);
        hex.tesselation(10, 5);

        hex.drawToScreen();

    }
}
