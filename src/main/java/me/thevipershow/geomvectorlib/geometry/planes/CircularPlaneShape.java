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

import me.thevipershow.geomvectorlib.geometry.common.CircularVertexesCalculator;
import me.thevipershow.geomvectorlib.pairs.DoublePair;

public abstract class CircularPlaneShape implements CircularVertexesCalculator<DoublePair> {
    protected final double radius;
    protected final DoublePair center;

    public CircularPlaneShape(final double radius, final DoublePair center) {
        this.radius = radius;
        this.center = center;
    }

    public CircularPlaneShape(final double radius, final double x, final double y) {
        this.radius = radius;
        this.center = new DoublePair(x, y);
    }
}
