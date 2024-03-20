package vn.techmaster.bookinghotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookinghotel.entity.Province;
import vn.techmaster.bookinghotel.repository.HotelRepository;
import vn.techmaster.bookinghotel.repository.ProvinceRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;
    @Autowired
    HotelRepository hotelRepository;

    public Province getProvinceBySlug(String slug){
        return provinceRepository.findBySlug(slug);
    }
    public Optional<Province> getProvinceByNameLike(String name){
        return provinceRepository.findProvinceByNameLike(name);
    }
    public Map<Province, Integer> getProvincesWithMostHotels(){
        Map<Province,Integer> provinceIntegerMap = new HashMap<>();
        List<Province> provinces = provinceRepository.findProvinceWithMaxHotels();
        for (Province province : provinces){
            provinceIntegerMap.put(province,hotelRepository.findNoHotelsInProvince(province.getId()));
        }
        return provinceIntegerMap;
    }
}
