package terraformars;

import terraformars.directions.ProbeDirection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Probe {
    private static final String LEFT = "L";
    private static final String RIGHT = "R";
    private static final String MOVE = "M";
    private static final String FLAG = "F";
    private ProbeDirection probeDirection;
    private Point point;
    private String commands;
    private List<Point> flagPositions = new ArrayList<>();

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

        if (LEFT.equals(command)) {
            this.probeDirection = probeDirection.turnLeft();

        } else if (RIGHT.equals(command)) {
            this.probeDirection = probeDirection.turnRight();

        } else if (MOVE.equals(command)) {
            this.point = probeDirection.move(point);

        } else if (FLAG.equals(command)) {
            this.flagPositions.add(point);

        } else{
            throw new RuntimeException( command + " is not valid. Please inform a valid command.");
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

    public String getFlagPositions() {
        return flagPositions.toString();
    }
}
