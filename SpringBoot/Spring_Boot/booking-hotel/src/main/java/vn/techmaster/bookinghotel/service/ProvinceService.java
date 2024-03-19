package vn.techmaster.bookinghotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookinghotel.entity.Province;
import vn.techmaster.bookinghotel.repository.ProvinceRepository;

import java.util.Optional;

@Service
public class ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;

    public Province getProvinceBySlug(String slug){
        return provinceRepository.findBySlug(slug);
    }
    public Optional<Province> getProvinceByNameLike(String name){
        return provinceRepository.findProvinceByNameLike(name);
    }
}
