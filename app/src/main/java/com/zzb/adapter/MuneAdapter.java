package com.zzb.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.zzb.entity.MenuEntity;
import com.zzb.ui.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zzb on 2017/3/29.
 */

public class MuneAdapter extends MyBaseAdapter<MenuEntity> {
    private DisplayImageOptions options;
    private Context context;
    public MuneAdapter(Context context) {
        super(context);
        this.context = context;
        options = new DisplayImageOptions.Builder()
                .showStubImage(R.mipmap.icon_file)//设置图片在下载期间显示的图片
                .showImageForEmptyUri(R.mipmap.ic_empty)//设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.mipmap.ic_error)//设置图片加载/解码过程中错误时候显示的图片
                .cacheInMemory()//设置下载的图片缓存在内存中
                .cacheOnDisc()//设置下载的图片缓存在SD卡中
                .displayer(new RoundedBitmapDisplayer(5))
                .build();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.menu_item_layout, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        MenuEntity menuEntity = getItem(position);
        ImageLoader.getInstance().displayImage(menuEntity.getUrl(),viewHolder.imgMenuitem,options);
        viewHolder.tvMenuTitle.setText(menuEntity.getTitle());
        viewHolder.tvMenuContext.setText(menuEntity.getContext());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.img_menuitem)
        ImageView imgMenuitem;
        @BindView(R.id.tv_menu_title)
        TextView tvMenuTitle;
        @BindView(R.id.tv_menu_context)
        TextView tvMenuContext;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
