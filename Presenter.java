// Принцип 3: Принцип подстановки Барбары Лисков (Liskov Substitution Principle)
// Класс CalculatorPresenter представляет презентер калькулятора, который использует абстракцию (интерфейс Operation) для математических операций.
class CalculatorPresenter {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorPresenter(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void onOperatorSelected(Operation operation) {
        UserInput userInput = view.getUserInput();

        if (userInput != null) {
            double num1 = userInput.num1;
            double num2 = userInput.num2;
            double result = operation.calculate(num1, num2);

            view.showResult(result);
        } else {
            view.showError("Некорректный ввод");
        }
    }
}