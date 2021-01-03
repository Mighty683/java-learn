package Engine.Utils;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionUtilsTest {
    @Test
    void testMax() throws ParseException {
        //given
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Collection<Date> numberCollection = Set.of(
                df.parse("2020-01-01"),
                df.parse("2020-01-02"),
                df.parse("2020-01-03")
        );
        //then
        assertThat(CollectionUtils.max(numberCollection)).isEqualTo(df.parse("2020-01-03"));
    }

    @Test
    void testSwap() {
        //given
        List<Number> testList = Arrays.asList(1,2,3);
        //when
        CollectionUtils.swap(testList, 1, 2);
        //then
        assertThat(testList.get(1)).isEqualTo(3);
        assertThat(testList.get(2)).isEqualTo(2);
    }
}
