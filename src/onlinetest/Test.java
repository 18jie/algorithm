package onlinetest;

/**
 * @author fengjie
 * @date 2019:04:18
 */
public class Test {

    public static void main(String[] args) {
        String code = "import java.util.Scanner;\n" +
                "public class HelloWorld{\n" +
                "\tpublic static void main(String[] args){\n" +
                "\t\tScanner sc = new Scanner(System.in);\n" +
                "\t\tfor(int i = 0 ; i < 10 ; i++){\n" +
                "\t\t\tString line = sc.nextLine();\n" +
                "\t\t\tif(i == 5){\n" +
                "\t\t\t\tint j = 1/0;\n" +
                "\t\t\t}\n" +
                "\t\t\tSystem.out.println(line);\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";
        String inputs = "1\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "6\n" +
                "7\n" +
                "8\n" +
                "9\n" +
                "10";
        CustomStringJavaCompiler compiler = new CustomStringJavaCompiler(code);
        boolean res = compiler.compiler();
        if (res) {
            System.out.println("编译成功");
            System.out.println("compilerTakeTime：" + compiler.getCompilerTakeTime());
            try {
                compiler.runMainMethod(inputs.getBytes());
                System.out.println("runTakeTime：" + compiler.getRunTakeTime());
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(compiler.getRunResult());
            System.out.println("诊断信息：" + compiler.getCompilerMessage());
        } else {
            System.out.println("编译失败");
            System.out.println(compiler.getCompilerMessage());
        }
    }

}
