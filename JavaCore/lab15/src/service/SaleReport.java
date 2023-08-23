package service;

import data.CustomerData;
import data.PhoneData;
import entities.Custom;
import handle.Handle;
import views.View;

import java.util.Map;
import java.util.Scanner;

public class SaleReport {
    CustomerData customerData = new CustomerData();
    PhoneData phoneData = new PhoneData();
    PhoneStore phoneStore = new PhoneStore();
    CustomManager customManager = new CustomManager();
    View view = new View();
    Scanner sc = new Scanner(System.in);
    Handle handle = new Handle();
    public void managePhoneStore(){
        view.viewMain();
        int choice = handle.handleChoice(sc);
        switch (choice){
            case 1:
                managePhone();
                break;
            case 2:
                manageCustomer();
                break;
            case 3:
                System.out.println(calRevenue(customerData.listCustomer()));
                managePhoneStore();
                break;
            default:break;

        }
    }
    public void managePhone(){
        view.viewManagePhone();
        int choice = handle.handleChoice(sc);;
        switch (choice){
            case 1:
                phoneStore.addPhone(sc,phoneData.listPhone());
                managePhone();
                break;
            case 2:
                phoneStore.deletePhone(sc,phoneData.listPhone());
                managePhone();
                break;
            case 3:
                phoneStore.searchPhone(sc,phoneData.listPhone());
                managePhone();
                break;
            case 4:
                phoneStore.update(sc,phoneData.listPhone());
                managePhone();
                break;
            case 0:
                managePhoneStore();
                break;
            default:break;
        }
    }
    public void manageCustomer(){
        view.viewManageCustomer();
        int choice = handle.handleChoice(sc);
        switch (choice){
            case 1:
                customManager.addCustom(sc,customerData.listCustomer());
                manageCustomer();
                break;
            case 2:
                customManager.deleteCustom(sc,customerData.listCustomer());
                manageCustomer();
                break;
            case 3:
                customManager.searchCustom(sc,customerData.listCustomer());
                manageCustomer();
            case 0:
                managePhoneStore();
                break;
            default:break;
        }
    }
    public double calRevenue(Map<String, Custom> customMap){
        double tong = 0;
        for (Map.Entry<String, Custom> entry : customMap.entrySet()){
            tong = tong + entry.getValue().getMoney();
        }
        return tong;
    }

}
