package bttonghop.controller;

import bttonghop.controller.service.BookService;

import java.util.Scanner;

public class BookController {
    public static void showMenuBook(Scanner sc) {
        while (true) {
            System.out.println("===============Quản lý thể loại===================");
            System.out.println("1.Thêm mới sách");
            System.out.println("2.Cập nhật thông tin sách");
            System.out.println("3.Xoá sách");
            System.out.println("4.Tìm kiếm sách");
            System.out.println("5.Hiển thị danh sách theo nhóm thể loại");
            System.out.println("6.Quay lại");
            System.out.println("==================================================");
            System.out.println("Lựa chọn của bạn");
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1:
                    BookService.addBook(sc);
                    break;
                case 2:
                    BookService.updateBook(sc);
                    break;
                case 3:
                    BookService.deleteBook(sc);
                    break;
                case 4:
                    BookService.findBook(sc);
                    break;
                case 5:
                    BookService.showListBook();
                    break;
                case 6:
                    return;
                case 7:
                    BookService.listBook();
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ, vui lòng nhập từ 1 -> 6");
            }
        }
    }
}
