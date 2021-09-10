package dionizio.victor.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progreBarHorizontal, progreBarCircular;
    private int progresso = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progreBarCircular   = findViewById(R.id.progressBarCircular);
        progreBarHorizontal = findViewById(R.id.progressBarHorizontal);

    }

    public void carregarProgressBar(View view){

        //ProgressBar Horizontal
        this.progresso = this.progresso + 1;
        progreBarHorizontal.setProgress(this.progresso);

        //ProgressBar Circular
        if(this.progresso == 10){
            progreBarCircular.setVisibility(View.GONE);
        }
    }
}