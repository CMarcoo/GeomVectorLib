package me.thevipershow.geomvectorlib.pairs;

public interface Pair<A, B> {
    /**
     * Get the first value
     * @return an Object that represent the first value of the pair.
     */
    A getFirst();

    /**
     * Get the second value
     * @return an Object that represent the second value of the pair.
     */
    B getSecond();

    /**
     * Return a new Pair with swapped elements
     *
     * @return the previous pair but with swapped values.
     */
    Pair<B, A> swapElements();
}
