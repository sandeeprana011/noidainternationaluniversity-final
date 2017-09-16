package sirfireys.rana.noidainternationaluniversity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.zilideus.niucommons.RVRecordsAdapter;
import com.zilideus.niucommons.api.ApiServices;
import com.zilideus.niucommons.api.ApiUtil;
import com.zilideus.niucommons.api.ResponseRecords;
import com.zilideus.niucommons.api.models.Teachers;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecordsListFragment extends Fragment {

    public static final String TAG = "RecordsFragment";
    @BindView(R.id.rv_recordslist)
    RecyclerView rv_recordslist;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    RVRecordsAdapter adapter;

    public RecordsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_records_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        adapter = new RVRecordsAdapter(getContext());
        rv_recordslist.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_recordslist.setAdapter(adapter);


        Bundle bundle = getArguments();
        if (bundle != null) {
            String teachers = bundle.getString(Constants.TEACHERS);
            Gson gson = new Gson();
            Teachers teacher = gson.fromJson(teachers, Teachers.class);

            ApiServices services = ApiUtil.getService();
            progressBar.setVisibility(View.VISIBLE);
            Call<ResponseRecords> call = services.getRecordsList(teacher.getTeacher_id());
            call.enqueue(new Callback<ResponseRecords>() {
                @Override
                public void onResponse(Call<ResponseRecords> call, Response<ResponseRecords> response) {
                    progressBar.setVisibility(View.GONE);
                    if (response != null && response.isSuccessful() && response.body().getStatus() == 200) {
                        adapter.addNewRecords(response.body().getRecords());
                    }
                }

                @Override
                public void onFailure(Call<ResponseRecords> call, Throwable t) {
                    progressBar.setVisibility(View.GONE);
                }
            });
        }
    }
}
