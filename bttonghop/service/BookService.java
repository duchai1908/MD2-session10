package bttonghop.controller.service;


import bttonghop.controller.model.Book;

import java.util.Scanner;

public class BookService {
    public static Book[] books = new Book[0];
    public static int indexBook = 0;

    //Kiem tra Id co ton tai khong
    public static Book finById(String id) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId().equals(id)) {
                return books[i];
            }
        }
        return null;
    }

    //Thêm mới sách
    public static void addBook(Scanner sc) {
        System.out.println("Thêm số lượng sách cần thêm");
        int number = Integer.parseInt(sc.nextLine());
        Book[] newBook = new Book[books.length + number];

        for (int i = 0; i < books.length; i++) {
            newBook[i] = books[i];
        }
        for (int i = 0; i < number; i++) {
            newBook[indexBook] = new Book();
            newBook[indexBook].inputData(sc);
            books = newBook;
            indexBook++;
        }
        System.out.println("Thêm " + number + " sách thành công");
    }

    //Hiển thị sách
    public static void listBook() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    //Cập nhật thông tin sách
    public static void updateBook(Scanner sc) {
        if (books.length == 0) {
            System.err.println("Không có sách trong kho");
            return;
        }
        System.out.println("Nhập mã sách bạn muốn update");
        String bookId = sc.nextLine();
        if (finById(bookId) != null) {
            finById(bookId).updateData(sc);
        } else {
            System.err.println("Không tìm thấy sách");
        }
    }

    //Xoá sách
    public static void deleteBook(Scanner sc) {
        if (books.length == 0) {
            System.err.println("Không có sách trong kho");
            return;
        }
        System.out.println("Nhập mã sách cần xoá");
        String bookId = sc.nextLine();
        if (finById(bookId) != null) {
            Book[] newBook = new Book[books.length - 1];
            int indexNewBook = 0;
            for (int i = 0; i < books.length; i++) {
                if (bookId.equals(books[i].getId())) {
                    continue;
                }
                newBook[indexNewBook] = books[i];
                indexNewBook++;
            }
            books = newBook;
            System.out.println("Xoá thành công");
        } else {
            System.err.println("Không tìm thấy sách");
        }
    }

    //Tìm kiếm sách theo tên
    public static void findBook(Scanner sc) {
        System.out.println("Nhập tiêu đề hoặc tác giả cần tìm kiếm");
        String bookName = sc.nextLine();
        for (Book book : books) {
            if (book.getTitle().contains(bookName) || book.getAuthor().contains(bookName)) {
                System.out.println(book);
            }
        }
    }

    //Hiển thị danh sách
    public static void showListBook() {
        for (int i = 0; i < CategoryService.categories.length; i++) {
            System.out.println((i + 1) +". " +CategoryService.categories[i].getName());
            for (int j = 0; j < books.length; j++) {
                if (books[j].getCategory().getId() == CategoryService.categories[i].getId()) {
                    System.out.println("\t" + "-------" + books[j].getTitle() + "\n");
                }
            }
        }
    }
}
