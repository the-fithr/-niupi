package com.example.exoplayer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements OnBannerListener {
    private RecyclerView recvlerView;
    private  ViewListAdapter viewlistadapter;
    private Banner banner;
    private  ArrayList<Integer>list_path;
    private  ArrayList<String>list_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        recvlerView=findViewById(R.id.recycler);
        viewlistadapter=new ViewListAdapter();
        recvlerView.setLayoutManager(new GridLayoutManager(this,2));
        recvlerView.addItemDecoration(new ReItemDecoration(15));
        recvlerView.setAdapter(viewlistadapter);

    }

    private void initView() {
        banner =findViewById(R.id.banner);
        //放图片地址的集合
        list_path=new ArrayList<>();
        list_title=new ArrayList<>();
        list_path.add(R.drawable.guanggao1);
        list_path.add(R.drawable.guanggao2);
        list_path.add(R.drawable.guanggao3);
        list_title.add("传承千年的传统节日：“赛装节”是怎么样的？");
        list_title.add("国创二周年");
        list_title.add("会是怎样呢？");
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.setImageLoader(new MyLoader());
        banner.setImages(list_path);
        banner.setBannerTitles(list_title);
        banner.setBannerAnimation(Transformer.Default);
        banner.setDelayTime(3000);
        banner.isAutoPlay(true);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.start();
    }

    @Override
    public void OnBannerClick(int position) {
        Log.i("tag","你点了第"+position+"张轮播图");
    }
    private  class  MyLoader extends ImageLoader{

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
           imageView.setImageResource((Integer)path);
        }
    }
}