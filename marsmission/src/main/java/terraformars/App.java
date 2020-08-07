package terraformars;

import terraformars.directions.ProbeDirection;

import java.util.Scanner;

public class App {

    private static Scanner scanner;

    public static void main( String[] args ) {

        System.out.println("Running... Please provide your input via CLI!");

        try {
            scanner = new Scanner(System.in);
            scanner.nextLine(); // skips first line as solution can be achieved without it

            final var voyager = createProbeWithInput();
            final var curiosity = createProbeWithInput();

            voyager.executeCommands();
            curiosity.executeCommands();

            System.out.println(voyager.getPosition());
            System.out.println(curiosity.getPosition());

        } finally {
            scanner.close();
        }
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