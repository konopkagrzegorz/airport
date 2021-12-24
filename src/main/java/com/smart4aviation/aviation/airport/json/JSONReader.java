package com.smart4aviation.aviation.airport.json;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class JSONReader {

    public <T> List<T> read(String path, Type type) {
        Reader reader = getReader(path);
        return new Gson().fromJson(reader,type);
    }

    private Reader getReader(String path) {
        Reader reader = null;
        try {
            reader = new InputStreamReader(this.getClass().getResourceAsStream(path));
        } catch (NullPointerException exception) {
            System.out.printf("File %s not found", path);
        }
        return reader;
    }
}
