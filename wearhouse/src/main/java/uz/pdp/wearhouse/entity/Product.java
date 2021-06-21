package uz.pdp.wearhouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.wearhouse.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends AbsEntity {
    @ManyToOne
    private Category category;

    @OneToOne
    private Attachmant photo;

    @Column(nullable = false, unique = true)
    private String code;

    @ManyToOne
    private Measurment measurment;

}
