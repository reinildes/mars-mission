package terraformars;

import org.junit.Test;
import terraformars.directions.ProbeDirection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ProbeTest {
    @Test
    public void probeExecutesCommands() {
        final var probe = new Probe(ProbeDirection.create("N"), new Point(1, 2), "LMLMLMLMM");
        probe.executeCommands();
        assertThat(probe.getPosition(), is("1 3 N"));
    }
}
