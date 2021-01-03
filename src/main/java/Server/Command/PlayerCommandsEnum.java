package Server.Command;

public enum PlayerCommandsEnum {
    JOIN_GAME("join_game"),
    CREATE_GAME("create_game");

    private final String string;

    PlayerCommandsEnum(final String s) {
        this.string = s;
    }

    @Override
    public String toString() {
        return this.string;
    }
}
