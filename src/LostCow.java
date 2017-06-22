/**
 * Created by Young Park
 * For practice
 */
public class LostCow {

    private int moveNum;
    private int farmerJohn;
    private int cowBessie;
    private boolean trackOperator;

    public LostCow(int farmer, int cow) {
        this.moveNum = 1; // used to get increment for addition/subtraction
        this.farmerJohn = farmer; // retrieves John's position
        this.cowBessie = cow; // retrieves Bessie's position
        this.trackOperator = true; // initially positive for adding John's position; false = negative.
    }

    /*
    Finds the next number to add or subtract to/from John's position.
     */
    private void increment() {
        this.moveNum = this.moveNum * 2;
    }

}
