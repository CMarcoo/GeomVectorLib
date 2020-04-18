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

import me.thevipershow.geomvectorlib.pairs.DoublePair;

public abstract class RegularPlaneShape implements PlaneCalculator {
    protected final int sides;
    protected final double radius;
    protected final DoublePair center;

    public RegularPlaneShape(int sides, double radius, DoublePair center) {
        this.sides = sides;
        this.radius = radius;
        this.center = center;
    }

    public RegularPlaneShape(int sides, double radius, final double x1, final double y1) {
        this.sides = sides;
        this.radius = radius;
        this.center = new DoublePair(x1, y1);
    }
}
