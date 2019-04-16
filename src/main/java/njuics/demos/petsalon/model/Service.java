package njuics.demos.petsalon.model;

import njuics.demos.petsalon.base.ServiceCategory;
import njuics.demos.petsalon.base.baseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "service")
public class Service extends baseEntity {
    @Column(name = "date")
    private Date date;
    @Column(name = "fee")
    private Double fee;
    @Column(name = "category")
    private ServiceCategory category;

    @Column(name = "pet_id")
    private Long petId;

    /*
    @ManyToOne
    @JoinColumn (name = "pet_id")
    private Pet pet;
     */

    public Date getDate() {
        return date;
    }

    public Double getFee() {
        return fee;
    }

    public ServiceCategory getCategory() {
        return category;
    }

    public void setCategory(ServiceCategory category) {
        this.category = category;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

}

