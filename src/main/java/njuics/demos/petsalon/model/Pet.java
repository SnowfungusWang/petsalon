package njuics.demos.petsalon.model;

import njuics.demos.petsalon.base.PetType;
import njuics.demos.petsalon.base.baseEntity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "pets")
public class Pet extends baseEntity {


    @Column(name = "name")
    private String name;
    @Column(name = "type")
    PetType type;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "petId", fetch = FetchType.EAGER)
    //@JoinColumn(name = "service_id")
    private Set<Service> services=new LinkedHashSet<>();


    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Pet(String name,PetType p) {
        this.name = name;
        this.type = p;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Service> getServices() {
        return new ArrayList<>(this.services);
    }

    public void addService(Service service) {
        if (service.isNew()){
            services.add(service);

        }
    }

    @Override
    public String toString() {
        return this.getName();
    }


}
