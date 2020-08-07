package terraformars.directions;

import terraformars.Point;

public class WestDirection implements ProbeDirection {
    public ProbeDirection turnLeft() {
        return new SouthDirection();
    }

    public ProbeDirection turnRight() {
        return new NorthDirection();
    }

    public Point move(Point point) {
        return new Point(point.x - 1, point.y);
    }

    public String name() {
        return "W";
    }
}
