package bo.edu.ucb.backend.dto;

public class ResponseDto {
    private String code;
    private Object result;
    private String message;

    public ResponseDto(){

    }
    //respuesta correcta
    public ResponseDto(Object result){
        this.code="TASK-0000";
        this.result=result;
    }
    //codigo de error unico
    public ResponseDto(String code,String message){
        this.code=code;
        this.message=message;
    }

    
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getResult() {
        return result;
    }
    public void setResult(Object result) {
        this.result = result;
    }
    @Override
    public String toString() {
        return "ResponseDto{" +
                "code='" + code + '\'' +
                ", result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
        

}
