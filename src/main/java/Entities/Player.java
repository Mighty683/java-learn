package Entities;

public class Player extends Entity {
    public String playerName;
    @Override
    public void onDestroy() {
        System.out.println("Player destroyed");
    }

    @Override
    public boolean canMoveHere() {
        return false;
    }

    public static class Builder extends Entity.Builder<Builder> {
        String playerName;

        public Builder(int axisX, int axisY) {
            super(axisX, axisY, "player");
        }

        public Player build() {
            return new Player(this);
        }

        public Builder setPlayerName (String playerName) {
            this.playerName = playerName;
            return self();
        }

        @Override
        Builder self() {
            return this;
        }
    }

    private Player(Builder builder) {
        super(builder);
        this.playerName = builder.playerName;
    }
}
