package com.example.stickyheader.Alphabet;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.stickyheader.Common.Common;
import com.example.stickyheader.Interface.IONAlpha;
import com.example.stickyheader.R;

import java.util.List;

public class AlphabetAdapter extends RecyclerView.Adapter<AlphabetAdapter.MyViewHolder> {
    List<String> alphaList;IONAlpha ionAlpha;
    public void setIonAlpha(IONAlpha ionAlpha) {
        this.ionAlpha = ionAlpha;
    }
    public AlphabetAdapter() {
        alphaList = Common.genAlpha();
    }
    @NonNull  @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.alphabet,parent,false);
        return new MyViewHolder(view); }
        @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) { TextDrawable textDrawable;
        final int pos= Common.alphabet_available.indexOf(alphaList.get(position));
        if (pos!=-1){
            textDrawable=TextDrawable.builder().buildRound(alphaList.get(position), Color.GREEN);
        }else {
            textDrawable=TextDrawable.builder().buildRound(alphaList.get(position), Color.GRAY);
        }
        holder.alphabet.setImageDrawable(textDrawable);
        holder.itemView.setOnClickListener(new View.OnClickListener() {@Override
            public void onClick(View view) {
                ionAlpha.onAlpha(alphaList.get(position),position); }}); }@Override
    public int getItemCount() {
        return alphaList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{ ImageView alphabet;
        public MyViewHolder(@NonNull View itemView) { super(itemView);
            alphabet=(ImageView)itemView.findViewById(R.id.alpha); }}
}
