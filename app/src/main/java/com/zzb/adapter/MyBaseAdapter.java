package com.zzb.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzb on 2017/3/29.
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {
    private Context context;
    protected LayoutInflater inflater;
    private ArrayList<T> arrayList = new ArrayList<>();

    public MyBaseAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * 适配器增加数据
     * */
    public void addData(T t){
        arrayList.add(t);
    }

    public void addAllDataToMyadapter(List<T> e){
        arrayList.clear();
        arrayList.addAll(e);//增加一个列表
    }

    public void delDataFromMyadapter(){
        //删除新增加的列表
        arrayList.remove(arrayList.size()-1);
    }

    public void delDataALL(){
        //一键清空
        arrayList.clear();
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public T getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }




}
