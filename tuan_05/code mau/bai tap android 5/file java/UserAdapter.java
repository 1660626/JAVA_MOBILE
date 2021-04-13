package com.jerem.fragments2;

import android.content.Context;

import android.graphics.drawable.Drawable;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    ArrayList<User> ListUser;
    Context context;


    public UserAdapter(ArrayList<User> listUser, Context context) {
        ListUser = listUser;
        this.context = context;
    }
    public class ViewHolder{
        TextView txtmasv;
        ImageView imghinhuser;
        LinearLayout linear_background;
        public ViewHolder(){

        }
    }
    @Override
    public int getCount() {
        return ListUser.size();
    }

    @Override
    public Object getItem(int position) {
        return ListUser.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    private Drawable getdrawablehinh(int idDrawable)
    {
        Drawable drawable;
        if(Build.VERSION.SDK_INT>21)
        {
            drawable= ContextCompat.getDrawable(context,idDrawable);
        }
        else
        {
            drawable= context.getResources().getDrawable(idDrawable);
        }
        return  drawable;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(view==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.custom_user_layout,null);
            viewHolder.txtmasv= (TextView) view.findViewById(R.id.txtmasv);
            viewHolder.linear_background= (LinearLayout) view.findViewById(R.id.linear_background);
            viewHolder.imghinhuser= (ImageView) view.findViewById(R.id.imghinhuser);

            view.setTag(viewHolder);
        }else
        {
            viewHolder= (ViewHolder) view.getTag();
        }
        User user= (User) getItem(position);
        viewHolder.txtmasv.setText(user.getMasv());

        Drawable drawable_hinh=getdrawablehinh(user.getHinhanh());
        viewHolder.imghinhuser.setImageDrawable(drawable_hinh);
        Log.d("LOG_TAMMMMMM", "getView: "+position+"-"+ListUser.get(position).isHienthi());
        if(user.hienthi==true){

            viewHolder.linear_background.setVisibility(View.VISIBLE);
        }
        if(user.hienthi==false){
            viewHolder.linear_background.setVisibility(View.INVISIBLE);

        }
        return view;
    }
}
