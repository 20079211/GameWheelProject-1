import java.util.ArrayList;

public class GameWheel
{
  private ArrayList<Slice> slices; // List of slices making up the wheel
  private int currentPos;   // Position of currently selected slice on wheel


  /* Returns string representation of GameWheel with each numbered slice
   * on a new line
   */
  public String toString(){
    //Implement the toString method here
    int count = 0;
    for(Slice s: slices) {
      System.out.println(count + " - " + s);
      count++;
    }
    return "";
  }


  /* Randomizes the positions of the slices that are in the wheel, but without
   * changing the pattern of the colors
   */
  /*
  public void scramble() //Implement the scramble method here
  {
    int randomSlice;
    ArrayList<Slice> red = new ArrayList<Slice>();
    ArrayList<Slice> blue = new ArrayList<Slice>();
    ArrayList<Slice> black = new ArrayList<Slice>();
    for(int i = 0; i<slices.size(); i++){
      if(i%5 == 0) {
        black.add(slices.get(i));
      }
      else if(i%2 == 0) {
        blue.add(slices.get(i));
      }
      else {
        red.add(slices.get(i));
      }
    }
    slices.clear();
    for(int i = 0; i<20; i++) {
      if(i%5 == 0) {
        randomSlice = (int) (Math.random()*black.size());
        slices.add(black.get(randomSlice));
        black.remove(randomSlice);
      }
      else if(i%2 == 0) {
        randomSlice = (int) (Math.random()*blue.size());
        slices.add(blue.get(randomSlice));
        blue.remove(randomSlice);
      }
      else {
        randomSlice = (int) (Math.random()*red.size());
        slices.add(red.get(randomSlice));
        red.remove(randomSlice);
      }
    }
  }
*/
public void scramble()
  {
    //Implement the scramble method here
    ArrayList <Slice> red = new ArrayList <Slice> ();
    ArrayList <Slice> blue = new ArrayList <Slice> ();
    ArrayList <Slice> black = new ArrayList <Slice> ();
    ArrayList <Slice> temp = new ArrayList <Slice> ();

    int count = 0;

    // Here's how I would add your slices
    for(int i = 0; i<slices.size(); i++)
    { // take advantage of the 'slices' instance data
      if(i%5 == 0) {
        black.add(slices.get(i));
      }
      else if(i%2 == 0) { // the 'else if' is useful
        blue.add(slices.get(i));
      }
      else {
        red.add(slices.get(i));
      }
    }

while(count < blue.size()){ //Randomize blue

int temp2 = (int)(Math.random()*(blue.size()));
temp.add(blue.get(temp2));
blue.remove(temp2);
blue.add(temp.get(0));
temp.remove(0);
count++;

}

count = 0;

while(count < red.size()){ //Randomize red

int temp2 = (int)(Math.random()*(red.size()));
temp.add(red.get(temp2));
red.remove(temp2);
red.add(temp.get(0));
temp.remove(0);
count++;

}

count = 0;

while(count < black.size()){ //Randomize black

int temp2 = (int)(Math.random()*(black.size()));
temp.add(black.get(temp2));
black.remove(temp2);
black.add(temp.get(0));
temp.remove(0);
count++;

}

count = 0;

slices.clear();
int temp2; // declare variable first
for(int i = 0; i < 20; i++){ // no '<=' needed

if((i%2 == 0) && (i%5 != 0)){ //Blue here
 temp2 = (int)((Math.random()*(blue.size()))); // I think you were missing a paranthesis ')'
  
slices.add(blue.get(temp2));
blue.remove(temp2);
      }

if((i%2 == 1) && (i%5 != 0)){ //Red here
 temp2 = (int)(Math.random()*(red.size()));
slices.add(red.get(temp2));
red.remove(temp2);
      }

if(i%5 == 0){ //Black here
 temp2 = (int)(Math.random()*(black.size()));
slices.add(black.get(temp2));
black.remove(temp2);
      }

}

  }
  /* Sorts the positions of the slices that are in the wheel by prize amount,
   * but without changing the pattern of the colors.
   */
  public void sort() //Implement the sort method here
  { 
    Slice tempSlice = new Slice("red", 50);
    int min;
    int index = 0;
    ArrayList<Slice> red = new ArrayList<Slice>();
    ArrayList<Slice> blue = new ArrayList<Slice>();
    ArrayList<Slice> black = new ArrayList<Slice>();
    for(int i = 0; i<slices.size(); i++){
      if(i%5 == 0) {
        black.add(slices.get(i));
      }
      else if(i%2 == 0) {
        blue.add(slices.get(i));
      }
      else {
        red.add(slices.get(i));
      }
    }

    // sorting individual colors
    for(int g = 0; g<red.size(); g++) {
      min = 100000000;
      for(int i = g; i<red.size(); i++) {
        if((red.get(i)).getPrizeAmount() < min) {
          tempSlice = red.get(i);
          min = tempSlice.getPrizeAmount();
          index = i;
        }
      }
      red.remove(index);
      red.add(g, tempSlice);
    }
    System.out.println(red + "\n");
    
    for(int g = 0; g<blue.size(); g++) {
      min = 100000000;
      for(int i = g; i<blue.size(); i++) {
        if((blue.get(i)).getPrizeAmount() < min) {
          tempSlice = blue.get(i);
          min = tempSlice.getPrizeAmount();
          index = i;
        }
      }
      blue.remove(index);
      blue.add(g, tempSlice);
    }
    System.out.println(blue + "\n");
    for(int g = 0; g<black.size(); g++) {
      min = 100000000;
      for(int i = g; i<black.size(); i++) {
        if((black.get(i)).getPrizeAmount() < min) {
          tempSlice = black.get(i);
          min = tempSlice.getPrizeAmount();
          index = i;
        }
      }
      black.remove(index);
      black.add(g, tempSlice);
    }
    System.out.println(black + "\n");
    // adding all sorted colors to main wheel
    slices.clear();
    for(int i = 0; i<20; i++) {
      if(i%5==0) {
        slices.add(black.get(0));
        black.remove(0);
        continue;
      }
      if(i%2==0) {
        slices.add(blue.get(0));
        blue.remove(0);
        continue;
      }
      else {
        slices.add(red.get(0));
        red.remove(0);
        continue;
      }
    }
  }

