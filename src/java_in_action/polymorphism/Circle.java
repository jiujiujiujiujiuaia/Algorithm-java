package java_in_action.polymorphism;

public class Circle extends Shape {
    Circle(){
        System.out.println("in circle");
    }
    public Circle draw(){
        ereas();
       return new Circle();
    }
    public void ereas(){
        System.out.println("circle erase");
    }
    public void circle(){
        System.out.println("circle circle");
    }


}
