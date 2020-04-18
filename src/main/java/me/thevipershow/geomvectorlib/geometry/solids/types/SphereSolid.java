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

import java.util.Set;
import me.thevipershow.geomvectorlib.geometry.solids.RegularSolidShape;
import me.thevipershow.geomvectorlib.triples.DoubleTriple;

public class SphereSolid extends RegularSolidShape {
    public SphereSolid(DoubleTriple center, double radius) {
        super(center, radius);
    }

    @Override
    public Set<Set<DoubleTriple>> calculateVertexes() {
        return null; // TODO: 18/04/2020 Implement.
    }

    @Override
    public final double calculateSurface() {
        return 4d * Math.PI * Math.pow(radius, 2d);
    }

    @Override
    public final double calculateVolume() {
        return (4d / 3d) * Math.PI * Math.pow(radius, 3d);
    }
}
