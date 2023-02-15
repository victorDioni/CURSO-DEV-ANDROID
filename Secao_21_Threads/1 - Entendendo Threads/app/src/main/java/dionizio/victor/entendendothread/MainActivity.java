package dionizio.victor.entendendothread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void iniciarThread(View view){
//        MyThread myThread = new MyThread();

        //Inicializando a thread criada
//        myThread.start();

        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();
    }

    class MyRunnable implements Runnable{

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