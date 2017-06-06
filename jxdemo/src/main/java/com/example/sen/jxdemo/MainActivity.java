package com.example.sen.jxdemo;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.jxccp.ui.view.JXInitActivity;


public class MainActivity extends AppCompatActivity implements JXPermissionUtil.OnPermissionCallback{

    JXPermissionUtil mJXPermissionUtil;
    int requestCode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mJXPermissionUtil = new JXPermissionUtil();
    }

    public void onClick(View view){
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M ){
            String[] permissions = new String[]{Manifest.permission.INTERNET, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_NETWORK_STATE, Manifest.permission.CAMERA};
            mJXPermissionUtil.requestPermissions(this, requestCode, permissions, this);
        }else{
            startActivity(new Intent(this, JXInitActivity.class));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mJXPermissionUtil.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onGranted() {
        startActivity(new Intent(this, JXInitActivity.class));
    }

    @Override
    public void onDenied() {
        Toast.makeText(getApplicationContext(), "无法获取权限，请允许权限后重试", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mJXPermissionUtil = null;
    }
}
