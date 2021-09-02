package me.arunav.spring.movierecommender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImpl {

    @Autowired
    private Filter filter;

//    public RecommenderImpl(Filter filter) {
//        this.contentBasedFilter = filter;
//    }

    public String[] recommendMovies(String movie) {
        return filter.getRecommendations(movie);
    }
}
