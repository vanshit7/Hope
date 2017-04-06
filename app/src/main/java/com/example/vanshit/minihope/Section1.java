package com.example.vanshit.minihope;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Section1 extends AppCompatActivity {

    private static final int PICK_IMAGE = 1;
    sql sql_obj;
    public EditText ename,eaddress,ephone,eproblem0,eproblem1,eproblem2;
    public String name,address,problem0,problem1,problem2,fproblem,phone;
    public TextView result ;
    Button regbut;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section1);
        sql_obj = new sql(this);
        ename = (EditText)findViewById(R.id.editname);
        eaddress = (EditText)findViewById(R.id.editAdd);
        ephone = (EditText)findViewById(R.id.editPhone);
        eproblem0 = (EditText)findViewById(R.id.editProblem0);
        eproblem1 = (EditText)findViewById(R.id.editProblem1);
        eproblem2 = (EditText)findViewById(R.id.editProblem2);
        img = (ImageView)findViewById(R.id.imgview);
        regbut = (Button)findViewById(R.id.butreg);
        image();
        result = (TextView)findViewById(R.id.print);
        //result.setText("hey");
        //printdata();
        regbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();

            }
        });
    }
    public void printdata(){
        String dbstring = sql_obj.databaseToString();
        result.setText(dbstring);
    }
    public void image(){
        ImageButton click = (ImageButton)findViewById(R.id.imgbutupload);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gall();
            }
        });
    }
    private void gall(){
        Intent gallery = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK ) {
            Uri selectedImage = data.getData();


            /*String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();*/
            img.setImageURI(selectedImage);
            // String picturePath contains the path of selected Image
        }
    }
    public void register(){
        initialize();
        if(!validate()){
            Toast.makeText(this,"SignUp Failed",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"SignUp successful",Toast.LENGTH_SHORT).show();
            addUser();
        }


    }
    public boolean validate(){
        boolean valid = true;
        if(name.isEmpty()){
            //Toast.makeText(this,"Name Cannot Be Empty",Toast.LENGTH_SHORT).show();
            ename.setError("Name Cannot Be Empty");
            valid = false;
        }
        if(name.length()>32){
            //Toast.makeText(this,"Name Too Long",Toast.LENGTH_SHORT).show();
            ename.setError("Name Too Long");
            valid = false;
        }
        if(address.isEmpty()){
            //Toast.makeText(this,"Address Cannot Be Empty",Toast.LENGTH_SHORT).show();
            eaddress.setError("Address Cannot Be Empty");
            valid = false;
        }
        if(phone.isEmpty()){
            //Toast.makeText(this,"Phone number Cannot Be Empty",Toast.LENGTH_SHORT).show();
            ephone.setError("Phone number Cannot Be Empty");
            valid = false;
        }
        //if(phone.is)
        if(phone.length()!=10){
           // Toast.makeText(this,"Enter Valid Phone Number",Toast.LENGTH_SHORT).show();
            ephone.setError("Enter Valid Phone Number");
            valid = false;
        }
        if(problem0.isEmpty()){
            eproblem0.setError("Please Let Us know Your Problem");
            valid = false;
        }
        return valid;
    }
    public void initialize(){
        name = ename.getText().toString().trim();
        address = eaddress.getText().toString().trim();
        phone = ephone.getText().toString().trim();
        problem0 = eproblem0.getText().toString().trim();
        problem1 = eproblem1.getText().toString().trim();
        problem2 = eproblem2.getText().toString().trim();
        fproblem = problem0.concat(" ").concat(problem1).concat(" ").concat(problem2);
    }

    public void addUser(){
        long id = sql_obj.adduser(this);
        //printdata();
        Toast.makeText(this,"good",Toast.LENGTH_LONG).show();
        if(id<0)
        {
            Toast.makeText(this,"failed",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"successfully inserted",Toast.LENGTH_LONG).show();
        }
    }
}
