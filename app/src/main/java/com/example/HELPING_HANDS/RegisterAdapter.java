package com.example.HELPING_HANDS;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

public class RegisterAdapter extends FirebaseRecyclerAdapter<RegisterModel, RegisterAdapter.myViewHolder> {

     /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public RegisterAdapter(@NonNull @NotNull FirebaseRecyclerOptions<RegisterModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull myViewHolder holder, int position, @NonNull @NotNull RegisterModel model) {
        holder.place.setText(model.getPlace());
        holder.address.setText(model.getAddress());
        holder.phone.setText(model.getPhone());
        holder.tCount.setText(model.gettCount());

    }

    @NonNull
    @NotNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_ddetail,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView place,phone,address, tCount;

        public myViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            place = (TextView)itemView.findViewById(R.id.planame);
            phone = (TextView)itemView.findViewById(R.id.plaphone);
            address = (TextView)itemView.findViewById(R.id.paladdress);
            tCount = (TextView)itemView.findViewById(R.id.plano);
        }
    }
}
