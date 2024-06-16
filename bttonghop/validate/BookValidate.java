package bttonghop.controller.validate;

import bttonghop.controller.model.Category;
import bttonghop.controller.service.BookService;
import bttonghop.controller.service.CategoryService;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BookValidate {
    public static String inputBookId(Scanner sc) {
        String bookIdRegex = "^B\\w{3}$";
        while (true) {
            System.out.println("Nhập vào mã sách");
            String bookId = sc.nextLine();
            if (Pattern.matches(bookIdRegex, bookId)) {
                boolean check = false;
                for (int i = 0; i<BookService.indexBook;i++) {
                    if (bookId.equals(BookService.books[i].getId())) {
                        System.err.println("Mã sách đã tồn tại");
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    return bookId;
                }
            } else {
                System.err.println("Mã sách phải bắt đầu bằng ký tự B và có độ dài 4 ký tự");
            }
        }
    }

    public static String inputBookTitle(Scanner sc) {
        String titleRegex = "^.{6,50}$";
        while (true) {
            System.out.println("Nhập vào tiêu đề của sách");
            String bookTitle = sc.nextLine();
            if (Pattern.matches(titleRegex, bookTitle)) {
                boolean check = false;
                for (int i = 0; i < BookService.indexBook;i++) {
                    if (bookTitle.equals(BookService.books[i].getTitle())){
                        System.err.println("Tiêu đề đã tồn tại");
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    return bookTitle;
                }
            } else {
                System.err.println("Tiêu đề phải từ 6 -> 50 ký tự");
            }
        }
    }

    public static String inputBookAuthor(Scanner sc) {
        while (true) {
            System.out.println("Nhập tên tác giả");
            String bookAuthor = sc.nextLine();
            if (bookAuthor.trim().isEmpty()) {
                System.err.println("Tên tác giả không được để trống");
            } else {
                return bookAuthor;
            }
        }
    }

    public static int inputYear(Scanner sc) {
        while (true) {
            System.out.println("Nhập năm xuất bản");
            int bookYear = Integer.parseInt(sc.nextLine());
            if (bookYear >= 1970 && bookYear <= LocalDate.now().getYear()) {
                return bookYear;
            } else {
                System.err.println("Năm xuất bản tối thiểu từ năm 1970 và không lớn hơn năm hiện tại");
            }
        }
    }

    public static String inputDescription(Scanner sc) {
        while (true) {
            System.out.println("Nhập mô tả của sách");
            String bookDescription = sc.nextLine();
            if (bookDescription.trim().isEmpty()) {
                System.err.println("Mô tả không được để trống");
            } else {
                return bookDescription;
            }
        }
    }

    public static Category inputBookCategory(Scanner sc) {
        System.out.println("Danh sách thể loại");
        for(Category category: CategoryService.categories){
            System.out.println(category);
        }
        while (true){
            System.out.println("Nhập thể loại bạn muốn");
            int choice = Integer.parseInt(sc.nextLine());
            if(CategoryService.findById(choice) != null){
                return CategoryService.findById(choice);
            }else{
                System.err.println("Bạn phải lựa chọn đúng thể loại, vui lòng nhập lại");
            }
        }
    }
}
