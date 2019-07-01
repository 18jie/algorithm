package test;

//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author fengjie
 * @date 2019:05:14
 */
public class ExcelReader {

//    public static void read(String path) throws IOException {
//        File excel = new File(path);
//        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(excel));
//        XSSFSheet sheet = workbook.getSheetAt(0);
//        int lastRowNum = sheet.getLastRowNum();
//        System.out.println("行数" + lastRowNum);
//        for (int j = 0; j < lastRowNum; j++) {
//            XSSFRow row = sheet.getRow(j);
//            short cellNum = row.getLastCellNum();
//            for (int i = 0; i < cellNum; i++) {
//                XSSFCell cell = row.getCell(i);
//                System.out.print(cell.getStringCellValue() + " ");
//            }
//            System.out.println();
//        }
//    }

    public static void main(String[] args) throws IOException {
//        read("C:\\Users\\丰杰\\Desktop\\学生.xlsx");
        String token1 = "&%%&\r\n";
        String token1Withoutr = "&%%&";
//        String token2 = "!&##&!";
//        String str = "1 2" + token1 + "3" + token2 + "10 20" + token1 + "30";
//        String[] split = str.split(token2);
//        System.out.println(Arrays.toString(split));
//
//        String[] split1 = split[0].split(token1);
//        System.out.println(Arrays.toString(split1));

        System.out.println(token1.equals(token1Withoutr));
        System.out.println(token1.endsWith("\r\n"));
        System.out.println(token1.length());
        System.out.println(token1.substring(0,token1.length() - 2).equals(token1Withoutr));
    }

}
