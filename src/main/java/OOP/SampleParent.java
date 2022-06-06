package OOP;


public class SampleParent implements MyInterface {

    @Override
    public void method1() {
        System.out.println("SampleParent.method1");
        method2();

    }

    @Override
    public void method2() {
        System.out.println("SampleParent.method2");
    }
}
