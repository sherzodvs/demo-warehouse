package uz.pdp.wearhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.wearhouse.entity.Measurment;
import uz.pdp.wearhouse.entity.Wearhouse;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.repository.MeasurmentRepository;
import uz.pdp.wearhouse.repository.WearhouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WearhouseService {
    @Autowired
    WearhouseRepository wearhouseRepository;

    public ApiResponse getAll() {

        List<Wearhouse> wearhouseList = wearhouseRepository.findAll();
        return new ApiResponse("OK!",true,wearhouseList);
    }

    public ApiResponse getById(Integer id) {

        Optional<Wearhouse> optionalWearhouse = wearhouseRepository.findById(id);
        if (optionalWearhouse.isPresent()){
            Wearhouse wearhouse = optionalWearhouse.get();
            return new ApiResponse("OK!",true,wearhouse);
        }
        return new ApiResponse("Id topilmadi!!!",false);
    }

    public ApiResponse add(Wearhouse wearhouse) {
        boolean existsByName = wearhouseRepository.existsByName(wearhouse.getName());
        if (!existsByName) {
            Wearhouse wearhouseNew = new Wearhouse();
            wearhouseNew.setName(wearhouse.getName());
            wearhouseNew.setActive(wearhouse.isActive());
            wearhouseRepository.save(wearhouseNew);
            return new ApiResponse("Saqlandi!!!",true);
        }
        return new ApiResponse("Bunday name bazada bor!!!",false);
    }

    public ApiResponse edit(Integer id, Wearhouse wearhouse) {
        Optional<Wearhouse> optionalWearhouse = wearhouseRepository.findById(id);
        if (optionalWearhouse.isPresent()){
            Wearhouse wearhouseNew = optionalWearhouse.get();
            wearhouseNew.setName(wearhouse.getName());
            wearhouseNew.setActive(wearhouse.isActive());
            wearhouseRepository.save(wearhouseNew);
            return new ApiResponse("O'zgartirildi!!!",true);
        }
        return new ApiResponse("Bunday id topilmadi!!!",false);
    }

    public ApiResponse delete(Integer id) {

        wearhouseRepository.deleteById(id);
        return new ApiResponse("O'chirildi!!!",true);
    }
}
