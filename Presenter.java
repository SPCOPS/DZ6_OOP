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

//Теперь в коде калькулятора были применены все пять принципов SOLID:
//Принцип единственной ответственности: Классы отвечают только за свои собственные обязанности и не содержат ненужной логики.
//Принцип открытости/закрытости: Возможность добавления новых операций без изменения существующего кода благодаря использованию интерфейса Operation.
//Принцип подстановки Барбары Лисков: Класс CalculatorPresenter использует абстракцию Operation для выполнения различных математических операций, и мы можем подставлять различные реализации без нарушения работы программы.
//Принцип инверсии зависимостей: Главный класс CalculatorApp зависит только от абстракции Operation, что делает код более гибким и легко расширяемым.
//Принцип DRY: Мы избегли дублирования кода, используя интерфейс Operation для определения различных математических операций и конкретные реализации каждой операции только один раз.