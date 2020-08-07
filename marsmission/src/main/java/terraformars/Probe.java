package terraformars;

import terraformars.directions.ProbeDirection;

public class Probe {
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

            if ('L' == command) {
                probeDirection = probeDirection.turnLeft();
            } else if ('R' == command) {
                probeDirection = probeDirection.turnRight();
            } else if ('M' == command) {
                point = probeDirection.move(point);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s)", point, probeDirection.name(), commands);
    }
}
