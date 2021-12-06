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
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR, idade INT(3))");

            // Inserir dados na tabela
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Victor', 23)");
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Maria', 32)");

            // Recuperar pessoas
            Cursor cursor = bancoDados.rawQuery("SELECT nome, idade  FROM pessoas", null);

            // Indices da tabela
            int indiceNome  = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();
            while(cursor != null){
                Log.i("RESULTADO - nome: ", cursor.getString(indiceNome));
                Log.i("RESULTADO - idade: ", cursor.getString(indiceIdade));
                cursor.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}