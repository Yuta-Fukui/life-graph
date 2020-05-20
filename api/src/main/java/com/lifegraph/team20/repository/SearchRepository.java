package com.lifegraph.team20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lifegraph.team20.entity.Search;

@Repository
public interface SearchRepository extends JpaRepository<Search, String> {
}
