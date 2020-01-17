public class NBody{

    /**要使用静态方法 */
    public static double readRadius(String s){
        In in = new In(s);
        int firstItemInFile = in.readInt();
        double secondItemInFile = in.readDouble();
        return secondItemInFile;
    }
    public static Body [] readBodies(String s){
        In in = new In(s);
        int num = in.readInt();/**读取第一行，也就是body的数量以此创建array */
        in.readDouble();/**一定要读不然后面乱了 */
        Body [] Planets = new Body [num];
        int i = 0;
        while(i<num){
            double xp =  in.readDouble();
            double yp = in.readDouble();
            double xv = in.readDouble();
            double yv = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            /**i++是操作之后增加 */
            Planets[i++] = new Body(xp,yp,xv,yv,m,img);
        }
        return Planets;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        /**在外部调用静态方法时，可以使用"类名.方法名"的方式，也可以使用"对象名.方法名"的方式。而实例方法只有后面这种方式。也就是说，调用静态方法可以无需创建对象。 */
        Body [] Planets = NBody.readBodies(filename);
        double Radius = NBody.readRadius(filename);
        /**画背景 */
        StdDraw.setScale(-1*Radius, Radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        /**画星球 */
        for(Body planet:Planets){/**其他写法for (Body planet : Planets) */
            planet.draw();
        }
        StdDraw.enableDoubleBuffering();
        for(double t = 0;t<=T;t+=dt){
            double [] xForces = new double[Planets.length];
            double [] yForces = new double[Planets.length];
            for(int i = 0; i<Planets.length;i++){
                xForces[i] = Planets[i].calcNetForceExertedByX(Planets);
                yForces[i] = Planets[i].calcNetForceExertedByY(Planets);
            }
            for (int i = 0; i < Planets.length; i++) {
                Planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Body planet : Planets) {
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            
        }

    }
    

}