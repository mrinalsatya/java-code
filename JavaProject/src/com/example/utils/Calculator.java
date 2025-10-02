package com.example.utils;
import com.example.geometry.Circle;
import com.example.geometry.Rectangle;

import  java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the rectangle");
        double length = sc.nextDouble();
        System.out.println("Enter the length of the rectangle");

        double width = sc.nextDouble();
        Rectangle rec = new Rectangle(length, width);

        System.out.println("Enter the radius of the circle");
        double radius  = sc.nextDouble();

        Circle circle = new Circle(radius);

        System.out.println("Area of the Rectangle is : " + rec.getArea());
        System.out.println("Area of the Circle is : " + circle.getArea());

    }
}
