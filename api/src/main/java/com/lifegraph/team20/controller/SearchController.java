package com.lifegraph.team20.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lifegraph.team20.entity.ParentChart;
import com.lifegraph.team20.service.SearchService;

@ComponentScan

@RestController
@RequestMapping("/search")
public class SearchController {

  @Autowired
  private SearchService service;

  @GetMapping(value = "/all")
  public ResponseEntity<List<ParentChart>> searchAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping(value = "/test")
  public ResponseEntity<List<ParentChart>> searchTest(@RequestParam("name") Optional<String> name,
      @RequestParam("updatedAtFrom") Optional<String> updatedAtFrom,
      @RequestParam("updatedAtTo") Optional<String> updatedAtTo) {
    return ResponseEntity.ok(service.test(name, updatedAtFrom, updatedAtTo));
  }
}