package Server.Command;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Command {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final String command;
    private final Map<String, String> data;

    public Command(final String command, final Map<String, String> data) {
        this.command = command;
        this.data = data;
    }

    public static Command fromJSONString(final String jsonString) throws IOException {
        final JsonNode commandNode = Command.objectMapper.readTree(jsonString);
        return new Command(
                commandNode.get("cmd").textValue(),
                Command.mapJsonNodeToData(commandNode.get("data"))
        );
    }

    private static HashMap mapJsonNodeToData(final JsonNode node) throws IOException {
        if (node != null) {
            return objectMapper.readValue(node.toString(), HashMap.class);
        } else {
            return new HashMap<>();
        }
    }

    public String getCommand() {
        return command;
    }

    public Map<String, String> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Command{" +
                "command='" + command + '\'' +
                ", data=" + data +
                '}';
    }
}
