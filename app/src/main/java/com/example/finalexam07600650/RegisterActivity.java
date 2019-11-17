package com.example.finalexam07600650;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalexam07600650.DB.LedgerItem;
import com.example.finalexam07600650.DB.LedgerRepository;

public class RegisterActivity extends AppCompatActivity {
    private int mLedgerType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Intent intent =getIntent();
        mLedgerType = intent.getIntExtra("type",0);

//        ActionBar ab = getSupportActionBar();
//        if(ab != null){
//            ab.setTitle(mLedgerType==0? "บันทึกรายรับ" : "บันทึกรายจ่าย"); //ถ้าใช่ทำ "บันทึกรายรับ" ถ้าไม่ใช่ "บันทึกรายจ่าย" ถ้าไม่ทำแบบนี้ไปทำif elseที่ class LedgerRecyclerViewAdapter
//        }
//        ImageView ledgerTypeImageView =findViewById(R.id.ledger_type_image_View);
//        ledgerTypeImageView.setImageResource(
//                mLedgerType==0? R.drawable.ic_income : R.drawable.ic_expense
//        );

        Button registerButton =findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText fullnameEditText =findViewById(R.id.full_name_edit_text);
                String fullname = fullnameEditText.getText().toString();

                EditText usernameEditText =findViewById(R.id.username_edit_text);
                String username = usernameEditText.getText().toString();

                EditText passwordEditText =findViewById(R.id.password_edit_text);
                String password = passwordEditText.getText().toString();
                if(username.equals("") && password.equals("") &&  fullname.equals("")){
                    Toast.makeText(RegisterActivity.this,"All fields are required",Toast.LENGTH_SHORT).show();
                }else {
                    LedgerItem item = new LedgerItem(0, fullname, username, password);
                    LedgerRepository repo = new LedgerRepository(RegisterActivity.this);
                    repo.insertLedger(item, new LedgerRepository.InsertCallback() {
                        @Override
                        public void onInsertSuccess() {
                            //reloadData();
                            Toast.makeText(RegisterActivity.this,"Register successfully",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    });
                }
            }
        });
    }
}