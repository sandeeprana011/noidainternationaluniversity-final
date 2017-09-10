package sirfireys.rana.noidainternationaluniversity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sirfireys.rana.noidainternationaluniversity.models.Teachers;

/**
 * Created by sandeeprana on 10/09/17.
 * License is only applicable to individuals and non-profits
 * and that any for-profit company must
 * purchase a different license, and create
 * a second commercial license of your
 * choosing for companies
 */

public class RVAdapterListTeachers extends RecyclerView.Adapter<RVAdapterListTeachers.Holder> {

    ArrayList<Teachers> teachersArrayList;

    @Override
    public RVAdapterListTeachers.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RVAdapterListTeachers.Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(View itemView) {
            super(itemView);
        }
    }
}
