package photoPatch;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author fengjie
 * @date 2019:04:24
 */
public class Main {

    private Queue<String> queue = new ConcurrentLinkedDeque<>();

    public static void main(String[] args) throws IOException {



//        getPhotes();

    }

    public static void getPhotes() throws IOException {
        URL url = new URL("https://cnsexy.net/wp-content/uploads/2019/04/11-1.jpg");
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent","Mozilla/5.0");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedInputStream buffer = new BufferedInputStream(inputStream);
        byte[] date = new byte[1024];
        int off = 0;
        File file = new File("C:\\Users\\丰杰\\Desktop\\photos\\11-2.jpg");
        file.delete();
        file.createNewFile();
        FileOutputStream outputStream = new FileOutputStream(file,true);
        while((off = buffer.read(date)) != -1){
            outputStream.write(date,0,off);
            outputStream.flush();
        }
        outputStream.close();
//        byte[] date = new byte[inputStream.available()];
//        inputStream.read(date);
//        System.out.println(date.length);




        System.out.println("下载完成");
    }

}
