package com.example.exoplayer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;
import java.util.List;

public class ViewListAdapter extends RecyclerView.Adapter<ViewListAdapter.ViewViewHolder> {
    public ViewListAdapter(List<com.example.exoplayer.View> data, OnItemClickListener channelClickListener) {
        this.listener=channelClickListener;
    }
    OnItemClickListener listener;
    public interface OnItemClickListener{
        /*注意参数*/
        public void OnItemClick(View v,int position,String id);
    }
    public void setOnItemClick(OnItemClickListener listener){
        this.listener=listener;
    }
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
        viewViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    /*注意参数*/
                    listener.OnItemClick(v,i,"1");
                }
            }
        });
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
