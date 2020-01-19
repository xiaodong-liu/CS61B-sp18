public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static final double G = 6.67e-11;

    //construction methods
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    //methods
    public double calcDistance(Planet p) {
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;

        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet p) {
        double distance = this.calcDistance(p);

        return (G * this.mass * p.mass) / (distance * distance);
    }

    public double calcForceExertedByX(Planet p) {
        double distance = this.calcDistance(p);
        double dx = p.xxPos - this.xxPos;
        double F = this.calcForceExertedBy(p);

        return (F * dx) / distance;
    }

    public double calcForceExertedByY(Planet p) {
        double distance = this.calcDistance(p);
        double dy = p.yyPos - this.yyPos;
        double F = this.calcForceExertedBy(p);

        return (F * dy) / distance;
    }

    public double calcNetForceExertedByX(Planet[] p) {
        int length = p.length;
        int i = 0;
        double result = 0;
        while (i < length) {
            if (!this.equals(p[i])) {
                result = result + this.calcForceExertedByX(p[i]);
            }
            i = i + 1;
        }

        return result;
    }

    public double calcNetForceExertedByY(Planet[] p) {
        int length = p.length;
        int i = 0;
        double result = 0;
        while (i < length) {
            if (!this.equals(p[i])) {
                result = result + this.calcForceExertedByY(p[i]);
            }
            i = i + 1;
        }

        return result;
    }

    public void update(double dt, double x_force, double y_force) {
        double a_x = x_force / this.mass;
        double a_y = y_force / this.mass;

        this.xxVel = this.xxVel + dt * a_x;
        this.yyVel = this.yyVel + dt * a_y;

        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}
