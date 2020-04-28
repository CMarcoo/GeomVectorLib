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
import me.thevipershow.geomvectorlib.geometry.planes.RegularPlaneShape;
import me.thevipershow.geomvectorlib.pairs.DoublePair;

public class SquarePlane extends RegularPlaneShape {
    public SquarePlane(int sides, double radius, DoublePair center) {
        super(sides, radius, center);
    }

    public SquarePlane(int sides, double radius, double x1, double y1) {
        super(sides, radius, x1, y1);
    }

    @Override
    public Set<DoublePair> calculateVertexes() {
        final Set<DoublePair> vertexes = new HashSet<>();
        vertexes.add(super.center.sum(super.apothem, super.apothem));
        vertexes.add(super.center.sum(super.apothem, -super.apothem));
        vertexes.add(super.center.sum(-super.apothem, super.apothem));
        vertexes.add(super.center.sum(-super.apothem, -super.apothem));
        return vertexes;
    }

    @Override
    public double getPerimeter() {
        return super.apothem * 8d;
    }

    @Override
    public double getSurface() {
        return Math.pow(super.apothem * 2d, 2d);
    }
}
