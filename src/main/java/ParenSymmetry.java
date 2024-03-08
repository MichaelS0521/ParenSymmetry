import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;

public class ParenSymmetry {


    private Boolean isBalanced(String s) {
        boolean b;
        int open = 0;
        int closed = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(') {
                open++;
            } else if (s.charAt(i) == ')') {
                closed++;
            }
        }

        if(open==closed){
            //System.out.println("String is balanced");
            b=true;
        }
        else {
            //System.out.println("String is unbalanced");
            b=false;
        }

        return b;
    }


    private void checkFile(String filename) {

        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){

              String str = scanner.nextLine();
                boolean b = isBalanced(str);
                System.out.println(b);
            }
            scanner.close();
        }
        catch(IOException e){
            System.out.println("An error occured while trying to write to the file");
        };
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
        boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);
        ps.checkFile("TestStrings0.txt");

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
