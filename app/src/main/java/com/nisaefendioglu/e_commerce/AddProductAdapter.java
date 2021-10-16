package com.nisaefendioglu.e_commerce;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;


public class AddProductAdapter extends FirebaseRecyclerAdapter<Model, AddProductAdapter.myviewholder>
{
    public AddProductAdapter(@NonNull FirebaseRecyclerOptions<Model> options)
    {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myviewholder holder, @SuppressLint("RecyclerView") final int position, @NonNull final Model model)
    {
       holder.name.setText(model.getName());
       holder.desc.setText(model.getDesc());
       holder.price.setText(model.getPrice());

        holder.edit.setOnClickListener(view -> {
                        final DialogPlus dialogPlus= DialogPlus.newDialog(holder.img.getContext())
                                .setContentHolder(new ViewHolder(R.layout.dialogcontent))
                                .setExpanded(true,1100)
                                .create();

                        View myview=dialogPlus.getHolderView();
                        final EditText name=myview.findViewById(R.id.uname);
                        final EditText desc=myview.findViewById(R.id.udesc);
                        final EditText price=myview.findViewById(R.id.uprice);
                        final ImageView img = myview.findViewById(R.id.img);
                        Button submit=myview.findViewById(R.id.usubmit);

                        name.setText(model.getName());
                        desc.setText(model.getDesc());
                        price.setText(model.getPrice());
                        img.setImageResource(R.drawable.shopping);
                        dialogPlus.show();

                            submit.setOnClickListener(view1 -> {
                                Map<String,Object> map=new HashMap<>();
                                map.put("name",name.getText().toString());
                                map.put("desc",desc.getText().toString());
                                map.put("price",price.getText().toString());

                                FirebaseDatabase.getInstance().getReference().child("Products")
                                        .child(getRef(position).getKey()).updateChildren(map)
                                        .addOnSuccessListener(aVoid -> dialogPlus.dismiss())
                                        .addOnFailureListener(e -> dialogPlus.dismiss());
                            });


                    });


                    holder.delete.setOnClickListener(view -> {
                        AlertDialog.Builder builder=new AlertDialog.Builder(holder.img.getContext());
                        builder.setTitle("Product Delete Page");
                        builder.setMessage("Are you sure you want to delete?");

                        builder.setPositiveButton("Yes", (dialogInterface, i) -> FirebaseDatabase.getInstance().getReference().child("Products")
                                .child(getRef(position).getKey()).removeValue());

                        builder.setNegativeButton("No", (dialogInterface, i) -> {

                        });

                        builder.show();
                    });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
       return new myviewholder(view);
    }


    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView edit,delete,img;
        TextView name,desc,price;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            img= itemView.findViewById(R.id.img);
            name=itemView.findViewById(R.id.name);
            desc=itemView.findViewById(R.id.desc);
            price=itemView.findViewById(R.id.price);
            edit=itemView.findViewById(R.id.editicon);
            delete=itemView.findViewById(R.id.deleteicon);
        }
    }
}
