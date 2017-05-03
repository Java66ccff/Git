package com.api;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by soft01 on 2017/5/2.
 */
public class Util {

    private static File file;
    private static int status;
    static {
        file=new File("D:/MyGit/Git/simple-service-webapp/date.txt");
    }
    /*
      写入数据
     */

    public static int getStatus() {
        return status;
    }

    public static void  getFile(User user){

        try {
            FileOutputStream fos=new FileOutputStream(file,true);
            BufferedOutputStream bos=new BufferedOutputStream(fos);
            OutputStreamWriter osw=new OutputStreamWriter(bos,"utf-8");
            PrintWriter pw= new PrintWriter(osw);
            String jsonString = JSON.toJSONString(user);
            pw.println(jsonString+"\n");
            System.out.println(jsonString);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("存mmp");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("创建mmp");
        }
    }

    /*
      根据name判断文件中有无这个name
      有：返回list<name,json>
      无：null
     */
    public static List<User> isName(String name){
        String json;
        List<User> result=new ArrayList<>();
        try {
            FileInputStream fis=new FileInputStream(file);
            BufferedInputStream bis=new BufferedInputStream(fis);
            InputStreamReader isr=new InputStreamReader(bis,"utf-8");
            BufferedReader br=new BufferedReader(isr);
            while ((json=br.readLine())!=null){
                User user= JSON.parseObject(json,User.class);
//                System.out.println(user.getName());
                if(name.equals(user.getName())){
                    result.add(user);
                    status=200;
//                    System.out.println(result+","+status);
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            status=300;
            throw new RuntimeException("无文件mmp");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            status=400;
            throw new RuntimeException("转码mmp");
        } catch (IOException e) {
            e.printStackTrace();
            status=500;
            throw new RuntimeException("读mmp");
        }finally {
            System.out.println("dasdasd");
            return result;
        }
    }
}
