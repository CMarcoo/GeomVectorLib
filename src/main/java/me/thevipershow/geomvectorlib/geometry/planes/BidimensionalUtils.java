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

import me.thevipershow.geomvectorlib.pairs.DoublePair;

public final class BidimensionalUtils {
    /**
     * Calculate the distance between two points in a plane
     *
     * @param firstPoint  the DoubleTriple representing the first point
     * @param secondPoint the DoubleTriple representing the second point
     * @return the exact distance between the two points in the plane
     */
    public static double distanceBetweenPlanePoints(final DoublePair firstPoint, final DoublePair secondPoint) {
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
}
