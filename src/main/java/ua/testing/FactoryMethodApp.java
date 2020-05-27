package ua.testing;

import java.util.Date;

/**
 * <h1>Design Patterns</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-03-16
 */
public class FactoryMethodApp {
    public static void main(String[] args) {
        WatchMaker maker = getMakerByName("name");
        Watch watch = maker.createWatch();
        watch.showTime();
    }

    public static WatchMaker getMakerByName(String maker) {
        if (maker.equals("Digital"))
            return new DigitalWatchMaker();
        else if (maker.equals("Rome"))
            return new RomeWatchMaker();

        throw new RuntimeException("Неподдерживаемая производственная линия часов: " + maker);
    }
}

interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch {
    public void showTime() {
        System.out.println("VII-XX");
    }
}

interface WatchMaker {
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker {
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker {
    public Watch createWatch() {
        return new RomeWatch();
    }
}
