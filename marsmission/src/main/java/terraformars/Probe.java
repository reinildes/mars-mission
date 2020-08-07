package terraformars;

import terraformars.directions.ProbeDirection;

import java.util.Arrays;
import java.util.List;

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
        commandsAsList()
                .forEach(this::applyCommand);
    }

    private void applyCommand(String command) {
        if ("L".equals(command)) {
            this.probeDirection = probeDirection.turnLeft();
        } else if ("R".equals(command)) {
            this.probeDirection = probeDirection.turnRight();
        } else if ("M".equals(command)) {
            this.point = probeDirection.move(point);
        }
    }

    private List<String> commandsAsList() {
        return Arrays.asList(commands.split(""));
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s)", point, probeDirection.name(), commands);
    }

    public String getPosition() {
        return String.format("%s %s %s", point.x, point.y, probeDirection.name());
    }
}
