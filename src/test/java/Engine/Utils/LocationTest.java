package Engine.Utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LocationTest {
    @Test
    void equalsItself() {
        //given
        Location testLocation = new Location(0, 0);
        //then
        assertThat(testLocation.equals(testLocation)).isEqualTo(true);
    }
    @Test
    void equalsNull() {
        //given
        Location testLocation = new Location(0, 0);
        //then
        assertThat(testLocation.equals(null)).isEqualTo(false);
    }
    @Test
    void equalsCoordinates() {
        //given
        Location testLocation = new Location(0, 0);
        Location testLocation2 = new Location(0, 0);
        //then
        assertThat(testLocation.equals(testLocation2)).isEqualTo(true);
    }
}
