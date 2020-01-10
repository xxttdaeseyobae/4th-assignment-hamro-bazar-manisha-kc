package com.example.hamrobaraz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hamrobaraz.API.UsersAPI;
import com.example.hamrobaraz.StrictMode.StrictModeClass;
import com.example.hamrobaraz.URL.URL;
import com.example.hamrobaraz.module.User;
import com.example.hamrobaraz.serverresponse.ImageResponse;
import com.example.hamrobaraz.serverresponse.SignUpResponse;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private EditText etReEmail, etReFullName, etRePassword, etReConPassword, etRePhone, etReMobPhone;
    private EditText etReAddressOne, etReAddressTwo;

    private Button btnRegisterFinal;

    private ImageView imgProfile;


    private Spinner spinCityThree;
    private TextView tvRegisterTerms;

    String imageUserPath;
    private String imageName = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        etReEmail = findViewById(R.id.etReEmail);
        etReFullName = findViewById(R.id.etReFullName);
        etRePassword = findViewById(R.id.etRePassword);
        etReConPassword = findViewById(R.id.etReConPassword);
        etRePhone = findViewById(R.id.etReMobPhone);
        etReMobPhone = findViewById(R.id.etReMobPhone);
        etReAddressOne = findViewById(R.id.etReAddressOne);
        etReAddressTwo = findViewById(R.id.etReAddressTwo);

        imgProfile = findViewById(R.id.imgProfile);
        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BrowseImage();
            }
        });

        btnRegisterFinal = findViewById(R.id.btnRegisterFinal);
        btnRegisterFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((etRePassword.getText().toString()).equals(etReConPassword.getText().toString())) {
                    if(validate()) {
                        saveImageOnly();
                        signUp();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    etRePassword.requestFocus();
                    return;
                }

            }
        });


        spinCityThree = findViewById(R.id.spinCityThree);

        String cities[] = {"Kathmandu","Lalitpur","Bhaktapur","Pokhara","Bara","Baglung","Chitwan","Dama","Dang","Syangja","Gorkha","Itahari","Hetauda","Biratnagar","Janakpur","Dadeldhura","Dhankuta"};

        ArrayAdapter spinAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                cities
        );

        spinCityThree.setAdapter(spinAdapter);

        //Terms Section
        tvRegisterTerms = findViewById(R.id.tvRegisterTerms);
        tvRegisterTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, TermsConditionActivity.class);
                startActivity(intent);
            }
        });

    }
    private boolean validate() {
        boolean status=true;
        if (etReFullName.getText().toString().length() < 6) {
            etReFullName.setError("Minimum 20 character");
            status=false;
        }
        return status;
    }

    private void BrowseImage() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (data == null) {
                Toast.makeText(this, "Please select an image ", Toast.LENGTH_SHORT).show();
            }
        }
        Uri uri = data.getData();
        imgProfile.setImageURI(uri);
        imageUserPath = getRealPathFromUri(uri);
    }

    private String getRealPathFromUri(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(getApplicationContext(),
                uri, projection, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int colIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(colIndex);
        cursor.close();
        return result;
    }

    private void saveImageOnly() {
        File file = new File(imageUserPath);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("profileImage",
                file.getName(), requestBody);

        UsersAPI usersAPI = URL.getInstance().create(UsersAPI.class);
        Call<ImageResponse> responseBodyCall = usersAPI.uploadImage(body);

        StrictModeClass.StrictMode();
        //Synchronous methid
        try {
            Response<ImageResponse> imageResponseResponse = responseBodyCall.execute();
            imageName = imageResponseResponse.body().getFilename();
            Toast.makeText(this, "Image inserted" + imageName, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Error" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void signUp() {

        String email= etReEmail.getText().toString();
        String fullname = etReFullName.getText().toString(  );
        String password = etRePassword.getText().toString();
        String phone = etRePhone.getText().toString();
        String mobilePhone = etReMobPhone.getText().toString();
        String  streetName = etReAddressOne.getText().toString();
        String  areaLocation = etReAddressTwo.getText().toString();
        String  cityName = spinCityThree.getSelectedItem().toString();

        User users = new User(imageName, email,fullname,password,phone,mobilePhone,streetName,areaLocation,cityName);

        UsersAPI usersAPI = URL.getInstance().create(UsersAPI.class);
        Call<SignUpResponse> signUpCall = usersAPI.registerUser(users);

        signUpCall.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(RegisterActivity.this, "Registered", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}