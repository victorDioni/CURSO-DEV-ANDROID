package dionizio.victor.tarefasassincronas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
    }

    public void iniciarAsyncTask(View view){

    }
    // Clase interna
    /*
    1 -> Parâmetro a ser passado para a classe / void
    2 -> Tipo de valor que será utilizado para o prograsso da tarefa
    3 -> Retorno após tarefa finalizada
     */
    class MyAsyncTask extends AsyncTask<Integer, Integer, String>{

        @Override
        protected String doInBackground(Integer... integers) {
            return null;
        }
    }
}