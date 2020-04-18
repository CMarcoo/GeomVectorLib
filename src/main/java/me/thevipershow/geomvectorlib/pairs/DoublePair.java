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

public class DoublePair implements Pair<Double, Double> {
    private final double first, second; // the first and second values

    public DoublePair(double first, double second) {
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
     * Sum another Object extending DoublePair to this
     *
     * @param doublePair the object whose values will be summed to this
     * @param <T>        must extend {@link DoublePair}
     * @return a new DoublePair with the new values
     */
    public <T extends DoublePair> DoublePair sum(final T doublePair) {
        return new DoublePair((first + doublePair.getFirst()), (second + doublePair.getSecond()));
    }

    /**
     * Sum values to the current DoublePair.
     *
     * @param first  the value that will be summed to the first double
     * @param second the value that will be summed to the second double
     * @return a new DoublePair with the new values
     */
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
    public <T extends DoublePair> DoublePair subtract(final T doublePair) {
        return new DoublePair((this.first - doublePair.getFirst()), (this.second - doublePair.getSecond()));
    }

    /**
     * Subtract values to the current DoublePair.
     *
     * @param first  the value that will be subtracted to the first double
     * @param second the value that will be subtracted to the second double
     * @return a new DoublePair with the new values
     */
    public DoublePair subtract(final double first, double second) {
        return new DoublePair((this.first - first), (this.second - second));
    }

    /**
     * Multiply another Object extending DoublePair to this
     *
     * @param doublePair the object whose values will be multiplied to this
     * @param <T>        must extend {@link DoublePair}
     * @return a new DoublePair with the new values
     */
    public <T extends DoublePair> DoublePair multiply(final T doublePair) {
        return new DoublePair((this.first * doublePair.getFirst()), (this.second * doublePair.getSecond()));
    }

    /**
     * Multiply values of the current DoublePair.
     *
     * @param first  the value that will be multiplied by the first double
     * @param second the value that will be multiplied by the second double
     * @return a new DoublePair with the new values
     */
    public DoublePair multiply(final double first, double second) {
        return new DoublePair((this.first * first), (this.second * second));
    }
}
