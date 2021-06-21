package uz.pdp.wearhouse.conreoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.wearhouse.entity.User;
import uz.pdp.wearhouse.entity.Wearhouse;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.payload.UserDto;
import uz.pdp.wearhouse.repository.WearhouseRepository;
import uz.pdp.wearhouse.service.Random;
import uz.pdp.wearhouse.service.UserService;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;



    @GetMapping
    public ApiResponse getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Integer id){
        return userService.getById(id);
    }

    @PostMapping
    public ApiResponse add(@RequestBody UserDto userDto){

        return userService.add(userDto);
    }

    @PutMapping("/{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody UserDto userDto){
        return userService.edit(id,userDto);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        return userService.delete(id);
    }
}
