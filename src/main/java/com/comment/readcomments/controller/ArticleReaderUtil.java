package com.comment.readcomments.controller;

import com.comment.readcomments.utils.Article;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ArticleReaderUtil {
    /**
     * 功能：Java读取txt文件的内容
     * 步骤：1：先获得文件句柄
     * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流
     * 4：一行一行的输出。readline()。
     * 备注：需要考虑的是异常情况
     */
    public static List<Article> readTxtFile(){
        String filePath = "C:\\Users\\liuke\\Desktop\\致命武器.txt";
        List<Article> articles=new ArrayList<>();
        try {
            String encoding="UTF-8";
            File file=new File(filePath);
            StringBuilder builder=new StringBuilder();
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                Pattern p = Pattern.compile("(^\\s*第)(.{1,9})[章节卷集部篇回](\\s{1})(.*)($\\s*)");
                Article article=new Article();
                int i=-1;
                while((lineTxt = bufferedReader.readLine()) != null){
                    if (p.matcher(lineTxt).find()){
                        if (i<0){
                            article.setChapter(lineTxt);
                            articles.add(article);
                            i++;
                        }
                        else {
                            articles.get(i).setSentence(builder.toString().split("。"));
                            builder=new StringBuilder();
                            article=new Article();
                            article.setChapter(lineTxt);
                            articles.add(article);
                            i++;
                        }
                    }
                    else
                    {
                        builder.append(lineTxt);
                    }
                }
                articles.get(i).setSentence(builder.toString().split("。"));
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    return articles;
    }

}
