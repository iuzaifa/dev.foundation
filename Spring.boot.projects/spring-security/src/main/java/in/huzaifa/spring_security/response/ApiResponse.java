package in.huzaifa.spring_security.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse <T>{

    private boolean success;
    private String message;
    private int errorCode;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private long timestamp;
    private String path;
    private Object errors;
    private T data;








}
