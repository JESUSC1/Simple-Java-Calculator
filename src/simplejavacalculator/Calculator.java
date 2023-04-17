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
import static java.lang.Math.log;
import static java.lang.Math.log10;
import static java.lang.Math.pow;


public class Calculator {

    public enum BiOperatorModes {
        normal, add, minus, multiply, divide , xpowerofy
    }

    public enum MonoOperatorModes {
        square, squareRoot, oneDividedBy, cos, sin, tan, acos, asin, atan, log, rate, abs, ln, cot, csc, pi
    }

    public static Double num1;
    public static Double num2;

    private BiOperatorModes mode = BiOperatorModes.normal;

    private Double calculateBiImpl() {
        if (mode == BiOperatorModes.normal) {
            return num2;
        }
        if (mode == BiOperatorModes.add) {
            if (num2 != 0) {
                return num1 + num2;
            }

            return num1;
        }
        if (mode == BiOperatorModes.minus) {
            return num1 - num2;
        }

        if (mode == BiOperatorModes.multiply) {
            return num1 * num2;
        }
        if (mode == BiOperatorModes.divide) {
            return num1 / num2;
        }
        if (mode == BiOperatorModes.xpowerofy) {
            return pow(num1,num2);
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
            num2 = num;
            num1 = calculateBiImpl();
            mode = newMode;
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
            return Math.sqrt(num);
        }
        if (newMode == MonoOperatorModes.oneDividedBy) {
            return 1 / num;
        }
        if (newMode == MonoOperatorModes.cos) {
            return Math.cos(Math.toRadians(num));
        }
        if (newMode == MonoOperatorModes.sin) {
            return Math.sin(Math.toRadians(num));
        }
        if (newMode == MonoOperatorModes.acos) {
            if(num < 1) {
                return Math.acos((num));
            }else{
                return NaN;
            }
        }
        if (newMode == MonoOperatorModes.asin) {
            if(num < 1) {
                return Math.asin((num));
            }else{
                return NaN;
            }
        }
        if (newMode == MonoOperatorModes.atan) {
            if(num <= 90 && num >= -90) {
                return Math.atan((num));
            }else{
                return NaN;
            }
        }
        if (newMode == MonoOperatorModes.tan) {
            if (num == 0 || num % 180 == 0) {
                return 0.0;
            }
            if (num % 90 == 0 && num % 180 != 0) {
                return NaN;
            }

            return Math.tan(Math.toRadians(num));
        }

        if (newMode == MonoOperatorModes.log) {
            return log10(num);
        }
        if (newMode == MonoOperatorModes.ln) {
            return log(num);
        }
        if (newMode == MonoOperatorModes.rate) {
           return num / 100;
        }
        if (newMode == MonoOperatorModes.abs){
            return Math.abs(num);
        }

        if (newMode == MonoOperatorModes.cot) {
            if (num == 0 || num % 180 == 0) {
                return NaN;
            }
            if (num % 90 == 0 && num % 180 != 0) {
                return 0.0;
            }
            return 1 / Math.tan(Math.toRadians(num));
        }

        if (newMode == MonoOperatorModes.csc) {
            if (num % 180 == 0) {
                return NaN;
            }
            return 1 / Math.sin(Math.toRadians(num));
        }
        
        if (newMode == MonoOperatorModes.pi) {
            return Math.PI;
        }

        // never reach
        throw new Error();
    }

}
