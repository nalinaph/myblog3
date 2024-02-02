package com.myblog.myblog3;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class Test2 {
    public static void main(String[] args) {
//        Function<String,Integer> result = str->str.length();
//        //Function<String,Integer> result = String::length; //lamdas expression replaced with method reference
//
//        Integer val = result.apply("mikesm");
//        System.out.println(val);


        // output : 15
//        Function<Integer,Integer> result = i->i+10;
//        Integer val = result.apply(5);
//        System.out.println(val);

//        List<Integer> numbers = Arrays.asList(10,20,30);
//        List<Integer> data = numbers.stream().map(i -> i + 10).collect(Collectors.toList());
//        System.out.println(data);
        
        //Upper case
//
//        List<String> names = Arrays.asList("abc", "xyz", "wxy");
//        //List<String> data = names.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
//        List<String> data = names.stream().sorted()
//        System.out.println(data);
//
//       List<Integer> numbers = Arrays.asList(10,8,8,20,20,15,30,6);
//       // List<Integer> data = numbers.stream().sorted().collect(Collectors.toList());
//        List<Integer> data = numbers.stream().distinct().sorted().collect(Collectors.toList());
//        System.out.println(data);

        // Consumer F. Interface
//        Consumer<Integer> val = number-> System.out.println(number);
//        val.accept(10);

//        Consumer<String> data = str-> System.out.println(str);
//        data.accept("nalina");

//        List<String> names = Arrays.asList("abc","nalina","Rakesh","achintya");
//        Consumer<String> data = name-> System.out.println(name);
//        names.forEach(data);
//
        //Supplier F. I

        //System.out.println(new Random().nextInt(500));
        Supplier<Integer> x= ()->(new Random().nextInt(400));
        Integer y = x.get();
        System.out.println(y);
    }
}
