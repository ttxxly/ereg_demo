package com.darklovy;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    public static void main(String[] args) throws IOException {
        getNmuber();
    }

    public static void getNmuber() throws IOException {
        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream("d://a.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        FileWriter fw = new FileWriter("d://b.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);



        String str = null;
        int sum = 2273;
        while((str = bufferedReader.readLine()) != null)
        {
            System.out.println(str);
            String s = "\\([0-9]+\\,";
            Pattern p = Pattern.compile(s);
            Matcher m = p.matcher(str);
            if (m.find()) {
                sum++;
                str = str.replaceAll(s, "\\("+sum+"\\,");
            }
            System.out.println(str);
            bw.write(str+"\r\n ");
        }
        //close
        inputStream.close();
        bufferedReader.close();
        bw.close();
        fw.close();
    }

    public static void getData() throws IOException {
        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream("d://a.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        FileWriter fw = new FileWriter("d://b.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        String str = null;
        int sum = 322;
        String CODE = null;
        String NAME = null;
        String TYPE = null;
        String SUBDIVISION = null;
        String DICDESC = null;
        String RESERVE = null;
        String prefix = "insert into td_datadic (ID, CODE, NAME, TYPE, SUBDIVISION, DICDESC, RESERVE) VALUES (2252";
        while((str = bufferedReader.readLine()) != null)
        {
            System.out.println(str);
            String[] split = str.split(",");
            CODE = split[3];
            NAME = split[4];
            TYPE = split[2];
            SUBDIVISION = " NULL";
            DICDESC = split[1];
            RESERVE = " NULL";
            System.out.println(split[0]+"  "+split[1]+"  "+split[2]+"  "+
                    split[3]+"  "+split[4]+"  "+split[5]);
            str = prefix+","+CODE+","+NAME+","+TYPE+","+SUBDIVISION+","+DICDESC+","+RESERVE+");";
            bw.write(str+"\r\n ");

        }
        //close
        inputStream.close();
        bufferedReader.close();
        bw.close();
        fw.close();
    }
}
