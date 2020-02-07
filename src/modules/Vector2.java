package modules;

public class Vector2 {
    public double x;
    public double y;

    /***
     * Creates a new modules.Vector2
     * Holds two doubles, x and y
     * @param x component of the vector
     * @param y component of the vector
     */
    public Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }
    /***
     * calculates the distance between two points with pythagoras theorem
     * @param a the first vector containing a int, x and y position
     * @param b the second vector containing a int, x and y position
     * @return return the result of pythagoras theorem of the two vectors
     */
    public static double Distance(Vector2 a, Vector2 b){
        double dx = a.x - b.x;
        double dy = a.y - b.y;

        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    /***
     * Addition of two vectors
     * @param a modules.Vector2
     * @param b modules.Vector2
     * @return modules.Vector2
     */
    public static Vector2 Add(Vector2 a, Vector2 b){
        return new Vector2(a.x + b.x, a.y + b.y);
    }

    /***
     * Multiplication of two vectors
     * @param a modules.Vector2
     * @param s double
     * @return modules.Vector2
     */
    public static Vector2 Scale(Vector2 a, double s){
        return new Vector2(a.x * s, a.y * s);
    }
}
