package com.project.review;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

// here we changed from extending from CRUDpository to PagingAndSortingRepository in order
// to add pagination to our results
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long>
{
    @Override
    @PreAuthorize("@reviewRepository.findOne(#id)?.reviewer?.username == authentication.name") // Expression-Based Access Controls
    void deleteById(@Param("id") Long id);

    @Override
    @PreAuthorize("#review.reviewer?.username == authentication.name")
    void delete(@Param("review") Review entity);
}
