/*
 *
 *  * Software licensed by TheViperShow
 *  * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 *  * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 *  * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 *  * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 *  * OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package me.thevipershow.geomvectorlib.pairs;

import org.jetbrains.annotations.NotNull;

public class DoublePair implements Pair<Double, Double> {
    private final double first, second; // the first and second values

    public @NotNull DoublePair(double first, double second) {
        this.first = first;
        this.second = second;
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
     * Return a new Pair with swapped elements
     *
     * @return the previous pair but with swapped values.
     */
    @NotNull
    @Override
    public DoublePair swapElements() {
        return new DoublePair(second, first);
    }

    /**
     * This methods compares the two double values in the current DoublePair object
     * A tolerance value can be provided in order to check for 'similar' values
     *
     * @param tolerance the tolerance value that will be used to compare
     *                  an example would be a tolerance of '2E-1' would make values
     *                  such as '3.0' and '2.5' successfully return true using this method.
     * @return true if they are similar according to the provided tolerance, false otherwise.
     */
    public boolean areSimilar(final double tolerance) {
        return (Math.abs(first - second) <= tolerance);
    }

    /**
     * This methods calculates the scalar product of two DoublePair objects
     *
     * @param doublePair the other DoublePair object
     * @param <T>        an object extending DoublePair
     * @return the scalar product between the two DoublePairs
     * {@see <a href="https://en.wikipedia.org/wiki/Dot_product">Scalar Product</a>}
     */
    public <T extends DoublePair> double scalarProduct(@NotNull final T doublePair) {
        return ((first * doublePair.getFirst()) + (second * doublePair.getSecond()));
    }

    /**
     * This methods calculates the scalar product of this DobulePair and another point in the plane
     *
     * @param x the first axis coordinate
     * @param y the second axis coordinate
     * @return the scalar product between the two points
     * {@see <a href="https://en.wikipedia.org/wiki/Dot_product">Scalar Product</a>}
     */
    public double scalarProduct(final double x, final double y) {
        return ((first * x) + (second * y));
    }

    /**
     * Sum another Object extending DoublePair to this
     *
     * @param doublePair the object whose values will be summed to this
     * @param <T>        must extend {@link DoublePair}
     * @return a new DoublePair with the new values
     */
    @NotNull
    public <T extends DoublePair> DoublePair sum(@NotNull final T doublePair) {
        return new DoublePair((first + doublePair.getFirst()), (second + doublePair.getSecond()));
    }

    /**
     * Sum values to the current DoublePair.
     *
     * @param first  the value that will be summed to the first double
     * @param second the value that will be summed to the second double
     * @return a new DoublePair with the new values
     */
    @NotNull
    public DoublePair sum(final double first, double second) {
        return new DoublePair((this.first + first), (this.second + second));
    }

    /**
     * Subtract another Object extending DoublePair to this
     *
     * @param doublePair the object whose values will be subtracted to this
     * @param <T>        must extend {@link DoublePair}
     * @return a new DoublePair with the new values
     */
    @NotNull
    public <T extends DoublePair> DoublePair subtract(@NotNull final T doublePair) {
        return new DoublePair((this.first - doublePair.getFirst()), (this.second - doublePair.getSecond()));
    }

    /**
     * Subtract values to the current DoublePair.
     *
     * @param first  the value that will be subtracted to the first double
     * @param second the value that will be subtracted to the second double
     * @return a new DoublePair with the new values
     */
    @NotNull
    public DoublePair subtract(final double first, double second) {
        return new DoublePair((this.first - first), (this.second - second));
    }

    /**
     * Resize current DoublePair with a provided value
     *
     * @param value a double value
     * @return the new resized DoublePair
     */
    @NotNull
    public DoublePair resize(final double value) {
        return new DoublePair((first * value), (second * value));
    }
}
