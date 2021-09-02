package me.arunav.spring.movierecommender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ContentBasedFilter implements Filter {

    private static int instances = 0;

//    @Autowired
    private Movie movie;

    ContentBasedFilter(Movie movie){
        super();
        instances++;
        this.movie = movie;
        System.out.println("ContentBasedFilter constructor called");
    }

    public static int getInstances() {
        return instances;
    }

    public Movie getMovie() {
        return movie;
    }

    public String[] getRecommendations(String movie) {
        return new String[]{"M5", "M6", "M7"};
    }
}
