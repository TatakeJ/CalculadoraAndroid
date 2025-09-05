package com.example.calculadora_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button btnSuma, btnResta, btnMulti, btnDiv;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Vincula con activity_main.xml

        // Vincular elementos del XML con Java
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        btnSuma = findViewById(R.id.btnSuma);
        btnResta = findViewById(R.id.btnResta);
        btnMulti = findViewById(R.id.btnMulti);
        btnDiv = findViewById(R.id.btnDiv);
        txtResultado = findViewById(R.id.txtResultado);

        // Eventos de botones
        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular("+");
            }
        });

        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular("-");
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular("*");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular("/");
            }
        });
    }

    // Método para realizar la operación
    private void calcular(String operacion) {
        String s1 = num1.getText().toString();
        String s2 = num2.getText().toString();

        if (s1.isEmpty() || s2.isEmpty()) {
            txtResultado.setText("Por favor, ingrese ambos números");
            return;
        }

        double n1 = Double.parseDouble(s1);
        double n2 = Double.parseDouble(s2);
        double resultado = 0;

        switch (operacion) {
            case "+": resultado = n1 + n2; break;
            case "-": resultado = n1 - n2; break;
            case "*": resultado = n1 * n2; break;
            case "/":
                if (n2 == 0) {
                    txtResultado.setText("Error: división por 0");
                    return;
                } else {
                    resultado = n1 / n2;
                }
                break;
        }

        txtResultado.setText("Resultado: " + resultado);
    }
}
