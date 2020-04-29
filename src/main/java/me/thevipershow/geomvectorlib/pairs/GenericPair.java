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

public class GenericPair<A, B> implements Pair<A, B> {
    private final @NotNull A first;  // The first element of this pair
    private final @NotNull B second; // The second element of this pair

    /**
     * Creates a new Pair with two objects stored in order.
     *
     * @param first  the first element.
     * @param second the second element.
     */
    public @NotNull GenericPair(@NotNull final A first, @NotNull final B second) {
        this.first = first;
        this.second = second;
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
     * Return a new Pair with swapped elements
     *
     * @return the previous pair but with swapped values.
     */
    @Override
    public Pair<B, A> swapElements() {
        return new GenericPair<>(second, first);
    }
}
