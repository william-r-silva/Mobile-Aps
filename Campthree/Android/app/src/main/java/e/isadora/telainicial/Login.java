package e.isadora.telainicial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

import e.isadora.telainicial.Models.Instituicao;
import e.isadora.telainicial.Models.User;
import e.isadora.telainicial.Retrofit.Configs;
import e.isadora.telainicial.Retrofit.RetrofitInstituicao;
import e.isadora.telainicial.Retrofit.RetrofitUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity implements Validator.ValidationListener {


    //Os @ são do Saripar2
    @Email(message = "Não é um email valido!")
    @NotEmpty(message = "Campo vazio!")
    private EditText email;
    @NotEmpty(message = "Campo vazio!")
    private EditText senha;
    private Button entrar;
    private Button cadastrar;

    //Saripar2
    private Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        start();

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    validator.validate();
            }
        });

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getIntent().getExtras();
                if(bundle.getString("Tipo").equals("vol")){
                    Intent intent = new Intent(Login.this, Cadastrar.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(Login.this, CadastrarInstituicao.class);
                    startActivity(intent);
                }
            }
        });

    }

    private void Teste(){
        Bundle bundle = getIntent().getExtras();
        if(bundle.getString("Tipo").equals("vol")) {
            Intent intent = new Intent(Login.this, MenuVoluntario.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(Login.this, MenuVoluntario.class);
            startActivity(intent);
        }
    }


    @Override
    public void onValidationSucceeded() {

        //Teste();

        final Bundle bundle = getIntent().getExtras();
        if(bundle.getString("Tipo").equals("vol")) {
            RetrofitUser service = Configs.retrofit.create(RetrofitUser.class);
            service.logar(email.getText().toString(), senha.getText().toString()).enqueue(new Callback<User>() {
                @Override
                public void onResponse(retrofit2.Call<User> call, retrofit2.Response<User> response) {
                    if(response.isSuccessful()) {
                        Intent intent = new Intent(Login.this, MenuVoluntario.class);
                        response.body().setSenha(senha.getText().toString());
                        AuxGlobal.user = response.body();
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login.this,"Login ou Senha errados", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(retrofit2.Call<User> call, Throwable t) {
                    Toast.makeText(Login.this, "Servidor erro", Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            RetrofitInstituicao service = Configs.retrofit.create(RetrofitInstituicao.class);
            service.logar(email.getText().toString(), senha.getText().toString()).enqueue(new Callback<Instituicao>() {
                @Override
                public void onResponse(Call<Instituicao> call, Response<Instituicao> response) {
                    if(response.isSuccessful()) {
                        Intent intent = new Intent(Login.this, MenuInstituicao.class);
                        response.body().setSenha(senha.getText().toString());
                        AuxGlobal.instituicao = response.body();
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login.this,"Login ou Senha errados", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Instituicao> call, Throwable t) {
                    Toast.makeText(Login.this, "Servidor erro", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    //Mostra Erro

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for(ValidationError error:errors){
            View component = error.getView();
            String msgErro = error.getCollatedErrorMessage(this);
            if(component instanceof TextView){
                ((TextView) component).setError(msgErro);
            }else{
                Toast.makeText(this, "não sei oq deu",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void start(){
        email = findViewById(R.id.L_email);
        senha = findViewById(R.id.L_senha);
        entrar = findViewById(R.id.L_entrar);
        cadastrar = findViewById(R.id.L_cadastrar);
        validator = new Validator(this);
        validator.setValidationListener(this);
    }
}
