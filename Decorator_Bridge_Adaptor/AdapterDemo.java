package Decorator_Bridge_Adaptor;

public class AdapterDemo {
    private DataAdapterAbstract aDataTarget;
    public AdapterDemo(){
        aDataTarget = new DataAdapterConcrete();
        aDataTarget.print();
    }
    public static void main(String[] args) {
        new AdapterDemo();
    }
}

abstract class DataAdapterAbstract{
    public abstract void print();
}

class DataAdapterConcrete extends DataAdapterAbstract{
    private DataAdaptee aDataAdaptee;
    public DataAdapterConcrete(){
        aDataAdaptee = new DataAdaptee();
    }
    public void print(){
        aDataAdaptee.printAdaptee();
    }
}

class DataAdaptee{
    public void printAdaptee(){
        System.out.println("Class Data Adaptee");
    }
}