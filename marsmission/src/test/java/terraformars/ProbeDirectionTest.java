package terraformars;

import org.junit.Test;
import terraformars.directions.*;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ProbeDirectionTest {

    @Test
    public void northTurnRightToEast() {
        ProbeDirection north = new NorthDirection();
        assertThat(north.turnRight(), instanceOf(EastDirection.class));
    }

    @Test
    public void northTurnLeftToEast() {
        ProbeDirection north = new NorthDirection();
        assertThat(north.turnLeft(), instanceOf(WestDirection.class));
    }

    @Test
    public void eastTurnRightToSouth() {
        ProbeDirection east = new EastDirection();
        assertThat(east.turnRight(), instanceOf(SouthDirection.class));
    }

    @Test
    public void eastTurnLeftToNorth() {
        ProbeDirection east = new EastDirection();
        assertThat(east.turnLeft(), instanceOf(NorthDirection.class));
    }

    @Test
    public void southTurnRightToEast() {
        ProbeDirection east = new SouthDirection();
        assertThat(east.turnRight(), instanceOf(EastDirection.class));
    }

    @Test
    public void southTurnLeftToWest() {
        ProbeDirection east = new SouthDirection();
        assertThat(east.turnLeft(), instanceOf(WestDirection.class));
    }

    @Test
    public void westTurnRightToNorth() {
        ProbeDirection west = new WestDirection();
        assertThat(west.turnRight(), instanceOf(NorthDirection.class));
    }

    @Test
    public void westTurnLeftToSouth() {
        ProbeDirection west = new WestDirection();
        assertThat(west.turnLeft(), instanceOf(SouthDirection.class));
    }



}
