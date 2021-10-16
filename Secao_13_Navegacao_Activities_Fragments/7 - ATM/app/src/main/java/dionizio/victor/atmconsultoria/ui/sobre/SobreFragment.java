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

                .addGroup("Entre em contato")
                .addEmail("atendimento@atmconsultoria.com.br", "Envie um e-mail")
                .addWebsite("https://www.google.com/", "Acesse nosso site")

                .addGroup("Redes Sociais")
                .addFacebook("victor.dionizio.3", "Facebook")
                .addInstagram("dionizio.v","Instagram")
                .addTwitter("https://twitter.com","Twiter")
                .addYoutube("https://www.youtube.com/","Youtube")
                .addGitHub("victorDioni","GitHub")
                .addPlayStore("tv.twitch.android.app","Download App")

                .create();
    }
}