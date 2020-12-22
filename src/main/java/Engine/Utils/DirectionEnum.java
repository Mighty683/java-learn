package Engine.Utils;

public enum DirectionEnum {
    LEFT("left"),
    RIGHT("right"),
    UP("up"),
    DOWN("down");

    private final String string;

    DirectionEnum(final String s) {
        this.string = s;
    }

    @Override
    public String toString() {
        return this.string;
    }

    public DirectionEnum fromString(final String string) {
        switch (string) {
            case "left":
                return LEFT;
            case "right":
                return RIGHT;
            case "down":
                return DOWN;
            default:
                return UP;
        }
    }

    public Location getNewLocation(final Location location) {
        switch (this) {
            case LEFT:
                return new Location(location.axisX - 1, location.axisY);
            case RIGHT:
                return new Location(location.axisX + 1, location.axisY);
            case UP:
                return new Location(location.axisX, location.axisY + 1);
            case DOWN:
                return new Location(location.axisX, location.axisY - 1);
            default:
                return location;
        }
    }
}
