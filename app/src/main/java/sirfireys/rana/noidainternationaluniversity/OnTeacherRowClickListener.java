package sirfireys.rana.noidainternationaluniversity;

import android.view.View;

import com.zilideus.niucommons.api.models.Teachers;


/**
 * Created by sandeeprana on 10/09/17.
 * License is only applicable to individuals and non-profits
 * and that any for-profit company must
 * purchase a different license, and create
 * a second commercial license of your
 * choosing for companies
 */

interface OnTeacherRowClickListener {
    void onClickRow(View view, Teachers teachers, int adapterPosition);
}
