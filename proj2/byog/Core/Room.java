package byog.Core;

public class Room {
    Position p;
    Position q;

    public Room(Position p, Position q) {
        Position.regularization(p, q);
        this.p = p;
        this.q = q;
    }
}
