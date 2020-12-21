package Server;

public enum CommandsEnum {
    JOIN_GAME("join_game"),
    CREATE_GAME("create_game");

    private final String string;

    CommandsEnum(String s) {
        this.string = s;
    }

    @Override
    public String toString() {
        return this.string;
    }
}
