import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Board {

  public static final Integer validMoneyOptions[] = { 1, 5, 10, 15, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000,
      5000, 10000, 25000, 50000, 75000, 100000, 200000, 300000, 400000, 500000, 600000, 750000, 1000000 };
  public Integer boardValues[];
  public List<Integer> boardState = new ArrayList<Integer>();
  public List<Integer> chosenCases = new ArrayList<Integer>();
  public int playerCase;
  public int pickedCase;
  public double count;
  public double round = 1;
  public boolean game = true;
  public String dump;
  public char accepted;

  public Board() {
    boardValues = validMoneyOptions;
  }

  public static Integer[] randomizeArray(Integer[] array) {
    Random r = ThreadLocalRandom.current();
    for (int i = array.length - 1; i >= 1; i--) {
      int j = r.nextInt(array.length);
      int t = array[i];
      array[i] = array[j];
      array[j] = t;
    }
    return array;
  }

  public void setCases() {
    randomizeArray(boardValues);
    boardState = new ArrayList<Integer>(Arrays.asList(boardValues));
  }

  public void chooseFirstCase(Scanner k) {
    System.out.println("Please Choose Any Case 1-26: ");
    playerCase = k.nextInt();
    while (playerCase > 26 || playerCase < 1) {
      System.out.println("Try Again. ");
      playerCase = k.nextInt();
    }
    chosenCases.add(playerCase);
    System.out.println("Your case is: " + playerCase);
  }

  public void chooseGameCases(int cases, Scanner k) {
    for (int i = 0; i < cases; i++) {
      System.out.println("You must pick " + (cases - i) + " more cases.");
      System.out.println("Choose any case that has not been picked");
      pickedCase = k.nextInt();
      OUTER_LOOP: while (true) {
        while (pickedCase >= 1 && pickedCase <= 26) {
          if (!chosenCases.contains(pickedCase)) {
            break OUTER_LOOP;
          }
          System.out.println("Case has already been chosen. Try again: ");
          pickedCase = k.nextInt();
        }
        System.out.println("Number is not within the case numbers. Try again: ");
        pickedCase = k.nextInt();
      }
      System.out.println("You picked case " + pickedCase);
      chosenCases.add(pickedCase);
      boardState.remove(boardValues[pickedCase]);
      System.out.println("Case " + pickedCase + " was $" + boardValues[pickedCase] + "!");
    }
  }

  public void bankerOffer() {
    count = 0;
    for (int i = 0; i < boardState.size(); i++) {
      count += Math.pow(boardState.get(i), 2);
    }
    count = count / boardState.size();
    count = Math.sqrt(count);
    count = count * (round / 24);
    System.out.println("Banker's Offer: " + (int) count);
    round++;
  }

  public boolean gameCheck(Scanner k) {
    System.out.println("Do You Accept? (y/n): ");
    dump = k.nextLine();
    while (accepted != 'y' && accepted != 'n') {
      accepted = k.nextLine().charAt(0);
      System.out.println(accepted);
      if (accepted == 'y') {
        game = false;
      } else if (accepted == 'n') {
        game = true;
      } else {
        gameCheck(k);
      }
    }
    return game;
  }

  public void openFinalCase() {
    System.out.println("The value of your case is $" + boardValues[playerCase]);
  }
}