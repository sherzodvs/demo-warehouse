package uz.pdp.wearhouse.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.wearhouse.entity.Attachmant;
import uz.pdp.wearhouse.entity.AttachmantContent;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.repository.AttachmantContentRepository;
import uz.pdp.wearhouse.repository.AttachmantRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Optional;

@Service
public class AttachmantService {
    @Autowired
    AttachmantRepository attachmantRepository;

    @Autowired
    AttachmantContentRepository attachmantContentRepository;

    @SneakyThrows
    public ApiResponse uploadFile(MultipartHttpServletRequest request) {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        Attachmant attachmant = new Attachmant();
        attachmant.setName(file.getName());
        attachmant.setSize(file.getSize());
        attachmant.setType(file.getContentType());
        Attachmant savedAttachmant = attachmantRepository.save(attachmant);

        AttachmantContent attachmantContent = new AttachmantContent();
        attachmantContent.setBytes(file.getBytes());
        attachmantContent.setAttachmant(savedAttachmant);
        attachmantContentRepository.save(attachmantContent);
        return new ApiResponse("Fayl saqlandi!",true,savedAttachmant.getId());
    }

    @SneakyThrows
    public void download(Integer id, HttpServletResponse response) {
        Optional<Attachmant> attachmantOptional = attachmantRepository.findById(id);
        if (attachmantOptional.isPresent()){
            Attachmant attachmant = attachmantOptional.get();
            response.setHeader("Content-Disposition", "attachment; filename=\""+attachmant.getName()+"\"");
            response.setContentType(attachmant.getType());
            AttachmantContent attachmantContent = attachmantContentRepository.findByAttachmantId(attachmant.getId());
            FileCopyUtils.copy(attachmantContent.getBytes(),response.getOutputStream());

        }
    }


    public ApiResponse delete(Integer id) {
//        attachmantContentRepository.deleteByAttachmantId(id);
        attachmantRepository.deleteById(id);

        return new ApiResponse("O'chirildi!!", true);
    }
}
