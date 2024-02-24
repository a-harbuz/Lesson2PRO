package de.telran.pro002Reflect;

public class Controller implements DoAble {

    @Override
    public void start() {
        System.out.println("Start!");
    }

    @Override
    public void stop() {
        System.out.println("Stop!");
    }
}

class ControllerProxy implements DoAble {
    private Controller originController;

    public ControllerProxy(Controller originController) {
        this.originController = originController;
    }

    @Override
    public void start() {
        System.out.println("Start LOGGING.");
        originController.start();
    }

    @Override
    public void stop() {
        System.out.println("Stop LOGGING.");
        originController.stop();
    }
}

class Main {
    public static void main(String[] args) {
        Controller oc = new Controller();
        //Логируй
        ControllerProxy controllerProxy = new ControllerProxy(oc);
        controllerProxy.start();
        controllerProxy.stop();
    }

//    RetentionPolicy
//    @Override
//    @Deprecated
//    @SuppressWarnings
//
//    @Test: используется для пометки методов, которые содержат тестовые сценарии.
//    @Before, @BeforeEach: используются для пометки методов, которые выполняются перед каждым тестовым методом.
//    @After, @AfterEach: используются для пометки методов, которые выполняются после каждого тестового метода.
//    @RunWith, @ExtendWith: используются для настройки запуска тестов или подключения дополнительных расширений.

}