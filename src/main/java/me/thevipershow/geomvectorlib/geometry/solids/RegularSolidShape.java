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

package me.thevipershow.geomvectorlib.geometry.solids;

import java.util.Set;
import me.thevipershow.geomvectorlib.geometry.common.SolidCalculator;
import me.thevipershow.geomvectorlib.geometry.common.VertexesCalculator;
import me.thevipershow.geomvectorlib.triples.DoubleTriple;

public abstract class RegularSolidShape implements VertexesCalculator<DoubleTriple>, SolidCalculator {
    protected DoubleTriple center;
    protected Set<DoubleTriple> vertexes;
    protected double radius;

    public RegularSolidShape(final DoubleTriple center, final double radius) {
        this.center = center;
        this.radius = radius;
    }
}
