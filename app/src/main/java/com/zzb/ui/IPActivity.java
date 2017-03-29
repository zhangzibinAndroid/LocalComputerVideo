package com.zzb.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class IPActivity extends AppCompatActivity {
    @BindView(R.id.certification_toolbar)
    Toolbar certificationToolbar;
    @BindView(R.id.edt_IP)
    EditText edtIP;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip);
        unbinder = ButterKnife.bind(this);
        certificationToolbar.setTitle("");
        edtIP.setHint("请输入IP地址");
    }

    @OnClick(R.id.btn_ok)
    public void onClick() {
        String IP = edtIP.getText().toString();
        if (!IP.equals("")&&IP != null){
            Intent intent = new Intent(this,ListMenuActivity.class);
            intent.putExtra("IpAddress",IP);
            startActivity(intent);
        }else {
            Toast.makeText(this, "IP地址不能为空", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
