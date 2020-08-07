package terraformars.directions;

import terraformars.Point;

public interface ProbeDirection {
    ProbeDirection turnLeft();
    ProbeDirection turnRight();
    Point move(Point point);
    String name();

    static ProbeDirection create (String name) {
        switch (name) {
            case "N" : return new NorthDirection();
            case "E" : return new EastDirection();
            case "S" : return new SouthDirection();
            case "W" : return new WestDirection();
            default: throw new RuntimeException( name + " is not a valid Direction");
        }
    }
}
