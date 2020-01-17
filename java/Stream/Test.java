package Stream;
import java.util.*;
import java.util.function.Consumer;
import	java.util.function.Supplier;

import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Student stuA = new Student(1, "A", "M", 184);
        Student stuB = new Student(2, "B", "G", 163);
        Student stuC = new Student(3, "C", "M", 175);
        Student stuD = new Student(4, "D", "G", 158);
        Student stuE = new Student(5, "E", "M", 170);
        List<Student> list = new ArrayList<>();
        list.add(stuA);
        list.add(stuB);
        list.add(stuC);
        list.add(stuD);
        list.add(stuE);



        List<Student> collect = list.stream()
                .filter(obj -> obj.name.equals("A") || obj.getClass().getName()
                        .equals("M")).collect(Collectors.toList());
//        System.out.println(collect);
        list.stream()
                .filter(obj -> obj.name.equals("A") || obj.getClass().getName()
                        .equals("M")).collect(Collectors.toList()).forEach(System.out::println);
        /**
         * 注意 : foreach 的函数接口方法是void 类型的 ，所以我们需要对方法引用也是void类型的
         */
        System.out.println("-----------------------------------");
        list.stream()
                .filter(obj -> obj.name.equals("A") || obj.getClass().getName()
                        .equals("M")).collect(Collectors.toList()).forEach(Student::ttoString);


        /**
         * reduce
         */
        Optional res= Stream.of(1,2,4,5).reduce(
                (x,y)-> {
                    System.out.println(x+"\t"+y);
                    return x;
                }
        );
        System.out.println(res.get());

        /**
         * reduce的常用操作：
         *
         */
        System.out.println("--------求和操作--------");
        Integer sum=Stream.of(1,2,3,4,5).reduce(0,Integer::sum);
        System.out.println(sum);
        Stream<Integer> is = Stream.of(1, 2, 3, 4, 5);
        is.reduce((i,j)->i+j).ifPresent(System.out::println);
        //求最大值
        Stream<Integer> is2 = Stream.of(1, 2, 3, 4, 5);
        is2.reduce(Integer::max).ifPresent(System.out::println);
        Stream<Integer> is3 = Stream.of(1, 2, 3, 4, 5);
        is3.reduce((x,y)->x>y? x:y).ifPresent(System.out::println);
        System.out.println("------------------------");
        Stream<Student> stream = list.stream();
        System.out.println(stream.reduce((arg1, arg2) -> arg1.getNo() < arg2.getNo() ? arg1 : arg2).get());
        System.out.println("------------------------");

        Stream<Student> stream2 = list.stream();
        stream2.sorted((x,y)->y.getNo()-x.getNo()).forEach(System.out::println);
        //测试hashmap
        Map<Integer,Student> map=new HashMap<Integer, Student>();
        map.put(1001,stuA);
        map.put(1002,stuB);
        map.put(1003,stuC);
        map.put(1004,stuD);
        map.put(1005,stuD);


         map.entrySet().stream().reduce((arg1, arg2) -> {
            arg1.getValue().setSex(arg1.getValue().getName());
            return arg2;
        });


        for (Map.Entry<Integer,Student> me:map.entrySet()){
            System.out.println(me.getKey()+"---"+me.getValue());
        }

    }
}
