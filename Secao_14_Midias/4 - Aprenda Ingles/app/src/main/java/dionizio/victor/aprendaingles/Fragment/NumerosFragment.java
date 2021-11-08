package dionizio.victor.aprendaingles.Fragment;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import dionizio.victor.aprendaingles.R;

public class NumerosFragment extends Fragment implements View.OnClickListener{
    private ImageButton btnUm, btnDois, btnTres,
                        btnQuatro, btnCinco, btnSeis;

    private MediaPlayer mediaPlayer;

    public NumerosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_numeros, container, false);

        btnUm       = view.findViewById(R.id.btnUm);
        btnDois     = view.findViewById(R.id.btnDois);
        btnTres     = view.findViewById(R.id.btnTres);
        btnQuatro   = view.findViewById(R.id.btnQuatro);
        btnCinco    = view.findViewById(R.id.btnCinco);
        btnSeis     = view.findViewById(R.id.btnSeis);

        btnUm.setOnClickListener(this);
        btnDois.setOnClickListener(this);
        btnTres.setOnClickListener(this);
        btnQuatro.setOnClickListener(this);
        btnCinco.setOnClickListener(this);
        btnSeis.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnUm:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
                tocarSomNumeros();
                break;
            case R.id.btnDois:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
                tocarSomNumeros();
                break;
            case R.id.btnTres:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
                tocarSomNumeros();
                break;
            case R.id.btnQuatro:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
                tocarSomNumeros();
                break;
            case R.id.btnCinco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
                tocarSomNumeros();
                break;
            case R.id.btnSeis:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
                tocarSomNumeros();
                break;
        }
    }

        public void tocarSomNumeros () {
            if (mediaPlayer != null) {
                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
            }
        }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}