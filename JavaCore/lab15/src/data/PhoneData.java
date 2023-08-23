package data;

import entities.Phone;

import java.util.HashMap;
import java.util.Map;

public class PhoneData {
    public Map<Integer, Phone> listPhone(){
        Map<Integer, Phone> phoneData = new HashMap<>();
        Phone phone1 = new Phone("Iphone 15 Pro Max","Apple","1TB",100);
        Phone phone2 = new Phone("Iphone 15 Pro Max","Apple","1TB",100);
        Phone phone3 = new Phone("Iphone 15 Pro Max","Apple","1TB",100);
        Phone phone4 = new Phone("Iphone 15 Pro Max","Apple","1TB",100);
        Phone phone5 = new Phone("Iphone 15 Pro Max","Apple","1TB",100);

        phoneData.put(phone1.getId(),phone1);
        phoneData.put(phone2.getId(),phone2);
        phoneData.put(phone3.getId(),phone3);
        phoneData.put(phone4.getId(),phone4);
        phoneData.put(phone5.getId(),phone5);
        return phoneData;
    }
}
