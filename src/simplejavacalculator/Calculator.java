/**
 * @name        Simple Java Calculator
 * @package     ph.calculator
 * @file        Main.java
 * @author      SORIA Pierre-Henry
 * @email       pierrehs@hotmail.com
 * @link        http://github.com/pH-7
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 */

package simplejavacalculator;

import java.lang.Math;
import static java.lang.Double.NaN;
import static java.lang.Math.pow;

public class Calculator {

    public enum BiOperatorModes {
        normal, add, minus, multiply, divide, xpowerofy, nPr, nCr
    }

    public enum MonoOperatorModes {
        square, squareRoot, oneDividedBy, cos, sin, tan, acos, asin, atan, log, rate, abs, ln, cot, csc, fact
    }
    public static double fact(double n) {
        double factorial = 1;
        for(double a = 2; a <= n; a++) {
            factorial *= a;
        }
        return factorial;
    }

    public static Double num1;
    public static Double num2;

    private BiOperatorModes mode = BiOperatorModes.normal;

    private Double calculateBiImpl() {
        if (mode == BiOperatorModes.normal) {
            return num2;
        }
        if (mode == BiOperatorModes.add) {
            return num1 + num2;
        }
        if (mode == BiOperatorModes.minus) {
            return num1 - num2;
        }
        if (mode == BiOperatorModes.multiply) {
            return num1 * num2;
        }
        if (mode == BiOperatorModes.divide) {
            if (num2 == 0) {
                return NaN;
            } else {
                return num1 / num2;
            }
        }
        if (mode == BiOperatorModes.xpowerofy) {
            return pow(num1, num2);
        }
        if(mode == BiOperatorModes.nPr) {
            double a1, a2, number;
            a1 = fact(num1);
            number = num1 - num2;
            a2 = fact(number);
            return a1/a2;
        }
        if(mode == BiOperatorModes.nCr) {
            double number = num1 - num2;
            return fact(num1) / (fact(num2) *
                    fact(number));
        }



        // never reach
        throw new Error();
    }

    public Double calculateBi(BiOperatorModes newMode, Double num) {
        if (mode == BiOperatorModes.normal) {
            num2 = 0.0;
            num1 = num;
            mode = newMode;
            return NaN;
        } else {
            if (newMode == BiOperatorModes.divide && num == 0) {
                num1 = NaN;
            } else {
                num2 = num;
                num1 = calculateBiImpl();
                mode = newMode;
            }
            return num1;
        }
    }

    public Double calculateEqual(Double num) {
        return calculateBi(BiOperatorModes.normal, num);
    }

    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        mode = BiOperatorModes.normal;
        return NaN;
    }

    public Double calculateMono(MonoOperatorModes newMode, Double num) {
        if (newMode == MonoOperatorModes.square) {
            return num * num;
        }
        if (newMode == MonoOperatorModes.squareRoot) {
            if (num < 0) {
                return NaN;
            }
            return Math.sqrt(num);
        }
        if (newMode == MonoOperatorModes.oneDividedBy) {
            if (num == 0) {
                return NaN;
            }
            return 1 / num;
        }
        if (newMode == MonoOperatorModes.cos) {
            return Math.cos(Math.toRadians(num));
        }
        if (newMode == MonoOperatorModes.sin) {
            return Math.sin(Math.toRadians(num));
        }
       if (newMode == MonoOperatorModes.acos) {
            if (num < -1 || num > 1) {
                return NaN;
            }
            return Math.acos((num));
        }
        if (newMode == MonoOperatorModes.asin) {
            if (num < -1 || num > 1) {
                return NaN;
            }
            return Math.asin((num));
        }
        if (newMode == MonoOperatorModes.atan) {
            return Math.atan((num));
        }
        if (newMode == MonoOperatorModes.tan) {
            if (num % 180 == 90) {
                return NaN;
            }
            return Math.tan(Math.toRadians(num));
        }
        if (newMode == MonoOperatorModes.log) {
            if (num <= 0) {
                return NaN;
            }
            return Math.log10(num);
        }
        if (newMode == MonoOperatorModes.ln) {
            if (num <= 0) {
                return NaN;
            }
            return Math.log(num);
        }
        if (newMode == MonoOperatorModes.rate) {
            return num / 100;
        }
        if (newMode == MonoOperatorModes.abs) {
            return Math.abs(num);
        }
        if (newMode == MonoOperatorModes.cot) {
            if (num % 180 == 0 || num % 180 == 90) {
                return NaN;
            }
            return 1 / Math.tan(Math.toRadians(num));
        }
        if (newMode == MonoOperatorModes.csc) {
            if (num % 180 == 0) {
                return NaN;
            }
            return 1 / Math.sin(Math.toRadians(num));
        }
        if( newMode == MonoOperatorModes.fact){
           return fact(num);
        }
        // never reach
        throw new Error();
    }
}
