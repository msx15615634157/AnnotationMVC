package orz.doublexi.pojo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author ：mengshx
 * @date ：Created in 2020/11/29 10:37
 * @description：小说实体
 */
public class Story {

    private String name;
    BufferedReader bufferedReader;
    ArrayList<String> content = new ArrayList<>(1024000);
    private boolean status;
    private int nowPage=1;


    public Story(String name){
        InputStream stream = Story.class.getClassLoader().getResourceAsStream(name);
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(stream,"utf-8");
            bufferedReader = new BufferedReader(reader);
            String s = bufferedReader.readLine();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String temp = "";
                    try {
                        while ((temp = bufferedReader.readLine()) != null) {
                            content.add(temp);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("读取失败");
        }


    }

    public String readPage(int pageNum) {
        String temp = "<p>";
        int form = (pageNum - 1) * 100;
        int to = pageNum * 100;
        for (; form < to; form++) {
            temp = temp + content.get(form)+"<br/>";
        }
        temp = temp + "</p>";
        return temp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

}
