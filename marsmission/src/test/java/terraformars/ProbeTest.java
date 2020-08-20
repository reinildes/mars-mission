package terraformars;

import org.junit.Test;
import terraformars.directions.ProbeDirection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ProbeTest {

    @Test
    public void probeExecutesCommandsA() {
        final var probe = new Probe(ProbeDirection.create("N"), new Point(1, 2), "LMLMLMLMM");
        probe.executeCommands();
        assertThat(probe.getPosition(), is("1 3 N"));
    }

    @Test
    public void probeMarksFlag() {
        final var probe = new Probe(ProbeDirection.create("N"), new Point(1, 2), "LMFLMLMLMM");
        probe.executeCommands();
        assertThat(probe.getPosition(), is("1 3 N"));
        assertThat(probe.getFlagPositions(), is("[(0, 2)]"));
    }

    @Test
    public void probeMarksMultipleFlags() {
        final var probe = new Probe(ProbeDirection.create("N"), new Point(1, 2), "LMFLMFLMLMM");
        probe.executeCommands();
        assertThat(probe.getPosition(), is("1 3 N"));
        assertThat(probe.getFlagPositions(), is("[(0, 2), (0, 1)]"));
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

    @Test
    public void probeThrowsExceptionWithInvalidCommand() {
        final var probe = new Probe(ProbeDirection.create("E"), new Point(0, 0), "T");
        try {
            probe.executeCommands();
            fail("Should not have reached this point");
        } catch (RuntimeException e) {
            assertThat(e.getMessage(), is("T is not valid. Please inform a valid command."));
        }
    }

    @Test
    public void whenRunning4LeftCommandsCirclesBackToOriginalDirection() {
        final var probe = new Probe(ProbeDirection.create("E"), new Point(0, 0), "LLLL");
        probe.executeCommands();
        assertThat(probe.getPosition(), is("0 0 E"));
    }


    @Test
    public void whenRunning4RightCommandsCirclesBackToOriginalDirection() {
        final var probe = new Probe(ProbeDirection.create("N"), new Point(0, 0), "RRRR");
        probe.executeCommands();
        assertThat(probe.getPosition(), is("0 0 N"));
    }
}
