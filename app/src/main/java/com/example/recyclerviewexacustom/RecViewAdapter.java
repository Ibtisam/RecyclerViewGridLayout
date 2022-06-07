package com.example.recyclerviewexacustom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.RecViewViewHoder> {
    private String[][] values;
    private int colIndex;
    private int rowIndex;
    public RecViewAdapter(String[][] values) {
        this.values = values;
        colIndex = 0;
        rowIndex = 0;
    }

    @NonNull
    @Override
    public RecViewViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Creating the layout for the single item of recyclerview
        LinearLayout itemLayout =(LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.recview_item_grid,parent,false);
        RecViewViewHoder recViewViewHoder = new RecViewViewHoder(itemLayout);
        return recViewViewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewViewHoder holder, int position) {
        /*if(colIndex<3) {
            holder.textView.setText(values[rowIndex][colIndex++]);
        }else{
            colIndex=0;
            rowIndex++;
            holder.textView.setText(values[rowIndex][colIndex++]);
        }*/


        if(colIndex==3){
            colIndex=0;
            rowIndex++;
        }
        holder.textView.setText(values[rowIndex][colIndex++]);
        //holder.button.setText(values[position]+" Button");
    }

    @Override
    public int getItemCount() {
        return values.length*3;
    }

    public class RecViewViewHoder extends RecyclerView.ViewHolder {
        public TextView textView;
        public RecViewViewHoder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewGTV);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "You pressed " +textView.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
