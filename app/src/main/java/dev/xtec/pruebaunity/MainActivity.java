package dev.xtec.pruebaunity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ExempleView vistaExample;
    Button bt;
    View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vistaExample = findViewById(R.id.exempleView);
        bt=findViewById(R.id.buttonBT);
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                if (vistaExample.cercleblau) {
                    vistaExample.cercleblau=false;
                    vistaExample.nau.setPosX(50);
                } else {
                    vistaExample.cercleblau=true;
                    vistaExample.nau.setPosX(350);
                }
                vistaExample.postInvalidate();
            }
        });
    }
}