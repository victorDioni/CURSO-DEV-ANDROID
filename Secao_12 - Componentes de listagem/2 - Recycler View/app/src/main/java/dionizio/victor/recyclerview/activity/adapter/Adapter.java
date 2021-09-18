package dionizio.victor.recyclerview.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dionizio.victor.recyclerview.R;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // CONVERTER XML E UM OBJETO DO TIPO VIEW
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.titulo.setText("Titulo de teste");
        holder.ano.setText("2017");
        holder.genero.setText("Comédia");
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titulo, ano, genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo    = itemView.findViewById(R.id.txtTitulo);
            ano       = itemView.findViewById(R.id.txtAno);
            genero    = itemView.findViewById(R.id.txtGenero);
        }
    }
}
