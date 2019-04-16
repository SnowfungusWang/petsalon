package njuics.demos.petsalon.controller;


import njuics.demos.petsalon.model.Service;
import njuics.demos.petsalon.repository.ServiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ServiceController {
    private ServiceRepository serviceRepository;

    ServiceController(ServiceRepository repository) {
        this.serviceRepository = repository;
    }

    @GetMapping("/services")
    List<Service> all(){
        return (List<Service>) serviceRepository.findAll();
    }
    @PostMapping("/services")
    Service newService(@RequestBody Service newService){
        return serviceRepository.save(newService);
    }


    @GetMapping("/services/{id}")
    Service find(@PathVariable long id){
        return serviceRepository.findById(id).get();
    }

    @PutMapping("/services/{id}")
    Service update(@RequestBody Service updated, @PathVariable Long id) {
        Service oldOne=serviceRepository.findById(id).get();
        oldOne.setCategory(updated.getCategory());
        oldOne.setDate(updated.getDate());
        oldOne.setFee(updated.getFee());
        return serviceRepository.save(oldOne);
    }


    @DeleteMapping("/services/{id}")
    void deleteService(@PathVariable Long id) {
        serviceRepository.deleteById(id);
    }

}
