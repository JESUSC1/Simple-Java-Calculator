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

import java.awt.*;
import java.lang.Math;
import static java.lang.Double.NaN;
import static java.lang.Math.log;
import static java.lang.Math.log10;
import static java.lang.Math.pow;

public class Calculator {

    public enum BiOperatorModes {
        normal, add, minus, multiply, divide, xpowerofy
    }

    public enum MonoOperatorModes {
        square, squareRoot, oneDividedBy, cos, sin, tan, acos, asin, atan, log, rate, abs, ln, cot, csc, factorial
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
                System.out.println("undefined");
                return NaN;
            } else {
                return num1 / num2;
            }
        }
        if (mode == BiOperatorModes.xpowerofy) {
            return pow(num1, num2);
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
                Label text = null;
                text.setText("undefined"); // TODO fix so that number/0 == "undefined"
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
            return Math.toRadians(Math.acos(num));
        }
        if (newMode == MonoOperatorModes.asin) {
            if (num < -1 || num > 1) {
                return NaN;
            }
            return Math.toRadians(Math.asin(num));
        }
        if (newMode == MonoOperatorModes.atan) {
            return Math.toRadians(Math.atan(num));
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
        if (newMode == MonoOperatorModes.factorial) {
            if (num < 0 || num != Math.floor(num)) {
                return NaN;
            }
            return factorial(num.intValue());
        }

        // never reach
        throw new Error();
    }

    private static Double factorial(int num) {
        if (num == 0 || num == 1) {
            return 1.0;
        }
        double result = 1.0;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

}
