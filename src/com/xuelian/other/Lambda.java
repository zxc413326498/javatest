package com.xuelian.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Lambda是一个匿名函数（相似于匿名内部类）,作用是返回一个实现了接口的对象
 * 缩减版的实现方法表达式
 * https://cloud.tencent.com/developer/article/1532870
 *
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
    }

    /**
     * (m) -> System.out.println("大保健，每次消费：" + m + "元") 缩减版的实现方法表达式
     *  m对应抽象方法accept的输入参数
     *  sout即具体实现
     */
    private void consumer(){
        System.out.println("Lambda.consumer" + "----------");
        happy(10000, (m) -> System.out.println("大保健，每次消费：" + m + "元"));
        //
        Consumer<Double> con=(m) -> System.out.println("大保健，每次消费：" + m + "元");
        con.accept(10000D);
    }
    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }

    private void supplier() {
        System.out.println("Lambda.supplier" + "-----------");
        List<Integer> numList = getNumList(10, () -> (int)(Math.random() * 100));
        for (Integer num : numList) {
            System.out.println("Lambda.supplier" + "----num 值= " + num);
        }
        // 另一种写法
        // numList.forEach(e -> System.out.println(e));
    }
    //产生指定个数的整数，并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup){
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
    public String strHandler(String str, Function<String, String> fun){
        return fun.apply(str);
    }

    private void predicate(){
        System.out.println("Lambda.predicate" + "----------");
        List<String> list = Arrays.asList("Hello", "baidu", "Lambda", "www", "ok");
        List<String> strList = filterStr(list, (s) -> s.length() > 3);

        for (String str : strList) {
            System.out.println(str);
        }
    }

    //将满足条件的字符串，放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> strList = new ArrayList<>();

        for (String str : list) {
            if(pre.test(str)){
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
        //无参
        PersonCreater creater1 = Person::new;
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

}