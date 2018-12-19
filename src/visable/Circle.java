package visable;

/**
 * @Author yuchunwei
 */
public class Circle {
    public int x,y;
    private int r;
    private int vx,vy;
    public Circle(int x,int y,int r,int vx,int vy){
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }
    public void move(){
        x+=vx;
        y+=vy;
    }
    public int getR(){
        return r;
    }


    public static void main(String[] args) {

    }
}   
