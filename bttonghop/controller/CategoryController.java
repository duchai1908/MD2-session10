package bttonghop.controller;

import bttonghop.controller.service.CategoryService;

import java.util.Scanner;

public class CategoryController {
    public static void showMenuCategory(Scanner sc) {
        while (true){
            System.out.println("===============Quản lý thể loại===================");
            System.out.println("1.Thêm mới thể loại");
            System.out.println("2.Hiển thị danh sách theo tên thể loại A-Z");
            System.out.println("3.Thống kê thể loại và số sách trong mỗi thể loại");
            System.out.println("4.Cập nhật thể loại");
            System.out.println("5.Xoá thể loại (Kiểm tra tồn tại sách trước khi xoá");
            System.out.println("6.Quay lại");
            System.out.println("Lựa chọn của bạn: ");
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1:
                    CategoryService.addCategory(sc);
                    break;
                case 2:
                    CategoryService.listCategory();
                    break;
                case 3:
                    CategoryService.countCategoryAndBook();
                    break;
                case 4:
                    CategoryService.updateCategory(sc);
                    break;
                case 5:
                    CategoryService.deleteCategory(sc);
                    break;
                case 6:
                    return;
                default:
                    System.err.println("Lựa chọn không hợp lệ, chọn từ 1->6");
            }
        }
    }
}
