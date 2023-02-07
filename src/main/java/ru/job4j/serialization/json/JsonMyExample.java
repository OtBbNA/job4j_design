package ru.job4j.serialization.json;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.StringWriter;
import java.util.List;

@XmlRootElement(name = "jsonMyExample")
@XmlAccessorType(XmlAccessType.FIELD)
public class JsonMyExample {

    private boolean magazine;
    private int numberOfRounds;
    private String firingMode;
    private Cartridges cartridges;
    private Cartridges[] rsl;
    private List<String> barrelFeatures;

    public JsonMyExample() {

    }

    public JsonMyExample(boolean magazine, int numberOfRounds,
                         String firingMode, Cartridges cartridges, List<String> barrelFeatures) {
        this.magazine = magazine;
        this.numberOfRounds = numberOfRounds;
        this.firingMode = firingMode;
        this.cartridges = cartridges;
        this.rsl = new Cartridges[numberOfRounds];
        Arrays.fill(rsl, cartridges);
        this.barrelFeatures = barrelFeatures;
    }

    @Override
    public String toString() {
        return "JsonMyExample: "
                + "\r\n" + "magazine=" + magazine
                + "\r\n" + "numberOfRounds=" + numberOfRounds
                + "\r\n" + "firingMode='" + firingMode + '\''
                + "\r\n" + "cartridges=" + cartridges
                + "\r\n" + "rsl=" + Arrays.toString(rsl)
                + "\r\n" + "barrelFeatures=" + barrelFeatures
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        List<String> newBarrelFeatures = new ArrayList<>();
        newBarrelFeatures.add("2");
        newBarrelFeatures.add("6");
        newBarrelFeatures.add("9");
        final JsonMyExample jsonMyExample = new JsonMyExample(true, 3, "SemiAuto",
                new Cartridges(2, "expansive"), newBarrelFeatures);

        JAXBContext context = JAXBContext.newInstance(JsonMyExample.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(jsonMyExample, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            JsonMyExample result = (JsonMyExample) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
