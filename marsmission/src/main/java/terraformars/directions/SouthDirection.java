package terraformars.directions;

import terraformars.Point;

public class SouthDirection implements ProbeDirection{
    public ProbeDirection turnLeft() {
        return new EastDirection();
    }

    public ProbeDirection turnRight() {
        return new WestDirection();
    }

    public Point move(Point point) {
        return new Point(point.x, point.y - 1);
    }

    public String name() {
        return "S";
    }
}
