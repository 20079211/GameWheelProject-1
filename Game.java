import java.util.ArrayList;

public class Game
{
  public static void play(GameWheel g)
  {
    int total = 0;
    boolean condition = false;
    ArrayList<Slice> currentSlices = new ArrayList<Slice>();
    String color1, color2, color3;
    for(int i = 0; i<3; i++) {
      currentSlices.add(g.spinWheel());
    }
    for(Slice s: currentSlices) {
      total += s.getPrizeAmount();
    }
    color1 = (currentSlices.get(0)).getColor();
    color2 = (currentSlices.get(1)).getColor();
    color3 = (currentSlices.get(2)).getColor();
    if(color1.equals(color2) && color2.equals(color3) && color3.equals(color1)) {
      total*=2;
      condition = true;
    }

    System.out.println("Total prize money: $" + total);
    System.out.println();
    for(int i = 0; i<3; i++) {
      System.out.println("Spin " + i + " - " + currentSlices.get(i));
    }
    if(condition == true) {
      System.out.println("Three " + color1 + "s = double your money!");
    }
    // Implement the play method here
  }
}

