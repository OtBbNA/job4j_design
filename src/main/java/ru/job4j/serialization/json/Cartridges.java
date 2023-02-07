package ru.job4j.serialization.json;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cartridges")
public class Cartridges {

    @XmlAttribute
    private int penetration;
    @XmlAttribute
    private String type;

    public Cartridges() {
    }

    public Cartridges(int penetration, String type) {
        this.penetration = penetration;
        this.type = type;
    }

    public int getPenetration() {
        return penetration;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Cartridges{"
                + "penetration=" + penetration
                + ", type='" + type + '\''
                + '}';
    }
}
