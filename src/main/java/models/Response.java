package models;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-08 <br>
 * Time: 16:07 <br>
 * Project: LiveSpringInitilizrDemo <br>
 */
public class Response {

    private String message;
    private Boolean status;

    public Response(){}

    public Response(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
