package Server.Command;

import java.util.Map;

public class Command {
    private final String command;
    private final Map<String, String> data;

    public Command(final String command, final Map<String, String> data) {
        this.command = command;
        this.data = data;
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
