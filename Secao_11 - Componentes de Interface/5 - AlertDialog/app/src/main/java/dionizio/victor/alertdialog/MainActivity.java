package dionizio.victor.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirDialog(View view){
        //INSTANCIAR AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        //CONFIGURAR TITULO E MENSAGEM
        dialog.setTitle("Título da dialog");
        dialog.setMessage("Mensagem da Dialog");

        //CONFIGURAR CANCELAMENTO
        dialog.setCancelable(false);

        //CONFIGURAR ICONE
        dialog.setIcon(android.R.drawable.ic_btn_speak_now);

        //CONFIGURAR AÇÕES PARA SIM E NÃO
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),
                "Executar ação ao clicar no botão SIM",
                Toast.LENGTH_LONG).show();
            }
        });

        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),
                        "Executar ação ao clicar no botão NÃO",
                        Toast.LENGTH_LONG).show();
            }
        });

        //CRIAR E EXIBIR AlertDialog
        dialog.create().show();
    }
}