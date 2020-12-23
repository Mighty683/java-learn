package Server;

import Server.Command.Command;
import Server.Command.CommandFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandFactoryTest {
    private static final CommandFactory commandFactory = CommandFactory.getInstance();

    @Nested
    @DisplayName("Testing json parsing")
    class FromJSONParse {
        @Test
        void commandParse() throws IOException {
            //when
            final Command testCommand = commandFactory.fromJSONString("{\"cmd\":\"command\"}");
            //then
            assertThat(testCommand.getCommand()).isEqualTo("command");
        }

        @Test
        void dataParse() throws IOException {
            //when
            final Command testCommand = commandFactory.fromJSONString(
                    "{"
                            + "\"cmd\": \"commandWithData\","
                            + "\"data\": {"
                            + "\"key1\": \"value1\","
                            + "\"key2\": \"value2\""
                            + "}"
                            + "}"
            );
            //then
            assertThat(testCommand.getCommand()).isEqualTo("commandWithData");
            assertThat(testCommand.getData().get("key1")).isEqualTo("value1");
            assertThat(testCommand.getData().get("key2")).isEqualTo("value2");
        }
    }
}
