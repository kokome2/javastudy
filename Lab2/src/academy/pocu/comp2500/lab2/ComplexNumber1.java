package academy.pocu.comp2500.lab2;
public final class ComplexNumber1 {
    public final double real;
    public final double imaginary;
    public ComplexNumber1() {
        real = 0.0;
        imaginary = 0.0;
    }
    public ComplexNumber1(double real) {
        this.real = real;
        imaginary = 0.0;
    }
    public ComplexNumber1(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    public boolean isReal() {
        return (imaginary == 0.0);
    }
    public boolean isImaginary() {
        return (real == 0.0);
    }
    public ComplexNumber getConjugate() {
        return new ComplexNumber(real, -imaginary);
    }
    public ComplexNumber add(ComplexNumber num) {
        return new ComplexNumber(real + num.real, imaginary + num.imaginary);
    }
    public ComplexNumber subtract(ComplexNumber num) {
        return new ComplexNumber(real - num.real, imaginary - num.imaginary);
    }
    public ComplexNumber multiply(ComplexNumber num) {
        return new ComplexNumber(real * num.real - imaginary * num.imaginary, real * num.imaginary + imaginary * num.real);
    }
    public ComplexNumber divide(ComplexNumber num) {
        return new ComplexNumber((real * num.real + imaginary * num.imaginary) / (num.real * num.real + num.imaginary * num.imaginary),
                (imaginary * num.real - real * num.imaginary) / (num.real * num.real + num.imaginary * num.imaginary));
    }
}