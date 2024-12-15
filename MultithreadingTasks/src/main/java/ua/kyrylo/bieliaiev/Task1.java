package ua.kyrylo.bieliaiev;

public class Task1 {

  public void printTime() {
    Thread fiveSecondsThread = new Thread(() -> {
      while (true) {
        try {
          Thread.sleep(5000);
        } catch (InterruptedException e) {
          System.out.println("Interrupted");
          return;
        }
        System.out.println("Минуло 5 секунд");
      }
    });

    fiveSecondsThread.start();

    int i = 0;
    while (true) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.println("Interrupted");
        return;
      }
      System.out.printf("Минуло %d секунд від моменту запуску програми%n", ++i);
    }
  }

  public static void main(String[] args) {
    new Task1().printTime();
  }

}
