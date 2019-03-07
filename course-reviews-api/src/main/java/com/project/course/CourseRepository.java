package com.project.course;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

// CRUD repository provides sophisticated CRUD functionality for the entity class that is
// being managed

// here we changed from extending from CRUDpository to PagingAndSortingRepository in order
// to add pagination to our results
public interface CourseRepository extends PagingAndSortingRepository<Course, Long>
{
    // before this the rel is findByTitleContaining, RestResource allow us to change it
    // Pagging source: https://docs.spring.io/spring-data/rest/docs/current/reference/html/#paging-and-sorting
    // Querymethods source: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods

    @RestResource(rel = "title-contains", path = "containsTitle")
    Page<Course> findByTitleContaining(@Param("title") String title, Pageable page);
}
