package me.arunav.spring.movierecommender;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class CollaborativeFilter implements Filter{

    public String[] getRecommendations(String movie){
        return new String[] {"M8", "M9"};
    }
}
