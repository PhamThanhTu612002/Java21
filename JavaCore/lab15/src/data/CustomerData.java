package data;

import entities.Custom;

import java.util.HashMap;
import java.util.Map;

public class CustomerData {
    public Map<String, Custom> listCustomer() {
        Map<String, Custom> customData = new HashMap<>();
        PhoneData phoneData1 = new PhoneData();
        PhoneData phoneData2 = new PhoneData();
        Custom custom = new Custom("Tú","Hà Nam","0123456",phoneData1.listPhone(),1000);
        Custom custom2 = new Custom("Huệ","Sơn La","0121212",phoneData2.listPhone(),1000);

        customData.put(custom.getPhone(),custom);
        customData.put(custom2.getPhone(),custom2);
        return customData;
    }
}
