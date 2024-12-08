package ua.kyrylo.bieliaiev.shapes;


public class Square extends Rectangle {

  public Square(int x, int y, int width, int height) {
    super(x, y, x + width, y + height);
  }


  @Override
  public String getShapeName() {
    return "Square";
  }
}
