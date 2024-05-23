package org.example;

import java.util.List;

public class RootIN {
    public List<TestIN> tests;

    public List<TestIN> getTests() {
        return tests;
    }

    public void setTests(List<TestIN> tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {
        return "RootIN{" +
                "tests=" + tests +
                '}';
    }
}
