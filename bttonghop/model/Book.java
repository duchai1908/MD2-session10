package bttonghop.controller.model;

import bttonghop.controller.interfaceLibrary.Ilibrary;
import bttonghop.controller.validate.BookValidate;

import java.util.Scanner;

public class Book implements Ilibrary {
    private String id,title,author,description;
    private int year;
    private Category category;

    public Book() {
    }

    public Book(String id, String title, String author, String description, int year, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.year = year;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public void inputData(Scanner sc) {
        this.id = BookValidate.inputBookId(sc);
        this.title = BookValidate.inputBookTitle(sc);
        this.author = BookValidate.inputBookAuthor(sc);
        this.year = BookValidate.inputYear(sc);
        this.description = BookValidate.inputDescription(sc);
        this.category = BookValidate.inputBookCategory(sc);
    }
    public void updateData(Scanner sc) {
        this.title = BookValidate.inputBookTitle(sc);
        this.author = BookValidate.inputBookAuthor(sc);
        this.year = BookValidate.inputYear(sc);
        this.description = BookValidate.inputDescription(sc);
        this.category = BookValidate.inputBookCategory(sc);
    }
    @Override
    public void displayData() {
        System.out.println("Mã sách: "+this.id);
        System.out.println("Tiêu đề: "+this.title);
        System.out.println("Tác giả: "+this.author);
        System.out.println("Năm xuất bản: "+this.year);
        System.out.println("Mô tả: "+this.description);
        System.out.println("Thể loại: "+this.category.getName());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", category=" + category +
                '}';
    }
}
