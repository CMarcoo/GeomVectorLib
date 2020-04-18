/*
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
