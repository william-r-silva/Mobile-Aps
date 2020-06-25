package e.vivi.home;

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
import com.mobsandgeeks.saripaar.annotation.ConfirmEmail;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

import e.vivi.home.Models.Comentario;
import e.vivi.home.Models.User;
import e.vivi.home.Retrofit.Configs;
import e.vivi.home.Retrofit.RetrofitComentarios;
import e.vivi.home.Retrofit.RetrofitUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Cadastro extends AppCompatActivity implements Validator.ValidationListener{

    @NotEmpty(message = "Campo obrigatório!")
    @Length(min = 3, max = 100, message = "Mínimo 3 e máximo 100 caracteres")
    private EditText nome;

    @NotEmpty(message = "Campo obrigatório!")
    @Length(min = 2, max = 2, message = "Estado abreviado exemplo (RS, RJ, SP)")
    private EditText estado;

    @NotEmpty(message = "Campo obrigatório!")
    @Length(min = 3, max = 100, message = "Mínimo 3 e máximo 150 caracteres")
    private EditText cidade;

    @NotEmpty(message = "Campo obrigatório!")
    @Email(message = "Email invalido!")
    private EditText email;

    @NotEmpty(message = "Campo obrigatório!")
    @ConfirmEmail(message = "Email não confirmado!")
    private EditText confEmail;

    @NotEmpty(message = "Campo obrigatório!")
    @Password(min = 6, scheme = Password.Scheme.ALPHA_NUMERIC, message = "Deve conter 6 caracteres sendo eles letras e números")
    private EditText senha;

    @NotEmpty(message = "Campo obrigatório!")
    @ConfirmPassword(message = "Senhas não coincidem")
    private EditText confSenha;

    private Button cadastrar;
    private Button entrar;
    private RetrofitUser service;
    private User user;
    Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        start();
        service = Configs.retrofit.create(RetrofitUser.class);
        user = new User();

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validator.validate();


            }
        });

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cadastro.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onValidationSucceeded() {
        user.setNome(nome.getText().toString());
        user.setEstado(estado.getText().toString());
        user.setCidade(cidade.getText().toString());
        user.setEmail(email.getText().toString());
        user.setSenha(senha.getText().toString());

        service.cadastrar(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Intent intent = new Intent(Cadastro.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

    }

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

    public void start(){
        nome = findViewById(R.id.R_Nome);
        estado = findViewById(R.id.R_Estado);
        cidade = findViewById(R.id.R_Cidade);
        email = findViewById(R.id.R_Email);
        confEmail = findViewById(R.id.R_ConfEmail);
        senha = findViewById(R.id.R_Senha);
        confSenha = findViewById(R.id.R_ConfSenha);
        cadastrar = findViewById(R.id.R_Cadastrar);
        entrar = findViewById(R.id.R_Entrar);
        validator = new Validator(this);
        validator.setValidationListener(this);
    }
}
