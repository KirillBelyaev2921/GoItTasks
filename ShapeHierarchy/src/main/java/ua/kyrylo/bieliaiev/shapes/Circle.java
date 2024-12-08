package ua.kyrylo.bieliaiev.shapes;

public class Circle extends Shape {

  private final int x;
  private final int y;
  private final int radius;

  public Circle(int x, int y, int radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getRadius() {
    return radius;
  }

  @Override
  public String getShapeName() {
    return "Circle";
  }
}
