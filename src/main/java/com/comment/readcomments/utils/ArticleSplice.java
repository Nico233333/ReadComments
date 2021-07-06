package com.comment.readcomments.utils;

import java.io.*;

public class ArticleSplice {
    public static void main(String[] args) throws Exception {
        //获取运行时路径，通常是jar包所在目录
        String filePath = "C:\\Users\\liuke\\Desktop\\致命武器.txt";
        File file = new File(filePath);
        File[] files = file.listFiles();
        //获取当前系统桌面路径，并在该路径创建novel文件夹，用来存放结果
        File rsPathRoot = new File("novel");
        //新建根路径novel
        if (!rsPathRoot.exists()){
            boolean mkdir = rsPathRoot.mkdir();
            if (mkdir){
                System.out.println(rsPathRoot.getPath()+"创建成功！");
            }
        }
        //获取该路径下的每个文件
        for (File filename : files) {
            readerLine(filename, rsPathRoot);
        }
    }

    private static void readerLine(File file, File rsPathRoot) throws IOException {
        InputStream rs = new FileInputStream(file);
        String name = file.getName().split("\\.")[0];
        System.out.println(name+"分割开始！");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        BufferedReader br = new BufferedReader(new InputStreamReader(rs));
        PrintWriter writer = null;
        String line = "";
        int countLine = 0;
        File rsPath = new File(rsPathRoot.getPath()+"/"+name);
        if (!rsPath.exists()){
            boolean mkdir = rsPath.mkdir();
            if (mkdir){
                System.out.println(rsPath+"创建成功！");
            }
        }
        while ((line = br.readLine())!=null) {
            if (countLine % 500 == 0) {//此处的500是读取500行的意思，即每500行做一个新文件
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
                String filename = name + (countLine / 500);
                writer = new PrintWriter(new File(rsPath+"/"+filename + ".txt"));
                //System.out.println(filename+".txt"+"已经完成");
            }

            writer.println(line);
            ++countLine;
        }

        if (writer != null) {
            writer.flush();
            writer.close();
        }
        System.out.println(name + "--分割完成！");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
        System.out.println();
    }
}