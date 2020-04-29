package br.usjt.devmobile.minhassenhasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetalhesSenhaActivity extends AppCompatActivity {

    private Senha senha;
    private TextView textViewNome;
    private TextView textViewUsuario;
    private TextView textViewSenha;
    private TextView textViewUrl;
    private TextView textViewObservacao;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_senha);
        Intent intent = getIntent();
        senha = (Senha)intent.getSerializableExtra("senha");
        textViewNome = findViewById(R.id.textViewNomeValue);
        textViewUsuario = findViewById(R.id.textViewUsuarioValue);
        textViewSenha = findViewById(R.id.textViewSenhaValue);
        textViewUrl = findViewById(R.id.textViewUrlValue);
        textViewObservacao = findViewById(R.id.textViewObsValue);

        textViewNome.setText(senha.getNome());
        textViewUsuario.setText(senha.getUsuario());
        textViewSenha.setText(senha.getSenha());
        textViewUrl.setText(senha.getUrl());
        textViewObservacao.setText(senha.getObservacao());
    }

    public void deletarSenha(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Deletando curso")
                .setMessage("Tem certeza que deseja deletar essa senha?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.senhaDao().delete(senha);
                        finish();
                    } }).setNegativeButton("Não", null).show();
    }

    public void alterarSenha(View view) {
        final Intent intent = new Intent(this, CadastroSenhaActivity.class);
        new AlertDialog.Builder(this)
                .setTitle("Alterando senha")
                .setMessage("Tem certeza que deseja alterar essa senha?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        intent.putExtra("senha",senha);
                        startActivity(intent);
                        finish();
                    } }).setNegativeButton("Não", null).show();

        finish();
    }

    public void fecharTela(View view) {
        finish();
    }
}
