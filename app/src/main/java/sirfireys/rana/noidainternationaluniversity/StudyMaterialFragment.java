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

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sirfireys.rana.noidainternationaluniversity.api.ApiServices;
import sirfireys.rana.noidainternationaluniversity.api.ApiUtil;
import sirfireys.rana.noidainternationaluniversity.api.models.ResponseTeachers;
import sirfireys.rana.noidainternationaluniversity.api.models.Teachers;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudyMaterialFragment extends Fragment implements OnRowClickListener {

    @BindView(R.id.progress_bar) ProgressBar progress_bar;
    @BindView(R.id.rv_listteachers) RecyclerView rv_listteachers;
    RVAdapterListTeachers adapter;


    public StudyMaterialFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_study_material, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        adapter = new RVAdapterListTeachers(getContext());

        rv_listteachers.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_listteachers.setAdapter(adapter);
        progress_bar.setVisibility(View.VISIBLE);

        adapter.setOnClickListener(this);

        ApiServices api = ApiUtil.getService();
        Call<ResponseTeachers> call = api.getTEachersList();
        call.enqueue(new Callback<ResponseTeachers>() {
            @Override
            public void onResponse(Call<ResponseTeachers> call, Response<ResponseTeachers> response) {
                if (progress_bar != null)
                    progress_bar.setVisibility(View.GONE);
                if (response != null && response.isSuccessful() && response.body().getStatus() == 200) {
                    if (adapter != null && getContext() != null) {
                        adapter.setTeachersArrayList(response.body().getTeachersArrayList());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseTeachers> call, Throwable t) {
                if (progress_bar != null)
                    progress_bar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onClickRow(View view, Teachers teachers, int adapterPosition) {
        if (teachers != null) {
            getFragmentManager().executePendingTransactions();
            Fragment fragment = new RecordsListFragment();
            Bundle bundle = new Bundle();
            Gson gson = new Gson();
            String strTeachers = gson.toJson(teachers);
            bundle.putString(Constants.TEACHERS, strTeachers);
            fragment.setArguments(bundle);
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment, RecordsListFragment.TAG).commitAllowingStateLoss();
        }
    }
}
