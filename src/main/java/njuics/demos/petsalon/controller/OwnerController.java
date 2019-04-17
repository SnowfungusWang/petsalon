package njuics.demos.petsalon.controller;

import njuics.demos.petsalon.model.Owner;
import njuics.demos.petsalon.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OwnerController {
    @Autowired
    private OwnerRepository ownersRepository;
/*
    @GetMapping("/owner")

    Optional<Owner> find (Long id){
        return ownersRepository.findById((long)3);
    }*/


    OwnerController(OwnerRepository ownersRepository){
        this.ownersRepository=ownersRepository;
    }


    @GetMapping("/getAllOwners")
        List<Owner> all () {
            return (List<Owner>) ownersRepository.findAll();
        }

    @PostMapping("/addNewOwner")
    Owner newOwner(@RequestBody Owner newOwner){
        return ownersRepository.save(newOwner);
    }

    @GetMapping("/getOwner")
    Owner find(@RequestParam(value = "id") Long id){
        /*Optional<Owner> result=ownersRepository.findById(id);
       return result.orElseThrow(()->new notFoundException(id));

        /*
        return ownersRepository.findById(id).
                orElseThrow(()->new notFoundException(id));
*/

      return ownersRepository.findById(id).get();

    }


    @PutMapping("/owners/{id}")
    Owner updateOwner(@RequestBody Owner updatedOwner, @PathVariable Long id) {

        Owner oldOne=ownersRepository.findById(id).get();
        oldOne.setName(updatedOwner.getName());
        return ownersRepository.save(oldOne);



/*
        return ownersRepository.findById(id)
                .map(owner -> {
                    owner.setName(updatedOwner.getName());
                    return ownersRepository.save(owner);
                })
                .orElseGet(() -> {
                    updatedOwner.setId(id);
                    return ownersRepository.save(updatedOwner);
                });
                //.orElseThrow(()->new notFoundException(id));


 */


    }
    @DeleteMapping("/deleteOwner")
    void deleteOwner(@RequestParam (value = "id")Long id) {
        ownersRepository.deleteById(id);
    }
/*
    @PostMapping("owners/{id}")
    Owner addPet(@PathVariable long id, @RequestBody Pet newPet)
    {
        if ()
    }

*/


}
