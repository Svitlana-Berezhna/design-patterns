package ua.testing;

/**
 * <h1>Design Patterns</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-03-16
 */
public class CommandApp {
    public static void main(String[] args) {
        Comp c = new Comp();
        User u = new User(new StartCommand(c), new StopCommand(c), new ResetCommand(c));

        u.startComputer();
        u.stopComputer();
        u.resetComputer();
    }
}

interface Command {
    void execute();
}

//Receiver
class Comp {
    void start() {
        System.out.println("Start");
    }

    void stop() {
        System.out.println("Stop");
    }

    void reset() {
        System.out.println("Reset");
    }
}

//ConcreteCommand
class StartCommand implements Command {
    Comp computer;

    public StartCommand(Comp computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.start();
    }
}

//ConcreteCommand
class StopCommand implements Command {
    Comp computer;

    public StopCommand(Comp computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.stop();
    }
}

//ConcreteCommand
class ResetCommand implements Command {
    Comp computer;

    public ResetCommand(Comp computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.reset();
    }
}

//Invoker
class User {
    Command start;
    Command stop;
    Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    void startComputer() {
        start.execute();
    }

    void stopComputer() {
        stop.execute();
    }

    void resetComputer() {
        reset.execute();
    }
}
