package terraformars;

public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
    }

    public static class Probe {
        public final ProbePosition probeState;

        public Probe(ProbePosition probeState) {
            this.probeState = probeState;
        }
    }
}
