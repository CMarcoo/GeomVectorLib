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

package me.thevipershow.geomvectorlib.geometry.planes.types.irregular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.thevipershow.geomvectorlib.geometry.common.PlaneCalculator;
import me.thevipershow.geomvectorlib.geometry.common.SpacedLinesCalculator;
import me.thevipershow.geomvectorlib.geometry.common.SurfaceCalculator;
import me.thevipershow.geomvectorlib.geometry.common.VertexesCalculator;
import me.thevipershow.geomvectorlib.geometry.planes.BidimensionalUtils;
import me.thevipershow.geomvectorlib.pairs.DoublePair;
import me.thevipershow.geomvectorlib.pairs.GenericPair;
import org.jetbrains.annotations.NotNull;

public class RectanglePlane implements PlaneCalculator, SurfaceCalculator, SpacedLinesCalculator<DoublePair>, VertexesCalculator<DoublePair> {
    private final GenericPair<DoublePair, DoublePair> oppositeVertexes;

    @NotNull
    public RectanglePlane(@NotNull final DoublePair point1, @NotNull final DoublePair point2) {
        oppositeVertexes = new GenericPair<>(point1, point2);
    }

    private @NotNull DoublePair getHeightAndLength() {
        final double height = BidimensionalUtils.distanceBetweenPlanePoints(oppositeVertexes.getFirst(),
                new DoublePair(oppositeVertexes.getFirst().getFirst(), oppositeVertexes.getSecond().getSecond()));
        final double length = BidimensionalUtils.distanceBetweenPlanePoints(oppositeVertexes.getSecond(),
                new DoublePair(oppositeVertexes.getFirst().getFirst(), oppositeVertexes.getSecond().getSecond()));
        return new DoublePair(height, length);
    }

    @Override
    public @NotNull List<DoublePair> calculateVertexes() {
        final List<DoublePair> vertexes = new ArrayList<>(Arrays.asList(oppositeVertexes.getFirst(), oppositeVertexes.getSecond()));
        vertexes.add(new DoublePair(oppositeVertexes.getFirst().getFirst(), oppositeVertexes.getSecond().getSecond()));
        vertexes.add(new DoublePair(oppositeVertexes.getFirst().getFirst(), oppositeVertexes.getSecond().getSecond()));
        return vertexes;
    }

    @Override
    public double getPerimeter() {
        final DoublePair heightAndLength = getHeightAndLength();
        return ((heightAndLength.getFirst() * 2) + (heightAndLength.getSecond() * 2));
    }

    @Override
    public double getSurface() {
        final DoublePair heightAndLength = getHeightAndLength();
        return heightAndLength.getFirst() * heightAndLength.getSecond();
    }

    @Override
    public @NotNull List<DoublePair> calculateSpacedLines(final double delta) {
        final List<DoublePair> vertexes = new ArrayList<>();
        final DoublePair oppositeFirst = new DoublePair(oppositeVertexes.getFirst().getFirst(), oppositeVertexes.getSecond().getSecond());
        final DoublePair oppositeSecond = new DoublePair(oppositeVertexes.getFirst().getFirst(), oppositeVertexes.getSecond().getSecond());
        vertexes.addAll(BidimensionalUtils.joinTwoSpacePoints(oppositeVertexes.getFirst(), oppositeVertexes.getSecond(), delta));
        vertexes.addAll(BidimensionalUtils.joinTwoSpacePoints(oppositeVertexes.getSecond(), oppositeFirst, delta));
        vertexes.addAll(BidimensionalUtils.joinTwoSpacePoints(oppositeFirst, oppositeSecond, delta));
        vertexes.addAll(BidimensionalUtils.joinTwoSpacePoints(oppositeSecond, oppositeVertexes.getFirst(), delta));
        return vertexes;
    }
}
