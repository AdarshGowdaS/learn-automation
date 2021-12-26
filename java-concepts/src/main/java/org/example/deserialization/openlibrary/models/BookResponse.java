package org.example.deserialization.openlibrary.models;

import lombok.Data;

@Data
public class BookResponse {
    private String description;
    private String title;
    private int[] covers;
    private String[] subjects;
    private String[] subjectPlaces;
    private String[] subjectPeople;
    private String key;
    private Author[] authors;
    private String[] subjectTimes;
    private BookType type;
    private String latestRevision;
    private String revision;
    private BookCreated created;
    private BookLastModified lastModified;
}
