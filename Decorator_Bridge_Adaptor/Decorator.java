package Decorator_Bridge_Adaptor;

public class Decorator {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }
}


abstract class Beverage{
    String descirption;
    abstract double cost();
    public String getDescription(){
        return descirption;
    }
}


class HouseBlend extends Beverage{

    public double cost() {
        return 2.0;
    }
}


class DarkRoast extends Beverage{

    public double cost(){
        return 2.0;
    }
}


class Espresso extends Beverage{

    public double cost(){
        return 2.0;
    }
}


class Decaf extends Beverage{

    public double cost(){
        return 2.0;
    }
}

abstract class CondimentDecorator extends Beverage{
    Beverage bevarge;
    public abstract String getDescription();  
}  

 
class Milk extends CondimentDecorator{
    Beverage beverage;
    public Milk(Beverage b){
        beverage = b;
    }
    public String getDescription(){
        return beverage.getDescription() + "Milk";
    }
    public double cost(){
        return 2.0 + beverage.cost();
    }
}

class Mocha extends CondimentDecorator{
    Beverage beverage;
    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }
    public String getDescription(){
        return beverage.getDescription() + " Mocha";
    }
    public double cost(){
        return 2.0 + beverage.cost();
    }
}

class Soy extends CondimentDecorator{
    Beverage beverage;
    public Soy(Beverage b){
        beverage = b;
    }
    public String getDescription(){
        return beverage.getDescription() + " Soy";
    }
    public double cost(){
        return 2.0 + beverage.cost();
    }
}

class Whip extends CondimentDecorator{
    Beverage beverage;
    public Whip(Beverage b){
        beverage = b;
    }
    public String getDescription(){
        return beverage.getDescription() + " Soy";
    }
    public double cost(){
        return 2.0 + beverage.cost();
    }
}