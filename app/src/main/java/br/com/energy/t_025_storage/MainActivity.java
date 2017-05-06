package br.com.energy.t_025_storage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

import br.com.energy.t_025_storage.util.Util;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private Button btn_gravar_ce;
    private Button btn_ler_ce;
    private Button btn_apagar_ce;
    private Button btn_apagar_sd;
    private Button btn_gravar_sd;
    private Button btn_ler_sd;
    private Button btn_apagar_sb;
    private Button btn_gravar_sb;
    private Button btn_ler_sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        inicializarVariaveis();
        acao();
    }

    private void inicializarVariaveis() {
        context = getBaseContext();
        btn_gravar_ce = (Button) findViewById(R.id.btn_gravar_ce);
        btn_ler_ce = (Button) findViewById(R.id.btn_ler_ce);
        btn_apagar_ce = (Button) findViewById(R.id.btn_apagar_ce);

        btn_gravar_sd = (Button) findViewById(R.id.btn_gravar_sd);
        btn_ler_sd = (Button) findViewById(R.id.btn_ler_sd);
        btn_apagar_sd = (Button) findViewById(R.id.btn_apagar_sd);

        btn_gravar_sb = (Button) findViewById(R.id.btn_gravar_sb);
        btn_ler_sb = (Button) findViewById(R.id.btn_ler_sb);
        btn_apagar_sb = (Button) findViewById(R.id.btn_apagar_sb);

    }

    private void acao() {
        btn_gravar_ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String extStorage = System.getenv("EXTERNAL_STORAGE");
                //
                Util.writeFile("Cassio", extStorage + "/DDCassio", "test.txt");
            }
        });
        btn_ler_ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String extStorage = System.getenv("EXTERNAL_STORAGE");
                //
                String resultado = Util.readFile(extStorage + "/DDCassio", "test.txt");
                Toast.makeText(context, resultado, Toast.LENGTH_SHORT).show();
            }
        });
        btn_apagar_ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String extStorage = System.getenv("EXTERNAL_STORAGE");
                //
                Util.deleteFile(extStorage + "/DDCassio", "test.txt");
            }
        });
//SD
        btn_gravar_sd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File paths[] = getExternalFilesDirs(null);

                String extStorage = paths[0].getPath();
                //
                Util.writeFile("Cassio", extStorage + "/DDCassio", "test.txt");
            }
        });
        btn_ler_sd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File paths[] = getExternalFilesDirs(null);

                String extStorage = paths[0].getPath();
                //
                String resultado = Util.readFile(extStorage + "/DDCassio", "test.txt");
                Toast.makeText(context, resultado, Toast.LENGTH_SHORT).show();
            }
        });
        btn_apagar_sd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File paths[] = getExternalFilesDirs(null);

                String extStorage = paths[0].getPath();
                //
                Util.deleteFile(extStorage + "/DDCassio", "test.txt");
            }
        });
//SB
        btn_gravar_sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = getFilesDir();
                String extStorage = file.getPath();
                //
                Util.writeFile("Cassio", extStorage + "/DDCassio", "test.txt");
            }
        });
        btn_ler_sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = getFilesDir();
                String extStorage = file.getPath();
                //
                String resultado = Util.readFile(extStorage + "/DDCassio", "test.txt");
                Toast.makeText(context, resultado, Toast.LENGTH_SHORT).show();
            }
        });
        btn_apagar_sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = getFilesDir();
                String extStorage = file.getPath();
                //
                Util.deleteFile(extStorage + "/DDCassio", "test.txt");
            }
        });
    }
}
