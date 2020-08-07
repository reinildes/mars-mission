package terraformars;

import terraformars.directions.ProbeDirection;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {

        var scanner = new Scanner(System.in);

        scanner.nextLine();

        final var x = scanner.nextInt();
        final var y = scanner.nextInt();

        final var point = new Point(x, y);

        System.out.println(point);

        final var directionName = scanner.next();
        final var probeDirection = ProbeDirection.create(directionName);

        System.out.println(probeDirection);


    }

    public static class Probe {
        public final ProbeDirection probeState;

        public Probe(ProbeDirection probeState) {
            this.probeState = probeState;
        }
    }
}
