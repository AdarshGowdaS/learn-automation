package org.example.deserialization.openlibrary;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.internal.mapping.Jackson2Mapper;
import io.restassured.path.json.mapper.factory.Jackson2ObjectMapperFactory;
import io.restassured.response.Response;
import org.example.deserialization.openlibrary.models.BookResponse;
import org.example.utils.StringUtil;

import java.awt.print.Book;
import java.util.Arrays;

public class Example {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        readFromJsonFile(mapper);
        readFromApi(mapper);
    }

    private static void readFromJsonFile(ObjectMapper mapper) throws Exception{

        String jsonString = StringUtil.readFileFromResources("book.json");

        BookResponse bookResponse = mapper.readValue(jsonString, BookResponse.class);

        System.out.println("complete book response" + bookResponse);

        System.out.println("book response title" + bookResponse.getTitle());

        Arrays.stream(bookResponse.getAuthors()).forEach(author -> System.out.println(author.getAuthor().getKey()));
    }

    private static void readFromApi(ObjectMapper mapper) throws Exception{
       String bookUrl =  "https://openlibrary.org/works/OL45883W.json";

//        io.restassured.mapper.ObjectMapper objectMapper = new Jackson2Mapper(((type, charset) -> {
//            com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();
//            mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
//                    .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//            return mapper;
//        }));

        Response response = RestAssured
                .given()
                .get(bookUrl)
                .then()
                .extract()
                .response();

        //BookResponse bookResponse = response.getBody().as(BookResponse.class, objectMapper);

        String jsonString = response.getBody().asString();
        BookResponse bookResponse = mapper.readValue(jsonString, BookResponse.class);

        System.out.println("complete book response" + bookResponse);

        System.out.println("book response title" + bookResponse.getTitle());

        Arrays.stream(bookResponse.getAuthors()).forEach(author -> System.out.println(author.getAuthor().getKey()));
    }
}
