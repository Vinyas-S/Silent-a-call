package com.example.silentcall.Utils;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.silentcall.DBUtils.ContactDetails;
import com.example.silentcall.R;

import java.util.ArrayList;


public class AllContactsAdapter extends RecyclerView.Adapter<AllContactsHolder> {

    Context ctx;
    ArrayList<ContactDetails> allContactsArrayList;

    public AllContactsAdapter(Context context, ArrayList<ContactDetails> list) {
        this.ctx = context;
        this.allContactsArrayList = list;
    }

    @Override
    public AllContactsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.all_contact_sample, parent, false);

        return new AllContactsHolder(itemView, ctx);
    }

    @Override
    public void onBindViewHolder(AllContactsHolder holder, int position) {
        final ContactDetails contactDetails = allContactsArrayList.get(position);
        holder.allContactsName.setText(contactDetails.getName());
        holder.allContactsNumber.setText(contactDetails.getNumber());
        holder.allContactsLetter.setText(Character.toString(contactDetails.getName().charAt(0)));
        if (position % 6 == 0){
            holder.gd.setColor(Color.parseColor("#FF0000"));
        }
        if (position % 6 == 1) {
            holder.gd.setColor(Color.BLUE);
        }
        if (position % 6 == 2){
            holder.gd.setColor(Color.parseColor("#008000"));
        }
        if (position % 6 == 3){
            holder.gd.setColor(Color.parseColor("#FFA500"));
        }
        if (position % 6 == 4){
            holder.gd.setColor(Color.parseColor("#800000"));
        }
        if (position % 6 == 5){
            holder.gd.setColor(Color.parseColor("#191970"));
        }
    }

    @Override
    public int getItemCount() {
        return allContactsArrayList.size();
    }
}
