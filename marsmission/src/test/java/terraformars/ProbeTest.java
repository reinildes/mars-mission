package terraformars;

import org.junit.Test;
import terraformars.directions.ProbeDirection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ProbeTest {

    @Test
    public void probeExecutesCommandsA() {
        final var probe = new Probe(ProbeDirection.create("N"), new Point(1, 2), "LMLMLMLMM");
        probe.executeCommands();
        assertThat(probe.getPosition(), is("1 3 N"));
    }

    @Test
    public void probeExecutesCommandsB() {
        final var probe = new Probe(ProbeDirection.create("E"), new Point(3, 3), "MMRMMRMRRM");
        probe.executeCommands();
        assertThat(probe.getPosition(), is("5 1 E"));
    }

    @Test
    public void probeExecutesCommandsWithNegativeNumbers() {
        final var probe = new Probe(ProbeDirection.create("E"), new Point(-3, -3), "MMRMMRMRRM");
        probe.executeCommands();
        assertThat(probe.getPosition(), is("-1 -5 E"));
    }

    @Test
    public void probeExecutesCommandsWithBigCommands() {
        final var probe = new Probe(ProbeDirection.create("E"), new Point(1000, 1000), "LLMRLMRLRRLLMMLMRLMRMLRMLRMLRMLRMLLMMRRLM");
        probe.executeCommands();
        assertThat(probe.getPosition(), is("993 997 S"));
    }
}
