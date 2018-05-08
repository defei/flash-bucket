package org.codelogger.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 通过Java执行命令行指令
 * //TODO 研究在同一个上下文的指令交互
 * @author defei
 * @data 5/7/18.
 */
public class CommandTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        InputStream in = null;
        Runtime runtime  = Runtime.getRuntime();
        while (true) {
            String input = scanner.nextLine();
            if("exit".equals(input)){
                break;
            }
            try {
                String[] commands = {"/bin/sh", "-c", input};
                Process process = runtime.exec(commands);
                process.waitFor();
                in = process.getInputStream();
                BufferedReader read = new BufferedReader(new InputStreamReader(in));
                StringBuilder buf = new StringBuilder();
                String result;
                while ((result = read.readLine()) != null) {
                    buf.append(result).append("\n");
                }
                System.out.println(buf.toString());
            } finally {
                if(in != null){
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
