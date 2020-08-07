package terraformars;

import org.junit.Test;
import terraformars.directions.*;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

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

    @Test
    public void northMoveUpYAxis() {
        ProbeDirection north = new NorthDirection();

        Point pointAfterMoving = north.move(new Point(0, 0));

        assertThat(pointAfterMoving, is(new Point(0, 1)));
    }

    @Test
    public void eastMoveRightXAxis() {
        ProbeDirection east = new EastDirection();

        Point pointAfterMoving = east.move(new Point(0, 0));

        assertThat(pointAfterMoving, is(new Point(1, 0)));
    }

    @Test
    public void southMoveDownYAxis() {
        ProbeDirection south = new SouthDirection();

        Point pointAfterMoving = south.move(new Point(0, 0));

        assertThat(pointAfterMoving, is(new Point(0, -1)));
    }

    @Test
    public void westMoveLeftXAxis() {
        ProbeDirection west = new WestDirection();

        Point pointAfterMoving = west.move(new Point(0, 0));

        assertThat(pointAfterMoving, is(new Point(-1, 0)));
    }

    @Test
    public void directionNames() {
        assertThat(new SouthDirection().name(), is("S"));
        assertThat(new NorthDirection().name(), is("N"));
        assertThat(new EastDirection().name(), is("E"));
        assertThat(new WestDirection().name(), is("W"));
    }

    @Test
    public void createDirections() {
        assertThat(ProbeDirection.create("N"), instanceOf(NorthDirection.class));
        assertThat(ProbeDirection.create("E"), instanceOf(EastDirection.class));
        assertThat(ProbeDirection.create("S"), instanceOf(SouthDirection.class));
        assertThat(ProbeDirection.create("W"), instanceOf(WestDirection.class));

        try {
            assertThat(ProbeDirection.create("Other"), instanceOf(WestDirection.class));
            fail("Should not have reached this point");
        } catch (RuntimeException e) {
            assertThat(e.getMessage(), is("Other is not a valid Direction"));
        }
    }

}
