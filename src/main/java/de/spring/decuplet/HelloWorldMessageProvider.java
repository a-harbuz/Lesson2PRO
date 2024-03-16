package de.spring.decuplet;

public class HelloWorldMessageProvider implements MessegeProvider{

    @Override
    public String getMessage() {
        //можем получить с любого места это сообщение и вернуть его
        return ">>> Hello! <<<";
    }
}

