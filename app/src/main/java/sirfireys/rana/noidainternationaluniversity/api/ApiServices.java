package sirfireys.rana.noidainternationaluniversity.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import sirfireys.rana.noidainternationaluniversity.api.models.ResponseTeachers;

/**
 * Created by sandeeprana on 10/09/17.
 * License is only applicable to individuals and non-profits
 * and that any for-profit company must
 * purchase a different license, and create
 * a second commercial license of your
 * choosing for companies
 */

public interface ApiServices {

    @GET("teachers")
    Call<ResponseTeachers> getTEachersList();

    @GET("teachers/records")
    Call<ResponseRecords> getRecordsList(
            @Query("teacher_id") String teacherId);

}
