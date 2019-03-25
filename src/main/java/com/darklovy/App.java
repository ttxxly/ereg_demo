package com.darklovy;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    public static void main(String[] args) throws IOException {
        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream("d://a.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        FileWriter fw = new FileWriter("d://b.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);



        String str = null;
        int sum = 322;
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
}
