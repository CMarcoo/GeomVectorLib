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

import me.thevipershow.geomvectorlib.geometry.common.SolidCalculator;
import me.thevipershow.geomvectorlib.geometry.common.SphericalVertexesCalculator;
import me.thevipershow.geomvectorlib.triples.DoubleTriple;
import org.jetbrains.annotations.NotNull;

public abstract class RegularSphericalShape implements SphericalVertexesCalculator, SolidCalculator {
    protected final @NotNull DoubleTriple center;
    protected final double radius;

    @NotNull
    public RegularSphericalShape(@NotNull final DoubleTriple center, final double radius) {
        this.center = center;
        this.radius = radius;
    }

    @NotNull
    public RegularSphericalShape(final double x, final double y, final double z, final double radius) {
        this.center = new DoubleTriple(x, y, z);
        this.radius = radius;
    }
}
