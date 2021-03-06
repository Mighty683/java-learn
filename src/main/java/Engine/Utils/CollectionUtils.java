package Engine.Utils;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class CollectionUtils {
    /**
     * PECS rule
     * producer - extends
     * consumer - super
     * @param c - source collection
     * @param <E> - element type
     * @return - max element
     */
    public static <E extends Comparable<? super E>> E max(Collection<? extends E> c) {
        if(c.isEmpty()) {
            throw new IllegalArgumentException("Empty collection");
        }
        E result = null;
        for(E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }
        return result;
    }

    /**
     * Hiding generic type with private helper method
     * it's good for public API
     * @param l - list
     * @param sourceIndex - source swap index
     * @param destinationIndex - destination swap index
     */
    public static void swap(List<?> l, int sourceIndex, int destinationIndex) {
        swapHelper(l, sourceIndex, destinationIndex);
    }

    private static <E> void swapHelper(List<E> l, int sourceIndex, int destinationIndex) {
        l.set(sourceIndex, l.set(destinationIndex, l.get(sourceIndex)));
    }
}
