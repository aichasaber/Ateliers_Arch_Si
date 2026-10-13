package tn.esprit.saber_aicha_4cce10.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, Long id) {
        super(resourceName + " introuvable avec l'id : " + id);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

}