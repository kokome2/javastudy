package academy.pocu.comp2500.lab2;
public class ComplexNumber2 {
    public double real;
    public double imaginary;
​
    public ComplexNumber2() {
        real = 0.0;
        imaginary = 0.0;
    }
​
    public ComplexNumber2(double real) {
        this.real = real;
        imaginary = 0.0;
    }
​
    public ComplexNumber2(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
​
    public boolean isReal() {
        if (imaginary != 0.0) {
            return false;
        }
        return true;
    }
​
    public boolean isImaginary() {
        if (real != 0.0) {
            return false;
        }
        return true;
    }
​
    public ComplexNumber getConjugate() {
        return new ComplexNumber(real, -imaginary);
    }
​
    public ComplexNumber add(ComplexNumber operand) {
        return new ComplexNumber(real + operand.real, imaginary + operand.imaginary);
    }
​
    public ComplexNumber subtract(ComplexNumber operand) {
        return new ComplexNumber(real - operand.real, imaginary - operand.imaginary);
    }
​
    public ComplexNumber multiply(ComplexNumber operand) {
        return new ComplexNumber(real * operand.real - imaginary * operand.imaginary, real * operand.imaginary + imaginary * operand.real);
    }
​
    public ComplexNumber divide(ComplexNumber operand) {
        return new ComplexNumber((real * operand.real + imaginary * operand.imaginary) / (operand.real * operand.real + operand.imaginary * operand.imaginary), (imaginary * operand.real - real * operand.imaginary) / (operand.real * operand.real + operand.imaginary * operand.imaginary));
    }
}