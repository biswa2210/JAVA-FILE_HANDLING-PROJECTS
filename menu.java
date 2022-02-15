import java.util.Scanner;
import operations.*;
public class menu {

    public static void main(String args[]){

        addBook obj1=new addBook();
        borrowBook obj2=new borrowBook();
        searchStudent obj3=new searchStudent();
        showTotal obj4=new showTotal();
        showBorrow obj5=new showBorrow();
        searchBooks obj6=new searchBooks();
        updateQuantity obj7=new updateQuantity();
        deleteStudent obj8=new deleteStudent();
        updateCatagory obj9=new updateCatagory();

    int input;
    do{
        System.out.println("*************************************************************************************************************************");
        System.out.println("LIBRARY ADMIN PANEL");
        System.out.println("*************************************************************************************************************************");
        System.out.println("PRESS 1 : ADD BOOKS");
        System.out.println("PRESS 2 : BORROW BOOKS");
        System.out.println("PRESS 3 : SEARCH STUDENT");
        System.out.println("PRESS 4 : SHOW TOTAL BOOKS");
        System.out.println("PRESS 5 : SHOW BORROWED BOOKS");
        System.out.println("PRESS 6 : SEARCH BOOKS");
        System.out.println("PRESS 7 : UPDATE QUANTITY");
        System.out.println("PRESS 8 : DELETE STUDENT");
        System.out.println("PRESS 9 : UPDATE CATAGORY");
        System.out.println("PRESS 10: EXIT");
        System.out.println("*************************************************************************************************************************");
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER YOUR CHOICE :: ");
        input = sc.nextInt();
        switch(input) {
            case 1: obj1.addBooks();
                break;
            case 2: obj2.BorrowBooks();
                break;
            case 3: obj3.SearchStudents();
                break;
            case 4: obj4.ShowTotalBooks();
                break;
            case 5: obj5.ShowBorrows();
                break;
            case 6: obj6.SearchBook();
                break;
            case 7: obj7.quantityUpdate();
                break;
            case 8: obj8.deleteStudents();
                break;
            case 9: obj9.updateCatagories();
            break;
            case 10: System.exit(0);
            default:
                System.out.print("The entered value is unrecognized!");
                break;
        }
    }while(true);


}
}