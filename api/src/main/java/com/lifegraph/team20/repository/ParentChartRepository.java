package com.lifegraph.team20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.lifegraph.team20.entity.ParentChart;

@Repository
public interface ParentChartRepository extends JpaRepository<ParentChart, Long>, JpaSpecificationExecutor<ParentChart> {
}
