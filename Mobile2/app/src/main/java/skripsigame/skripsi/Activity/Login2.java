package skripsigame.skripsi.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import skripsigame.skripsi.ApiClient.ApiClient;
import skripsigame.skripsi.ApiClient.UserService;
import skripsigame.skripsi.Model.User;
import skripsigame.skripsi.R;

public class Login2 extends AppCompatActivity {
    EditText txtemail, txtpassword;
    TextInputLayout inputemail, inputpassword;
    Button btnlogin;
    TextView tviewdaftar,tviewforgotpass;
    Context context;
    AlertDialog alertDialog;
    AlertDialog.Builder alertDialogBuilder;
    ProgressDialog loading;
    private UserService userserviceapi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        context = this;

        initcomponent();
        initDialogBuilder();
        TextView register = (TextView)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getApplicationContext(),Register.class);
                startActivity(i);
            }
        });

        TextView forgotpassword = (TextView)findViewById(R.id.forgotpassword);
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getApplicationContext(),ForgotPassword.class);
                startActivity(i);
            }
        });

    }

    private void initcomponent(){
        inputemail = (TextInputLayout)findViewById(R.id.tilemail);
        inputpassword = (TextInputLayout)findViewById(R.id.tilpassword);
        txtemail = (EditText)findViewById(R.id.email);
        txtpassword = (EditText)findViewById(R.id.password);
        btnlogin = (Button)findViewById(R.id.login);
        tviewdaftar =(TextView)findViewById(R.id.register);
        tviewforgotpass=(TextView)findViewById(R.id.forgotpassword);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isvalid = true;
                inputemail.setErrorEnabled(false);
                inputpassword.setErrorEnabled(false);
                if(TextUtils.isEmpty(txtemail.getText())){
                    isvalid = false;

                    txtemail.setError("Email Required");

                }
                else if(TextUtils.isEmpty(txtpassword.getText())){
                    isvalid = false;

                    txtpassword.setError("Password Required");
                }

                if(TextUtils.isEmpty(txtemail.getText().toString()) || TextUtils.isEmpty(txtpassword.getText().toString())){
                    alertDialogBuilder.setMessage("Please fill all field").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }

                if(isvalid){
                    try {
                        Log.d("check try", "onClick: masuk try");
                        Log.v("EdiText", txtemail.getText().toString());
                        Log.v("EditText", txtpassword.getText().toString());
                        final User user = new User();
                        user.setEmail(txtemail.getText().toString());
                        user.setPassword(txtpassword.getText().toString());
                        final UserService userClient = ApiClient.getClient().create(UserService.class);
                        retrofit2.Call call = userClient.login(user);

                        call.enqueue(new Callback<User>() {
                            @Override
                            public void onResponse(retrofit2.Call<User> call, retrofit2.Response<User> response) {
                                if(response.isSuccessful()){
                                    Log.d("Call", "onResponse: call success");
                                    Intent intent = new Intent(Login2.this, PopularActivity.class);
                                    String token = response.body().getToken().toString();
                                    intent.putExtra("token", token);
                                    intent.putExtra("email",txtemail.getText().toString());
                                    startActivity(intent);
                                    finish();
                                }
                                else {
                                    txtemail.setText("");
                                    txtpassword.setText("");
                                    alertDialogBuilder.setMessage("Email or Password Invalid").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.dismiss();
                                        }
                                    });
                                    alertDialog = alertDialogBuilder.create();
                                    alertDialog.show();
                                }
                            }

                            @Override
                            public void onFailure(retrofit2.Call call, Throwable t) {
                                Log.d("On failure", "onFailure: retrofit failure");
                                Toast.makeText(getApplicationContext(), "Failed to call API", Toast.LENGTH_LONG).show();
                                alertDialogBuilder.setMessage("Connection Problem").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                });
                                alertDialog = alertDialogBuilder.create();
                                alertDialog.show();
                            }
                        });
                    }catch (Exception e){
                        Log.d("catch", "onClick: try failed");
                        Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
                        alertDialogBuilder.setMessage("Connection Problem").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    }
                }


            }
        });

    }

    private void requestLogin(){

    }

    private void initDialogBuilder() {
        alertDialogBuilder = new AlertDialog.Builder(this);
    }
}
