import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

public class ParenSymmetry {


    private Boolean isBalanced(String s) {
        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "( )", "( () ( ) )"};

        return s;
    }

    private void checkFile(String filename) {
        try {
            PrintStream writer = new PrintStream( new File("TestStrings0.txt"));
            Random r = new Random();

            writer.close();
        }
        catch(IOException e) {
            System.out.println("An error occured while trying to write to the file");
        }
        // open file named filename

        // for each line in the file
            // read the line
            // print whether or not the line's parenthesis are balanced

        // CLOSE the file
    }

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();

        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
