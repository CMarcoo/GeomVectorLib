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
import me.thevipershow.geomvectorlib.geometry.planes.BidimensionalUtils;
import me.thevipershow.geomvectorlib.pairs.DoublePair;
import org.jetbrains.annotations.NotNull;

public class RhombusPlane implements SpacedLinesCalculator<DoublePair>, SurfaceCalculator, PlaneCalculator {
    private final List<DoublePair> vertexes;
    private final double height, length;

    @NotNull
    public RhombusPlane(@NotNull final DoublePair center, final double height, final double length) {
        this.height = height;
        this.length = length;
        vertexes = new ArrayList<>();
        vertexes.add(center.sum(length / 2d, 0d));
        vertexes.add(center.subtract(length / 2d, 0d));
        vertexes.add(center.sum(0d, height / 2d));
        vertexes.add(center.subtract(0d, height / 2d));
    }

    @Override
    public double getPerimeter() {
        return (Math.sqrt(Math.pow(height / 2d, 2d) + Math.pow(length / 2d, 2d)) * 4d);
    }

    @Override
    public double getSurface() {
        return ((height * length) / 2d);
    }

    @Override
    public @NotNull List<DoublePair> calculateSpacedLines(double delta) {
        final List<DoublePair> spacedVertexes = new ArrayList<>();
        spacedVertexes.addAll(BidimensionalUtils.joinTwoSpacePoints(vertexes.get(0), vertexes.get(1), delta));
        spacedVertexes.addAll(BidimensionalUtils.joinTwoSpacePoints(vertexes.get(1), vertexes.get(2), delta));
        spacedVertexes.addAll(BidimensionalUtils.joinTwoSpacePoints(vertexes.get(2), vertexes.get(3), delta));
        spacedVertexes.addAll(BidimensionalUtils.joinTwoSpacePoints(vertexes.get(3), vertexes.get(0), delta));
        return spacedVertexes;
    }
}
