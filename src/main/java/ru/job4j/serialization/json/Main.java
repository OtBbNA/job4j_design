package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final JsonMyExample example = new JsonMyExample(true, 3, "SemiAuto", new Cartridges(372, "tracer"), new ArrayList<>());
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(example));
        final String jsonMyExample =
                "{"
                        + "\"magazine\":true,"
                        + "\"numberOfRounds\":3,"
                        + "\"firingMode\":\"SemiAuto\","
                        + "\"cartridges\":"
                        + "{"
                        + "\"penetration\":372,"
                        + "\"type\":\"tracer\""
                        + "},"
                        + "\"rsl\":"
                        + "[{\"penetration\":372,\"type\":\"tracer\"},{\"penetration\":372,\"type\":\"tracer\"},{\"penetration\":372,\"type\":\"tracer\"}]"
                + "}";
        final JsonMyExample jsonMod = gson.fromJson(jsonMyExample, JsonMyExample.class);
        System.out.println(jsonMod);
    }
}