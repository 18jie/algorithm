package photoPatch;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Queue;

/**
 * @author fengjie
 * @date 2019:04:25
 */
public class PhotoWorker {

    public void work(Queue<String> urls) throws IOException, InterruptedException {
        if(urls.isEmpty()){
            this.wait();
        }
        String poll = urls.poll();
        URL url = new URL(poll);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent","Mozilla/5.0");
        //解析地址，获得所有的图片地址
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

    }

}
