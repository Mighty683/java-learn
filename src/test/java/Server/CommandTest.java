package Server;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandTest {
    @Nested
    @DisplayName("Testing json parsing")
    class FromJSONParse {
        @Test
        void commandParse () throws IOException {
            Command testCommand = Command.fromJSONString("{\"cmd\":\"command\"}");
            assertThat(testCommand.command).isEqualTo("command");
        }
        @Test
        void dataParse() throws IOException {
            Command testCommand = Command.fromJSONString(
                    "{"
                    + "\"cmd\": \"commandWithData\","
                    + "\"data\": {"
                    + "\"key1\": \"value1\","
                    + "\"key2\": \"value2\""
                    + "}}"
            );
            assertThat(testCommand.command).isEqualTo("commandWithData");
            assertThat(testCommand.data.get("key1")).isEqualTo("value1");
            assertThat(testCommand.data.get("key2")).isEqualTo("value2");
        }
    }
}
