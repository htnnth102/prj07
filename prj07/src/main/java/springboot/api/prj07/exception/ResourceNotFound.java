package springboot.api.prj07.exception;

public class ResourceNotFound extends RuntimeException{
    private static final long serialVersion = 1L;

    public ResourceNotFound(String message) {
        super(message);
    }
}
