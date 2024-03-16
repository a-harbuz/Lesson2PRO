package de.spring.decuplet;

public class SoutMessageRenderer implements MessegeRenderer{
    private MessegeProvider messegeProvider;
    public SoutMessageRenderer() {
        System.out.println("SoutMessageRenderer constructor started!");
    }

    @Override
    public void render() {
        System.out.println(messegeProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessegeProvider provider) {

    }

    @Override
    public MessegeRenderer getMessageProvider() {
        return null;
    }
}
