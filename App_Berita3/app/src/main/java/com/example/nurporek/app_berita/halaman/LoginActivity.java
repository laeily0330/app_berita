package com.example.nurporek.app_berita.halaman;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nurporek.app_berita.MainActivity;
import com.example.nurporek.app_berita.R;
import com.example.nurporek.app_berita.generator.ServiceGenerator;
import com.example.nurporek.app_berita.model.User;
import com.example.nurporek.app_berita.services.Services;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    AutoCompleteTextView email;
    EditText password;
    Button logIn, signUp, btnHome;
    public int id_user;
    public String nama_user, e_mail;
    public int logged = 0;
    private static final String TAG = LoginActivity.class.getSimpleName();
    private static final String PREF_NAME = TAG+"_prefs";
    private SharedPreferences mPref;
    Services gotService = ServiceGenerator.createService(Services.class);
    List<User> userList = new ArrayList<>();

    @Override
    public void onBackPressed() {

    }

//    private static final String TAG = "LoginActivity";
//    private static final int REQUEST_SIGNUP = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mPref = getSharedPreferences(PREF_NAME,MODE_PRIVATE);

        Call<List<User>> callUser = gotService.getUser();
        callUser.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> callUser, Response<List<User>> response) {
                Log.d("SOKO", "SUKSES");
                userList.clear();
                userList.addAll(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("SOKO", "GAGAL");
            }
        });

        btnHome = (Button) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("id_user", id_user);
                i.putExtra("nama_user", nama_user);
                i.putExtra("e_mail", e_mail);
                i.putExtra("logged", logged);
                startActivity(i);
            }
        });

        email = (AutoCompleteTextView) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        String storedUsername = mPref.getString("EMAIL",""); //bikin key firstname dan value default string null,
        email.setText(storedUsername); //ngambil text dari layout u/ ke storeduname
        String storedPassword = mPref.getString("PASSWORD","");
        password.setText(storedPassword);
        logIn = (Button) findViewById(R.id.email_sign_in_button);
        signUp = (Button) findViewById(R.id.button);

        logIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this, R.style.Base_V7_Theme_AppCompat_Light_Dialog);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Authenticating...");
                progressDialog.show();

                String emails = email.getText().toString();
                String passwords = password.getText().toString();

                int found = 0;
                for(int pos=0; pos<userList.size(); pos++) {
                    User itemUser = userList.get(pos);
                    if (emails.equals(itemUser.getEmail()) && passwords.equals(itemUser.getPassword())) {
                        found = 1;
                        id_user = itemUser.getId_user();
                        nama_user = itemUser.getNama();
                        e_mail = itemUser.getEmail();
                        break;
                    }
                }

                if (found == 1){
                    logged = 1;
                    String emailText = email.getText().toString(); //ngambil dari storeduname ke unametext diganti string
                    String passwordText = password.getText().toString();

                    SharedPreferences.Editor editor = mPref.edit(); //mengedit isi mPref
                    editor.putString("FIRSTNAME",emailText); //set mPref baru
                    editor.putString("LASTNAME",passwordText);
                    editor.apply();
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    i.putExtra("id_user", id_user);
                    i.putExtra("nama_user", nama_user);
                    i.putExtra("e_mail", e_mail);
                    i.putExtra("logged", logged);
                    startActivity(i);
//                    if(i.equals(null)|| i.getData()==null){
//                        Log.d("INTENT heueheuehehe", "NULLLLLLLLLL");
//                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                    progressDialog.hide();
                }
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), hal_registrasi.class);
                startActivity(i);
            }
        });
    }

}

