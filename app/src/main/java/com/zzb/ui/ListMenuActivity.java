package com.zzb.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ListMenuActivity extends AppCompatActivity {
    @BindView(R.id.certification_toolbar)
    Toolbar certificationToolbar;
    @BindView(R.id.lv_menu)
    ListView lvMenu;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);
        unbinder = ButterKnife.bind(this);
        certificationToolbar.setTitle("");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
