package test.bitmaptry;

import java.io.*;

/**
 * @author fengjie
 * @date 2019:03:29
 */
public class OutMegrySort {

    private static String path = "C:\\Users\\丰杰\\Desktop\\testoutmargsort\\cutFile";
    private static String cutname = "data";
    private static int size = 1000000;

    private static String result1 = "C:\\Users\\丰杰\\Desktop\\testoutmargsort\\result1.txt";
    private static int total = 0;

    public void mergeSort() throws IOException {
        BufferedReader[] readers = new BufferedReader[10];
        for (int i = 0; i < 10; i++) {
            readers[i] = new BufferedReader(new FileReader(path + "\\" + cutname + i + ".txt"));
        }

        File file = new File(result1);
        file.delete();
        file.createNewFile();
        FileWriter writer = new FileWriter(file);

        int[] data = new int[10];
        for (int i = 0; i < 10; i++) {
            data[i] = Integer.parseInt(readers[i].readLine());
        }

        int index = 0;
        int min;
        while (hasNext(data)) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < data.length; i++) {
                if (data[i] != -1 && data[i] < min) {
                    min = data[i];
                    index = i;
                }
            }
            writer.write(min + "\r\n");
            read(readers, index, data);
        }
        writer.close();
        System.out.println("完成");

    }

    public void read(BufferedReader[] readers, int index, int[] nums) throws IOException {
        String line;
        if ((line = readers[index].readLine()) != null) {
            total++;
            nums[index] = Integer.parseInt(line);
        } else {
            nums[index] = -1;
            readers[index].close();
        }
    }

    public boolean hasNext(int[] nums) {
        for (int num : nums) {
            if (num != -1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        OutMegrySort o = new OutMegrySort();
        long start = System.currentTimeMillis();
        o.mergeSort();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(total);
    }


}
