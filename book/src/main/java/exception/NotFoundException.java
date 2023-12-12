package exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND) // 500error -> 404error
public class NotFoundException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private Integer fieldValue;
    public NotFoundException(String resourceName, String fieldName, Integer fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
