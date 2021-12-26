package org.example.deserialization.openlibrary.models;

import lombok.Data;

@Data
public class Author {
    private InnerAuthor author;
    private AuthorType type;
}
