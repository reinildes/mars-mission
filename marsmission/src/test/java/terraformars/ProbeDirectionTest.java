package terraformars;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ProbeDirectionTest
{
    @Test
    public void northTurnRightToEast() {

        ProbeDirection north = new NorthDirection();

        assertThat(north, instanceOf(EastDirection.class));
    }
}
