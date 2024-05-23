package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String json = Files.readString(Paths.get(new Scanner(System.in).nextLine()));//"values.json"
        String jsonIN = Files.readString(Paths.get(new Scanner(System.in).nextLine()));//"tests.json"
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectMapper objectMapperIN = new ObjectMapper();

        Root root = objectMapper.readValue(json, Root.class);
        RootIN rootin = objectMapperIN.readValue(jsonIN, RootIN.class);


        //Iterator<Value> iterator = root.getValues().iterator();
        Iterator<TestIN> inIteratorin = rootin.getTests().iterator();


        while (inIteratorin.hasNext()) {
            TestIN itTestIn = inIteratorin.next();
            System.out.println(itTestIn.getId());

            //Первый проход
            Iterator<Value> iterator = root.getValues().iterator();
            while(iterator.hasNext()){
                Value itValue = iterator.next();
                //System.out.println(itValue.getId());
                if(itValue.getId()==itTestIn.getId()){
                    itTestIn.setValue(itValue.getValue());
                }
            }

            if (itTestIn.getValues()!=null){
                Iterator<ValueIN> valueIN = itTestIn.getValues().iterator();
                while(valueIN.hasNext()){
                    ValueIN itValueIn = valueIN.next();
                    System.out.println(itValueIn.getId());

                    //Второй проход
                    Iterator<Value> iterator2 = root.getValues().iterator();
                    while(iterator2.hasNext()){
                        Value itValue = iterator2.next();
                        //System.out.println(itValue.getId());
                        if(itValue.getId()==itValueIn.getId()){
                            itValueIn.setValue(itValue.getValue());
                        }
                    }

                    if(itValueIn.getValues()!=null) {
                        Iterator<ValueIN> valueININ = itValueIn.getValues().iterator();
                        while (valueININ.hasNext()) {
                            ValueIN itValueInIn = valueININ.next();
                            System.out.println(itValueInIn.getId());

                            //Трейти проход
                            Iterator<Value> iterator3 = root.getValues().iterator();
                            while(iterator3.hasNext()){
                                Value itValue = iterator3.next();
                                //System.out.println(itValue.getId());
                                if(itValue.getId()==itValueInIn.getId()){
                                    itValueInIn.setValue(itValue.getValue());
                                }
                            }


                            if(itValueInIn.getValues()!=null){
                                Iterator<ValueIN> valueINININ = itValueInIn.getValues().iterator();
                                while(valueINININ.hasNext()){
                                    ValueIN itValueInInIn = valueINININ.next();
                                    System.out.println(itValueInInIn.getId());

                                    //Четвертый проход
                                    Iterator<Value> iterator4 = root.getValues().iterator();
                                    while(iterator4.hasNext()){
                                        Value itValue = iterator4.next();
                                        //System.out.println(itValue.getId());
                                        if(itValue.getId()==itValueInInIn.getId()){
                                            itValueInInIn.setValue(itValue.getValue());
                                        }
                                    }

                                }
                            }


                        }
                    }


                }

            }




//            if (itTestIn.getValues() != null) {
//                Iterator<ValueIN> valueINIterator = itTestIn.getValues().iterator();
//                while (valueINIterator.hasNext()) {
//                    ValueIN itValueIn = valueINIterator.next();
//                    System.out.println(itValueIn.getId());
//                    while (iterator.hasNext()) {
//                        Value itoutValue = iterator.next();
//
//                        if (itoutValue.getId() == itValueIn.getId()) {
//                            itoutValue.setValue(itValueIn.getValue());
//                        }
//                    }
//
//                    if (itValueIn.getValues() != null) {
//                        Iterator<ValueIN> valueINIteratorIn = itValueIn.getValues().iterator();
//                        while (iterator.hasNext()) {
//                            Value itoutValuein = iterator.next();
//
//                            if (itoutValuein.getId() == itValueIn.getId()) {
//                                itoutValuein.setValue(itValueIn.getValue());
//                            }
//                        }
//                        while (valueINIteratorIn.hasNext()) {
//                            ValueIN itValueInIN = valueINIteratorIn.next();
//                            System.out.println(itValueInIN.getId());
//                            while (iterator.hasNext()) {
//                                Value itoutValueinin = iterator.next();
//                                if (itoutValueinin.getId() == itValueInIN.getId()) {
//                                    itValueInIN.setValue(itoutValueinin.getValue());
//                                }
//                            }
//                        }
//                    }
//                }
//            }

//            Value itValue = iterator.next();
//            System.out.println("id="+itValue.getId());
//            System.out.println("value="+itValue.getValue());
//
//            while(inIteratorin.hasNext()){
//                TestIN itValueIn = inIteratorin.next();
//                if (itValueIn.getId()==itValue.getId()){
//                    itValueIn.setValue(itValue.getValue());
//                    System.out.println("есть");
//                    if (itValueIn.getValues()!=null){
//                        Iterator<ValueIN> iterValuesIN = itValueIn.getValues().iterator();
//                        while (iterValuesIN.hasNext()){
//                            ValueIN itValuesIn = iterValuesIN.next();
//
//
//                            System.out.println("ВОШЕЛ");
//                            if (itValuesIn.getId()==itValue.getId()){
//                                itValueIn.setValue(itValue.getValue());
//                                System.out.println("       id="+itValueIn.getId());
//                                System.out.println("       value="+itValueIn.getValue());
//                                 System.out.println("       values="+itValueIn.toString());
//                            }
//                        }
//                    }
//                }
//
//
//            }
//            if (itValue.getValues()!=null){
//                Iterator<Value> iterValues = itValue.getValues().iterator();
//                while(iterValues.hasNext()){
//                    Value itValues = iterValues.next();
//                    System.out.println("       id="+itValues.getId());
//                    System.out.println("       value="+itValues.getValue());
//                    System.out.println("       values="+itValues.toString());
//                }
//            }

        }


        System.out.println();
        String jsonString = objectMapperIN.writerWithDefaultPrettyPrinter().writeValueAsString(rootin);
        PrintWriter writer = new PrintWriter("testsOut.json", "UTF-8");

        //System.out.println(jsonString);
        writer.print(jsonString);
        writer.close();
    }
}