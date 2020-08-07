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

}
