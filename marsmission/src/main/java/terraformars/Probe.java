package terraformars;

import terraformars.directions.ProbeDirection;

public class Probe {
    public static final char LEFT = 'L';
    public static final char RIGHT = 'R';
    public static final char MOVE = 'M';
    private ProbeDirection probeDirection;
    private Point point;
    private String commands;

    public Probe(ProbeDirection direction, Point point, String commands) {
        this.probeDirection = direction;
        this.point = point;
        this.commands = commands;
    }

    public void executeCommands() {

        for (char command : commands.toCharArray()) {

            if (LEFT == command) {
                probeDirection = probeDirection.turnLeft();
            } else if (RIGHT == command) {
                probeDirection = probeDirection.turnRight();
            } else if (MOVE == command) {
                point = probeDirection.move(point);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s)", point, probeDirection.name(), commands);
    }

    public String getPosition() {
        return String.format("%s %s %s", point.x, point.y, probeDirection.name());
    }
}
