package sirfireys.rana.noidainternationaluniversity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zilideus.niucommons.api.models.Teachers;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    private Context context;
    private OnTeacherRowClickListener onClickListener;

    public RVAdapterListTeachers(Context context) {
        this.context = context;
        this.teachersArrayList = new ArrayList<>();
    }

    public void setOnClickListener(OnTeacherRowClickListener onClickListener) {

        this.onClickListener = onClickListener;
    }

    public void setTeachersArrayList(ArrayList<Teachers> teachersArrayList) {
        this.teachersArrayList.clear();
        if (teachersArrayList != null) {
            this.teachersArrayList.addAll(teachersArrayList);
            this.notifyDataSetChanged();
        }
    }

    @Override
    public RVAdapterListTeachers.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(context).inflate(R.layout.teachers_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RVAdapterListTeachers.Holder holder, int position) {
        Teachers teacher = this.teachersArrayList.get(position);
        if (teacher != null) {
            Glide.with(context)
                    .load(teacher.getProfile_url())
                    .into(holder.i_avatar);
            holder.t_name.setText(teacher.getName());
            holder.t_email.setText(teacher.getEmail());
        }

    }

    @Override
    public int getItemCount() {
        return this.teachersArrayList.size();
    }



    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.i_avatar) ImageView i_avatar;
        @BindView(R.id.t_name) TextView t_name;
        @BindView(R.id.t_email) TextView t_email;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onClickListener != null) {
                onClickListener.onClickRow(view, teachersArrayList.get(getAdapterPosition()), getAdapterPosition());
            }
        }
    }
}
