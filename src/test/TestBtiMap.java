package test;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 * @author fengjie
 * @date 2019:03:29
 */
public class TestBtiMap {
    private static String fileName = "C:\\Users\\丰杰\\Desktop\\testoutmargsort\\totalData.txt";
    private static String path = "C:\\Users\\丰杰\\Desktop\\testoutmargsort\\cutFile";
    private static String cutname = "data";
    private static int size = 1000000;

    public static void main(String[] args) throws IOException {
        makeFile();
        cutFile();
    }

    public static void makeFile() throws IOException {
        File file = new File(fileName);
        file.delete();
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        Random random = new Random();
        for (int i = 0; i < 10000000; i++) {
            writer.write(random.nextInt(Integer.MAX_VALUE) + "\r\n");
        }
        writer.close();
        System.out.println("写入完成");
    }

    public static void cutFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        int index = 0;

        for (int i = 0; i < 10; i++) {
            File file = new File(path + "\\" + cutname + i + ".txt");
            file.delete();
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            int[] nums = new int[size];
            for (int j = 0; j < size; j++) {
                line = reader.readLine();
                index++;
                nums[j] = Integer.parseInt(line);
            }
            Arrays.sort(nums);
            for (int j = 0; j < size; j++) {
                writer.write(nums[j] + "\r\n");
            }
            writer.close();
        }
        System.out.println("分割完成" + index);
    }


}
