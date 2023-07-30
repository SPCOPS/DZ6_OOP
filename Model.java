// Принцип 1: Принцип единственной ответственности (Single Responsibility Principle)
// Класс CalculatorModel представляет модель калькулятора и содержит только логику математических операций.
class CalculatorModel {
    private double result;

    public void add(double a, double b) {
        result = a + b;
    }

    public void subtract(double a, double b) {
        result = a - b;
    }

    public void multiply(double a, double b) {
        result = a * b;
    }

    public void divide(double a, double b) {
        if (b != 0) {
            result = a / b;
        } else {
            result = Double.POSITIVE_INFINITY; // Обработка деления на ноль
        }
    }

    public double getResult() {
        return result;
    }
}

// Принцип 2: Принцип открытости/закрытости (Open/Closed Principle)
// Интерфейс Operation представляет абстракцию для математических операций.
interface Operation {
    double calculate(double a, double b);
}

// Реализации интерфейса Operation для каждой математической операции.
class Addition implements Operation {
    @Override
    public double calculate(double a, double b) {
        return a + b;
    }
}

class Subtraction implements Operation {
    @Override
    public double calculate(double a, double b) {
        return a - b;
    }
}

class Multiplication implements Operation {
    @Override
    public double calculate(double a, double b) {
        return a * b;
    }
}

class Division implements Operation {
    @Override
    public double calculate(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            return Double.POSITIVE_INFINITY; // Обработка деления на ноль
        }
    }
}