package com.xuelian.other;

import com.alibaba.fastjson.JSONObject;
import com.xuelian.entity.Person;
import javafx.util.Pair;

import java.util.*;
//import java.util.function.BinaryOperator;
//import java.util.stream.Collectors;

public class javaTest {

    public static void main(String[] args) throws Exception {
        //
//        pairToMap();
        //
//        collectingAndThen();
        //
//        reducing();

        String objectStr = "{\n" +
                "    \"msg\": \"操作成功\",\n" +
                "    \"code\": 200,\n" +
                "    \"permissions\": [\n" +
                "        \"system:user:resetPwd\",\n" +
                "        \"system:project:team\",\n" +
                "        \"system:moment:add\",\n" +
                "        \"system:type:edit\",\n" +
                "        \"system:dept:remove\",\n" +
                "        \"system:project:remove\",\n" +
                "        \"system:projectTemplate:add\",\n" +
                "        \"system:user:query\",\n" +
                "        \"system:user:add\",\n" +
                "        \"system:doctype:edit\",\n" +
                "        \"system:user:export\",\n" +
                "        \"system:projectDoc:delete\",\n" +
                "        \"system:role:remove\",\n" +
                "        \"system:worktime:edit\",\n" +
                "        \"system:client:query\",\n" +
                "        \"system:dept:query\",\n" +
                "        \"system:contractor:query\",\n" +
                "        \"system:project:detail\",\n" +
                "        \"system:type:add\",\n" +
                "        \"system:moment:remove\",\n" +
                "        \"system:role:editCost\",\n" +
                "        \"system:worktime:add\",\n" +
                "        \"system:project:edit\",\n" +
                "        \"system:client:remove\",\n" +
                "        \"system:projectDoc:download\",\n" +
                "        \"system:project:close\",\n" +
                "        \"system:moment:edit\",\n" +
                "        \"system:client:add\",\n" +
                "        \"system:user:remove\",\n" +
                "        \"system:project:addChild\",\n" +
                "        \"system:project:backup\",\n" +
                "        \"system:client:list\",\n" +
                "        \"system:role:list\",\n" +
                "        \"system:contractor:add\",\n" +
                "        \"system:contractor:edit\",\n" +
                "        \"system:user:import\",\n" +
                "        \"system:project:add\",\n" +
                "        \"system:user:edit\",\n" +
                "        \"system:role:edit\",\n" +
                "        \"system:dept:list\",\n" +
                "        \"system:doctype:remove\",\n" +
                "        \"system:project:start\",\n" +
                "        \"system:doctype:add\",\n" +
                "        \"system:contractor:list\",\n" +
                "        \"system:role:add\",\n" +
                "        \"system:projectDoc:upload\",\n" +
                "        \"system:dept:edit\",\n" +
                "        \"system:user:list\",\n" +
                "        \"system:contractor:remove\",\n" +
                "        \"system:client:edit\",\n" +
                "        \"system:role:export\",\n" +
                "        \"system:worktime:remove\",\n" +
                "        \"system:projectDirector:update\",\n" +
                "        \"system:projectMoment:add\",\n" +
                "        \"system:role:query\",\n" +
                "        \"system:dept:add\"\n" +
                "    ],\n" +
                "    \"roles\": [\n" +
                "        \"SysAdmin\",\n" +
                "        \"zjdb\",\n" +
                "        \"ceo\",\n" +
                "        \"xmzj\",\n" +
                "        \"engineer\"\n" +
                "    ],\n" +
                "    \"user\": {\n" +
                "        \"searchValue\": null,\n" +
                "        \"createBy\": \"admin2\",\n" +
                "        \"createTime\": \"2021-02-01 11:39:28\",\n" +
                "        \"updateBy\": null,\n" +
                "        \"updateTime\": null,\n" +
                "        \"remark\": null,\n" +
                "        \"params\": {},\n" +
                "        \"userId\": 3,\n" +
                "        \"deptId\": 100,\n" +
                "        \"userName\": \"8001\",\n" +
                "        \"nickName\": \"邓晓明\",\n" +
                "        \"email\": null,\n" +
                "        \"phonenumber\": \"13811111111\",\n" +
                "        \"sex\": \"0\",\n" +
                "        \"avatar\": \"\",\n" +
                "        \"salt\": null,\n" +
                "        \"status\": \"0\",\n" +
                "        \"delFlag\": \"0\",\n" +
                "        \"loginIp\": null,\n" +
                "        \"loginDate\": null,\n" +
                "        \"dept\": {\n" +
                "            \"searchValue\": null,\n" +
                "            \"createBy\": null,\n" +
                "            \"createTime\": null,\n" +
                "            \"updateBy\": null,\n" +
                "            \"updateTime\": null,\n" +
                "            \"remark\": null,\n" +
                "            \"params\": {},\n" +
                "            \"deptId\": 100,\n" +
                "            \"parentId\": 0,\n" +
                "            \"ancestors\": null,\n" +
                "            \"deptName\": \"恒普总公司\",\n" +
                "            \"orderNum\": \"0\",\n" +
                "            \"leader\": \"若依\",\n" +
                "            \"phone\": null,\n" +
                "            \"email\": null,\n" +
                "            \"status\": \"0\",\n" +
                "            \"delFlag\": null,\n" +
                "            \"parentName\": null,\n" +
                "            \"children\": []\n" +
                "        },\n" +
                "        \"roles\": [\n" +
                "            {\n" +
                "                \"searchValue\": null,\n" +
                "                \"createBy\": null,\n" +
                "                \"createTime\": null,\n" +
                "                \"updateBy\": null,\n" +
                "                \"updateTime\": null,\n" +
                "                \"remark\": null,\n" +
                "                \"params\": {},\n" +
                "                \"roleId\": 61,\n" +
                "                \"roleName\": \"系统管理员\",\n" +
                "                \"roleKey\": \"SysAdmin\",\n" +
                "                \"roleSort\": \"99\",\n" +
                "                \"dataScope\": \"1\",\n" +
                "                \"menuCheckStrictly\": false,\n" +
                "                \"deptCheckStrictly\": false,\n" +
                "                \"status\": \"0\",\n" +
                "                \"delFlag\": null,\n" +
                "                \"flag\": false,\n" +
                "                \"menuIds\": null,\n" +
                "                \"deptIds\": null,\n" +
                "                \"admin\": false\n" +
                "            },\n" +
                "            {\n" +
                "                \"searchValue\": null,\n" +
                "                \"createBy\": null,\n" +
                "                \"createTime\": null,\n" +
                "                \"updateBy\": null,\n" +
                "                \"updateTime\": null,\n" +
                "                \"remark\": null,\n" +
                "                \"params\": {},\n" +
                "                \"roleId\": 100,\n" +
                "                \"roleName\": \"总经理\",\n" +
                "                \"roleKey\": \"ceo\",\n" +
                "                \"roleSort\": \"0\",\n" +
                "                \"dataScope\": \"1\",\n" +
                "                \"menuCheckStrictly\": false,\n" +
                "                \"deptCheckStrictly\": false,\n" +
                "                \"status\": \"0\",\n" +
                "                \"delFlag\": null,\n" +
                "                \"flag\": false,\n" +
                "                \"menuIds\": null,\n" +
                "                \"deptIds\": null,\n" +
                "                \"admin\": false\n" +
                "            },\n" +
                "            {\n" +
                "                \"searchValue\": null,\n" +
                "                \"createBy\": null,\n" +
                "                \"createTime\": null,\n" +
                "                \"updateBy\": null,\n" +
                "                \"updateTime\": null,\n" +
                "                \"remark\": null,\n" +
                "                \"params\": {},\n" +
                "                \"roleId\": 106,\n" +
                "                \"roleName\": \"总监代表\",\n" +
                "                \"roleKey\": \"zjdb\",\n" +
                "                \"roleSort\": \"6\",\n" +
                "                \"dataScope\": \"1\",\n" +
                "                \"menuCheckStrictly\": false,\n" +
                "                \"deptCheckStrictly\": false,\n" +
                "                \"status\": \"0\",\n" +
                "                \"delFlag\": null,\n" +
                "                \"flag\": false,\n" +
                "                \"menuIds\": null,\n" +
                "                \"deptIds\": null,\n" +
                "                \"admin\": false\n" +
                "            },\n" +
                "            {\n" +
                "                \"searchValue\": null,\n" +
                "                \"createBy\": null,\n" +
                "                \"createTime\": null,\n" +
                "                \"updateBy\": null,\n" +
                "                \"updateTime\": null,\n" +
                "                \"remark\": null,\n" +
                "                \"params\": {},\n" +
                "                \"roleId\": 107,\n" +
                "                \"roleName\": \"项目总监\",\n" +
                "                \"roleKey\": \"xmzj\",\n" +
                "                \"roleSort\": \"7\",\n" +
                "                \"dataScope\": \"1\",\n" +
                "                \"menuCheckStrictly\": false,\n" +
                "                \"deptCheckStrictly\": false,\n" +
                "                \"status\": \"0\",\n" +
                "                \"delFlag\": null,\n" +
                "                \"flag\": false,\n" +
                "                \"menuIds\": null,\n" +
                "                \"deptIds\": null,\n" +
                "                \"admin\": false\n" +
                "            },\n" +
                "            {\n" +
                "                \"searchValue\": null,\n" +
                "                \"createBy\": null,\n" +
                "                \"createTime\": null,\n" +
                "                \"updateBy\": null,\n" +
                "                \"updateTime\": null,\n" +
                "                \"remark\": null,\n" +
                "                \"params\": {},\n" +
                "                \"roleId\": 108,\n" +
                "                \"roleName\": \"监理工程师\",\n" +
                "                \"roleKey\": \"engineer\",\n" +
                "                \"roleSort\": \"10\",\n" +
                "                \"dataScope\": \"1\",\n" +
                "                \"menuCheckStrictly\": false,\n" +
                "                \"deptCheckStrictly\": false,\n" +
                "                \"status\": \"0\",\n" +
                "                \"delFlag\": null,\n" +
                "                \"flag\": false,\n" +
                "                \"menuIds\": null,\n" +
                "                \"deptIds\": null,\n" +
                "                \"admin\": false\n" +
                "            }\n" +
                "        ],\n" +
                "        \"roleIds\": null,\n" +
                "        \"postIds\": null,\n" +
                "        \"admin\": false\n" +
                "    }\n" +
                "}";
        String arrayStr = "[{\"name\":\"JSON\",\"age\":\"24\",\"address\":\"北京市西城区\"}]";
        //1、使用JSONObject
        JSONObject jsonObject = JSONObject.parseObject(objectStr);
        Object object = jsonObject.get("user");
        System.out.println(object);
    }

