package e.isadora.telainicial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import e.isadora.telainicial.Models.Instituicao;
import e.isadora.telainicial.Retrofit.Configs;
import e.isadora.telainicial.Retrofit.RetrofitInstituicao;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastrarInstituicao extends AppCompatActivity implements Validator.ValidationListener{
    @NotEmpty(message = "Campo obrigatório!")
    @Length(min = 3, max = 200, message = "Mínimo 3 e máximo 200 caracteres")
    private EditText nome;
    @NotEmpty(message = "Campo obrigatório!")
    @Length(min = 2, max = 2, message = "Estado incorreto use como exemplo(RS, SP, RJ)")
    private EditText estado;
    @NotEmpty(message = "Campo obrigatório!")
    @Length(min = 3, max = 150, message = "Mínimo 3 e máximo 150 caracteres")
    private EditText cidade;
    @NotEmpty(message = "Campo obrigatório!")
    @Length(min = 3, max = 150, message = "Mínimo 3 e máximo 150 caracteres")
    private EditText rua;
    @NotEmpty(message = "Campo obrigatório!")
    @Length(min = 3, max = 150, message = "Mínimo 3 e máximo 150 caracteres")
    private EditText bairro;
    @NotEmpty(message = "Campo obrigatório!")
    @Length(min = 1, max = 10, message = "Mínimo 1 e máximo 10 caracteres")
    private EditText numero;
    @NotEmpty(message = "Campo obrigatório!")
    @Length(min = 9, max = 11, message = "Mínimo 9 e máximo 11 caracteres\nExemplo ( 51923324554 )")
    private EditText telefone;
    @NotEmpty(message = "Campo obrigatório!")
    @Length(min = 11, max = 14, message = "Mínimo 11 e máximo 14 caracteres")
    private EditText cnpj;
    @Length(max = 200, message = "Mínimo 0 e máximo 200 caracteres")
    private EditText razao;
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
        setContentView(R.layout.activity_cadastrar_instituicao);
        start();

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validator.validate();
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastrarInstituicao.this, Login.class);
                intent.putExtra("Tipo", "inst");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onValidationSucceeded() {

        Instituicao institucao = new Instituicao();

        institucao.setNome(nome.getText().toString());
        String local = "";
        local += estado.getText().toString()+", ";
        local += cidade.getText().toString()+", ";
        local += bairro.getText().toString()+", ";
        local += rua.getText().toString()+", ";
        local += numero.getText().toString();
        institucao.setEndereco(local);
        institucao.setTelefone(telefone.getText().toString());
        institucao.setRazaoSocial(razao.getText().toString());
        institucao.setCnpj(cnpj.getText().toString());
        institucao.setEmail(email.getText().toString());
        institucao.setSenha(senha.getText().toString());


        RetrofitInstituicao service = Configs.retrofit.create(RetrofitInstituicao.class);
        service.cadastrar(institucao).enqueue(new Callback<Instituicao>() {
            @Override
            public void onResponse(Call<Instituicao> call, Response<Instituicao> response) {
                Intent intent = new Intent(CadastrarInstituicao.this, Login.class);
                intent.putExtra("Tipo", "inst");
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Instituicao> call, Throwable t) {

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

    private void start(){
        nome = findViewById(R.id.CI_nome);
        cnpj = findViewById(R.id.CI_CNPJ);
        estado = findViewById(R.id.CI_estado);
        cidade = findViewById(R.id.CI_Cidade);
        rua = findViewById(R.id.CI_Rua);
        bairro = findViewById(R.id.CI_Bairro);
        numero = findViewById(R.id.CI_Numero);
        telefone = findViewById(R.id.CI_Telefone);
        razao = findViewById(R.id.CI_Razao);
        email = findViewById(R.id.CI_email);
        confEmail = findViewById(R.id.CI_confEmail);
        senha = findViewById(R.id.CI_senha);
        confSenha = findViewById(R.id.CI_confSenha);
        voltar = findViewById(R.id.CI_voltar);
        cadastrar = findViewById(R.id.CI_cadastrar);
        validator = new Validator(this);
        validator.setValidationListener(this);
    }
}
