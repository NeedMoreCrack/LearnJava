package webcrawler;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler1 {
    public static void main(String[] args) throws IOException {
        String web = "https://invoice.etax.nat.gov.tw/";
        System.out.println(webCrawler(web));
    }
    public static List<String> webCrawler(String webUrl) throws IOException {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        URL url = new URL(webUrl);
        URLConnection conn = url.openConnection();
        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
        char[] b = new char[8192];
        int len;
        while((len=isr.read(b)) != -1){
            sb.append(b,0,len);
        }
        Pattern pattern = Pattern.compile("font-weight-bold etw-color-red\">(\\d{8})<|<span class=\"font-weight-bold\">(\\d{5})<|etw-color-red\">(\\d{3})<");
        Matcher matcher = pattern.matcher(sb.toString());
        while(matcher.find()){
            if(matcher.group(1) != null){
                sb2.append(matcher.group(1)).append(",");
            }else if(matcher.group(2) != null){
                sb2.append(matcher.group(2)).append(",");
            }else if(matcher.group(3) != null){
                sb2.append(matcher.group(3));
            }
        }
        list.add(sb2.toString());
        return list;
    }
}
