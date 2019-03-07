package com.project.core;

import com.project.course.Course;
import com.project.course.CourseRepository;
import com.project.review.Review;
import com.project.user.User;
import com.project.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Component // so it will be found as a component standard startup
public class DataBaseLoader implements ApplicationRunner
{
    private final CourseRepository courses;
    private final UserRepository users;

    @Autowired
    public DataBaseLoader(CourseRepository courses, UserRepository users)
    {
        this.courses = courses;
        this.users = users;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        Course course = new Course("Java Basics", "url1");
        Review review = new Review(5, "You are a awesom!!");
        course.addReview(review);
        courses.save(course);

        String[] templates = {
                "Up and Running with %s",
                "%s Basics",
                "%s for Beginners",
        };

        String[] buzzwords = {
                "Spring REST Data",
                "Java 9",
                "Scala",
        };

        List<User> students = Arrays.asList(
                new User("claudiaL", "Claudia", "Proffer", "password", new String[] {"ROLE_USER"})
        );

        users.saveAll(students);

        List<Course> bunchOfCourses = new ArrayList<>();
        IntStream.range(0,100)
                .forEach(i -> {
                    String template = templates[i % templates.length];
                    String buzzword = buzzwords[i % buzzwords.length];
                    String title = String.format(template, buzzword);
                    Course c = new Course(title, "http://www.example.com");
                    Review review1 = new Review((i % 5) + 1, String.format("Moar %s please!!!", buzzword));
                    review1.setReviewer(students.get(i % students.size()));
                    c.addReview(review1);
                    bunchOfCourses.add(c);
                });

        courses.saveAll(bunchOfCourses);
    }
}
