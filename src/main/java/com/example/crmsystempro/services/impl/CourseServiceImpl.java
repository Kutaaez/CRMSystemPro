package com.example.crmsystempro.services.impl;

import com.example.crmsystempro.entities.Course;
import com.example.crmsystempro.repository.CourseRepository;
import com.example.crmsystempro.services.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository coursesRepository;


}
