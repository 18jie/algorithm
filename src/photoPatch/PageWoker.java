package photoPatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author fengjie
 * @date 2019:04:24
 */
public class PageWoker {

    private static final String url_prefix = "https://cnsexy.net";

    public void work(List<String> queue, AtomicInteger page) throws IOException {
        URL url = new URL(url_prefix + "/" + page.incrementAndGet());
        InputStream inputStream = null;
        try{
            URLConnection urlConnection = url.openConnection();
            urlConnection.setRequestProperty("User-Agent","Mozilla/5.0");
            inputStream = urlConnection.getInputStream();
        }catch (Exception e){
            return;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        Pattern pattern = Pattern.compile("https://cnsexy.net/\\S*/");
        while((line = reader.readLine()) != null){
            Matcher matcher = pattern.matcher(line);
            while(matcher.find()){
                String group = matcher.group();
                if(!(group.contains("feed") || group.contains("categories") || group.contains("wp-includes") || group.contains("admin") || group.contains("wp-content") || group.contains("css") || group.contains("js") || group.contains("page"))){
                    if(!queue.contains(group)){
                        queue.add(group);
                    }
                }
            }
        }
    }

}
