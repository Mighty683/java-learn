package Engine;

import java.math.BigInteger;

public abstract class Entity implements IEntity {
    public int axisX;
    public int axisY;
    public String name;
    /**
     * Builder Pattern in class hierarchy with possibility to extend in subclasses.
     */
    abstract public static class Builder<T extends Builder<T>> {
        int axisX;
        int axisY;
        String name;
        Builder(int axisX, int axisY, String name) {
            this.axisX = axisX;
            this.axisY = axisY;
            this.name = name;
        }
        /**
         * Implement to return dynamic type this;
         * @return this
         */
        abstract T self();
    }
    protected Entity(Builder<?> builder) {
        this.axisX = builder.axisX;
        this.axisY = builder.axisY;
        this.name = builder.name;
    }
}
