package test.bitmaptry;

import java.io.*;

/**
 * @author fengjie
 * @date 2019:03:29
 */
public class BigMapTry {

    private static String fileName = "C:\\Users\\丰杰\\Desktop\\testoutmargsort\\totalData.txt";
    private static String resultFileName = "C:\\Users\\丰杰\\Desktop\\testoutmargsort\\result.txt";
    private int size = 50000000;

    public void bigmapSort() throws IOException {
        FileReader reader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(reader);

        FileWriter writer = new FileWriter(resultFileName,true);
        byte[] bitMap = new byte[size];
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            int num = Integer.parseInt(line);
            if (num < size) {
                bitMap[num] = 1;
            }
        }
        File file = new File(resultFileName);
        if (!file.exists()) {
            file.createNewFile();
        }

        for (int i = 0; i < size; i++) {
            if (bitMap[i] == 1) {
                writer.write(i + "\r\n");
            }
        }

        bitMap = new byte[size];
        System.gc();
        System.gc();

        while ((line = bufferedReader.readLine()) != null) {
            int num = Integer.parseInt(line);
            if (num >= size && num < size * 2) {
                bitMap[num - size] = 1;
            }
        }

        for (int i = 0; i < size; i++) {
            if (bitMap[i] == 1) {
                writer.write(i + size + "\r\n");
            }
        }
        writer.close();
        System.out.println("排序完成");
    }

    public static void main(String[] args) throws IOException {
        BigMapTry b = new BigMapTry();
        b.bigmapSort();
    }

}
