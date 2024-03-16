package de.spring.decuplet;

public interface MessegeRenderer {
    //Как отображать информацию(сама визуализация)
    void render();
    void setMessageProvider(MessegeProvider provider);
    MessegeRenderer getMessageProvider();

}
