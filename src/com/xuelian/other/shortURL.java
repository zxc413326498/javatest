package com.xuelian.other;

public class shortURL {
    //62个字符 0-61
    public static final String[] chars= new String[]{
            "a","b","c","d","e","f","g","h","i", "j","k","l","m",
            "n","o","p","q","r","s","t","u","v","w","x","y","z",
            "0","1","2","3","4","5","6","7","8","9",
            "A","B","C","D","E","F","G","H","I", "J","K","L","M",
            "N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    public static void main(String[] args)throws Exception {

        //网址转短链接
        String hex="566ab90fc1bb2c6544ac4353f0d0a364";
        String[] resUrl=new String[4];
        for(int i=0;i<4;i++){
            String substr=hex.substring(i*8,i*8+8);

            long hexlong=0x3FFFFFFF & Long.parseLong(substr,16);

            String outchar="";

            for(int j=0;j<5;j++){
                long index=0x0000003D & hexlong;
                outchar +=chars[(int)index];
                //
                String str=Long.toBinaryString(hexlong);
                System.out.println("bf>>>"+str);

                hexlong=hexlong>>6;
                //
                str=Long.toBinaryString(hexlong);
                System.out.println("af>>>"+str);
            }
            resUrl[i]=outchar;
            System.out.println("outchar>>>"+outchar);
        }
    }
}
