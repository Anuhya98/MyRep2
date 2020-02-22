package com.cts.training.restresource;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cts.training.model.User;

@RepositoryRestResource(path = "users", collectionResourceRel = "users")
public interface UserRestResource extends PagingAndSortingRepository<User, Integer>{

}