    /**
     * note:在使用 java.util.stream.Collectors 类的 toMap()方法转为 Map 集合时，一定要使用含有参数类型为 BinaryOperator
     * ，参数名为 mergeFunction 的方法，否则当出现相同 key值时会抛出 IllegalStateException 异常。
     * 说明：参数 mergeFunction 的作用是当出现 key 重复时，自定义对 value 的处理策略。
     */
//    public static void pairToMap() {
//
//        //pair -> map
//        // Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,Function<? super T, ? extends U> valueMapper
//        // ,BinaryOperator<U> mergeFunction)
//        // mergeFunction 合并操作，如果key相同则进行自定义的操作 (v1, v2) -> v2) lambda合并，只要第二个数
//        List<Pair<String, Double>> pairArrayList = new ArrayList<>(3);
//        pairArrayList.add(new Pair<>("version", 12.10));
//        pairArrayList.add(new Pair<>("version", 12.19));
//        pairArrayList.add(new Pair<>("version", 6.28));
//        Map<String, Double> map = pairArrayList.stream().collect(
//                // 生成的 map 集合中只有一个键值对：{version=6.28}
//                Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));
//        System.out.println(map.toString());
//
//        //
//        pairArrayList.clear();
//        pairArrayList.add(new Pair<>("version0", 12.10));
//        pairArrayList.add(new Pair<>("version1", 12.19));
//        pairArrayList.add(new Pair<>("version1", 6.28));
//        Map<String, Double> map1 = pairArrayList.stream().collect(
//                //没有mergeFunction参数时，key相同会报错
//                Collectors.toMap(Pair::getKey, Pair::getValue));
//        System.out.println(map1.toString());
//
//        //lambda数据操作
//        BinaryOperator<Integer> add = (n1, n2) -> n1 + n2;
//        //apply方法用于接收参数，并返回BinaryOperator中的Integer类型
//        System.out.println(add.apply(3, 4));
//    }
//
//    static void collectingAndThen() {
//
//        List<String> servers = new ArrayList<>();
//        servers.add("Felordcn");
//        servers.add("Tomcat");
//        servers.add("Jetty");
//        servers.add("Undertow");
//        servers.add("Resin");
//
//        servers.stream().collect(Collectors.collectingAndThen(Collectors.joining(","), String::toUpperCase));
//
//        servers.toString();
//    }
//
//    /**
//     * 统计每个城市个子最高的人
//     * note:比如我们给出高于 2 米 的人作为 identity。 我们就可以统计每个城市不低于 2 米 而且最高的那个人
//     * ，当然如果该城市没有人高于 2 米则返回基准值identity
//     */
//    static void reducing() {
//        //模拟数据
//        List<Person> persons = new ArrayList<>();
//        for (int i = 1; i < 10; i++) {
//            Person person = new Person();
//            person.setName("sjq" + i);
//            person.setHeight(3 * Math.random());
//            person.setCity("北京");
//            if (i < 5)
//                person.setCity("武汉");
//            if (i > 7)
//                person.setCity("上海");
//            persons.add(person);
//        }
//        //
//        Comparator<Person> byHeight = Comparator.comparing(Person::getHeight);
//        Person identity = new Person();
//        identity.setHeight(2);
//        identity.setName("identity");
//        identity.setCity("武汉");
//        Map<String, Person> collect = persons.stream()
//                .collect(Collectors.groupingBy(Person::getCity, Collectors.reducing(identity, BinaryOperator.maxBy(byHeight))));
//
//        System.out.println(collect.toString());
//    }
}
