package com.lifegraph.team20.controller;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lifegraph.team20.entity.ParentChart;
import com.lifegraph.team20.entity.Search;
import com.lifegraph.team20.repository.ParentChartRepository;
import com.lifegraph.team20.service.SearchService;

@ComponentScan

@RestController
@RequestMapping("/search")
public class SearchController {

  @Autowired
  public SearchService service;

  @Autowired
  private ParentChartRepository repository;

  @RequestMapping(method = RequestMethod.GET)
  List<Search> getSearch() {
    return service.getSearch();
  }

  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public List<ParentChart> getSearchTest(@RequestParam("name") String name) {
////    Specification<ParentChart> spec = 
////    repository.findAll(Specification<T>)
//    CriteriaBuilder builder = new 
//    
//    repository.findAll(spec)
//        
//    
    return repository.findAll();
  }

  private Specification<ParentChart> test(String name) {
    return StringUtils.isEmpty(name) ? null : new Specification<ParentChart>() {
      @Override
      public Predicate toPredicate(Root<ParentChart> root, CriteriaQuery<?> criteriaQuery,
          CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get("companyName"), name);
      }
    };
  }
}