/*
Создать абстрактный класс Employee для хранения сведений о сотруднике (имени, фамилии, стажа работы и должности).
Должность должна быть описана в enum (DIRECTOR, WORKER) и хранить в себе коэффициент заработанной платы).
В классе Employee реализовать расчет з/п = базовая_ставка * коэффициент * стаж.
Создать класс Worker для создания сотрудников (наследуется от Employee).
Реализовать класс Director (наследуется от Employee).
Реализовать метод для назначения сотрудников (как работника, так и директора) под его управление.
Для директора переопределить метод расчета з/п, в котором предусмотреть влияние количества сотрудников, которые находятся
в подчинении (непосредственном) директора.
1) Необходимо создать 3 работника и 1 директора. Для каждого сотрудника распечатать полное имя сотрудника и его з/п.
2) Назначить двух созданных сотрудников под управление директора. Распечатать сведения о директоре (инфо о директоре и об его подчинении).
3) Создать нового директора с одним сотрудником (под управлением) и добавить его под управления существующего директора.
4) Убедиться, что сведения о первом директоре теперь включают сведения о втором, который так же добавлен к нему (и т.д.).
5) Создать сервис, который определяет есть ли у данного директора в подчинении (прямом или косвенном)
сотрудник с указанным именем (поиск вглубь).
*/

package org.tms.structure;


public class MainApp {
    public static void main(String[] args) {

        // создаем экземпляры 1 директора и 3 рабочих
        Director director1 = new Director("Петр", "Петров" , 16);
        Worker worker1 = new Worker("Сидор", "Сидоров", 13);
        Worker worker2 = new Worker("Федор", "Федоров", 11);
        Worker worker3 = new Worker("Алексей", "Алексеев", 8);

        // выводим пустую строку для удобства чтения данных с консоли
        System.out.println(" ");

        // выводим на консоль информацию об их полных именах и заработной плате
        System.out.println("Штатная численность организации:");
        director1.showInformation();
        worker1.showInformation();
        worker2.showInformation();
        worker3.showInformation();

        // выводим пустую строку для удобства чтения данных с консоли
        System.out.println(" ");

        // назначаем двух работников под управление директора и печатаем сведения о директоре и его подчиненных
        director1.addSubordinates(worker1);
        director1.addSubordinates(worker2);
        director1.printSubordinates(director1);

        // выводим пустую строку для удобства чтения данных с консоли
        System.out.println(" ");

        // создаем экземпляры нового директора, находящегося в подчинении у первого, и его работника
        Director director2 = new Director ("Константин", "Константинов", 5);
        Worker worker4 = new Worker ("Семен", "Семенов", 4);

        director2.addSubordinates(worker4);
        director2.printSubordinates(director2);

        // выводим пустую строку для удобства чтения данных с консоли
        System.out.println(" ");

        // добавляем в подчинение первого директора второго директора и убеждаемся, что сведения о втором включена в сведения о первом
        director1.addSubordinates(director2);
        director1.printSubordinates(director1);

        // выводим пустую строку для удобства чтения данных с консоли
        System.out.println(" ");

        // поиск вглубь (среди всех подчиненных одного директора)
        // задаем искомые имя и фамилию
        String findFirstName = "Константин";
        String findLastName = "Константинов";
        FindSubordinateService find = new FindSubordinateService();

        // составляем массив, в котором будет происходить поиск заданного сотрудника, для прямого и косвенного поиска
        Employee[][] directorsList = { director1.employees, director2.employees };

        // определение максимальной длины одного из массивов для правильной работы сервиса по поиску подчиненного
        int maxLength = director1.sumOfSubordinates();

        if (maxLength < director2.sumOfSubordinates()) {
            maxLength = director2.sumOfSubordinates();
        }

        // взятие булевого значения, возвращаемого поисковым сервисом (был найден сотрудник или нет)
        boolean isWorker = find.findSubordinates(findFirstName, findLastName, maxLength, directorsList);

        // выводим пустую строку для удобства чтения данных с консоли
        System.out.println(" ");

        if (isWorker) {
            System.out.println("Сотрудник " + findFirstName + " " + findLastName +
                    " является подчиненным (прямым или косвенным) директора " +
                    director1.getFirstName() + "а " + director1.getLastName() + "а");
        }
        else {
            System.out.println("Сотрудник " + findFirstName + " " + findLastName +
                    " не является подчиненным (прямым или косвенным) директора " +
                    director1.getFirstName() + "а " + director1.getLastName() + "а");
        }
    }
}