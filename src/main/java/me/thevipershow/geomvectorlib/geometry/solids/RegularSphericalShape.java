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

public abstract class RegularSphericalShape implements SphericalVertexesCalculator, SolidCalculator {
    protected final DoubleTriple center;
    protected final double radius;

    public RegularSphericalShape(DoubleTriple center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public RegularSphericalShape(double x, double y, double z, double radius) {
        this.center = new DoubleTriple(x, y, z);
        this.radius = radius;
    }
}