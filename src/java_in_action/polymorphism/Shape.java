package java_in_action.polymorphism;

public class Shape {
    private int a = 100;
    Shape(){
        System.out.println("in shape and a = "+a);
    }
    private void draw() {
            ereas();
        }
    private void ereas(){
        System.out.println("shape erase");
    }
    public static void main(String[] args){
        Shape s = new Circle();
        s.draw();
        ((Circle) s).circle();
    }
}
