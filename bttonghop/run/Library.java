package bttonghop.controller.run;

import bttonghop.controller.BookController;
import bttonghop.controller.CategoryController;

import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("=============Quản Lý Thư Viện==============");
            System.out.println("1.Quản lý thể loại");
            System.out.println("2.Quản lý sách");
            System.out.println("3.Thoát");
            System.out.println("Lựa chọn của bạn: ");
            byte choice = Byte.parseByte(sc.nextLine());
            switch(choice){
                case 1:
                    CategoryController.showMenuCategory(sc);
                    break;
                case 2:
                    BookController.showMenuBook(sc);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập lựa chọn từ 1 -> 3");
            }
        }

    }
}
