import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Young Park
 * For practice
 */
public class LostCow {

    private int moveNum;
    private int increment;
    final private int FARMER_JOHN;
    final private int COW_BESSIE;
    private int farmerCurrent;
    private boolean trackOperator;

    public LostCow(int farmer, int cow) {
        this.moveNum = 0; // used to get increment for addition/subtraction
        this.increment = 1;
        this.FARMER_JOHN = farmer; // retrieves John's initial position
        this.COW_BESSIE = cow; // retrieves Bessie's position
        this.trackOperator = true; // initially positive for adding John's position; false = negative.
        this.farmerCurrent = farmer; // John's moving position
    }

    /*
    Finds the next number to add or subtract to/from John's position.
     */
    private void increment() {
        this.increment = this.increment*2;
    }

    private void findTotalMove() {
        if (this.trackOperator) {
            this.moveNum = Math.abs(this.farmerCurrent - (this.FARMER_JOHN + this.increment));
        } else if (!this.trackOperator) {
            this.moveNum = Math.abs(this.farmerCurrent - (this.FARMER_JOHN - this.increment));
        }
    }

    /*
    Finds the total distance it takes to find Bessie
     */
    private int findDistance() {
        int totalDistance = 0;
        boolean keepGoing = true;
        while(keepGoing) {
            findTotalMove();
            for (int i = this.moveNum; i > 0; i--) {
                if (this.trackOperator) {
                    this.farmerCurrent += 1;
                } else if (!this.trackOperator) {
                    this.farmerCurrent -= 1;
                }
                totalDistance++;
                // check if bessie is there
                if (this.farmerCurrent == this.COW_BESSIE) {
                    return totalDistance;
                }
            }
            this.trackOperator = !this.trackOperator;
            increment();
        }
        return 0; //should not reach this statement
    }

    public static void main(String[] args) {
        Scanner sc;
        for (int i = 1; i <= 10; i++) {
            File input = new File(i + ".in");
            try {
                int farmerTemp;
                int cowTemp;
                sc = new Scanner(input);
                farmerTemp = sc.nextInt();
                cowTemp = sc.nextInt();
                LostCow a = new LostCow(farmerTemp, cowTemp);
                // output
                PrintWriter pw = new PrintWriter(i + ".out");
                int distance = a.findDistance();
                pw.println(distance);
                pw.close();
            } catch (FileNotFoundException g) {
                System.out.println("File does not exist.");
            }
        }
    }

}
