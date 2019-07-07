package com.cmpundhir.cm.allwidgetsdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.security.Permission;

public class PermissionActivity extends AppCompatActivity implements View .OnClickListener{
public static final int permissioncodeforreadcontact=11;
public static final int permissioncodeforcameraaccess=12;
public static final int permissioncodefordialnumber=13;
Button btn,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        init();
    }
    public void init(){
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.btn){
            permtoreadcontact();
        }
        if(id == R.id.btn2){
            permtoopencamera();
        }
        if(id == R.id.btn3){
            permtodialnumber();
        }
    }
    private void permtoopencamera(){
        if(ContextCompat.checkSelfPermission(PermissionActivity.this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(PermissionActivity.this, new String[]{Manifest.permission.CAMERA}, permissioncodeforcameraaccess);
        }
        else{
            open_camera_permission();
        }
    }
    private void permtoreadcontact(){
        if(ContextCompat.checkSelfPermission(PermissionActivity.this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(PermissionActivity.this, new String[]{ Manifest.permission.READ_CONTACTS},permissioncodeforreadcontact);
        }
        else{
            read_contact_permission();
        }
    }
    private void permtodialnumber(){
        if(ContextCompat.checkSelfPermission(PermissionActivity.this, Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(PermissionActivity.this, new String[]{Manifest.permission.CALL_PHONE}, permissioncodefordialnumber);
        }
        else{
            dial_number_permission();
        }
    }
    private void read_contact_permission(){
        AlertDialog.Builder builder = new AlertDialog.Builder(PermissionActivity.this);
        builder.setTitle("Permission granted");
        builder.setMessage("You already have given the permission to read contacts");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent contact_intent = new Intent(Intent.ACTION_PICK,ContactsContract.Contacts.CONTENT_URI);
                if(contact_intent.resolveActivity(getPackageManager())!=null){
                    startActivity(contact_intent);
                }
                else{
                    Toast.makeText(PermissionActivity.this, "Can't show contact", Toast.LENGTH_LONG).show();
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void open_camera_permission(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(PermissionActivity.this);
        builder.setTitle("Permission granted");
        builder.setMessage("You have already given permission to access to open camera");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent camera_intent = new Intent();
                camera_intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                if(camera_intent.resolveActivity(getPackageManager())!=null){
                    startActivity(camera_intent);
                }
                else{
                    Toast.makeText(PermissionActivity.this, "Can't open camera", Toast.LENGTH_LONG).show();
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void dial_number_permission(){
        AlertDialog.Builder builder = new AlertDialog.Builder(PermissionActivity.this);
        builder.setTitle("Permission granted");
        builder.setMessage("You have already given permission to dial number");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent dial_number_intent = new Intent();
                dial_number_intent.setAction(Intent.ACTION_DIAL);
                dial_number_intent.setData(Uri.parse("tel:"+"9999664813"));
                if(dial_number_intent.resolveActivity(getPackageManager())!=null){
                    startActivity(dial_number_intent);
                }
                else {
                    Toast.makeText(PermissionActivity.this, "Can't dial number", Toast.LENGTH_LONG).show();
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
