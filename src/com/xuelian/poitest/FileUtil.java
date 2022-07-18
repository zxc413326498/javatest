package com.xuelian.poitest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {


    public static  List<List<String>> readFile() {
        List<List<String>> result = new ArrayList<List<String>>();
        try {
            FileInputStream fis = new FileInputStream(new File("src/test.txt"));
            InputStreamReader reader = new InputStreamReader(fis,"UTF8");
            BufferedReader br = new BufferedReader(reader);
//            DataInputStream dis = new DataInputStream(fis);

            String row;
            while((row = br.readLine()) != null) {
//                while((row = dis.readLine()) != null) {
                if (row.trim().startsWith("column")) {
                    String[] rows=null;
                    if(row.trim().contains("'"))
                        rows = row.trim().split("'");
                    if(row.trim().contains("\""))
                        rows = row.trim().split("\"");

                    List<String> row1 = new ArrayList<String>();
                    //从第一列开始去掉id列
                    for (int i = 0; i < (rows.length - 1) / 2; i++) {
                        row1.add(rows[i * 2 + 1]);
                    }
                    result.add(row1);
                }
            }
//            fis.close();
//            dis.close();
        } catch (IOException e) {
            e.fillInStackTrace();

        }finally {

        }

        return result;
    }
//    /**
//     * 获取表中字段的所有注释
//     * @return
//     */
//    public static List<String> getColumnComments() {
//        List<String> columnTypes = new ArrayList<>();
//        //与数据库的连接
//        Connection conn = getConnection();
//        PreparedStatement pStemt = null;
//        String tableSql = "SELECT * FROM " + tableName;
//        List<String> columnComments = new ArrayList<>();//列名注释集合
//        ResultSet rs = null;
//        try {
//            pStemt = conn.prepareStatement(tableSql);
//            rs = pStemt.executeQuery("show full columns from " + tableName);
//            while (rs.next()) {
//                columnComments.add(rs.getString("Comment"));
//            }
//            //去掉第一列的id
//            columnComments.remove(0);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (rs != null) {
//                try {
//                    rs.close();
//                    closeConnection(conn);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return columnComments;
//    }
//
//    /**
//     * 获取数据库表中的数据,查询出来的每一行封装成一个list
//     * @param selectSQL
//     * @return
//     */
//    public static List<List<String>> selectRowToList(String selectSQL) {
//        List<List<String>> result = new ArrayList<List<String>>();
//
//
//        try {
//            pst = (PreparedStatement) conn.prepareStatement(selectSQL);
//            ResultSet rs = pst.executeQuery();
//            //获取元数据
//            ResultSetMetaData rmd = rs.getMetaData();
//            //获取总的列数
//            int columnCount = rmd.getColumnCount();
//            while (rs.next()) {
//                List<String> row = new ArrayList<String>();
//                //从第一列开始去掉id列
//                for (int i = 1; i < columnCount; i++) {
//                    row.add(rs.getObject(i+1).toString());
//                }
//                result.add(row);
//            }
//        } catch (Exception e) {
//            System.out.println("execute selectSQL failure ");
//        } finally {
//            closeConnection(conn);
//        }
//        return result;
//        /*1   周星驰   45
//          2   刘德华   44*/
//    }
//
//    /**
//     * 按字段别名拼装结果,每行数据返回一个map
//     * @return
//     */
//    public static List<Map<String, Object>> selectRowToMap(String selectSQL) {
//        Connection conn = getConnection();
//        PreparedStatement pst = null;
//        // 定义一个list用于接受数据库查询到的内容
//        List<Map<String, Object>> list = new ArrayList<>();
//        try {
//            pst = (PreparedStatement) conn.prepareStatement(selectSQL);
//            ResultSet rs = pst.executeQuery();
//            //获取元数据
//            ResultSetMetaData rmd = rs.getMetaData();
//            //获取总的列数
//            int columnCount = rmd.getColumnCount();
//            while (rs.next()) {
//                Map<String, Object> rsMap = new LinkedHashMap<String, Object>();
//                //从1列开始,去掉id列
//                for (int i = 1; i < columnCount; i++) {
//                    //循环每一列，并取得该列的值，以别名方式
//                    rsMap.put(rmd.getColumnLabel(i+1), rs.getString(i+1));
//                }
//                list.add(rsMap);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            closeConnection(conn);
//        }
//        return list;
//        /* id=====1   name=====周星驰   age=====45
//          id=====2   name=====刘德华   age=====44*/
//    }
//
}
