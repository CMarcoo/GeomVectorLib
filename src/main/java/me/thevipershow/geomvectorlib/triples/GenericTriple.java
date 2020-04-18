package me.thevipershow.geomvectorlib.triples;

public class GenericTriple<A, B, C> implements Triple<A, B, C> {
    private final A first; //the first object
    private final B second; //the second object
    private final C third; //the third object

    public GenericTriple(A first, B second, C third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    /**
     * Get the first value
     *
     * @return an Object that represent the first value of the pair.
     */
    @Override
    public A getFirst() {
        return first;
    }

    /**
     * Get the second value
     *
     * @return an Object that represent the second value of the pair.
     */
    @Override
    public B getSecond() {
        return second;
    }

    /**
     * Get the third value
     *
     * @return an Object that represent the third value of the pair.
     */
    @Override
    public C getThird() {
        return third;
    }

    /**
     * Return a new Triple with swapped elements
     *
     * @return the previous pair but with swapped values
     */
    @Override
    public Triple<C, B, A> swapElements() {
        return new GenericTriple<>(third, second, first);
    }
}
