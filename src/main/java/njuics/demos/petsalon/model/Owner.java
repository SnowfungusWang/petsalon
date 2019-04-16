package njuics.demos.petsalon.model;

import njuics.demos.petsalon.base.baseEntity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "owners")
public class Owner extends baseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected Set<Pet> getPetsSet() {
        if (this.pets == null) {
            this.pets = new HashSet<>();
        }
        return this.pets;
    }

    protected void setPetsSet(Set<Pet> pets) {
        this.pets = pets;
    }

    public List<Pet> getPets() {
        List<Pet> petList = new ArrayList<>(getPetsSet());
        return petList;
    }

    public void addPet(Pet pet) {
        if (pet.isNew()) {
            getPets().add(pet);
        }
        pet.setOwner(this);
    }

    /**
     * Return the Pet with the given name, or null if none found for this Owner.
     *
     * @param name to test
     * @return true if pet name is already in use
     */
    public Pet getPet(String name) {
        return getPet(name, false);
    }

    /**
     * Return the Pet with the given name, or null if none found for this Owner.
     *
     * @param name to test
     * @return true if pet name is already in use
     */
    public Pet getPet(String name, boolean ignoreNew) {
        for (Pet pet :getPets()) {
            if (!ignoreNew || !pet.isNew()) {
                String compName = pet.getName();
                if (compName.equals(name)) {
                    return pet;
                }
            }
        }
        return null;
    }





    @Override
    public String toString() {
        return this.getName();
    }
}
