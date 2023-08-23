package views;

public class View {
    public void viewMain(){
        System.out.println("1. Manage Phone");
        System.out.println("2. Manage Custom");
        System.out.println("3. Calculate revenue");
    }
    public void viewManagePhone(){
        System.out.println("1. Add Phone");
        System.out.println("2. Delete Phone");
        System.out.println("3. Search Phone");
        System.out.println("4. Update Phone");
        System.out.println("0. Quit");
    }
    public void viewManageCustomer(){
        System.out.println("1. Add Customer");
        System.out.println("2. Delete Customer");
        System.out.println("3. Search Customer");
        System.out.println("0. Quit");
    }
}
