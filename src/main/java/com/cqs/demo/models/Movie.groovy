package com.cqs.demo.models

/**
 * Created by cqs on 10/11/16.
 */
class Movie {
    String cover;
    String title;
    boolean is_beetle_subject;
    boolean is_new;
    boolean playable;
    float rate;
    String url;


    @Override
    public String toString() {
        return "Movie{" +
                "cover='" + cover + '\'' +
                ", title='" + title + '\'' +
                ", is_beetle_subject=" + is_beetle_subject +
                ", is_new=" + is_new +
                ", playable=" + playable +
                ", rate=" + rate +
                ", url='" + url + '\'' +
                '}';
    }
}
