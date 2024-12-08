package ua.kyrylo.bieliaiev;

import ua.kyrylo.bieliaiev.shapes.*;

public class Main {

  public static void main(String[] args) {
    ShapePrinter printer = new ShapePrinter();

    Shape rectangle1 = new Rectangle(0, 0, 5, 10);
    Rectangle rectangle2 = new Rectangle(10, 0, 15, 10);
    Shape circle1 = new Circle(0, 0, 5);

    printer.printShape(rectangle1);
    printer.printShape(rectangle2);
    printer.printShape(circle1);
  }
}