package com.unicon.ipms.student_ui.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unicon.ipms.R;
import com.unicon.ipms.getStudentPlacementSalModel;

import java.util.List;

public class yourplaceAdaptor extends RecyclerView.Adapter<yourplaceAdaptor.holder> {
    LayoutInflater inflater;
    List<getStudentPlacementSalModel> model;

    public yourplaceAdaptor(Context ctx , List<getStudentPlacementSalModel> model){
        this.inflater = LayoutInflater.from(ctx);
        this.model = model;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.your_placement_cardview,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        try{
        holder.tv.setText(model.get(position).c_name);
        holder.salary_1.setText(model.get(position).salary);
        }catch (Exception e){
            Toast.makeText(holder.tv.getContext(), "error"+e+model.get(position).c_name, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public int getItemCount() {
        return model.size();
    }


    class holder extends RecyclerView.ViewHolder
    {
        private TextView tv,salary_1;
        public holder(@NonNull View itemView) {
            super(itemView);
            tv=(TextView) itemView.findViewById(R.id.Company_Name_TV_Card_Place);
            salary_1=(TextView) itemView.findViewById(R.id.salary_TV_card);
        }
        public TextView getView(){
            return tv;
        }
    }

}
