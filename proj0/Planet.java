/** class Planet contains everything for a Planet
 *  Implemented By Xc.Li
 */

public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G = 6.67e-11;  // Gravitation Constant

    /** Constructor 1: take in the parameters and build a new Planet object
    * @param xP, yP, xV, yV, m, img : variables in the object
    * **/
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /** Constructor 2: take in an object and make a copy of it.
    * @param P is the input object **/
    public Planet(Planet P){
        xxPos = P.xxPos;
        yyPos = P.yyPos;
        xxVel = P.xxVel;
        yyVel = P.yyVel;
        mass = P.mass;
        imgFileName = P.imgFileName;
    }

    /** Calculate the distance between the current Planet and anotherPlanet
    * @param anotherPlanet : the planet we want to calculate distance
    * @return distance **/
    public double calcDistance(Planet anotherPlanet){
        double dx = xxPos - anotherPlanet.xxPos;
        double dy = yyPos - anotherPlanet.yyPos;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance;
    }

    /**Calculate the force exerted on this planet by the given planet
     * @param anotherPlanet the given planet
     * @return force**/
    public double calcForceExertedBy(Planet anotherPlanet){
        double distance = calcDistance(anotherPlanet);
        double force = (G * anotherPlanet.mass * mass) / (distance * distance);
        return force;
    }

    /**Calculate tje force exerted in the X direction
     * @param anotherPlanet : the given planet
     * @return forceX**/
    public double calcForceExertedByX(Planet anotherPlanet){
        double force = calcForceExertedBy(anotherPlanet);
        double distance = calcDistance(anotherPlanet);
        double forceX = force * (anotherPlanet.xxPos - xxPos) / distance;
        return forceX;
    }

    /**Calculate the force exerted in the Y direction
     * @param anotherPlanet : the given planet
     * @return forceX**/
    public double calcForceExertedByY(Planet anotherPlanet){
        double force = calcForceExertedBy(anotherPlanet);
        double distance = calcDistance(anotherPlanet);
        double forceY = force * (anotherPlanet.yyPos - yyPos) / distance;
        return forceY;
    }

    /** Calculate the force exerted by all the planets in the array in X direction
     *
     * @param allPlanets array of Planets
     * @return Net force in X direction
     */
    public double calcNetForceExertedByX(Planet[] allPlanets){
        double netForceX = 0.0;
        for (Planet P : allPlanets) {
            if (P == this) {
                continue; // Skip itself
            } else {
                netForceX += calcForceExertedByX(P);
            }
        }
        return netForceX;
    }

    /** Calculate the force exerted by all the planets in the array in Y direction
     *
     * @param allPlanets array of Planets
     * @return Net Force in Y direction
     */
    public double calcNetForceExertedByY(Planet[] allPlanets){
        double netForceY = 0.0;
        for (Planet P : allPlanets) {
            if (P == this) {
                continue;  // skip itself
            } else {
                netForceY += calcForceExertedByY(P);
            }
        }
        return netForceY;
    }

    /** update the Velocity and Position
     *
     * @param dt time
     * @param fX force in X direction
     * @param fY force in Y direction
     */
    public void update(double dt, double fX, double fY){
        double aX = fX/mass;
        double aY = fY/mass;
        xxVel += dt * aX;
        yyVel += dt * aY;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
    }
}
