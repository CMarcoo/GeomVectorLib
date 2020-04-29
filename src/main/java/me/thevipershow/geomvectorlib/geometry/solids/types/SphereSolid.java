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

import java.util.HashSet;
import java.util.Set;
import me.thevipershow.geomvectorlib.geometry.planes.types.CirclePlane;
import me.thevipershow.geomvectorlib.geometry.solids.RegularSphericalShape;
import me.thevipershow.geomvectorlib.pairs.DoublePair;
import me.thevipershow.geomvectorlib.triples.DoubleTriple;
import org.jetbrains.annotations.NotNull;

public class SphereSolid extends RegularSphericalShape {
    @NotNull
    public SphereSolid(@NotNull final DoubleTriple center, final double radius) {
        super(center, radius);
    }

    @NotNull
    @Override
    public Set<CirclePlane> calculateVertexes(final double delta) {
        final Set<CirclePlane> circlePlaneSet = new HashSet<>();
        final Set<DoublePair> dummyCircle = new CirclePlane(super.radius,
                super.center.getFirst(),
                super.center.getSecond()).calculateVertexes(delta, 180d);
        dummyCircle.forEach(doublePair ->
                circlePlaneSet.add(new CirclePlane(Math.abs(doublePair.getFirst() - center.getFirst()),
                        super.center.getFirst(),
                        doublePair.getSecond())));
        return circlePlaneSet;
    }

    /**
     * Calculate the surface of the current sphere solid.
     *
     * @return the surface of this sphere solid
     * {@see <a href="https://en.wikipedia.org/wiki/Sphere#Surface_area">Sphere surface</a>}
     */
    @Override
    public final double getSurface() {
        return 4d * Math.PI * Math.pow(super.radius, 2d);
    }

    /**
     * Calculate the volume of the current sphere solid.
     *
     * @return the volume of this sphere solid
     * {@see <a href="https://en.wikipedia.org/wiki/Sphere#Enclosed_volume">Sphere volume</a>}
     */
    @Override
    public final double getVolume() {
        return (4d / 3d) * Math.PI * Math.pow(super.radius, 3d);
    }
}
