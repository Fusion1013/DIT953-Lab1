public class Vector2 {
    public double x;
    public double y;

    /***
     * Creates a new Vector2
     * Holds two doubles, x and y
     * @param x component of the vector
     * @param y component of the vector
     */
    public Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }

    /***
     * Addition of two vectors
     * @param a Vector2
     * @param b Vector2
     * @return Vector2
     */
    public static Vector2 Add(Vector2 a, Vector2 b){
        return new Vector2(a.x + b.x, a.y + b.y);
    }

    /***
     * Multiplication of two vectors
     * @param a Vector2
     * @param s double
     * @return Vector2
     */
    public static Vector2 Scale(Vector2 a, double s){
        return new Vector2(a.x * s, a.y * s);
    }
}
