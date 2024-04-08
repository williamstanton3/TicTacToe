public class BoardTester {

    public static void main(String[] args) {

        System.out.println("Testing Board.getColumn: ");
        if(testGetColumn()){
            System.out.println("PASSED");
        }
        else{
            System.out.println("FAILED");
        }

        System.out.println("Testing Board.getRow: ");
        if(testGetRow()){
            System.out.println("PASSED");
        }
        else {
            System.out.println("FAILED");
        }

    }

    public static boolean testGetColumn(){
        Board b = new Board();

        int testMove0 = 7;
        int expectedCol0 = 0;
        if (b.getColumn(testMove0) != expectedCol0) {
            return false;
        }

        int testMove1 = 2;
        int expectedCol1 = 1;
        if (b.getColumn(testMove1) != expectedCol1) {
            return false;
        }

        int testMove2 = 6;
        int expectedCol2 = 2;
        if (b.getColumn(testMove2) != expectedCol2) {
            return false;
        }

        return true;
    }

    public static boolean testGetRow() {
        Board b = new Board();

        int testMove0 = 7;
        int expectedRow0 = 2;
        if (b.getRow(testMove0) != expectedRow0) {
            return false;
        }

        int testMove1 = 2;
        int expectedRow1 = 0;
        if (b.getRow(testMove1) != expectedRow1) {
            return false;
        }

        int testMove2 = 6;
        int expectedRow2 = 1;
        if (b.getRow(testMove2) != expectedRow2) {
            return false;
        }

        return true;
    }
}