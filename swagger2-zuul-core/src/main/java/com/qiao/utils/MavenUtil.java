package com.qiao.utils;

import org.apache.maven.shared.invoker.*;

import java.io.File;
import java.util.Collections;

/**
 * @Description: 操作maven命令工具包
 * @Created by ql on 2019/5/19/019 08:33
 * @Version: v1.0
 */
public class MavenUtil {

    public static void executeMavenCmd(String command) {
        DefaultInvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile(new File("swagger2-zuul-core/pom.xml"));
        request.setGoals(Collections.singletonList(command));

        DefaultInvoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File("E:\\Java\\develop\\apache-maven-3.5.0"));
        // 只輸出error級別
        invoker.setLogger(new PrintStreamLogger(System.err, InvokerLogger.ERROR));

        // 編譯不提示信息
        invoker.setOutputHandler((str) -> str = "");

        InvocationResult result = null;
        try {
            result = invoker.execute(request);
        } catch (MavenInvocationException e) {
            e.printStackTrace();
        }

        if (result.getExitCode() == 0) {
            System.out.println("success");
        } else {
            System.out.println("error");
        }
    }

}
