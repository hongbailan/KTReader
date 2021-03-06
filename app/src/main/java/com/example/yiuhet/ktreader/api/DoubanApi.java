package com.example.yiuhet.ktreader.api;

import com.example.yiuhet.ktreader.model.entity.DoubanBook;
import com.example.yiuhet.ktreader.model.entity.DoubanBookDetail;
import com.example.yiuhet.ktreader.model.entity.DoubanMovieDetail;
import com.example.yiuhet.ktreader.model.entity.DoubanMovieSubject;
import com.example.yiuhet.ktreader.model.entity.DoubanMusic;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by yiuhet on 2017/5/31.
 */

public interface DoubanApi {
    /**
     * 图书Api
     */
    @GET("book/{text}")
    Observable<DoubanBookDetail> getSearchBookDetail(@Path("text")  String text,@Query("start") String start); //搜索图书
    @GET("book/search")
    Observable<DoubanBook> getSearchBookByName(@Query("q")  String text, @Query("count") String count); //搜索图书by关键字
    @GET("book/search")
    Observable<String> getSearchBookByTag(@Query("tag") String text); //搜索图书by类型

    /**
     * 电影Api
     */
    @GET("movie/search")
    Observable<String> getSearchMovie(@Path("q") String text);//获取电影条目搜索结果数据
    @GET("movie/in_theaters")
    Observable<DoubanMovieDetail> getInTheaters();//获取热映电影数据
    @GET("movie/coming_soon")
    Observable<String> getComingSonn();//获取即将即将上映电影数据
    @GET("movie/top250")
    Observable<DoubanMovieDetail> getTop250(@Query("start") String start);//获取Top250数据
    @GET("movie/weekly")
    Observable<String> getWeekly();//获取口碑榜数据
    @GET("movie/new_movies")
    Observable<String> getNewMovies();//获取新片榜数据
    @GET("movie/subject/{text}")
    Observable<DoubanMovieSubject> getMovieSubject(@Path("text")  String text);//获取电影条目信息

    /**
     * 音乐Api
     */
    @GET("music/search")
    Observable<DoubanMusic> getSearchMusicByTag(@Query("tag")  String text, @Query("count") String count); //搜索音乐by关键字
    @GET("music/{id}")
    Observable<DoubanMusic> getSearchMusicById(@Path("text")  String id); //搜索音乐
}
