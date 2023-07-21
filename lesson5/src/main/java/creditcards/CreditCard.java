package creditcards;

public class CreditCard {

    String accountNumber;   // номер счета
    int accountBalance;     // баланс счета

    // конструктор класса org.tms.creditcards.CreditCard
    public CreditCard(String accountNumber, int accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    // метод, который возвращает номер счета
    public String getAccountNumber() {
        return accountNumber;
    }

    // метод, который позволяет начислять сумму на кредитную карточку
    public void deposit (int sum) {
        accountBalance += sum;
        System.out.print("Операция совершена успешно! ");
        currentBalance();
    }

    // метод, который позволяет снимать с карточки некоторую сумму
    public void withdraw (int sum) {
        if ((accountBalance - sum) > 0) {
            accountBalance -= sum;
            System.out.print("Операция совершена успешно! ");
            currentBalance();
        }
        else {
            System.out.println("Ошибка операции: недостаточно средств.");
            currentBalance();
        }
    }

    // метод, который выводит текущую информацию о карточке
    private void currentBalance () {
        System.out.println("Текущий остаток на счете №" + accountNumber + ": " + accountBalance);
    }
}