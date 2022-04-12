package com.unicon.ipms.student_ui.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unicon.ipms.R;
import com.unicon.ipms.myIntenshipDateModel;

import java.util.List;

public class myinternAdaptor extends RecyclerView.Adapter<myinternAdaptor.holder> {

    String data[];
    String sd[], ed[];
    List<myIntenshipDateModel> model;
    LayoutInflater inflater;

    public myinternAdaptor(Context ctx,List<myIntenshipDateModel> model) {
        this.inflater = LayoutInflater.from(ctx);
        this.model  = model;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.student_my_internship_cardview, parent, false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
//        String title = data[position];
//        String sd_1 = sd[position];
//        String ed_1 = ed[position];
//        holder.tv.setText(title);
//        holder.sd.setText(sd_1);
//        holder.ed.setText(ed_1);
        holder.tv.setText(model.get(position).getCompany_name());
        holder.sd.setText(model.get(position).getStart_date());
        holder.ed.setText(model.get(position).getEnd_date());


    }

    @Override
    public int getItemCount() {
        return model.size();
    }


    class holder extends RecyclerView.ViewHolder {
        private TextView tv, sd, ed;

        public holder(@NonNull View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.Company_Name_TV_Card_Intern);
            sd = (TextView) itemView.findViewById(R.id.Start_Date_TV_Card_Intern);
            ed = (TextView) itemView.findViewById(R.id.End_Date_TV_Card_Intern);
        }

        public TextView getView() {
            return tv;
        }
    }

}
