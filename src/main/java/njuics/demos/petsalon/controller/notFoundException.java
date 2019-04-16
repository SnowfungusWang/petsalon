package njuics.demos.petsalon.controller;


public class notFoundException extends RuntimeException{
    notFoundException(Long id) {
        super("Could not find id" + id);
    }
}

