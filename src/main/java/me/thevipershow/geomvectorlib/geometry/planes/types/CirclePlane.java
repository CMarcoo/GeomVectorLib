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

package me.thevipershow.geomvectorlib.geometry.planes.types;

import java.util.HashSet;
import java.util.Set;
import me.thevipershow.geomvectorlib.geometry.planes.CircularPlaneShape;
import me.thevipershow.geomvectorlib.pairs.DoublePair;
import org.jetbrains.annotations.NotNull;

public class CirclePlane extends CircularPlaneShape {

    @NotNull
    public CirclePlane(final double radius, @NotNull final DoublePair center) {
        super(radius, center);
    }

    @NotNull
    public CirclePlane(final double radius, final double x, final double y) {
        super(radius, x, y);
    }

    @NotNull
    private Set<DoublePair> getCircleVertexes(final double distribution, final double degrees) {
        final Set<DoublePair> doublePairSet = new HashSet<>();
        for (double i = 0d; i < Math.toRadians(degrees); i += Math.toRadians(distribution)) {
            doublePairSet.add(new DoublePair(
                    (super.radius * Math.sin(i)) + super.center.getFirst(),
                    (super.radius * Math.cos(i)) + super.center.getSecond()
            ));
        }
        return doublePairSet;
    }

    @NotNull
    @Override
    public Set<DoublePair> calculateVertexes(final double delta) {
        return getCircleVertexes(delta, 360d);
    }

    @NotNull
    public Set<DoublePair> calculateVertexes(final double delta, final double degrees) {
        return getCircleVertexes(delta, degrees);
    }

    /**
     * Calculate the surface of the current circle
     *
     * @return the surface of this circle from the radius
     * {@see <a href="https://en.wikipedia.org/wiki/Circle#Area_enclosed">Circle surface</a>}
     */
    @Override
    public double getSurface() {
        return (Math.PI * Math.pow(super.radius, 2d));
    }

    /**
     * Calculate the length of the circumference of the current circle
     *
     * @return the length of the circumference from the radius
     * {@see <a href="https://en.wikipedia.org/wiki/Circle#Length_of_circumference">Circle circumference</a>}
     */
    @Override
    public double getPerimeter() {
        return (Math.PI * (super.radius * 2));
    }
}
