package ru.gb.jseminar;

import java.util.*;
import java.util.logging.Logger;


public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников в формате строки
    // "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;"
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.
    public static void main(String[] args) {
        Homework hw = new Homework();
        String data = "Ева,Дарахвелидзе,89010348765;Ева,Дарахвелидзе,89010344345;Андрей,Иванов,89050377654;Дмитрий,Пономаренко,89344322343;";
        Logger log = Logger.getLogger(Homework.class.getName());
        log.info(hw.findPerson(data));
    }

    public String findPerson (String st) {
        Map<String, List<String>> map = new TreeMap<>();

        for (String item: st.split(";")) {
            List<String> t = List.of(item.split(","));
            String key = t.get(0).toLowerCase() + " " +t.get(1).toLowerCase();
            if (!map.containsKey(key)) {

                List<String> value = new ArrayList<>();
                value.add(t.get(2));
                map.put(key, value);
            }
            else
            {
                String value = t.get(2);
                map.get(key).addAll(Arrays.asList(value));
            }
        }

        Map<Integer, List<String>> result = new TreeMap<>(Collections.reverseOrder());



        for (String item: map.keySet()) {
            if (map.get(item).size() > 1){

                int key = map.get(item).size();
                System.out.println(item);

                if (!result.containsKey(key)) {
                    List<String> value = new ArrayList<>();
                    value.add(item);
                    result.put(map.get(item).size(), value);
                }
                else
                {
                    String value = item;
                    result.get(key).addAll(Arrays.asList(value));
                }

            }

        }
        result.entrySet().stream();

        return result.toString().replaceAll("^\\{|\\}$", "");
    }


}