public class NBody {
    public static double readRadius(String fileAddress) {
        In in = new In(fileAddress);

        int firstItemInFile = in.readInt();
        double secondItemInFile = in.readDouble();

        return secondItemInFile;
    }

    public static Planet[] readPlanets(String fileAddress) {
        In in = new In(fileAddress);

        int Planet_Number = in.readInt();
        double Planet_radius = in.readDouble();
        Planet[] p = new Planet[Planet_Number];

        int i = 0;
        while (i < Planet_Number) {
            Planet temp = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
            p[i] = temp;
            i++;
        }
        return p;
    }

    public static void main(String[] args) {

        //Collecting ALL Needed Input
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] p = readPlanets(filename);
        double radius = readRadius(filename);

        //Drawing the Background
        String imageToDraw = "images/starfield.jpg";
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, imageToDraw);

        for (int i = 0; i < p.length; i++) {
            p[i].draw();
        }
        StdDraw.show();


        StdDraw.enableDoubleBuffering();
        
        for (double time = 0; time < T; time = time + dt) {
            double[] xForces = new double[p.length];
            double[] yForces = new double[p.length];
            for (int i = 0; i < p.length; i++) {
                xForces[i] = p[i].calcNetForceExertedByX(p);
                yForces[i] = p[i].calcNetForceExertedByY(p);
            }
            for (int i = 0; i < p.length; i++)
                p[i].update(dt, xForces[i], yForces[i]);
            StdDraw.clear();
            StdDraw.picture(0, 0, imageToDraw);
            for (int i = 0; i < p.length; i++) {
                //p[i].update(10, xForces[i], yForces[i]);
                p[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }

        StdOut.printf("%d\n", p.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < p.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    p[i].xxPos, p[i].yyPos, p[i].xxVel,
                    p[i].yyVel, p[i].mass, p[i].imgFileName);
        }
    }
}
