package njuics.demos.petsalon.controller;

import njuics.demos.petsalon.model.Pet;
import njuics.demos.petsalon.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {
    @Autowired
    private  PetRepository petRepository;

    PetController(PetRepository repository) {
        this.petRepository = repository;
    }

    @GetMapping("/pets")
    List<Pet> all(){
        return (List<Pet>) petRepository.findAll();
    }
    @PostMapping("/pets")
    Pet newPet(@RequestBody Pet newPet){
        return petRepository.save(newPet);
    }
    @GetMapping("/pets/{id}")
    Pet find(@PathVariable long id){
        return petRepository.findById(id).get();
    }

    @PutMapping("/pets/{id}")
    Pet update(@RequestBody Pet updated, @PathVariable Long id) {
        Pet oldOne=petRepository.findById(id).get();
        oldOne.setName(updated.getName());
        oldOne.setType(updated.getType());
        return petRepository.save(oldOne);
    }



    @DeleteMapping("/pets/{id}")
    void deletePet(@PathVariable Long id) {
       petRepository.deleteById(id);
    }

}
