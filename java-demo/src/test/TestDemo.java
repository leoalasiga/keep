package test;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestDemo {
    public static void main(String[] args) {
        List<Double> collect = Stream.generate(Math::random).limit(10000000).collect(Collectors.toList());


        long start = System.currentTimeMillis();
        long count = collect.stream().filter(x -> x > 0.5).count();
        long end = System.currentTimeMillis();
        System.out.println("stream take " +(end-start)+" milliseconds");

        start = System.currentTimeMillis();
        long count1 = collect.parallelStream().filter(x -> x > 0.5).count();
        end = System.currentTimeMillis();
        System.out.println("parallelStream take " +(end-start)+" milliseconds");


    }

}



