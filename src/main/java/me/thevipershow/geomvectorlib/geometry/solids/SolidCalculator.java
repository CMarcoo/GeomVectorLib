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

package me.thevipershow.geomvectorlib.geometry.solids;

import java.util.Set;
import me.thevipershow.geomvectorlib.triples.DoubleTriple;

public interface SolidCalculator {
    /**
     * This methods provides a nested Set of DoubleTriple objects
     * {@linkplain DoubleTriple}
     * Each DoubleTriple object represents a point in space with 3 coordinates.
     * Each Set stored in the outer one represents a bi dimensional part of the
     * tri dimensional solid itself. For example in a Cube you would wind a Set of
     * DoubleTriple objects for each side, so 12 collections.
     * Or A sphere , where each Set represents one circle.
     *
     * @return a nested Collection of DoubleTriple objects
     */
    Set<Set<DoubleTriple>> calculateVertexes();

    /**
     * This methods calculates the surface area of the solid
     *
     * @return the surface of this solid
     */
    double calculateSurface();

    /**
     * This methods calculates the volume of the solid
     *
     * @return the volume of this solid
     */
    double calculateVolume();
}
