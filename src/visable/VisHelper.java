package visable;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @Author yuchunwei
 */
public class VisHelper {

    private VisHelper(){

    }
    public static void setStrokeWidth(Graphics2D g2d,int w){
        g2d.setStroke(new BasicStroke(w,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
    }
    public static void drawCircle(Graphics2D g2d,int x,int y,int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r,y-r,2*r,2*r);
        g2d.draw(circle);
    }
    public static void setColor(Graphics2D g2d,Color color){
        g2d.setColor(color);
    }

    public static void main(String[] args) {

    }
}   
