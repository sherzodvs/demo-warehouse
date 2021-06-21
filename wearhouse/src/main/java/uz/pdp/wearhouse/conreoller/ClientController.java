package uz.pdp.wearhouse.conreoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.wearhouse.entity.Client;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping
    public ApiResponse getAll(){
        return clientService.getAll();
    }

    @GetMapping ("/{id}")
    public ApiResponse getById(@PathVariable Integer id){
        return clientService.getById(id);
    }
    @PostMapping
    public ApiResponse add(@RequestBody Client client){
        return clientService.add(client);
    }

    @PutMapping("/{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody Client client){
        return clientService.edit(id,client);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        return clientService.delete(id);
    }
}
