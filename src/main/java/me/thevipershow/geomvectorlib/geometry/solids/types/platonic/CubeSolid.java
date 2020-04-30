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

package me.thevipershow.geomvectorlib.geometry.solids.types.platonic;

import java.util.ArrayList;
import java.util.List;
import me.thevipershow.geomvectorlib.geometry.solids.RegularSolidShape;
import me.thevipershow.geomvectorlib.geometry.solids.TridimensionalUtils;
import me.thevipershow.geomvectorlib.triples.DoubleTriple;
import org.jetbrains.annotations.NotNull;

public class CubeSolid extends RegularSolidShape {
    public CubeSolid(@NotNull DoubleTriple center, double radius) {
        super(center, radius);
    }

    @Override
    public double getVolume() {
        return Math.pow(super.apothem, 3d);
    }

    @Override
    public double getSurface() {
        return Math.pow(super.apothem, 2d) * 6d;
    }

    @Override
    public @NotNull List<DoubleTriple> calculateVertexes() {
        final List<DoubleTriple> vertexes = new ArrayList<>();
        vertexes.add(super.center.sum(super.apothem, super.apothem, super.apothem));
        vertexes.add(super.center.sum(super.apothem, super.apothem, -super.apothem));
        vertexes.add(super.center.sum(-super.apothem, super.apothem, -super.apothem));
        vertexes.add(super.center.sum(-super.apothem, super.apothem, super.apothem));
        vertexes.add(super.center.sum(super.apothem, -super.apothem, super.apothem));
        vertexes.add(super.center.sum(super.apothem, -super.apothem, -super.apothem));
        vertexes.add(super.center.sum(-super.apothem, -super.apothem, -super.apothem));
        vertexes.add(super.center.sum(-super.apothem, -super.apothem, super.apothem));
        return vertexes;
    }

    public @NotNull List<DoubleTriple> joinVertexes(final double delta) {
        final List<DoubleTriple> vertexes = calculateVertexes();
        final List<DoubleTriple> lines = new ArrayList<>();
        lines.addAll(TridimensionalUtils.joinTwoSpacePoints(vertexes.get(0),vertexes.get(1),delta));
        lines.addAll(TridimensionalUtils.joinTwoSpacePoints(vertexes.get(1), vertexes.get(2), delta));
        lines.addAll(TridimensionalUtils.joinTwoSpacePoints(vertexes.get(2), vertexes.get(3), delta));
        lines.addAll(TridimensionalUtils.joinTwoSpacePoints(vertexes.get(3), vertexes.get(0), delta));
        lines.addAll(TridimensionalUtils.joinTwoSpacePoints(vertexes.get(4), vertexes.get(5), delta));
        lines.addAll(TridimensionalUtils.joinTwoSpacePoints(vertexes.get(5), vertexes.get(6), delta));
        lines.addAll(TridimensionalUtils.joinTwoSpacePoints(vertexes.get(6), vertexes.get(7), delta));
        lines.addAll(TridimensionalUtils.joinTwoSpacePoints(vertexes.get(7), vertexes.get(4), delta));
        lines.addAll(TridimensionalUtils.joinTwoSpacePoints(vertexes.get(0), vertexes.get(4), delta));
        lines.addAll(TridimensionalUtils.joinTwoSpacePoints(vertexes.get(1), vertexes.get(5), delta));
        lines.addAll(TridimensionalUtils.joinTwoSpacePoints(vertexes.get(2), vertexes.get(6), delta));
        lines.addAll(TridimensionalUtils.joinTwoSpacePoints(vertexes.get(3), vertexes.get(7), delta));
        return lines;
    }
}
