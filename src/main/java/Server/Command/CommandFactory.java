package Server.Command;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

public class CommandFactory {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final CommandFactory instance = new CommandFactory();

    private CommandFactory() {
    }

    public static CommandFactory getInstance() {
        return instance;
    }

    private static HashMap<String, String> mapJsonNodeToData(final JsonNode node) throws IOException {
        if (node != null) {
            return objectMapper.readValue(node.toString(), HashMap.class);
        } else {
            return new HashMap<>();
        }
    }

    public Command fromJSONString(final String jsonString) throws IOException {
        final JsonNode commandNode = objectMapper.readTree(jsonString);
        return new Command(
                commandNode.get("cmd").textValue(),
                mapJsonNodeToData(commandNode.get("data"))
        );
    }
}
