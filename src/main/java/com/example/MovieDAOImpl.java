package com.example;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MovieDAOImpl implements MovieDAO {

    private final MongoCollection<Document> movieCollection;

    public MovieDAOImpl(MongoDatabase database) {
        this.movieCollection = database.getCollection("movies");
    }

    @Override
    public void insert(String title, int year) {
        Document movie = new Document("title", title)
                .append("year", year);

        movieCollection.insertOne(movie);
    }

    @Override
    public List<Document> findAll() {
        List<Document> movies = new ArrayList<>();
        for (Document doc : movieCollection.find()) {
            movies.add(doc);
        }
        return movies;
    }
}
