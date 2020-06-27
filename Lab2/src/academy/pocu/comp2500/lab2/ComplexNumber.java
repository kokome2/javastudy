package academy.pocu.comp2500.lab2;
public class ComplexNumber {
    public double real;
    public double imaginary;
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    public ComplexNumber(double real) {
        this(real, 0.0);
    }
    public ComplexNumber() {
        this(0.0, 0.0);
    }
    public boolean isReal() {
        return imaginary == 0.0;
    }
    public boolean isImaginary() {
        return real == 0.0;
    }
    public ComplexNumber getConjugate() {
        if (this.real == 0.0 && this.imaginary == 0.0) {
            return new ComplexNumber();
        }
        ComplexNumber conjugate = new ComplexNumber(this.real, -this.imaginary);
        return conjugate;
    }
    public ComplexNumber add(ComplexNumber addComplexNumber) {
        ComplexNumber resultNumber = new ComplexNumber(this.real + addComplexNumber.real, this.imaginary + addComplexNumber.imaginary);
        return resultNumber;
    }
    public ComplexNumber subtract(ComplexNumber subtractNumber) {
        ComplexNumber resultNumber = new ComplexNumber(this.real - subtractNumber.real, this.imaginary - subtractNumber.imaginary);
        return resultNumber;
    }
    public ComplexNumber multiply(ComplexNumber multiplyNumber) {
        ComplexNumber resultNumber = new ComplexNumber(this.real * multiplyNumber.real - this.imaginary * multiplyNumber.imaginary
                , this.real * multiplyNumber.imaginary + this.imaginary * multiplyNumber.real);
        return resultNumber;
    }
    public ComplexNumber divide(ComplexNumber divideNumber) {
        ComplexNumber conjugateNumber = divideNumber.getConjugate();
        ComplexNumber multiplyNumber = this.multiply(conjugateNumber);
        double tempNumber = divideNumber.real * divideNumber.real + divideNumber.imaginary * divideNumber.imaginary;
        ComplexNumber resultNumber = new ComplexNumber(multiplyNumber.real / tempNumber, multiplyNumber.imaginary / tempNumber);
        return resultNumber;
    }
}