  /* COMPLETED METHODS - YOU DO NOT NEED TO CHANGE THESE */

  /* Creates a wheel with 20 preset slices
   */
  public GameWheel()
  {
    this(getStandardPrizes());
  }

  /* Creates a wheel with 20 slices, using values from array parameter
   */
  public GameWheel(int[] prizes)
  {
    currentPos = 0;
    slices = new ArrayList<Slice>();
    for(int i = 0; i < 20; i++){
      int pa = 0;
      String col = "blue";
      if(i < prizes.length)
        pa = prizes[i];
      if (i%5 == 0)
        col = "black";
      else if (i%2 == 1)
        col = "red";
      slices.add(new Slice(col, pa));
    }
  }

  /* Spins the wheel by so that a different slice is selected. Returns that
   * slice (Note: the 10 slices following the current slice are more likely to
   * be returned than the other 10).
   */
  public Slice spinWheel()
  {
    //spin power between range of 1-50 (inclusive)
    int power = (int)(Math.random()*50 + 1);
    int newPos = (currentPos + power) % slices.size();
    currentPos = newPos;
    return slices.get(currentPos);
  }

  public Slice getSlice(int i){
    int sliceNum = i;
    if(i < 0 || i > 19)
      sliceNum = 0;
    return slices.get(sliceNum);
  }

  // Makes an array with a standard list of prizes
  private static int[] getStandardPrizes()
  {
    int[] arr = new int[20];
    for (int i=0; i < 20; i++)
    {
      if (i%5 == 0)
        arr[i] = i*1000;
      else if (i%2 == 1)
        arr[i] = i*100;
      else
        arr[i] = i*200;
    }
    return arr;
  }
}
