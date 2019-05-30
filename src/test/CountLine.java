package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CountLine {
	private static int countLine;

	public static void countCodeLine(List<String> file) {
		if(null == file || file.size() == 0) {
			return;
		}
		List<String> files = new ArrayList<String>();
		file.forEach(one ->{
			File singleFile = new File(one);
			if(singleFile.isFile()) {
//				System.out.println(singleFile.getAbsolutePath());
				try {
					FileReader reader = new FileReader(singleFile);
					BufferedReader buffer = new BufferedReader(reader);
					while(buffer.readLine() != null) {
						countLine++;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				for (File string : singleFile.listFiles()) {
					files.add(string.getAbsolutePath());
				}
			}
		});
		countCodeLine(files);
	}
	
	public static void main(String[] args) {
		List<String> files = new ArrayList<String>();
		files.add("D:\\IDEAWorkplace\\course-program\\src\\main\\java\\com\\fengjie\\courseprogram");
		files.add("D:\\IDEAWorkplace\\course-program\\src\\main\\resources\\templates");
		countCodeLine(files);
		System.out.println(countLine);
	}

}
