package com.example.exoplayer;

import java.util.ArrayList;
import java.util.List;

public class ViewLab {
    private  static ViewLab instance=null;
    private List<View>Views;
    private ViewLab(){init();}

    private void init() {
        Views=new ArrayList<>();
        View m1=new View(R.drawable.a,"B站一月最烂新番","https://www.bilibili.com/video/av47012859/");
        Views.add(m1);
        View m2=new View(R.drawable.b,"【手绘版】一拳超人第二季PV","https://www.bilibili.com/video/av47033270/");
        Views.add(m2);
        View m3=new View(R.drawable.c,"【Tom Webb】超可爱！Maison Kitsuné16年秋冬广告短片","https://www.bilibili.com/video/av7719841/");
        Views.add(m3);
        View m4=new View(R.drawable.d,"【灵魂P图】来自啊嘞嘞（物间宁人）的攻击","【灵魂P图】来自啊嘞嘞（物间宁人）的攻击");
        Views.add(m4);
        View m5=new View(R.drawable.e,"【超清/全屏】【国产/经典】悬崖【40集全】","https://www.bilibili.com/video/av14458605/?p=22");
        Views.add(m5);
        View m6=new View(R.drawable.f,"少年歌行 无心 COS仿妆","https://www.bilibili.com/video/av47054948/");
        Views.add(m6);
        View m7=new View(R.drawable.g,"地平线系列：心智斗争","https://www.bilibili.com/bangumi/play/ep120902/");
        Views.add(m7);
        View m8=new View(R.drawable.h,"【钢铁侠/励志/混剪/1080P】当你想放弃的时候，请像钢铁侠一样坚持下去！","https://www.bilibili.com/video/av44932804/");
        Views.add(m8);
    }
    public  static  ViewLab get(){
        if (null==instance)
        {
            instance =new ViewLab();
        }
        return  instance;
    }
    public  int getSize(){return  Views.size();}
    public View getView(int n){return  Views.get(n);}
}
