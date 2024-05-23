package org.example;

import java.util.List;

public class Value {
    public int id;
    public String value;
    public List<Value> values;
    public String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", value='" + value + '\'' +
                ", values=" + values +
                ", title='" + title + '\'';
    }
}
