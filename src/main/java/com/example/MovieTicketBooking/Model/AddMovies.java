package com.example.MovieTicketBooking.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "movie")
public class AddMovies {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String movieID;
    @Column(name = "MOVIE_NAME")
    private String movieName;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "GENRE")
    private String genre;
    @Column(name = "IMAGE_PATH")
    private String pathName;
    private String image;
    @Column(name = "RELEASED_DATE")
    private String releasedDate;

    public AddMovies() {
        this.movieID= UUID.randomUUID().toString();
    }

    public AddMovies(String movieID, String movieName, String category, String genre, String pathName, String image, String releasedDate) {
        this.movieID = movieID;
        this.movieName = movieName;
        this.category = category;
        this.genre = genre;
        this.pathName = pathName;
        this.image = image;
        this.releasedDate = releasedDate;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public String getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(String releasedDate) {
        this.releasedDate = releasedDate;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
