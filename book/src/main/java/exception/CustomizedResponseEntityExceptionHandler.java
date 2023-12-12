//package exception;
//
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.util.Date;
//
//@ControllerAdvice
//public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(Exception.class) // 예외 발생시 Exception.class만 처리
//    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
//        ExceptionResponse exceptionResponse =
//                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
//
//        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(NotFoundException.class)
//    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {
//        ExceptionResponse exceptionResponse =
//                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
//
//        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
//
//        }
//
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  HttpHeaders headers, HttpStatusCode status,
//                                                                  WebRequest request) {
//
//        ExceptionResponse exceptionResponse =
//                                    //너무 길면 message: "Validation Failed" ,  현재 들어가있는 정확한 에러메시지 출력
//                new ExceptionResponse(new Date(), ex.getMessage(), ex.getBindingResult().toString());
//
//        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
//    }
//
//
//
//}
