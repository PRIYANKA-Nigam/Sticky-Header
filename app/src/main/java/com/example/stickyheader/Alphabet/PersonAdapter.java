package com.example.stickyheader.Alphabet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.example.stickyheader.Common.Common;
import com.example.stickyheader.MainActivity2;
import com.example.stickyheader.Model.Person;
import com.example.stickyheader.R;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;List<Person> personList;
    public PersonAdapter(Context context, List<Person> personList) {
        this.context = context;this.personList = personList; }@NonNull @Override
    public  RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { LayoutInflater inflater=LayoutInflater.from(context);
       if (viewType== Common.VIEWTYPE_GROUP){ ViewGroup group=(ViewGroup)inflater.inflate(R.layout.group,parent,false);
           GroupViewHolder groupViewHolder=new GroupViewHolder(group); return groupViewHolder;
       }else if (viewType== Common.VIEWTYPE_PERSON){ ViewGroup group=(ViewGroup)inflater.inflate(R.layout.person_layout,parent,false);
           PersonViewHolder personViewHolder=new PersonViewHolder(group);return personViewHolder;}
         else { ViewGroup group=(ViewGroup)inflater.inflate(R.layout.group,parent,false);
           GroupViewHolder groupViewHolder=new GroupViewHolder(group); return groupViewHolder; } }@Override
    public int getItemViewType(int position) {
        return personList.get(position).getViewType();
    }@Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    if (holder instanceof GroupViewHolder){ GroupViewHolder groupViewHolder=(GroupViewHolder)holder;
        groupViewHolder.title.setText(personList.get(position).getName());groupViewHolder.itemView.setOnClickListener(new View.OnClickListener() {@Override
            public void onClick(View view) { ((Activity)context).startActivityForResult(new Intent(context, MainActivity2.class),Common.RESULT_CODE); }}); }
    else  if (holder instanceof PersonViewHolder){ PersonViewHolder personViewHolder=(PersonViewHolder)holder;personViewHolder.name.setText(personList.get(position).getName());
        personViewHolder.position.setText(personList.get(position).getPosition());ColorGenerator generator=ColorGenerator.MATERIAL;
        TextDrawable drawable=TextDrawable.builder().buildRound(String.valueOf(personList.get(position).getName().charAt(0)),generator.getRandomColor());
        personViewHolder.itemView.setOnClickListener(new View.OnClickListener() {@Override
            public void onClick(View view) { Toast.makeText(context,""+personList.get(position).getName(),Toast.LENGTH_SHORT).show(); }}); } }@Override
    public int getItemCount() {
        return personList.size();
    }
    private class GroupViewHolder extends RecyclerView.ViewHolder{ TextView title;
        public GroupViewHolder(@NonNull View itemView) { super(itemView); title=itemView.findViewById(R.id.tt); }}
        private class PersonViewHolder extends RecyclerView.ViewHolder{ TextView name,position;ImageView imageView;
        public PersonViewHolder(@NonNull View itemView) { super(itemView); name=(TextView)itemView.findViewById(R.id.name);
            position=(TextView)itemView.findViewById(R.id.pos); imageView=(ImageView)itemView.findViewById(R.id.alpha); }}}
