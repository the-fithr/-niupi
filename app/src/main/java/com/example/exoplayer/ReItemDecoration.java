package com.example.exoplayer;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.HashMap;

public class ReItemDecoration extends RecyclerView.ItemDecoration {

    int mspace;


    public  void  getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
        super.getItemOffsets(outRect,view,parent,state);
        outRect.left=mspace;
        outRect.right=mspace;
        outRect.bottom=mspace;
        outRect.top=mspace;
    }
    public  ReItemDecoration(int space){
        this.mspace=space;
    }
}
