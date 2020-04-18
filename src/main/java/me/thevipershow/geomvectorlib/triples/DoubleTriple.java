package me.thevipershow.geomvectorlib.triples;

import me.thevipershow.geomvectorlib.pairs.DoublePair;

public class DoubleTriple implements Triple<Double, Double, Double> {
    private final double first, second, third; // the first, second and third values.

    public DoubleTriple(double first, double second, double third) {
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
    public final Double getFirst() {
        return first;
    }

    /**
     * Get the second value
     *
     * @return an Object that represent the second value of the pair.
     */
    @Override
    public final Double getSecond() {
        return second;
    }

    /**
     * Get the third value
     *
     * @return an Object that represent the third value of the pair.
     */
    @Override
    public final Double getThird() {
        return third;
    }

    /**
     * Return a new Triple with swapped elements
     *
     * @return the previous pair but with swapped values
     */
    @Override
    public Triple<Double, Double, Double> swapElements() {
        return new DoubleTriple(third, second, first);
    }

    /**
     * This methods compares the three double values in the current DoubleTriple object
     * A tolerance value can be provided in order to check for 'similar' values
     *
     * @param tolerance the tolerance value that will be used to compare
     *                  an example would be a tolerance of '2E-1' would make values
     *                  such as '3.0', '2.5' and '2.7' successfully return true using this method.
     * @return true if they are similar according to the provided tolerance, false otherwise.
     */
    public boolean areSimilar(final double tolerance) {
        return (Math.abs(first - second) <= tolerance
                && Math.abs(second - third) <= tolerance
                && Math.abs(first - third) <= tolerance);
    }

    /**
     * Sum another Object extending DoubleTriple to this
     *
     * @param doubleTriple the object whose values will be summed to this
     * @param <T>          must extend {@link DoubleTriple}
     * @return a new DoubleTriple with the new values
     */
    public <T extends DoubleTriple> DoubleTriple sum(final T doubleTriple) {
        return new DoubleTriple((first + doubleTriple.getFirst()), (second + doubleTriple.getSecond()), (third + doubleTriple.getThird()));
    }

    /**
     * Sum values to the current DoubleTriple.
     *
     * @param first  the value that will be summed to the first double
     * @param second the value that will be summed to the second double
     * @param third  the value that will be summed to the third double
     * @return a new DoubleTriple with the new values
     */
    public DoubleTriple sum(final double first, final double second, final double third) {
        return new DoubleTriple((this.first + first), (this.second + second), (this.third + third));
    }

    /**
     * Subtract another Object extending DoubleTriple to this
     *
     * @param doubleTriple the object whose values will be subtracted to this
     * @param <T>          must extend {@link DoubleTriple}
     * @return a new DoubleTriple with the new values
     */
    public <T extends DoubleTriple> DoubleTriple subtract(final T doubleTriple) {
        return new DoubleTriple((first - doubleTriple.getFirst()), (second - doubleTriple.getSecond()), (third - doubleTriple.getThird()));
    }

    /**
     * Subtract values to the current DoubleTriple.
     *
     * @param first  the value that will be subtracted to the first double
     * @param second the value that will be subtracted to the second double
     * @param third  the value that will be subtracted to the third double
     * @return a new DoubleTriple with the new values
     */
    public DoubleTriple subtract(final double first, final double second, final double third) {
        return new DoubleTriple((this.first - first), (this.second - second), (this.third - third));
    }

    /**
     * Multiply another Object extending DoubleTriple to this
     *
     * @param doubleTriple the object whose values will be multiplied by this
     * @param <T>          must extend {@link DoubleTriple}
     * @return a new DoubleTriple with the new values
     */
    public <T extends DoubleTriple> DoubleTriple multiply(final T doubleTriple) {
        return new DoubleTriple((first * doubleTriple.getFirst()), (second * doubleTriple.getSecond()), (third * doubleTriple.getThird()));
    }

    /**
     * Multiply values of the current DoubleTriple.
     *
     * @param first  the value that will multiply the first double
     * @param second the value that will multiply the second double
     * @param third  the value that will multiply the third double
     * @return a new DoubleTriple with the new values
     */
    public DoubleTriple multiply(final double first, final double second, final double third) {
        return new DoubleTriple((this.first * first), (this.second * second), (this.third * third));
    }
}
