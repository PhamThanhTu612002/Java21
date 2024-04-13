package vn.techmaster.bookinghotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookinghotel.entity.Bed;
import vn.techmaster.bookinghotel.repository.BedRepository;

import java.util.List;

@Service
public class BedService {
    @Autowired
    BedRepository bedRepository;

    public List<Bed> getAll(){
        return bedRepository.findAll();
    }
}
