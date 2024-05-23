package org.example;

import java.util.List;

public class TestIN {
    public int id;
    public String value;
    public String title;
    public List<ValueIN> values;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ValueIN> getValues() {
        return values;
    }

    public void setValues(List<ValueIN> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "TestIN{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", title='" + title + '\'' +
                ", values=" + values +
                '}';
    }
}
