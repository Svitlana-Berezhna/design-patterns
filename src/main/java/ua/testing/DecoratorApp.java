package ua.testing;

/**
 * <h1>Design Patterns</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-03-16
 */
public class DecoratorApp {
    public static void main(String[] args) {
        //PrinterInterface printer = new Printer("Привет");
        PrinterInterface printer = new QuotesDecorator(new RightBracketDecorator(new LeftBracketDecorator(
                new Printer("Привет"))));
        printer.print();
    }
}

interface PrinterInterface {
    void print();
}

class Printer implements PrinterInterface {
    String value;

    public Printer(String value) {
        this.value = value;
    }

    public void print() {
        System.out.print(value);
    }
}

abstract class Decorator implements PrinterInterface {
    PrinterInterface component;

    public Decorator(PrinterInterface component) {
        this.component = component;
    }

    public void print() {
        component.print();
    }
}

class QuotesDecorator extends Decorator {
    public QuotesDecorator(PrinterInterface component) {
        super(component);
    }

    public void print() {
        System.out.print("\"");
        super.print();
        System.out.print("\"");
    }
}

class LeftBracketDecorator extends Decorator {
    public LeftBracketDecorator(PrinterInterface component) {
        super(component);
    }

    public void print() {
        System.out.print("[");
        super.print();
    }
}

class RightBracketDecorator extends Decorator {
    public RightBracketDecorator(PrinterInterface component) {
        super(component);
    }

    public void print() {
        super.print();
        System.out.print("]");
    }
}
