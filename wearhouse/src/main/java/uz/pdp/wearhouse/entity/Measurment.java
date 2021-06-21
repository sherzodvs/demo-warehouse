package uz.pdp.wearhouse.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.wearhouse.entity.template.AbsEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Measurment extends AbsEntity {
}
