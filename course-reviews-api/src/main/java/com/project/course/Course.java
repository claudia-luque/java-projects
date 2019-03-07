package com.project.course;

import com.project.core.BaseEntity;
import com.project.review.Review;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course extends BaseEntity
{
    // validation constrain
    @NotNull // along with the RestConfig adapter for validating
    @Size(min = 2, max = 140)
    private String title;

    private String url;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL) // links review and courses entities like in DB PK?
    private List<Review> reviews;

    // just only classes in this constructor will access it
    // id will be set in the DB that is why we are initializing to null
    protected Course() {
        super();
        reviews = new ArrayList<>();
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        review.setCourse(this);
        reviews.add(review);
    }

    public Course(String title, String url) {
        this();
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
