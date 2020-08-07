package terraformars.directions;

import terraformars.Point;

public class NorthDirection implements ProbeDirection {
    public ProbeDirection turnLeft() {
        return new WestDirection();
    }

    public ProbeDirection turnRight() {
        return new EastDirection();
    }

    public Point move() {
        return null;
    }
}
