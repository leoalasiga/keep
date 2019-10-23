package common.test;

public class TestDemo {
    public static void main(String[] args) {
        Integer i = 100;
        Integer b = 100;
        System.out.println(i==b);
        Integer c = 127;
        Integer d = 127;
        System.out.println(c==d);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    protected void finalized() {

    }
}
