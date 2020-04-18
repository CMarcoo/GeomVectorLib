package me.thevipershow.geomvectorlib.triples;

public interface Triple<A, B, C> {
    /**
     * Get the first value
     *
     * @return an Object that represent the first value of the pair.
     */
    A getFirst();

    /**
     * Get the second value
     *
     * @return an Object that represent the second value of the pair.
     */
    B getSecond();

    /**
     * Get the third value
     *
     * @return an Object that represent the third value of the pair.
     */
    C getThird();

    /**
     * Return a new Triple with swapped elements
     *
     * @return the previous pair but with swapped values
     */
    Triple<C, B, A> swapElements();
}
