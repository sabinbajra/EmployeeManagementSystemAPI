package api.emscrud.exception;

public class ResourceNotFoundException extends Exception{

    public ResourceNotFoundException(Long id){
        super("Can not find user with id " + id);
    }
}
