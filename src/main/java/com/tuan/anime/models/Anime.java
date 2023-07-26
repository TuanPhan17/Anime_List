package com.tuan.anime.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity // declares that it is going to be apart of mysql
@Table(name = "animes") // gives the table name of the model
public class Anime {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // generates an auto incrementing 
	private Long id;
	
	@NotEmpty(message = "Title is required!") // validation for strings
	private String title;
	
	@NotEmpty(message = "artist is required!") // validation for strings
	private String artist;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User seller;
	
    @Column(updatable = false)
	private Date createdAt;

	private Date updatedAt;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@NotEmpty(message = "genre is required!") // validation for strings
	private String genre;
	
	@Max(value=10, message = "max rating must be 10")
	@Min(value=1, message = "min rating must be 1" )
	private Integer rating;
	
	@NotEmpty(message = "description is required!") // validation for strings
	private String description;

	public Anime() {
		// TODO Auto-generated constructor stub
	}
	
	  @PrePersist // adds the created at date and time to sql on creation 
		protected void onCreate() {
			this.createdAt = new Date();
		}

		@PreUpdate // add the updated at date and time when being updated
		protected void onUpdate() {
			this.updatedAt = new Date();
		}

}
