package Hackerrank.Singleton;


class Singleton{
    String str;

    private  Singleton() {}

    private static final Singleton instance = new Singleton();

    public static Singleton getSingleInstance () {
        return instance;
    }

}