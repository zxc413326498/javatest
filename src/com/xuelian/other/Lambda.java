package com.xuelian.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * Lambda是一个匿名函数（相似于匿名内部类）,作用是返回一个实现了接口的对象（缩减版的实现方法表达式）
 * Lambda表达式只和函数式接口有关
 * Lambda表达式用于取代函数式接口的实现类及其方法
 * 函数式接口 :某个接口,里面有且仅有一个抽象方法.
 * https://cloud.tencent.com/developer/article/1532870
 * https://juejin.cn/post/7017384080765370381
 */
public class Lambda {

    public static void main(String[] args) {
        new Lambda();
    }

    public Lambda() {
        //Consumer : 消费型接口
        consumer();
        //Supplier : 供给型接口
        supplier();
        //Function<T, R> : 函数型接口
        function();
        //Predicate : 断言型接口
        predicate();
        //构造函数测试
        getPerson();
        //power
        power();
        //LowercaseToUppercase
        lowercaseToUppercase();
    }

    /**
     * (m) -> System.out.println("大保健，每次消费：" + m + "元") 缩减版的实现方法表达式
     * m对应抽象方法accept的输入参数
     * sout即具体实现
     */
//    @Test
    public void consumer() {
        System.out.println("Lambda.consumer" + "----------");
        happy(10000, (m) -> System.out.println("大保健，每次消费：" + m + "元"));
        //
        Consumer<Double> con = (m) -> System.out.println("大保健，每次消费：" + m + "元");
        con.accept(10000D);
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    private void supplier() {
        System.out.println("Lambda.supplier" + "-----------");
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer num : numList) {
            System.out.println("Lambda.supplier" + "----num 值= " + num);
        }
        // 另一种写法
        // numList.forEach(e -> System.out.println(e));
    }

    //产生指定个数的整数，并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }

    private void function() {
        System.out.println("Lambda.function" + "------------");
        String newStr = strHandler("\t\t\t  武汉加油，中国加油   ", String::trim);//(str) -> str.trim()
        System.out.println(newStr);

        String subStr = strHandler("武汉加油，中国加油 ", (str) -> str.substring(2, 5));
        System.out.println(subStr);  //加油，
    }

    //需求：用于处理字符串
    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    private void predicate() {
        System.out.println("Lambda.predicate" + "----------");
        List<String> list = Arrays.asList("Hello", "baidu", "Lambda", "www", "ok");
        List<String> strList = filterStr(list, (s) -> s.length() > 3);

        for (String str : strList) {
            System.out.println(str);
        }
    }

    //将满足条件的字符串，放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();

        for (String str : list) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }

        return strList;
    }

    /**
     * 预定义构造器方法，调用时才会执行
     */
    public void getPerson() {
        System.out.println("Lambda.getPerson" + "---------------");
        //无参,这是使用方法引用实现了抽象方法的对象（返回的是一个被实现了抽象方法的接口的实例）
        PersonCreater creater1 = Person::new;
        //这是调用接口实例的实现方法，返回一个Person对象，分为有参和无参。
        Person person1 = creater1.getPerson();
        System.out.println("Lambda.getPerson" + "----person1 值= " + person1);
        //有参
        PersonCreater2 creater2 = Person::new;
        Person person2 = creater2.getPerson("Fisherman", 18);
        System.out.println("Lambda.getPerson" + "----person2 值= " + person2);
    }

    class Person {
        public String name;
        public int age;

        public Person() {
            System.out.println("Person类的无参构造方法执行了");//语句用于判断无参构造器是否执行了
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
            System.out.println("Person类的有参构造方法执行了");//语句用于判断有参构造器是否执行了
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    interface PersonCreater {
        Person getPerson();
    }

    interface PersonCreater2 {
        Person getPerson(String name, int age);
    }

    /**
     * 在具体方法调用时将对象作为参数输入到方法调用中
     * 增加了多态在方法引用中的便利性
     * 如果采用其他方法引用方式，将产生多个接口的实例，而此方式只需要一个接口的实例
     */
    private void power() {
        System.out.println("Lambda.power" + "----------");
        Power powerObject1 = new PowerOfTwo();
        Power powerObject2 = new PowerOfThree();
        //方法引用的方式
        BiFunction<Power, Integer, Integer> function = Power::power;
        System.out.println("Lambda.power" + "----function.apply。powerObject1值= " +function.apply(powerObject1, 4));//输出"2"的4次方：16
        System.out.println("Lambda.power" + "----function.apply。powerObject2值= " +function.apply(powerObject2, 4));//输出"3"的4次方：81
        //直接接口抽象方法使用
        System.out.println("Lambda.power" + "----powerObject1.power 值= " + powerObject1.power(4));
        System.out.println("Lambda.power" + "----powerObject2.power 值= " + powerObject2.power(4));
    }

    interface Power {
        int power(int i);
    }

    class PowerOfTwo implements Power {
        public int power(int i) {
            return (int) Math.pow(2, i);
        }
    }

    class PowerOfThree implements Power {
        public int power(int i) {
            return (int) Math.pow(3, i);
        }
    }

    /**
     * 1.map(String::toUpperCase),向map方法内传入一个方法引用所形成的接口实现对象
     * 2.<R> Stream<R> map(Function<? super T, ? extends R> mapper);，map是一个返回Stream对象，输入为实现Function接口的对象即1中的方法引用
     * 3.R apply(T t);此是Function接口所要实现的方法，即使用toUpperCase()方法去实现它。
     * 4.public String toUpperCase() { return toUpperCase(Locale.getDefault());}，这是toUpperCase()方法的源码，其是一个无参返回String类对象的非静态方法。
     * 5.接口所需实现的方法的形参T t则对应任意一个String对象。
     */
    private void lowercaseToUppercase(){
        System.out.println("Lambda.lowercaseToUppercase" + "----------");
        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}