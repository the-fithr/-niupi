package com.example.exoplayer;

public class View  {
    private  int touxiang;
    private  String title;
    private String url;

    public  View(int touxiang,String title,String url)
    {
        this.touxiang=touxiang;
        this.title=title;
        this.url=url;
    }
    public int getTouxiang() { return touxiang; }
    public void setTouxiang(int touxiang) { this.touxiang = touxiang; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

}
