package java_in_action.polymorphism;

import java.util.*;

public class Shape {
    private int a = 100;
    Shape(){
        System.out.println("in shape and a = "+a);
    }
    public Shape draw() {
            ereas();
            return new Shape();
        }
    private void ereas(){
        System.out.println("shape erase");
    }
    public static void main(String[] args){
        Shape s = new Circle();
        s.draw();
        ((Circle) s).circle();//向下转型

    }
}
