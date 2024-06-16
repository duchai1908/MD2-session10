package bttonghop.controller.validate;

import bttonghop.controller.service.CategoryService;

import java.util.Scanner;

public class CategoryValidate {
    public static int inputCategoryId(){
        if(CategoryService.categories.length >0){
            int maxId = CategoryService.categories[0].getId();
            for(int i = 0; i < CategoryService.indexCate; i++){
                if( maxId < CategoryService.categories[i].getId()){
                    maxId = CategoryService.categories[i].getId();
                }
            }
            return maxId + 1;

        }else{
            return 1;
        }
    }
    public static String inputCategoryName(Scanner sc){
        while (true){
            System.out.println("Nhập tên danh mục");
            String categoryName = sc.nextLine();
            if(categoryName.length() >= 6 && categoryName.length() <= 30){
                boolean check = false;
                for(int i = 0; i < CategoryService.indexCate;i++){
                    if(categoryName.equals(CategoryService.categories[i].getName())){
                        check = true;
                        break;
                    }
                }
                if(!check){
                    return categoryName;
                }else{
                    System.err.println("Tên danh mục đã tồn tại");
                }
            }else{
                System.err.println("Tên danh mục phải từ 6->50 ký tự");
            }
        }
    }
    public static boolean inputCategoryStatus(Scanner sc){
        while (true){
            System.out.println("Nhập trạng thái (true | false): ");
            String categoryStatus = sc.nextLine().toLowerCase();
            if(categoryStatus.equals("true") || categoryStatus.equals("false")){
                return Boolean.parseBoolean(categoryStatus);
            }
            else{
                System.err.println("Vui lòng nhập true hoặc false");
            }
        }
    }
}
