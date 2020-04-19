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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import me.thevipershow.geomvectorlib.geometry.planes.types.CirclePlane;
import me.thevipershow.geomvectorlib.geometry.solids.RegularSolidShape;
import me.thevipershow.geomvectorlib.geometry.solids.TridimensionalUtils;
import me.thevipershow.geomvectorlib.pairs.DoublePair;
import me.thevipershow.geomvectorlib.triples.DoubleTriple;

public class SphereSolid extends RegularSolidShape {
    public SphereSolid(DoubleTriple center, double radius) {
        super(center, radius);
    }

    @Override
    public Set<Set<DoubleTriple>> calculateVertexes(double delta) {
        final Set<Set<DoubleTriple>> sphereVertexes = new HashSet<>(); // The result
        final CirclePlane dummyCircle = new CirclePlane(radius, new DoublePair(center.getFirst(), center.getSecond()));
        final List<DoubleTriple> dummyCircleInSpace = new ArrayList<>();
        dummyCircle.calculateVertexes(delta, 180d).forEach(vx -> dummyCircleInSpace.add(new DoubleTriple(vx.getFirst(), vx.getSecond(), center.getThird())));
        dummyCircleInSpace.forEach(point -> {
            final DoubleTriple newCenter = new DoubleTriple(center.getFirst(), point.getSecond(), center.getThird());
            final double currentRadius = TridimensionalUtils.distanceBetweenSpacePoints(point, newCenter);
            final Set<DoubleTriple> currentCircleSet = new HashSet<>();
            new CirclePlane(currentRadius, new DoublePair(newCenter.getFirst(), newCenter.getThird())).calculateVertexes(delta)
                    .forEach(pair -> currentCircleSet.add(new DoubleTriple(pair.getFirst(), newCenter.getSecond(), pair.getSecond())));
            sphereVertexes.add(currentCircleSet);
        });

        return sphereVertexes;
    }

    /**
     * Calculate the surface of the current sphere solid.
     *
     * @return the surface of this sphere solid
     * {@see <a href="https://en.wikipedia.org/wiki/Sphere#Surface_area">Sphere surface</a>}
     */
    @Override
    public final double calculateSurface() {
        return 4d * Math.PI * Math.pow(radius, 2d);
    }

    /**
     * Calculate the volume of the current sphere solid.
     *
     * @return the volume of this sphere solid
     * {@see <a href="https://en.wikipedia.org/wiki/Sphere#Enclosed_volume">Sphere volume</a>}
     */
    @Override
    public final double calculateVolume() {
        return (4d / 3d) * Math.PI * Math.pow(radius, 3d);
    }
}
