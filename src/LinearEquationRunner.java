import javax.sound.sampled.Line;
import java.util.Scanner;
public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Start & Initial Inputs
        System.out.println("Welcome!");

        System.out.println("Enter coordinate 1: ");
        String coord1 = scan.nextLine();

        System.out.println("Enter coordinate 2: ");
        String coord2 = scan.nextLine();

        System.out.println("The two points are " + coord1 + " and " + coord2);

        //Using parseInt method to convert input into x and y coordinates
        //Using the indexOf and substring methods to correctly parse coord1 and coord2
        //coord1
        int x1 = Integer.parseInt(coord1.substring(coord1.indexOf("(") + 1, (coord1.indexOf(","))));
        int y1 = Integer.parseInt(coord1.substring(coord1.indexOf(",") + 2, (coord1.indexOf(")"))));

        //coord2
        int x2 = Integer.parseInt(coord2.substring(coord2.indexOf("(") + 1, (coord2.indexOf(","))));
        int y2 = Integer.parseInt(coord2.substring(coord2.indexOf(",") + 2, (coord2.indexOf(")"))));

        //Creating object
        LinearEquation linearEquation = new LinearEquation(x1, y1, x2, y2);

        //Outputs
        System.out.println("Line Information:\n" + linearEquation.lineInfo());
    }
}