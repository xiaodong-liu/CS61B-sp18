public class Body{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    /**Constructor 构造器用来让class能接受参数 */
    /**构造器1 */
    public Body(double xP, double yP, double xV,double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img; 
    }
   /**构造器2 */
    public Body(Body b){
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName; 
    }
    /** method 方法 为什么是动态的？答：因为需要和传入的实例进行交互*/
    /**动态方法1 */
    public double calcDistance(Body c){
        double dx = this.xxPos - c.xxPos;
        double dy = this.yyPos - c.yyPos;
        double r = Math.hypot(dx, dy);
        return r;
    }
    /**动态方法2 */
    public double calcForceExertedBy(Body d){
        double G = 6.67e-11;
        double r = this.calcDistance(d);/**这里需要注意不是double r = calcDistance(Body d);  这里body不需要再出现*/
        double r2 = Math.pow(r,2);
        double F = G*this.mass*d.mass/r2;
        return F;
    }
    /**动态方法3 */
    public double calcForceExertedByX(Body e){
        double F = calcForceExertedBy(e);
        double r = this.calcDistance(e);
        double Fx = F*(this.xxPos-e.xxPos)/r;
        return -Fx;
    }
    /**动态方法4 */
    public double calcForceExertedByY(Body f){
        double F = calcForceExertedBy(f);
        double r = this.calcDistance(f);
        double Fy = F*(this.yyPos-f.yyPos)/r;
        return -Fy;
    }
    /**动态方法5 */
    /**调用array */
    public double calcNetForceExertedByX(Body[] allBodys){
        double netforcex = 0;
        for(int i =0;i<allBodys.length;i++){
            if (this.equals(allBodys[i])){
                continue;
            }
            netforcex += this.calcForceExertedByX(allBodys[i]);

        }
        return netforcex;
    }
    /**动态方法6 */
    /**调用array */
    public double calcNetForceExertedByY(Body[] allBodys){
        double netforcey = 0;
        for(int i =0;i<allBodys.length;i++){
            /**用this就可以实时知道被哪个实例所调用 */
            if (this.equals(allBodys[i])){
                continue;
            }
            netforcey += this.calcForceExertedByY(allBodys[i]);

        }
        return netforcey;
    
    /**这个为啥动态? 答：因为要引用this，无法从静态上下文中引用非静态变量，this也算实例 */
    public void update(double dt,double fX,double fY){
        double ax = fX / this.mass;
        double ay = fY / this.mass;
        this.xxVel += ax * dt;
        this.yyVel += ay * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }
    /**使用this函数，问题：为啥这里不用传入参数Body b？答：因为仅需要调用本身*/
    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }

}