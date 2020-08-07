package terraformars;

import terraformars.directions.ProbeDirection;

import java.util.Scanner;

public class App {
    private static Scanner scanner;
    public static void main( String[] args ) {

        scanner = new Scanner(System.in);
        scanner.nextLine();

        final var probeA = createProbeWithInput();
        final var probeB = createProbeWithInput();

        probeA.executeCommands();
        probeB.executeCommands();

    }

    private static Probe createProbeWithInput() {

        final var x = scanner.nextInt();
        final var y = scanner.nextInt();

        final var point = new Point(x, y);

        final var directionName = scanner.next();
        final var probeDirection = ProbeDirection.create(directionName);

        final var commands = scanner.next();

        return new Probe(probeDirection, point, commands);
    }

    public static class Probe {
        private ProbeDirection probeDirection;
        private Point point;
        private String commands;

        public Probe(ProbeDirection direction, Point point, String commands) {
            this.probeDirection = direction;
            this.point = point;
            this.commands = commands;
        }

        public void executeCommands(){

            for (char command : commands.toCharArray()) {

                if ('L' == command){
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
}
