import java.util.Scanner;

public class Main {
    static int earnings = 0;
    static int spendings = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStrIncome = scanner.nextLine();
                    int income = Integer.parseInt(moneyStrIncome);
                    earnings += income;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String moneyStrSpending = scanner.nextLine();
                    int spending = Integer.parseInt(moneyStrSpending);
                    spendings += spending;
                    break;
                case 3:
                    BestTaxSystem();
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена!");
    }

    static int taxEarnings() {
        return earnings * 6 / 100;
    }

    static int taxEarningsMinusSpendings() {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    static void BestTaxSystem() {
        int tax1 = taxEarnings();
        int tax2 = taxEarningsMinusSpendings();

        if (tax1 < tax2) {
            System.out.println("Мы советуем вам УСН доходы");
            System.out.println("Ваш налог составит: " + tax1 + " рублей");
            System.out.println("Налог на другой системе: " + tax2 + " рублей");
            System.out.println("Экономия: " + (tax2 - tax1) + " рублей");
        } else if (tax2 < tax1) {
            System.out.println("Мы советуем вам УСН доходы минус расходы");
            System.out.println("Ваш налог составит: " + tax2 + " рублей");
            System.out.println("Налог на другой системе: " + tax1 + " рублей");
            System.out.println("Экономия: " + (tax1 - tax2) + " рублей");
        } else {
            System.out.println("Можете выбрать любую систему налогообложения");
            System.out.println("Налог на обеих системах: " + tax1 + " рублей");
        }
    }
}