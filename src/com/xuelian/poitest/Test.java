package com.xuelian.poitest;

import java.util.List;

public class Test {

    public static void main(String[] args)throws Exception {
        //读文件
        List<List<String>> lists = FileUtil.readFile();
        //写入表格
        POIUtil.writeExcel(null, lists, "D:\\Program Files\\workspace\\other\\11");
    }

}
