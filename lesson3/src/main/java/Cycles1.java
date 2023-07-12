/*
При помощи цикла for вывести на экран нечетные числа от 1 до 99.
При решении используйте операцию инкремента (++).
*/

public class Cycles1 {
    public static void main(String[] args) {

        // цикл вывода всех нечетных чисел от 1 до 99
        for (int i = 0; i < 100; i++)
            if (i % 2 == 1)
                System.out.println(i);
    }
}