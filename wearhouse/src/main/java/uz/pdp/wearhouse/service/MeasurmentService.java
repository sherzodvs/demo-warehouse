package uz.pdp.wearhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.wearhouse.entity.Measurment;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.repository.MeasurmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurmentService {
    @Autowired
    MeasurmentRepository measurmentRepository;

    public ApiResponse getAll() {

        List<Measurment> measurmentList = measurmentRepository.findAll();
        return new ApiResponse("OK!",true,measurmentList);
    }

    public ApiResponse getById(Integer id) {

        Optional<Measurment> optionalMeasurment = measurmentRepository.findById(id);
        if (optionalMeasurment.isPresent()){
            Measurment measurment = optionalMeasurment.get();
            return new ApiResponse("OK!",true,measurment);
        }
        return new ApiResponse("Id topilmadi!!!",false);
    }

    public ApiResponse add(Measurment measurment) {
        boolean existsByName = measurmentRepository.existsByName(measurment.getName());
        if (!existsByName) {
            Measurment measurmentNew = new Measurment();
            measurmentNew.setName(measurment.getName());
            measurmentNew.setActive(measurment.isActive());
            measurmentRepository.save(measurmentNew);
            return new ApiResponse("Saqlandi!!!",true);
        }
        return new ApiResponse("Bunday name bazada bor!!!",false);
    }

    public ApiResponse edit(Integer id, Measurment measurment) {
        Optional<Measurment> optionalMeasurment = measurmentRepository.findById(id);
        if (optionalMeasurment.isPresent()){
            Measurment measurmentNew = optionalMeasurment.get();
            measurmentNew.setName(measurment.getName());
            measurmentNew.setActive(measurment.isActive());
            measurmentRepository.save(measurmentNew);
            return new ApiResponse("O'zgartirildi!!!",true);
        }
        return new ApiResponse("Bunday id topilmadi!!!",false);
    }

    public ApiResponse delete(Integer id) {

        measurmentRepository.deleteById(id);
        return new ApiResponse("O'chirildi!!!",true);
    }
}
