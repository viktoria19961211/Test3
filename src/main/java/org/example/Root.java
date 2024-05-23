package org.example;

import java.util.List;

public class Root {
    public List<Value> values;

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return
                ""+values ;
    }
}
