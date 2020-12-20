package Server;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Command {
    private static ObjectMapper objectMapper = new ObjectMapper();
    String command;
    Map<String, String> data;
    private static HashMap mapJsonNodeToData(JsonNode node) throws IOException {
        if (node != null) {
            return objectMapper.readValue(node.toString(), HashMap.class);
        } else {
            return new HashMap<>();
        }
    }

    private Command (String command, Map<String, String> data) {
        this.command = command;
        this.data = data;
    }

    static Command fromJSONString (String jsonString) throws IOException {
        JsonNode commandNode = objectMapper.readTree(jsonString);
        return new Command(
                commandNode.get("cmd").textValue(),
                mapJsonNodeToData(commandNode.get("data"))
        );
    }


}
