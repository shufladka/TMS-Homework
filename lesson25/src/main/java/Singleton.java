public class Singleton {
    private static Singleton INSTANCE;

    private Singleton() {
        /*
        Конструктор одиночки всегда должен оставаться приватным,
        чтобы клиенты не могли самостоятельно создавать
        экземпляры этого класса через оператор `new`.
        */
    }

    public static Singleton getInstance()
    {
        /*
        Основной статический метод одиночки служит альтернативой
        конструктору и является точкой доступа к экземпляру этого класса.
        */

        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }

        return INSTANCE;
    }
}