package uz.pdp.wearhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.wearhouse.entity.AttachmantContent;

public interface AttachmantContentRepository extends JpaRepository<AttachmantContent, Integer> {
    AttachmantContent findByAttachmantId(Integer attachmant_id);
    void deleteByAttachmantId(Integer attachmant_id);
}
