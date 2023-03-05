package dionizio.victor.tarefasassincronas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
    }

    public void iniciarAsyncTask(View view){
        MyAsyncTask task = new MyAsyncTask();
        task.execute(10);
    }
    // Clase interna
    /*
    1 -> Parâmetro a ser passado para a classe / void
    2 -> Tipo de valor que será utilizado para o prograsso da tarefa
    3 -> Retorno após tarefa finalizada
     */
    class MyAsyncTask extends AsyncTask<Integer, Integer, String>{

        // Primeiro a executar
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        // Segundo a executar
        @Override
        protected String doInBackground(Integer... integers) {
            int numero = integers[0];
            for (int i = 0; i < numero; i++){

                publishProgress(i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Finalizado";
        }

        // Executa durante a execucao do doInBackground
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        // Ultimo a executar
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this,
                    s, Toast.LENGTH_SHORT).show();

            progressBar.setProgress(0);
            progressBar.setVisibility(View.INVISIBLE);
        }

    }
}