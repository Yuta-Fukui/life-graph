package com.lifegraph.team20.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.lifegraph.team20.entity.ParentChart;
import com.lifegraph.team20.repository.ParentChartRepository;

@Service
public class SearchService {

  @Autowired
  private ParentChartRepository repository;

  public List<ParentChart> findAll() {
    return repository.findAll();
  }

  public List<ParentChart> test(Optional<String> name, Optional<String> from, Optional<String> to) {
    return repository.findAll(getSpec(name, from, to));
  }

  private Specification<ParentChart> getSpec(Optional<String> name, Optional<String> from, Optional<String> to) {
    return (Specification<ParentChart>) (root, query, builder) -> {
      List<Predicate> predicates = new ArrayList<>();
      if (name.isPresent()) {
        predicates.add(builder.like(root.join("user", JoinType.INNER).get("name"), "%" + name.get() + "%"));
      }
      Date fromDate = from.isPresent() ? toLocalDateTime(from.get()) : null;
      if (fromDate != null) {
        predicates.add(builder.greaterThanOrEqualTo(root.get("updatedAt"), fromDate));
      }
      Date toDate = to.isPresent() ? toLocalDateTime(to.get()) : null;
      if (to.isPresent()) {
        predicates.add(builder.lessThanOrEqualTo(root.get("updatedAt"), toDate));
      }
      return builder.and(predicates.toArray(new Predicate[predicates.size()]));
    };
  }

  private Date toLocalDateTime(String date) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    Date formatDate = null;
    try {
      formatDate = sdf.parse(date);
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return formatDate;
  }
}
