package dionizio.victor.atmconsultoria.ui.sobre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dionizio.victor.atmconsultoria.R;
import mehdi.sakout.aboutpage.AboutPage;

public class SobreFragment extends Fragment {

    public SobreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .create();

    }
}