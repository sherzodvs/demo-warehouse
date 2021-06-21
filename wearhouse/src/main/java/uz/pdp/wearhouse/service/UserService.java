package uz.pdp.wearhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.wearhouse.entity.User;
import uz.pdp.wearhouse.entity.Wearhouse;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.payload.UserDto;
import uz.pdp.wearhouse.repository.UserRepository;
import uz.pdp.wearhouse.repository.WearhouseRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    WearhouseRepository wearhouseRepository;

    public ApiResponse getAll() {

        List<User> users = userRepository.findAll();
        return new ApiResponse("Ok!", true, users);
    }

    public ApiResponse getById(Integer id) {

        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return new ApiResponse("OK!", true, user);
        }

        return new ApiResponse("Bunday Id lik user topilmadi!!!", false);
    }
    public String generedCode(String name){
        String code = Random.random(name);
        boolean existsByCode = userRepository.existsByCode(code);
        if (existsByCode){
            generedCode(name);
        }
        return code;
    }


    public ApiResponse add(UserDto userDto) {

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setActive(userDto.isActive());
        user.setCode(generedCode("u"));
        Set<Wearhouse> wearhouses = user.getWearhouse();
        Integer[] wearhouseId = userDto.getWearhouseId();
        for (Integer integer : wearhouseId) {
            Wearhouse wearhouse = wearhouseRepository.getById(integer);
            wearhouses.add(wearhouse);
        }
        user.setWearhouse(wearhouses);
        userRepository.save(user);
        return new ApiResponse("Saqlandi!!!", true);
    }


    public ApiResponse edit(Integer id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setPhoneNumber(userDto.getPhoneNumber());
            user.setActive(userDto.isActive());
            user.setCode(generedCode("u"));
            Set<Wearhouse> wearhouses = user.getWearhouse();
            Integer[] wearhouseId = userDto.getWearhouseId();
            for (Integer integer : wearhouseId) {
                Wearhouse wearhouse = wearhouseRepository.getById(integer);
                wearhouses.add(wearhouse);
            }
            user.setWearhouse(wearhouses);
            userRepository.save(user);
            return new ApiResponse("O'zgartirildi!!!", true);
        }
        return new ApiResponse("Bunday Id lik user topilmadi!!!", false);
    }

    public ApiResponse delete(Integer id) {

        userRepository.deleteById(id);
        return new ApiResponse("O'chirildi!!!",true);
    }
}
