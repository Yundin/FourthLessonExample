package org.styleru.fourthlessonexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.styleru.fourthlessonexample.api.ApiService;
import org.styleru.fourthlessonexample.api.ExampleRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Yundin Vladislav
 */
public class AddActivity extends AppCompatActivity {

    EditText name;
    EditText description;
    EditText about;
    Button apply;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = findViewById(R.id.name);
        description = findViewById(R.id.desc);
        about = findViewById(R.id.about);
        apply = findViewById(R.id.apply);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameSrt = name.getText().toString();
                String descriptionSrt = description.getText().toString();
                String aboutSrt = about.getText().toString();
                if (!nameSrt.equals("") && !descriptionSrt.equals("") && !aboutSrt.equals("")) {
                    ApiService.getApiInterface()
                            .replace("application/json", new ExampleRequest(nameSrt, descriptionSrt, aboutSrt))
                            .enqueue(new Callback<Void>() {
                                @Override
                                public void onResponse(Call<Void> call, Response<Void> response) {
                                    Toast.makeText(getApplicationContext(), String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                                    finish();
                                }

                                @Override
                                public void onFailure(Call<Void> call, Throwable t) {
                                    finish();
                                }
                            });
                }
            }
        });
    }
}
