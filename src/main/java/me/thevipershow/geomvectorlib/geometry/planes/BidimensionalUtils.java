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

package me.thevipershow.geomvectorlib.geometry.planes;

import java.util.ArrayList;
import java.util.List;
import me.thevipershow.geomvectorlib.pairs.DoublePair;
import me.thevipershow.geomvectorlib.triples.DoubleTriple;
import org.jetbrains.annotations.NotNull;

public final class BidimensionalUtils {
    /**
     * Calculate the distance between two points in a plane
     *
     * @param firstPoint  the DoubleTriple representing the first point
     * @param secondPoint the DoubleTriple representing the second point
     * @return the exact distance between the two points in the plane
     */
    public static double distanceBetweenPlanePoints(@NotNull final DoublePair firstPoint, @NotNull final DoublePair secondPoint) {
        final double differenceX = secondPoint.getFirst() - firstPoint.getFirst();
        final double differenceY = secondPoint.getSecond() - firstPoint.getSecond();
        return Math.sqrt((Math.pow(differenceX, 2d) + Math.pow(differenceY, 2d)));
    }

    /**
     * Calculate the distance between two points in space
     *
     * @param x1 the first coordinate of the first point
     * @param y1 the second coordinate of the first point
     * @param x2 the first coordinate of the second point
     * @param y2 the second coordinate of the second point
     * @return the exact distance between the two points in the plane
     */
    public static double distanceBetweenPlanePoints(final double x1, final double y1, final double x2, final double y2) {
        return Math.sqrt(Math.pow((x1 - x2), 2d) + Math.pow((y1 - y2), 2d));
    }

    /**
     * This methods provides a List of DoublePair points that represent the connection between two
     * different points in a plane. You can provide the 'intensity' of the line by increasing or lowering the delta.
     *
     * @param firstPoint  the first point
     * @param secondPoint the second point
     * @param delta       the 'intensity' of the points distribution between the two connected points.
     *                    This value should usually be a double from 0.0 to 1.0
     * @return A Set of DoublePair objects that represent a 'connection' between two points in a plane.
     */
    @NotNull
    public static List<DoublePair> joinTwoSpacePoints(@NotNull final DoublePair firstPoint, @NotNull final DoublePair secondPoint, final double delta) {
        final List<DoublePair> doublePairList = new ArrayList<>();
        final DoublePair resultDoublePair = new DoublePair((secondPoint.getFirst() - firstPoint.getFirst()),
                (secondPoint.getSecond() - firstPoint.getSecond()));
        for (double i = 0.0d; i < 1.0d; i += delta) {
            doublePairList.add(firstPoint.sum(resultDoublePair.resize(i)));
        }
        return doublePairList;
    }
}
