package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@ToString
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_movies", joinColumns = @JoinColumn (name = "user_id"),
            inverseJoinColumns = @JoinColumn(name ="movie_id"))
    private Collection<Movie> movies;
    public User(String firstName, String lastName, String email, String password, Collection<Movie> movies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.movies = movies;
    }

}
