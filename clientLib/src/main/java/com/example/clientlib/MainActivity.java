package com.example.clientlib;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.aidllib.ISimpleAidlInterface;

public class MainActivity extends AppCompatActivity implements ServiceConnection{

    private ISimpleAidlInterface iSimpleAidlInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=(Button)findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int result = iSimpleAidlInterface.add(20,10);
                    Toast.makeText(getApplicationContext(), "Res:"+result, Toast.LENGTH_LONG).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    protected void onStart() {
        super.onStart();
        bindService(new Intent("com.example.user06.serveraidlservice.ServerService").setPackage("com.example.user06.serveraidlservice")
                ,this,BIND_AUTO_CREATE);

    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        iSimpleAidlInterface = ISimpleAidlInterface.Stub.asInterface(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
