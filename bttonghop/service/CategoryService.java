package bttonghop.controller.service;

import bttonghop.controller.model.Category;
import bttonghop.controller.service.comparerator.CategoryName;

import java.util.Arrays;
import java.util.Scanner;

public class CategoryService {
    public static Category[] categories = new Category[0];
    public static int indexCate = 0;
    //Kiem tra Id
    public static Category findById(int id){
        for(int i =0; i < categories.length;i++){
            if(categories[i].getId() == id){
                return categories[i];
            }
        }
        return null;
    }

    //Them moi danh muc
    public static void addCategory(Scanner sc) {
        System.out.println("Nhập số thể loại bạn muốn thêm");
        int number = Integer.parseInt(sc.nextLine());
        Category[] newCategories = new Category[categories.length + number];
        for (int i = 0; i < categories.length; i++) {
            newCategories[i] = categories[i];
        }
        //c1:
//        int indexCate1 = categories.length;
//        for (int i = 0; i < number; i++) {
//            newCategories[indexCate1 + i] = new Category();
//            newCategories[indexCate1 + i].inputData(sc);
//            categories = newCategories;
//        }
        //c2:
        for (int i = 0; i < number; i++) {
            newCategories[indexCate] = new Category();
            newCategories[indexCate].inputData(sc);
            categories = newCategories;
            indexCate++;
        }
        System.out.println("thêm " + number + " thành công");

    }

    // sap xem theo tang dan ten danh muc A-Z
    public static void listCategory() {
        System.out.println("------------Danh sách--------------");
        Arrays.sort(categories, new CategoryName());
        for (Category category : categories) {
            category.displayData();
        }
    }

    //thong ke the loai va so sach co trong moi the loai
    public static void countCategoryAndBook() {
            for(int i = 0; i < categories.length;i++){
                int count = 0;
                for(int j = 0; j < BookService.books.length;j++){
                    if(BookService.books[j].getCategory().getId() == categories[i].getId()){
                        count++;
                    }
                }
                System.out.printf((i+1) + categories[i].getName() + " có "+count +" cuốn sách\n");
            }
    }

    // cap nhat the loai
    public static void updateCategory(Scanner sc) {
        System.out.println("Nhập mã thể loại bạn muốn cập nhật");
        int number = Integer.parseInt(sc.nextLine());
        boolean check = false;
        for(Category category : categories) {
            if(category.getId() == number){
                check = true;
                category.updateData(sc);
                System.out.println("Cập nhật thành công");
                break;
            }
        }
        if(!check){
            System.err.println("Không tìm thấy danh mục");
        }
    }

    // xoá thể loại
    public static void deleteCategory(Scanner sc){
        System.out.println("Nhập mã thể loại cần xoá");
        int bookId = Integer.parseInt(sc.nextLine());
        if(findById(bookId) != null){
            boolean check = false;
            for(int i = 0; i < BookService.books.length; i++){
                if(BookService.books[i].getCategory().getId() == bookId){
                    check = true;
                    break;
                }
            }
            if(check){
                System.err.println("Không thể xoá thể loại có tồn tại sách");
            }else{
                Category[] newCategory  = new Category[categories.length -1];
                int indexCate = 0;
                for(int i = 0; i < categories.length;i++){
                    if(categories[i].getId() != bookId){
                        newCategory[indexCate] = categories[i];
                        indexCate++;
                    }
                }
                categories = newCategory;
            }
        }else{
            System.err.println("Không tìm thấy thể loại");
        }
    }

}

