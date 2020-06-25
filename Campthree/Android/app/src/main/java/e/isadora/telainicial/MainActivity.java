package e.isadora.telainicial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button Login;
    private Button Instituicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start();

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                intent.putExtra("Tipo", "vol");
                startActivity(intent);
            }
        });
        Instituicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                intent.putExtra("Tipo", "ins");
                startActivity(intent);
            }
        });
    }

    private void start(){
        Login = findViewById(R.id.Voluntario);
        Instituicao = findViewById(R.id.Instituicao);
    }
}
