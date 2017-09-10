package sirfireys.rana.noidainternationaluniversity.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by sandeeprana on 10/09/17.
 * License is only applicable to individuals and non-profits
 * and that any for-profit company must
 * purchase a different license, and create
 * a second commercial license of your
 * choosing for companies
 */

public class ResponseTeachers {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("order_list")
    @Expose

    private ArrayList<Teachers> order_list;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public ArrayList<Teachers> getOrder_list() {
        return order_list;
    }

    public void setOrder_list(ArrayList<Teachers> order_list) {
        this.order_list = order_list;
    }
}
