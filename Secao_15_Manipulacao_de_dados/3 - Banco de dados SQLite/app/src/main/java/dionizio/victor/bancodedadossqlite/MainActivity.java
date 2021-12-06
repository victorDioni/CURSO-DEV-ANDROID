package dionizio.victor.bancodedadossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Banco de dados devem ser criados dentro de um try catch

        try {// Criar banco de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("Banco de dados SQLite", MODE_PRIVATE, null);

            // Criar tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT" +
                    ", nome VARCHAR, idade INT(3))");

            // Apagar tabela
//            bancoDados.execSQL("DROP TABLE pessoas");

            // Inserir dados na tabela
//            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Mario', 23)");
//            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Maria', 32)");

            //Atualizando dados
//            bancoDados.execSQL("UPDATE pessoas SET idade = 19 WHERE nome = 'Mariana'");

//            String consulta =
//                    "SELECT nome, idade  FROM pessoas WHERE nome IN ('Maria', 'Victor')";

            String consulta =
                    "SELECT id, nome, idade  FROM pessoas WHERE 1=1";

            // Recuperar pessoas
            Cursor cursor = bancoDados.rawQuery(consulta, null);

            // Indices da tabela
            int indiceID  = cursor.getColumnIndex("id");
            int indiceNome  = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();
            while(cursor != null){
                String id = cursor.getString(indiceID);
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);

                Log.i("RESULTADO - id ",  id + " | nome " + nome + " | idade " + idade);
                cursor.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}