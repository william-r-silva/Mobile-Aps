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
import com.mobsandgeeks.saripaar.annotation.ConfirmEmail;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

import e.isadora.telainicial.Models.User;
import e.isadora.telainicial.Retrofit.Configs;
import e.isadora.telainicial.Retrofit.RetrofitCampanha;
import e.isadora.telainicial.Retrofit.RetrofitUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Cadastrar extends AppCompatActivity implements Validator.ValidationListener{
    @NotEmpty(message = "Campo obrigatório!")
    @Length(min = 3, max = 100, message = "Mínimo 3 e máximo 100 caracteres")
    private EditText nome;
    @NotEmpty(message = "Campo obrigatório!")
    @Length(min = 14, max = 17, message = "Mínimo 14 e máximo 17 caracteres")
    private EditText cpf;
    @NotEmpty(message = "Campo obrigatório!")
    @Length(min = 2, max = 2, message = "Exemplo (RS, SP, RJ)")
    private EditText estado;
    @NotEmpty(message = "Campo obrigatório!")
    @Length(min = 10, max = 200, message = "Mínimo 10 e máximo 200 caracteres")
    private EditText cidade;
    @NotEmpty(message = "Campo obrigatório!")
    @Length(min = 3, max = 100, message = "Mínimo 3 e máximo 100 caracteres")
    private EditText bairro;
    @NotEmpty(message = "Campo obrigatório!")
    @Length(min = 3, max = 150, message = "Mínimo 3 e máximo 150 caracteres")
    private EditText rua;
    @NotEmpty(message = "Campo obrigatório!")
    @Length(min = 1, max = 10, message = "Mínimo 1 e máximo 10 caracteres")
    private EditText numero;
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
    private Button voltar;
    private Button cadastrar;
    private Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        //Inicializa Componentes
        start();

        //Clica cadastrar  CHAMA  método de validação do Saripar2
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validator.validate();
            }
        });


        //Volta Tela

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cadastrar.this, Login.class);
                intent.putExtra("Tipo", "vol");
                startActivity(intent);
            }
        });

    }


    //Validação Saripar2
    //Quando tudo está correto

    @Override
    public void onValidationSucceeded() {

        //Passas as informações digitadas para um User que dps é enviado por body em uma requisição web

        User user = new User();
        user.setNome(nome.getText().toString());

        user.setCpf(cpf.getText().toString());
        String local = "";
        local += estado.getText().toString()+", ";
        local += cidade.getText().toString()+", ";
        local += bairro.getText().toString()+", ";
        local += rua.getText().toString()+", ";
        local += numero.getText().toString();
        user.setEndereco(local);

        user.setSenha(senha.getText().toString());
        user.setEmail(email.getText().toString());

        RetrofitUser service = Configs.retrofit.create(RetrofitUser.class);
        service.cadastrar(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                //Caso tenha cadastrado Troca tela
                Intent intent = new Intent(Cadastrar.this, Login.class);
                intent.putExtra("Tipo", "vol");
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText( Cadastrar.this, "Servidor erro",Toast.LENGTH_SHORT).show();
            }
        });
    }


    //Mostra ERRO
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
        nome = findViewById(R.id.C_nome);
        cpf = findViewById(R.id.C_cpf);
        estado = findViewById(R.id.C_estado);
        cidade = findViewById(R.id.C_Cidade);
        bairro = findViewById(R.id.C_Bairro);
        rua = findViewById(R.id.C_Rua);
        numero = findViewById(R.id.C_Numero);
        email = findViewById(R.id.C_email);
        confEmail = findViewById(R.id.C_confEmail);
        senha = findViewById(R.id.C_senha);
        confSenha = findViewById(R.id.C_confSenha);
        voltar = findViewById(R.id.C_voltar);
        cadastrar = findViewById(R.id.C_cadastrar);
        validator = new Validator(this);
        validator.setValidationListener(this);
    }
}
