package com.myblog.myblog3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class TestClass {
    public static void main(String[] args) {

//        List<Integer> number = Arrays.asList(12,45,2,34,12,55,44);
//      // List<Integer> evenNumbers = number.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
//       List<Integer> evenNumbers = number.stream().filter(x -> x % 2 != 0).toList();
//        System.out.println(evenNumbers);

        List<String> names = Arrays.asList("mike","asha","asha", "arpitha","nalina","anu");
        List<String> data1 = names.stream().filter(n -> n.startsWith("a")).collect(Collectors.toList());
        List<String> data2 = names.stream().filter(n -> n.endsWith("u")).collect(Collectors.toList());
        List<String> data3 = names.stream().filter(n -> n.equals("asha")).collect(Collectors.toList());
       // Predicate<Integer> data4 = (Predicate<Integer>) names.stream().filter(n -> n.equals("asha")); it didnt work


        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data3);
        //System.out.println(data4);



        //Predicate<String> val= str->str.equals("stallin");
               //boolean result= val.test("mike");
        //System.out.println(result);


    }


}
