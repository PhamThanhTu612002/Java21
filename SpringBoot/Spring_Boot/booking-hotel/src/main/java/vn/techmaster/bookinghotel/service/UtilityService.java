package vn.techmaster.bookinghotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookinghotel.entity.Utility;
import vn.techmaster.bookinghotel.model.UtilityType;
import vn.techmaster.bookinghotel.repository.UtilityRepository;

import java.util.List;

@Service
public class UtilityService {
    @Autowired
    UtilityRepository utilityRepository;
    public List<Utility> getUtilitiHotel(){
        return utilityRepository.findByUtilityType(UtilityType.HOTEL);
    }
}
