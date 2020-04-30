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

package me.thevipershow.geomvectorlib.geometry.planes;

import me.thevipershow.geomvectorlib.geometry.common.PlaneCalculator;
import me.thevipershow.geomvectorlib.geometry.common.SpacedLinesCalculator;
import me.thevipershow.geomvectorlib.geometry.common.VertexesCalculator;
import me.thevipershow.geomvectorlib.pairs.DoublePair;
import org.jetbrains.annotations.NotNull;

public abstract class RegularPlaneShape implements VertexesCalculator<DoublePair>, PlaneCalculator, SpacedLinesCalculator<DoublePair> {
    protected final int sides;
    protected final double apothem;
    protected final @NotNull DoublePair center;

    @NotNull
    public RegularPlaneShape(final int sides, final double apothem, @NotNull final DoublePair center) {
        this.sides = sides;
        this.apothem = apothem;
        this.center = center;
    }

    @NotNull
    public RegularPlaneShape(final int sides, final double apothem, final double x1, final double y1) {
        this.sides = sides;
        this.apothem = apothem;
        this.center = new DoublePair(x1, y1);
    }
}
