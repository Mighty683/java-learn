package Engine.Utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest {
    @Test
    void equalsItself() {
        //given
        final Location testLocation = new Location(0, 0);
        //then
        assertThat(testLocation.equals(testLocation)).isEqualTo(true);
    }

    @Test
    void equalsNull() {
        //given
        final Location testLocation = new Location(0, 0);
        //then
        assertThat(testLocation.equals(null)).isEqualTo(false);
    }

    @Test
    void equalsCoordinates() {
        //given
        final Location testLocation = new Location(0, 0);
        final Location testLocation2 = new Location(0, 0);
        //then
        assertThat(testLocation.equals(testLocation2)).isEqualTo(true);
    }
}
