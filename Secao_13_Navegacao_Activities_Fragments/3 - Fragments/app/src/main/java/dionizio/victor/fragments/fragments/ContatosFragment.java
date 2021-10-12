package dionizio.victor.fragments.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dionizio.victor.fragments.R;


public class ContatosFragment extends Fragment {
    private TextView txtContatos;

    public ContatosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contatos, container, false);

        txtContatos = view.findViewById(R.id.txtContatos);
        txtContatos.setText("Contatos alterados");

        return view;
    }
}