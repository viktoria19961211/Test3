package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите путь к файлу values.json:");
        String json = Files.readString(Paths.get(new Scanner(System.in).nextLine()));//"values.json"
        System.out.println("Введите путь к файлу tests.json:");
        String jsonIN = Files.readString(Paths.get(new Scanner(System.in).nextLine()));//"tests.json"
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectMapper objectMapperIN = new ObjectMapper();

        Root root = objectMapper.readValue(json, Root.class);
        RootIN rootin = objectMapperIN.readValue(jsonIN, RootIN.class);


        //Iterator<Value> iterator = root.getValues().iterator();
        Iterator<TestIN> inIteratorin = rootin.getTests().iterator();


        while (inIteratorin.hasNext()) {
            TestIN itTestIn = inIteratorin.next();
            //System.out.println(itTestIn.getId());

            //Первый проход
            Iterator<Value> iterator = root.getValues().iterator();
            while (iterator.hasNext()) {
                Value itValue = iterator.next();
                //System.out.println(itValue.getId());
                if (itValue.getId() == itTestIn.getId()) {
                    itTestIn.setValue(itValue.getValue());
                }
            }

            if (itTestIn.getValues() != null) {
                Iterator<ValueIN> valueIN = itTestIn.getValues().iterator();
                while (valueIN.hasNext()) {
                    ValueIN itValueIn = valueIN.next();
                    //System.out.println(itValueIn.getId());

                    //Второй проход
                    Iterator<Value> iterator2 = root.getValues().iterator();
                    while (iterator2.hasNext()) {
                        Value itValue = iterator2.next();
                        //System.out.println(itValue.getId());
                        if (itValue.getId() == itValueIn.getId()) {
                            itValueIn.setValue(itValue.getValue());
                        }
                    }

                    if (itValueIn.getValues() != null) {
                        Iterator<ValueIN> valueININ = itValueIn.getValues().iterator();
                        while (valueININ.hasNext()) {
                            ValueIN itValueInIn = valueININ.next();
                            //System.out.println(itValueInIn.getId());

                            //Трейти проход
                            Iterator<Value> iterator3 = root.getValues().iterator();
                            while (iterator3.hasNext()) {
                                Value itValue = iterator3.next();
                                //System.out.println(itValue.getId());
                                if (itValue.getId() == itValueInIn.getId()) {
                                    itValueInIn.setValue(itValue.getValue());
                                }
                            }


                            if (itValueInIn.getValues() != null) {
                                Iterator<ValueIN> valueINININ = itValueInIn.getValues().iterator();
                                while (valueINININ.hasNext()) {
                                    ValueIN itValueInInIn = valueINININ.next();
                                    //System.out.println(itValueInInIn.getId());

                                    //Четвертый проход
                                    Iterator<Value> iterator4 = root.getValues().iterator();
                                    while (iterator4.hasNext()) {
                                        Value itValue = iterator4.next();
                                        //System.out.println(itValue.getId());
                                        if (itValue.getId() == itValueInInIn.getId()) {
                                            itValueInInIn.setValue(itValue.getValue());
                                        }
                                    }

                                }
                            }


                        }
                    }


                }

            }


        }


        System.out.println();
        String jsonString = objectMapperIN.writerWithDefaultPrettyPrinter().writeValueAsString(rootin);
        PrintWriter writer = new PrintWriter("report.json", "UTF-8");

        //System.out.println(jsonString);
        writer.print(jsonString);
        writer.close();
        System.out.println("Файл report.json готов.");
    }
}