package terraformars.directions;

import terraformars.Point;

public class EastDirection implements ProbeDirection{
    public ProbeDirection turnLeft() {
        return new NorthDirection();
    }

    public ProbeDirection turnRight() {
        return new SouthDirection();
    }

    public Point move(Point point) {
        return new Point(point.x + 1, point.y);
    }
}
