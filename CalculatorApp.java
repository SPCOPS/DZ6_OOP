// Принцип 4: Принцип инверсии зависимостей (Dependency Inversion Principle)
// Класс CalculatorApp является главным классом приложения и зависит только от абстракции (интерфейса Operation).
public class CalculatorApp {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorPresenter presenter = new CalculatorPresenter(model, view);

        5// Принцип 5: Принцип DRY (Don't Repeat Yourself)
        // Мы используем экземпляры конкретных реализаций Operation для каждой операции.
        Operation addition = new Addition();
        Operation subtraction = new Subtraction();
        Operation multiplication = new Multiplication();
        Operation division = new Division();

        do {
            char operator = view.getOperator();

            switch (operator) {
                case '+':
                    presenter.onOperatorSelected(addition);
                    break;
                case '-':
                    presenter.onOperatorSelected(subtraction);
                    break;
                case '*':
                    presenter.onOperatorSelected(multiplication);
                    break;
                case '/':
                    presenter.onOperatorSelected(division);
                    break;
                default:
                    view.showError("Некорректный оператор");
            }

            char choice = view.getContinueChoice();
            if (choice != 'y') {
                break;
            }
        } while (true);
    }
}