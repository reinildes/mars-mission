package terraformars;

import terraformars.directions.ProbeDirection;

import java.util.Scanner;

public class App {
    private static Scanner scanner;
    public static void main( String[] args ) {

        scanner = new Scanner(System.in);
        scanner.nextLine();

        final var probeA = createProbeWithInput();
        System.out.println(probeA);

        final var probeB = createProbeWithInput();
        System.out.println(probeB);


    }

    private static Probe createProbeWithInput() {

        final var x = scanner.nextInt();
        final var y = scanner.nextInt();

        final var point = new Point(x, y);

        final var directionName = scanner.next();
        final var probeDirection = ProbeDirection.create(directionName);

        final var commands = scanner.next();

        return new Probe(probeDirection, point);
    }

    public static class Probe {
        public final ProbeDirection probeState;
        private Point point;

        public Probe(ProbeDirection probeState, Point point) {
            this.probeState = probeState;
            this.point = point;
        }
    }
}
