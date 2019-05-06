package com.example.contact.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.contact.MainActivity;
import com.example.contact.R;
import com.example.contact.module.contact;

import java.util.List;


public class contactadapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List <contact> listcontact;

    public contactadapter (Context context, int layout, List <contact> listcontact) {
        this.context = context;
        this.layout = layout;
        this.listcontact = listcontact;
    }

    @Override
    public int getCount ( ) {
        return listcontact.size ();
    }

    @Override
    public Object getItem (int position) {
        return null;
    }

    @Override
    public long getItemId (int position) {
        return 0;
    }
    private class ViewHolder{
        ImageView imgAvatar;
        TextView tvName, tvNumber;

    };

    @Override
    public View getView (int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService (Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate (layout, null);
            holder = new ViewHolder ();

            // anh xa view
            holder.tvName = view.findViewById (R.id.tvName);
            holder.tvNumber = view.findViewById (R.id.tvNumber);
            holder.imgAvatar = view.findViewById (R.id.imgAvatar);
            view.setTag (holder);
        }
        else {
            holder = (ViewHolder) view.getTag ();
        }


        // gan gia tri
        contact contact = listcontact.get(position);
        holder.tvName.setText (contact.getName());
        holder.tvNumber.setText (contact.getNumber());
        if(contact.isMale ()){
       holder.imgAvatar.setImageResource (R.drawable.man);
        }
        else{
            holder.imgAvatar.setImageResource (R.drawable.girl);

        }
        return view;

    }
}
