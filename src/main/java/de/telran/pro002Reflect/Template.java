package de.telran.pro002Reflect;

public class Template {
    int id;
    String name;
    public String filiale;
    private int insideNummer;

    public Template(int id, String name, String filiale, int insideNummer) {
        this.id = id;
        this.name = name;
        this.filiale = filiale;
        this.insideNummer = insideNummer;
    }

    public int getInsideNummer() {
        return insideNummer;
    }

    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", filiale='" + filiale + '\'' +
                ", insideNummer=" + insideNummer +
                '}';
    }
}
