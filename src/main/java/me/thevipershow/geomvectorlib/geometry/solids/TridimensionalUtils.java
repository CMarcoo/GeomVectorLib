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

import java.util.HashSet;
import java.util.Set;
import me.thevipershow.geomvectorlib.triples.DoubleTriple;

public final class TridimensionalUtils {
    /**
     * Calculate the distance between two points in space
     *
     * @param firstPoint  the DoubleTriple representing the first point
     * @param secondPoint the DoubleTriple representing the second point
     * @return the exact distance between the two points in space
     */
    public static double distanceBetweenSpacePoints(final DoubleTriple firstPoint, final DoubleTriple secondPoint) {
        final double differenceX = secondPoint.getFirst() - firstPoint.getFirst();
        final double differenceY = secondPoint.getSecond() - firstPoint.getSecond();
        final double differenceZ = secondPoint.getThird() - firstPoint.getThird();
        return Math.sqrt((Math.pow(differenceX, 2d) + Math.pow(differenceY, 2d) + Math.pow(differenceZ, 2d)));
    }

    /**
     * Calculate the distance between two points in space
     *
     * @param x1 the first coordinate of the first point
     * @param y1 the second coordinate of the first point
     * @param z1 the third coordinate of the first point
     * @param x2 the first coordinate of the second point
     * @param y2 the second coordinate of the second point
     * @param z2 the third coordinate of the second point
     * @return the exact distance between the two points in space
     */
    public static double distanceBetweenSpacePoints(final double x1, final double y1, final double z1, final double x2, final double y2, final double z2) {
        return Math.sqrt(Math.pow((x1 - x2), 2d) + Math.pow((y1 - y2), 2d) + Math.pow((z1 - z2), 2d));
    }

    /**
     * This methods provides a Set of DoubleTriple points that represent the connection between two
     * different points in space. You can provide the 'intensity' of the line by increasing or lowering the delta.
     *
     * @param firstPoint  the first point
     * @param secondPoint the second point
     * @param delta       the 'intensity' of the points distribution between the two connected points.
     *                    This value should usually be a double from 0.0 to 1.0
     * @return A Set of DoubleTriple objects that represent a 'connection' between two points in space.
     */
    public static Set<DoubleTriple> joinTwoSpacePoints(final DoubleTriple firstPoint, final DoubleTriple secondPoint, final double delta) {
        final Set<DoubleTriple> doubleTripleSet = new HashSet<>();
        final DoubleTriple resultDoubleTriple = new DoubleTriple((secondPoint.getFirst() - firstPoint.getFirst()),
                (secondPoint.getSecond() - firstPoint.getSecond()),
                (secondPoint.getThird() - firstPoint.getThird()));
        for (double i = 0.0d; i < 1.0d; i += delta) {
            doubleTripleSet.add(firstPoint.scalarProduct(resultDoubleTriple.resize(i)));
        }
        return doubleTripleSet;
    }
}
