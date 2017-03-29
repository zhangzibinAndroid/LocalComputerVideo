package com.zzb.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zzb.adapter.MuneAdapter;
import com.zzb.entity.MenuEntity;
import com.zzb.utils.MyContext;
import com.zzb.utils.MyUrl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ListMenuActivity extends AppCompatActivity {
    @BindView(R.id.certification_toolbar)
    Toolbar certificationToolbar;
    @BindView(R.id.lv_menu)
    ListView lvMenu;
    private Unbinder unbinder;
    private MuneAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);
        unbinder = ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        certificationToolbar.setTitle("");
        adapter = new MuneAdapter(this);
        lvMenu.setAdapter(adapter);
        MenuEntity menuEntity = new MenuEntity(getResources().getString(R.string.yaojingweiba), MyContext.yaojingweiba, MyUrl.yaojingweiba);
        adapter.addData(menuEntity);
        adapter.notifyDataSetChanged();

        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
