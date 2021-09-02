package me.arunav.spring;

import me.arunav.spring.movierecommender.CollaborativeFilter;
import me.arunav.spring.movierecommender.ContentBasedFilter;
import me.arunav.spring.movierecommender.Movie;
import me.arunav.spring.movierecommender.RecommenderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringBasicsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext appContext = SpringApplication.run(SpringBasicsApplication.class, args);

//        ContentBasedFilter contentBasedFilter = appContext.getBean(ContentBasedFilter.class);
//        System.out.println("ContentBasedFilter with Singleton scope");
//        System.out.println(contentBasedFilter);
//
//        System.out.println("Getting Movie 1");
//        Movie m1 = contentBasedFilter.getMovie();
//        System.out.println("Getting Movie 2");
//        Movie m2 = contentBasedFilter.getMovie();
//        System.out.println("Getting Movie 3");
//        Movie m3 = contentBasedFilter.getMovie();
//
//        System.out.println(m1);
//        System.out.println(m2);
//        System.out.println(m3);
//
//        System.out.println("ContentBasedFilter instances=" + ContentBasedFilter.getInstances());
//        System.out.println("Movie instances=" + Movie.getInstances());
//
//        RecommenderImpl recommenderImpl = appContext.getBean(RecommenderImpl.class);
//        String[] recommendedMovies = recommenderImpl.recommendMovies("Some movie");
//        Arrays.stream(recommendedMovies).forEach(System.out::println);
    }
}
