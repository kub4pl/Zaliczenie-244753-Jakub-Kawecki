package sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.List;

public class Parser {

    public List<Movie> parse(String jsonString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        List<Movie> movieList = objectMapper.readValue(jsonString, typeFactory.constructCollectionType(List.class, Movie.class));
        return movieList;
    }
}
