public class LinearEquation {
    /* Instance Variables */
    private int x1;
    private int y1;
    private int x2;
    private int y2;


    /* Creates a LinearEquation object */
// PRECONDITION: x1 and x2 are NOT equal (client programs are responsible for ensuring
// this precondition is not violated)/*
//
    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

    }
    public String formatSlope(double slope) {
        if (slope == (int) slope) {
            return Integer.toString((int) slope);
        } else {
            return String.format("%.2f", slope);
        }
    }
    private String formatIntercept(double intercept) {
        if (intercept == (int) intercept) {
            if (intercept != 0) {
                return Integer.toString((int) intercept);
            } else {
                return "0";
            }
        } else if (intercept > 0) {
            return "+ " + String.format("%.2f", intercept);
        } else if (intercept < 0) {
            return "- " + String.format("%.2f", Math.abs(intercept));
        } else {
            return "0"; // Display "0" for y-intercepts of 0
        }
    }



    /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
    to the nearest hundredth

    HINT:  the Math.round method can help with this!
 */
    public double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100.0) / 100.0;
    }


    // Helper method to format the slope as a fraction
    private String fractionString(double value) {
        if (value == (int) value) {
            return Integer.toString((int) value);
        }

        int numerator = (int) Math.round(value * 100);
        int denominator = 100;

        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        return String.format("%d/%d", numerator, denominator);
    }

    // Helper method to calculate the greatest common divisor (GCD) of two numbers
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    /* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
the nearest hundredth */
    public double distance() {
        double distance = Math.sqrt((Math.pow(x2 - x1, 2)) + (Math.pow(y2 - y1, 2)));
        return roundedToHundredth(distance);
    }

    /* Calculates and returns the slope of the line between (x1, y1) and
   (x2, y2), rounded to the nearest hundredth */
    public double slope(){
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;
        return deltaY / deltaX;

    }

    /* Calculates and returns the y-intercept of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double yIntercept(){
        double yIntercept = -1*(slope() * x1 - y1);
        return yIntercept;
    }



    /* Returns a String that represents the linear equation of the line through points
       (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5".

        When generating the m value (slope), here are examples of "printable" slopes:
           5, -5, 1/2, 6/8 (reducing not required), 8/5, -2/3, -18/7

        Here are non-examples of "printable" slopes:
     1/-2 (should be -1/2), -4/-3 (should be 4/3), 8/4 (should be reduced to 2),
           -12/3 (should be -4), 3/3 (should be 1), -6/6 (should be -1)

        HINT: Be sure to check if the line is horizontal and return an appropriate string,
        e.g. y = 6
        HINT: Absolute value might be helpful for ensuring proper placement of negative sign!


        When generating the b value, here are some examples of "printable" y-intercepts:
           + 1.0 	- 2.35	      + 12.5		- 8.0		+ 17.19

        Here are non-examples of "printable" y-intercepts:
           - -1.0 	+ -2.35	- -12.5	+ -8.0	     - -17.19	+ 0	- 0

        HINT: Absolute value might be helpful for printing negative y-intercepts as
               subtraction!
     */

    public String equation() {
        double m = slope();
        double b = yIntercept();

        if (Double.isInfinite(m)) {
            // Vertical line
            return "x = " + String.format("%.2f", x1);
        } else {
            String mString = "";
            if (m == 1) {
                mString = "x";
            } else if (m == -1) {
                mString = "-x";
            } else if (m != 0) {
                mString = fractionString(m) + "x";
            }

            String bString = "";
            if (b != 0) {
                if (b < 0) {
                    bString = "- " + formatIntercept(Math.abs(b));
                } else {
                    bString = "+ " + formatIntercept(b);
                }
            }

            return "y = " + mString + " " + bString;
        }
    }









    /* Returns a String of the coordinate point on the line that has the given x value, with
       both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
    public String coordinateForX(double xValue) {
        double yValue = slope() * xValue + yIntercept();
        return String.format("(%.2f, %.2f)", xValue, roundedToHundredth(yValue));
    }



    /* Returns a string that includes all information about the linear equation, each on
       separate lines:
         - The original points: (x1, y1) and (x2, y2)
         - The equation of the line in y = mx + b format (using equation() method)
         - The slope of the line, as a decimal (using slope() method)
         - The y-intercept of the line (using yIntercept() method)
         - The distance between the two points (using distance() method)

      This method should call all other appropriate methods to get the info it needs:
      equation(), slope(), yIntercept(), distance().

      */
    public String lineInfo() {
        String info = "Equation: " + equation() + "\n";
        info += "Slope: " + formatSlope(slope()) + "\n";
        info += "Y-Intercept: " + formatIntercept(yIntercept()) + "\n";
        info += "Distance: " + distance();
        return info;
    }




}
