package project.autobg.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {

    private String name;
}
