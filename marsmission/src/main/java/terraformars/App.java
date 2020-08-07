package terraformars;

import terraformars.directions.ProbeDirection;

public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
    }

    public static class Probe {
        public final ProbeDirection probeState;

        public Probe(ProbeDirection probeState) {
            this.probeState = probeState;
        }
    }
}
