package LinkMySQL;
import java.sql.SQLException;
import java.util.Scanner;
public class Start {
    public static void main(String[] args) throws SQLException, Exception{
        LinkDB linker = new LinkDB();
        Scanner scanner = new Scanner(System.in);
        String str1,str2,str3;
        for (int i = 0; i < 10; i++) {
            System.out.println("请输入ID");
            str1 = scanner.nextLine();
            System.out.println("请输入用户ID");
            str2 = scanner.nextLine();
            System.out.println("请输入权限ID");
            str3 = scanner.nextLine();
            linker.SqlInsert(str1,str2,str3);
        }

    }
}
