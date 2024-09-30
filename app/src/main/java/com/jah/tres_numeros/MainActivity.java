package com.jah.tres_numeros;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText txtNumber1;
    EditText txtNumber2;
    EditText txtNumber3;
    String numero1;
    String numero2;
    String numero3;
    int numero01;
    int numero02;
    int numero03;
    int[] misNumeros;
    EditText txtMenor;
    EditText txtMayor;
    EditText txtMedio;
    Button btnMenor;
    Button btnMayor;
    Button btnAsc;
    Button btnDesc;
    Button btnBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtNumber1 = findViewById(R.id.txtNumber1);
        txtNumber2 = findViewById(R.id.txtNumber2);
        txtNumber3 = findViewById(R.id.txtNumber3);
        txtMenor = findViewById(R.id.txtMenor);
        txtMedio = findViewById(R.id.txtMedio);
        txtMayor = findViewById(R.id.txtMayor);

        findViewById(R.id.btnMenor).setOnClickListener(view -> numeroMenor());
        findViewById(R.id.btnMayor).setOnClickListener(view -> numeroMayor());
        findViewById(R.id.btnAsc).setOnClickListener(view -> ordernarAsc());
        findViewById(R.id.btnDesc).setOnClickListener(view -> ordernarDesc());
        findViewById(R.id.btnBorrar).setOnClickListener(view -> borrar());
    }

    public void numeroMayor() {
        misNumeros = convertirAInt();
        txtMedio.setText(String.valueOf(misNumeros[2]));
        txtMenor.setText("");
        txtMayor.setText("");
    }

    public void numeroMenor() {
        misNumeros = convertirAInt();
        txtMedio.setText(String.valueOf(misNumeros[0]));
        txtMenor.setText("");
        txtMayor.setText("");
    }

    public void ordernarAsc() {
        misNumeros = convertirAInt();
        txtMenor.setText(String.valueOf(misNumeros[0]));
        txtMedio.setText(String.valueOf(misNumeros[1]));
        txtMayor.setText(String.valueOf(misNumeros[2]));
    }

    public void ordernarDesc() {
        misNumeros = convertirAInt();
        txtMenor.setText(String.valueOf(misNumeros[2]));
        txtMedio.setText(String.valueOf(misNumeros[1]));
        txtMayor.setText(String.valueOf(misNumeros[0]));
    }

    public void borrar() {
        txtNumber1.setText("");
        txtNumber2.setText("");
        txtNumber3.setText("");
        txtMenor.setText("");
        txtMayor.setText("");
        txtMedio.setText("");
    }

    public int[] convertirAInt() {
        String numero1 = txtNumber1.getText().toString();
        String numero2 = txtNumber2.getText().toString();
        String numero3 = txtNumber3.getText().toString();
        int[] numeros = new int[3];
        if (!numero1.isEmpty() && !numero2.isEmpty() && !numero3.isEmpty()) {
            numeros[0] = Integer.parseInt(numero1);
            numeros[1] = Integer.parseInt(numero2);
            numeros[2] = Integer.parseInt(numero3);
            Arrays.sort(numeros);
        }
        return numeros;
    }
}