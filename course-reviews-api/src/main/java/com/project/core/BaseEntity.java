package com.project.core;

import javax.persistence.*;

// telling JPA this is a map supper class to be used along the other entities
@MappedSuperclass
public class BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    // adding during versioning
    @Version
    private Long version;

    protected BaseEntity()
    {
        id = null;
    }
}
