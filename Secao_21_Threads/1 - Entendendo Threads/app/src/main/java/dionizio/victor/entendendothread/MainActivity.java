package dionizio.victor.entendendothread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnInicicar;
    private int numero;
    private Handler handler = new Handler();
    private boolean pararExecucao = false;
    /* Ele permite enviar codigos para ser executado em uma Thread*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInicicar = findViewById(R.id.buttonIniciar);
    }

    public void iniciarThread(View view){
//        MyThread myThread = new MyThread();

        //Inicializando a thread criada
//        myThread.start();

        pararExecucao = false;
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();
    }

    class MyRunnable implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i <= 15; i++){
                if(pararExecucao)
                    return ;

                numero = i;
                Log.d("Thread", "contador: " + i);


                // Enviando comandos para Thread principal
                /*runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        btnInicicar.setText("contador: " + numero);
                    }
                });*/

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        btnInicicar.setText("contador: " + numero);
                    }
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void pararThread(View view){
        pararExecucao = true;
    }

    class MyThread extends Thread{
        // Parar executar e criar uma thread utilizar o método run
        @Override
        public void run() {
            for (int i = 0; i <= 15; i++){
                Log.d("Thread", "contador: " + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}