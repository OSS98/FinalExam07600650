package com.example.finalexam07600650;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import com.example.finalexam07600650.DB.AppDatabase;
import com.example.finalexam07600650.DB.LedgerItem;
import com.example.finalexam07600650.DB.LedgerRepository;

import java.util.List;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button regisButton=findViewById(R.id.register_button);
        regisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(LoginActivity.this,RegisterActivity.class);
                intent.putExtra("type",0);  //เรากำหนด 0=รายรับ
                startActivity(intent);
            }
        });


        Button loginButton =findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usernameEditText =findViewById(R.id.username_edit_text);
                String username = usernameEditText.getText().toString();

                EditText passwordEditText =findViewById(R.id.password_edit_text);
                String password = passwordEditText.getText().toString();
                if(username.equals("") && password.equals("") ){
                    Toast.makeText(LoginActivity.this,"All fields are required",Toast.LENGTH_SHORT).show();
                }else{
                    final LedgerRepository repo =new LedgerRepository(LoginActivity.this);

                    repo.getLedger(username, password, new LedgerRepository.Callback() {
                        @Override
                        public void onGetLedger(List<LedgerItem> itemList) {
                            Log.i("MainActivity", "Item List Size: " + itemList.size());

                            for (LedgerItem item : itemList) {
                                Log.i("LoginActivity", "user : " + item.username);
                            }
                        }
                    });
                }
            }
        });
    }


}
