package dionizio.victor.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);
    }

    public void executarSom(View view){
        mediaPlayer.start();
    }

    public void pausarSom(View view){
        mediaPlayer.pause();
    }

    public void stopSom(View view){
        mediaPlayer.stop();
    }
}