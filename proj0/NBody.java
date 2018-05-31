public class NBody {

    /** Read Radius
     *
     * @param fileName input
     * @return the second line
     */
    public static double readRadius(String fileName){
        In in = new In(fileName);
        in.readInt();
        return in.readDouble();
    }

    /** read Planets
     *
     * @param fileName input file
     * @return array of planets
     */
    public static Planet[] readPlanets(String fileName){
        In in = new In(fileName);
        int numberOfPlanets = in.readInt();
        in.readDouble();
        Planet[] planets = new Planet[numberOfPlanets];
        for(int i = 0; i < numberOfPlanets; i++){
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xP, yP, xV, yV, m, img);
        }
        return planets;

    }

    public static void main(String args[]){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);
        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0,0,"images/starfield.jpg");
        for(Planet p:planets){
            p.draw();
        }
        StdDraw.enableDoubleBuffering();
        for(double time = 0; time <= T; time += dt){
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            StdDraw.picture(0,0,"images/starfield.jpg");
            for (int j = 0; j < planets.length; j++){
                xForces[j] = planets[j].calcNetForceExertedByX(planets);
                yForces[j] = planets[j].calcNetForceExertedByY(planets);
            }
            for (int j = 0; j<planets.length; j++){
                planets[j].update(dt, xForces[j], yForces[j]);
                planets[j].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n",radius);
        for (int i = 0; i<planets.length; i++){
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}