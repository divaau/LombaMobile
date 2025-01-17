package io.github.aerhakim.lombamobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

import dev.shreyaspatil.MaterialDialog.BottomSheetMaterialDialog;
import dev.shreyaspatil.MaterialDialog.interfaces.DialogInterface;
import dev.shreyaspatil.MaterialDialog.model.TextAlignment;
import io.github.aerhakim.lombamobile.R;
import io.github.aerhakim.lombamobile.activity.InsertActivity;
import io.github.aerhakim.lombamobile.activity.UangSampahActivity;
import io.github.aerhakim.lombamobile.api.bayar.Config;
import io.github.aerhakim.lombamobile.model.Heros;


public class HerosAdapter extends RecyclerView.Adapter<HerosAdapter.MyViewHolder>{
    List<Heros> herosList;
    Context context;
    public HerosAdapter(Context context, List<Heros> herosList) {
        this.context = context;
        this.herosList = herosList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(context).inflate(R.layout.item_transaksi, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewName.setText(herosList.get(position).getName());
        holder.mTextViewDescription.setText(herosList.get(position).getDescription());
        holder.mTextViewDate.setText(herosList.get(position).getDate());
        String anjayani = "Jumlah Bayar : \n"+herosList.get(position).getName()
                +"\n\nTanggal : "+herosList.get(position).getDate()
                +"\n\nCatatan : \n"+herosList.get(position).getDescription();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetMaterialDialog mBottomSheetDialog = new BottomSheetMaterialDialog.Builder((Activity) context)

                        .setTitle("Detail Pembayaran")
                        .setMessage(anjayani, TextAlignment.START)
                        .setCancelable(false)
                        .setPositiveButton("Tutup", new BottomSheetMaterialDialog.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                dialogInterface.dismiss();
                            }
                        })
                        .build();

                // Show Dialog
                mBottomSheetDialog.show();
            }
        });
    }

    @Override
    public int getItemCount () {
        return herosList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewName, mTextViewDescription, mTextViewDate;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewName = (TextView) itemView.findViewById(R.id.jumlah);
            mTextViewDescription = (TextView) itemView.findViewById(R.id.deskripsi);
            mTextViewDate = (TextView) itemView.findViewById(R.id.tanggal);

        }
    }
}
