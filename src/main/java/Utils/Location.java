package Utils;

import java.util.Objects;

public class Location {
    public int axisX;
    public int axisY;
    public Location (int axisX, int axisY) {
        this.axisX = axisX;
        this.axisY = axisY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return axisX == location.axisX && axisY == location.axisY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(axisX, axisY);
    }
}
