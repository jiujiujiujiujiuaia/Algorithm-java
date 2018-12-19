package visable;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @Author yuchunwei
 */
public class LearnSwing extends JFrame {
    private int width;
    private int height;
    public LearnSwing(int width,int height,String title){
        super(title);
        this.width = width;
        this.height = height;
        Canvas canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        setContentPane(canvas);
        pack();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public LearnSwing(String title){
        this(1024,768,title);
    }
    private Circle[] circles;
    public void render(Circle[] circles){
        this.circles = circles;
        repaint();
    }
    class Canvas extends JPanel{

        public Canvas(){
            super(true);
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
//            g.drawLine(100,100,200,200);
            int fontWidth = 10;
            //抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );
            Graphics2D g2d = (Graphics2D) g;
            g2d.addRenderingHints(hints);

            //绘制
            VisHelper.setStrokeWidth(g2d,2);
            VisHelper.setColor(g2d,Color.red);
            for(Circle circle : circles){
                VisHelper.drawCircle(g2d,circle.x,circle.y,circle.getR());
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(width,height);
        }
    }


    public static void main(String[] args) {
        int w = 800;
        int h = 800;

        int n = 10;
        int R = 50;
        Circle[] circles = new Circle[n];
        for(int i = 0 ; i<n ;i++){
            int x = (int)Math.random() * (w - 2* R) + R;
            int y = (int)Math.random() * (w - 2* R) + R;
            int vx = (int)(Math.random()*11) - 5;
            int vy = (int)(Math.random() * 11) -5;
            circles[i] = new Circle(x,y,R,vx,vy);
        }

        EventQueue.invokeLater(() ->{
            LearnSwing learnSwing = new LearnSwing(w,h,"learn");
            while (true){
                try {
                    learnSwing.render(circles);
                    Thread.sleep(20);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}   
