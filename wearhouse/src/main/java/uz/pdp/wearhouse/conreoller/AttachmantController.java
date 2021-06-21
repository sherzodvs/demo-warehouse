package uz.pdp.wearhouse.conreoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.service.AttachmantService;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/attachmant")
public class AttachmantController {
    @Autowired
    AttachmantService attachmantService;

    @PostMapping("/upload")
    public ApiResponse uploadFile(MultipartHttpServletRequest request){
        return attachmantService.uploadFile(request);
    }

    @GetMapping("/download/{id}")
    public void  download(@PathVariable Integer id, HttpServletResponse response){
        attachmantService.download(id,response);
    }
    @DeleteMapping("delete/{id}")
    public ApiResponse deleteById(@PathVariable Integer id){
        return attachmantService.delete(id);
    }
}
