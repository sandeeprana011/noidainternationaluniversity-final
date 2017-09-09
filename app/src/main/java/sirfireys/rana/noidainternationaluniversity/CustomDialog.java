package sirfireys.rana.noidainternationaluniversity;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sandeeprana on 09/09/17.
 * License is only applicable to individuals and non-profits
 * and that any for-profit company must
 * purchase a different license, and create
 * a second commercial license of your
 * choosing for companies
 */

public class CustomDialog extends DialogFragment {
    @BindView(R.id.i_image_view)
    ImageView i_image_view;
    @BindView(R.id.t_title)
    TextView t_title;


    public static CustomDialog getFragment(@StringRes int content, @DrawableRes int resId) {
        CustomDialog dialog = new CustomDialog();
        Bundle bundle = new Bundle();

        bundle.putInt(Constants.TEXT, content);
        bundle.putInt(Constants.RESOURCEKEY, resId);
        dialog.setArguments(bundle);
        return dialog;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        int text = bundle.getInt(Constants.TEXT, -1);
        int resourceKey = bundle.getInt(Constants.RESOURCEKEY, -1);

        t_title.setText(text);
        i_image_view.setImageDrawable(getResources().getDrawable(resourceKey));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_custom, container, false);
    }
}
