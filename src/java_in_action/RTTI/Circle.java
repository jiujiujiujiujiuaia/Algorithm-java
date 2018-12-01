package java_in_action.RTTI;

/**
 * @Author yuchunwei
 */
abstract class Shape{
    void draw(){
        System.out.println(this+".draw()");
    }
    abstract public String toString();
}

class Rectangel {
    public static final int a = 10;
    static {
        System.out.println("this is a rectangel");
    }
}


public class Circle extends Shape{
    public static final int a = 47;
    public String toString(){
        return "circle";
    }
    static {
        System.out.println("it is a circle");
    }
    public static void main(String[] args) {
        System.out.println(Rectangel.a);
//        Shape[] a = {new Circle()};
//        for(Shape b :a){
//            b.draw();
//        }

//       try{
//           Class.forName("java_in_action.RTTI.Rectangel");
//       }
//       catch (Exception e){
//           e.printStackTrace();
//       }
    }
}   
