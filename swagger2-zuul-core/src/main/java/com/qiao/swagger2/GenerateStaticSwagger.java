package com.qiao.swagger2;

import io.github.robwin.markup.builder.MarkupLanguage;
import io.github.robwin.swagger2markup.GroupBy;
import io.github.robwin.swagger2markup.Swagger2MarkupConverter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Description:
 * @Created by ql on 2019/5/19/019 17:50
 * @Version: v1.0
 */
public class GenerateStaticSwagger {
    private static final String snippetDir = "target/generated-snippets";
    private static final String outputDir  = "target/asciidoc";


    public static void main(String[] args) throws Exception {
        generateSwaggerJsonFile("http://localhost:65003/v2/api-docs");
    }
    
    public static void generateSwaggerJsonFile(String url) throws Exception {
        // 得到swagger.json,写入outputDir目录中
        getSwaggerJSon(url);
        // 读取上一步生成的swagger.json转成asciiDoc,写入到outputDir
        // 这个outputDir必须和插件里面<generated></generated>标签配置一致
        Swagger2MarkupConverter.from(outputDir + "/swagger.json")
                .withPathsGroupedBy(GroupBy.TAGS)// 按tag排序
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)// 格式
                .withExamples(snippetDir)
                .build()
                .intoFolder(outputDir);// 输出
    }

    public static void getSwaggerJSon(String urlPath) {
        InputStream in = null;
        FileOutputStream os = null;
        try {
            URL url = new URL(urlPath);
            in = url.openStream();
            //定义输出的路径
            File saveDir = new File(outputDir);
            if (!saveDir.exists()) {
                saveDir.mkdirs();//创建多重目录
            }
            os = new FileOutputStream(saveDir + "/swagger.json");
            //创建缓冲区
            byte buffer[] = new byte[1024];
            int len = 0;
            // 循环将输入流中的内容读取到缓冲区当中
            while ((len = in.read(buffer)) > 0) {
                os.write(buffer, 0, len);
            }
        } catch (Exception e) {

        } finally {
            try {
                in.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
