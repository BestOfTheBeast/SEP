package student.enterprise.project.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class HTTPException extends RuntimeException {

  private HttpStatus status;

  public HTTPException(String message, HttpStatus status) {
    super(message);
    this.status = status;
  }
}
