package de.spring.decuplet;

public class HWMDecupled {
    public static void main(String[] args) {
        MessegeRenderer mr = new SoutMessageRenderer();
        MessegeProvider mp = new HelloWorldMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();

    }

}
