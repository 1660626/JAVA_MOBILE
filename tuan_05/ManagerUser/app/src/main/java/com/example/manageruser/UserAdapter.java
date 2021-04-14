package com.example.manageruser;

import android.app.Activity;
import android.content.Context;

import android.graphics.drawable.Drawable;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class UserAdapter extends BaseAdapter  {
    private Context context;
    ArrayList<User> listUser;

    public UserAdapter(Context context,ArrayList<User> listUser1) {
        listUser = listUser1;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listUser.size();
    }

    @Override
    public Object getItem(int position) {
        return listUser.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        TextView txtHoTenF1;
        ImageView imageView;
//        LinearLayout linear_background;
        public ViewHolder(){
        }
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (view == null) {

            // Gọi layoutInflater ra để bắt đầu ánh xạ view và data.
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            // Đổ dữ liệu vào biến View, view này chính là những gì nằm trong custom_layout_user.xml
            view = inflater.inflate(R.layout.custom_layout_user, null);

            viewHolder = new ViewHolder();
            // Đặt chữ cho từng view trong danh sách.
            viewHolder.txtHoTenF1 = (TextView) view.findViewById(R.id.txtHoTenF1);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.imageView);
//            viewHolder.linear_background= (LinearLayout) view.findViewById(R.id.linear_background);
            view.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) view.getTag();

        }

        User user = (User) getItem(position);
        viewHolder.txtHoTenF1.setText(user.getMSSV());
        viewHolder.imageView.setImageResource(user.getHinhAnh());

//        Toast.makeText(context, user.getMSSV() +Boolean.toString(user.isHienthi()), Toast.LENGTH_SHORT ).show();
//
//        if(user.hienthi==true){
////            Toast.makeText(context, "true", Toast.LENGTH_SHORT ).show();
//
//            viewHolder.linear_background.setVisibility(View.VISIBLE);
//        }
//        if(user.hienthi==false){
////            Toast.makeText(context, "false", Toast.LENGTH_SHORT ).show();
//
//            viewHolder.linear_background.setVisibility(View.INVISIBLE);
//
//        }
        return view;

    }

}
