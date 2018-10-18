package java_in_action.polymorphism;

public class Shape {
    private void draw() {
            ereas();
        }
    private void ereas(){
        System.out.println("shape erase");
    }
    public static void main(String[] args){
        Shape s = new Circle();
        s.draw();
    }
}
