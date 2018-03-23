package org.styleru.fourthlessonexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.styleru.fourthlessonexample.api.ApiService;
import org.styleru.fourthlessonexample.api.ExampleResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button updateButton;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);
        updateButton = findViewById(R.id.update);
        addButton = findViewById(R.id.add);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAddActivity();
            }
        });
    }

    private void updateData() {
        ApiService.getApiInterface()
                .getData()
                .enqueue(new Callback<ExampleResponse>() {
                    @Override
                    public void onResponse(Call<ExampleResponse> call, Response<ExampleResponse> response) {
                        if (response.body() != null) {
                            String name = response.body().getName();
                            String description = response.body().getDescription();
                            String about = response.body().getAbout();
                            textView.setText(getString(R.string.template, name, description, about));
                        }
                    }

                    @Override
                    public void onFailure(Call<ExampleResponse> call, Throwable t) {

                    }
                });
    }

    private void goToAddActivity() {

        startActivity(new Intent(this, AddActivity.class));
    }
}
