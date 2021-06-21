package uz.pdp.wearhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.wearhouse.entity.Client;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public ApiResponse getAll() {

        List<Client> clients = clientRepository.findAll();
        return new ApiResponse("OK!", true, clients);
    }

    public ApiResponse getById(Integer id) {

        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()){
            Client client = clientOptional.get();
            return new ApiResponse("OK!",true,client);
        }
        return new ApiResponse("Bunday id lik client topilmadi!!!",false);
    }

    public ApiResponse add(Client client) {

        Client clientNew = new Client();
        clientNew.setName(client.getName());
        clientNew.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(clientNew);

        return new ApiResponse("Saqlandi!!!", true);
    }

    public ApiResponse edit(Integer id, Client client) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()){
            Client clientNew = clientOptional.get();
            clientNew.setName(client.getName());
            clientNew.setPhoneNumber(client.getPhoneNumber());
            clientRepository.save(clientNew);

            return new ApiResponse("Saqlandi!!!", true);
        }
        return new ApiResponse("Bunday id lik client topilmadi!!!",false);
    }

    public ApiResponse delete(Integer id) {

        clientRepository.deleteById(id);
        return new ApiResponse("O'chirildi!!!",false);
    }
}
