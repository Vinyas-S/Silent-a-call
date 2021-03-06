package com.example.silentcall.Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.silentcall.Activities.MainActivity;
import com.example.silentcall.DBUtils.DBHelper;
import com.example.silentcall.R;


public class AllContactsHolder extends RecyclerView.ViewHolder {

    TextView allContactsLetter;
    TextView allContactsName, allContactsNumber;
    ImageView circle;
    View contactColor;
    View view;
    DBHelper mydb;
    GradientDrawable gd;

    public AllContactsHolder(View itemView, final Context ctx) {
        super(itemView);

        this.allContactsName = (TextView) itemView.findViewById(R.id.allContactsName);
        this.allContactsNumber = (TextView) itemView.findViewById(R.id.allContactsNumber);
        this.allContactsLetter = (TextView) itemView.findViewById(R.id.contactLetter);
        this.contactColor = itemView.findViewById(R.id.contactColor);
        circle = (ImageView) itemView.findViewById(R.id.circle);
        gd = (GradientDrawable) circle.getBackground();

        this.view = itemView;

        mydb = new DBHelper(ctx);

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);

                alertDialog.setTitle("Remove");
                alertDialog.setMessage("Are you sure you want remove this contact?");
                alertDialog.setIcon(R.mipmap.ic_bin);

                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        mydb.deleteData(allContactsNumber.getText().toString().trim());
                        MainActivity.getOnDelete().onDel();
                    }
                });

                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                alertDialog.show();
                return true;
            }
        });

    }
}
