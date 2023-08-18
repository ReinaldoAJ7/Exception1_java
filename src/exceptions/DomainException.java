package exceptions;
import java.io.Serial;
import java.lang.Exception;
public class DomainException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public DomainException(String msg){
        super(msg);
    }
}
