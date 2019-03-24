package com.example.exoplayer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewListAdapter extends RecyclerView.Adapter<ViewListAdapter.ViewViewHolder> {
    @NonNull
    @Override
    public ViewListAdapter.ViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View container= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_view,null);
        return new ViewViewHolder(container);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewListAdapter.ViewViewHolder viewViewHolder, int i) {
        com.example.exoplayer.View view=ViewLab.get().getView(i);
        viewViewHolder.bind(view);
    }

    @Override
    public int getItemCount() {
        return ViewLab.get().getSize();
    }

    public  class ViewViewHolder extends RecyclerView.ViewHolder{
        private ImageView touxiang;
        private TextView title;


        public ViewViewHolder (@NonNull View itemView) {
            super(itemView);
            touxiang=itemView.findViewById(R.id.imageview);
            title=itemView.findViewById(R.id.textView);
        }

        public void bind(com.example.exoplayer.View view) {
            this.touxiang.setImageResource(view.getTouxiang());
            this.title.setText(view.getTitle());
        }
    }
}
