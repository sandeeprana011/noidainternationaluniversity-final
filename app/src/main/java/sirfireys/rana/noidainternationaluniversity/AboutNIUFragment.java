package sirfireys.rana.noidainternationaluniversity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutNIUFragment extends Fragment {


    private static final String TAG = "AboutNiuFragment";
    @BindView(R.id.lin_whyniu) LinearLayout lin_whyniu;
    @BindView(R.id.lin_vcs_message) LinearLayout lin_vcs_message;
    @BindView(R.id.lin_ourfoundation) LinearLayout lin_ourfoundation;
    @BindView(R.id.lin_growwithniu) LinearLayout lin_growwithniu;

    public AboutNIUFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_niu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @OnClick({R.id.lin_whyniu, R.id.lin_vcs_message, R.id.lin_ourfoundation, R.id.lin_growwithniu})
    void onClickLinLayout(LinearLayout view) {
        CustomDialog dialog = null;
        switch (view.getId()) {
            case R.id.lin_whyniu:
                dialog = CustomDialog.getFragment(R.string.why_niu, R.drawable.niu);
                break;
            case R.id.lin_vcs_message:
                dialog = CustomDialog.getFragment(R.string.vc_message, R.drawable.niu_vc);
                break;
            case R.id.lin_ourfoundation:
                dialog = CustomDialog.getFragment(R.string.our_foundation, R.drawable.niu8);
                break;
            case R.id.lin_growwithniu:
                dialog = CustomDialog.getFragment(R.string.grow_up, R.drawable.niu7);
                break;
        }
        if (dialog != null) {
            dialog.show(getFragmentManager(), TAG);
        }
    }
}