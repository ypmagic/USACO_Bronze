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
        LostCow a = new LostCow(3, 6);
        System.out.println(a.findDistance());
    }

}
