package terraformars.directions;

import terraformars.Point;

public interface ProbeDirection {
    ProbeDirection turnLeft();
    ProbeDirection turnRight();
    Point move(Point point);
}
