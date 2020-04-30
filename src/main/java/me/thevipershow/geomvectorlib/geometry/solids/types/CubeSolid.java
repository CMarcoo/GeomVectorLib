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

package me.thevipershow.geomvectorlib.geometry.solids.types;

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
        for (int i = 1; i < 8; i += 2) {
            lines.addAll(TridimensionalUtils.joinTwoSpacePoints(vertexes.get(i), vertexes.get(i - 1), delta));
        }
        for (int i = 0; i < 4; i++) {
            lines.addAll(TridimensionalUtils.joinTwoSpacePoints(vertexes.get(i), vertexes.get(i + 4), delta));
        }
        return lines;
    }
}
