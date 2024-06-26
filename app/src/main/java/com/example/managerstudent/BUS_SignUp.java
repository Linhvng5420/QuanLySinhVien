package com.example.managerstudent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.managerstudent.Minh.Database.DBAccount;

public class BUS_SignUp extends AppCompatActivity {

EditText edtUser,edtPassword,edtConfirmPassword;
Button btnCear, btnConfirm;
DBAccount dbAccount = new DBAccount(this, null, null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gui_sign_up);
        SetControl();
        SetEvent();
    }

    private void SetEvent() {
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbAccount.addAccount(edtUser.getText().toString().trim(), edtPassword.getText().toString().trim());
                if (dbAccount.getListAccount().size() > 0) {
                    if(edtPassword.getText().toString().trim().equals(edtConfirmPassword.getText().toString().trim())){
                        Intent inte = new Intent(BUS_SignUp.this, BUS_Login.class);
                        startActivity(inte);
                        Toast.makeText(BUS_SignUp.this, "dang ki thanh cong", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(BUS_SignUp.this,"mat khau khong trung nhau" , Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        btnCear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtUser.getText().clear();
                edtPassword.getText().clear();
                edtConfirmPassword.getText().clear();

            }
        });
    }

    private void SetControl() {
        edtUser = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        btnCear = findViewById(R.id.btnClear);
        btnConfirm = findViewById(R.id.btnConfirm);
    }
}