package ua.testing;

/**
 * <h1>Design Patterns</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-03-16
 */
public class BridgeApp {
    public static void main(String[] args) {
        Car c = new Coupe(new Kia());
        c.showDetails();
    }
}

abstract class Car {
    Make make;

    public Car(Make m) {
        make = m;
    }

    abstract void showType();

    void showDetails() {
        showType();
        make.setMake();
    }
}

class Sedan extends Car {
    public Sedan(Make m) {
        super(m);
    }

    void showType() {
        System.out.println("Sedan");
    }
}

class Hatchback extends Car {
    public Hatchback(Make m) {
        super(m);
    }

    void showType() {
        System.out.println("Hatchback");
    }
}

class Coupe extends Car {
    public Coupe(Make m) {
        super(m);
    }

    void showType() {
        System.out.println("Coupe");
    }
}

interface Make {
    void setMake();
}

class Kia implements Make {
    public void setMake() {
        System.out.println("Kia");
    }
}

class Skoda implements Make {
    public void setMake() {
        System.out.println("Skoda");
    }
}

class Mercedes implements Make {
    public void setMake() {
        System.out.println("Mercedes");
    }
}
