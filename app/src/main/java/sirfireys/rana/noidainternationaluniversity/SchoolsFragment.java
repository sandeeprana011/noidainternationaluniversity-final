package sirfireys.rana.noidainternationaluniversity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class SchoolsFragment extends Fragment {


    public SchoolsFragment() {
        // Required empty public constructor
    }

    @OnClick({
            R.id.lin_schoolofeng,
            R.id.lin_schoolofsciences,
            R.id.lin_schooloflaw,
            R.id.lin_jsm,
            R.id.lin_nursing,
            R.id.lin_finearts,
            R.id.lin_liberalarts,
            R.id.lin_arch,
            R.id.lin_defence
//            R.id.lin_edu
    })
    void onClickLinSchools(View view) {
        CustomDialog dialog = null;
        switch (view.getId()) {
            case R.id.lin_schoolofeng:
//                dialog = CustomDialog.getFragment(R.string., R.drawable.);
                break;
            case R.id.lin_schoolofsciences:
                dialog = CustomDialog.getFragment(R.string.sof_science, R.drawable.science_pic);
                break;
            case R.id.lin_schooloflaw:
                dialog = CustomDialog.getFragment(R.string.sof_law, R.drawable.school_of_law);
                break;
            case R.id.lin_jsm:
                dialog = CustomDialog.getFragment(R.string.sof_jms, R.drawable.jms);
                break;
            case R.id.lin_nursing:
                dialog = CustomDialog.getFragment(R.string.sof_nursing, R.drawable.nursing_pic);
                break;
            case R.id.lin_finearts:
                dialog = CustomDialog.getFragment(R.string.sof_finearts, R.drawable.fine_arts_pic);
                break;
            case R.id.lin_liberalarts:
                dialog = CustomDialog.getFragment(R.string.sof_liberalarts, R.drawable.liberal_arts);
                break;
            case R.id.lin_arch:
                dialog = CustomDialog.getFragment(R.string.sof_architect, R.drawable.architect_pic);
                break;
            case R.id.lin_defence:
                dialog = CustomDialog.getFragment(R.string.sof_defence, R.drawable.defence);
                break;
//            case R.id.lin_edu:
//                dialog = CustomDialog.getFragment(R.string., R.drawable.);
//                break;


        }
        if (dialog != null) {
            dialog.show(getFragmentManager(), CustomDialog.TAG);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schools, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }
}

