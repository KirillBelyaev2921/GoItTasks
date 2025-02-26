package ua.kyrylo.bieliaiev.shapes;

public class Triangle extends Shape {


  private final int x1;
  private final int y1;
  private final int x2;
  private final int y2;
  private final int x3;
  private final int y3;

  public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.x3 = x3;
    this.y3 = y3;
  }

  public int getX1() {
    return x1;
  }

  public int getY1() {
    return y1;
  }

  public int getX2() {
    return x2;
  }

  public int getY2() {
    return y2;
  }

  public int getX3() {
    return x3;
  }

  public int getY3() {
    return y3;
  }

  @Override
  public String getShapeName() {
    return "Triangle";
  }
}
