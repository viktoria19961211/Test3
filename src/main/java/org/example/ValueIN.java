package org.example;

import java.util.List;

public class ValueIN {
    public int id;
    public String title;
    public String value;
    public List<ValueIN> values;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<ValueIN> getValues() {
        return values;
    }

    public void setValues(List<ValueIN> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "ValueIN{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                ", values=" + values +
                '}';
    }
}
