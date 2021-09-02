package me.arunav.spring.movierecommender;

public interface Filter {

    String[] getRecommendations(String movie);
}
