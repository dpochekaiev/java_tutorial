package com.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args) {

        // обычный массив, задан поэлементно
        String[] langs = new String[4];
        langs[0] = "Java";
        langs[1] = "C#";
        langs[2] = "Python";
        langs[3] = "PHP";

        // обычный массив, заполненный при создании
        String[] langsOneLine = {"Java", "C#", "Python", "PHP"};

        // коллекция строк типа 'List', заполненная поэлементно
        List<String> langsList = new ArrayList<String>();
        langsList.add("Java");
        langsList.add("Java"); // to be removed
        langsList.add("Pascal"); // to be removed
        langsList.add("C#");
        langsList.add("Python");
        langsList.add("PHP");

        // коллекция строк типа 'List', заполненная при создании
        // Фактически это массив: к нему нельзя добавить или убрать элементы, как и в обычном массиве через методы .add и .remove
        List<String> langList_ArrayAsList = Arrays.asList("Java", "C#", "Python", "PHP");
        langsList.getClass();
        langList_ArrayAsList.getClass();

        /*==========================================================================================================================================*/

        //  работа с массивом через обычный цикл FOR
        System.out.println("работа с массивом через обычный цикл FOR");
        for (int i = 0; i < langs.length; i++) {
            System.out.println(i + ": " + langs[i] + " and " + langsOneLine[i] + " are equals: " + langs[i].equals(langsOneLine[i]));
        }

        // Работа с массивами через цикл FOR для массивов (в качестве переменной цикла выступает сразу очередной эдлемент массива ('l'))
        System.out.println();
        System.out.println("Работа с массивами через цикл FOR для массивов (в качестве переменной цикла выступает сразу очередной эдлемент массива ('l'))");
        for (String l : langs) {
            System.out.println("Я хочу выучить " + l);
            if (l.equals("C#")) {
                break; // проверка работы break - прерывается только текущий цикла, а не весь метод
            }
        }

        System.out.println();
        //  removing two languages from the list 'langsList'
        langsList.remove("Pascal"); // Removing Pascal
        langsList.remove(1); // Removing the second "Java"
        //

        // работа с коллекцией 'langsList', где переменной цикла выступает очередно элемент списка ('l')
        System.out.println("работа с коллекцией 'langsList', где переменной цикла выступает очередно элемент списка ('l')");
        int i = 0;
        for (String l : langsList) {
            System.out.println(i + ": " + langs[i] + " and " + l + " are equals: " + langs[i].equals(l));
            i++;
        }

        // работа с коллекцией, как с обычным массивом
        System.out.println();
        System.out.println("работа с коллекцией, как с обычным массивом");
        for (int j = 0; j < langList_ArrayAsList.size(); j++) {
            System.out.println("Я хочу выучить " + langList_ArrayAsList.get(j));
        }

    }

}
