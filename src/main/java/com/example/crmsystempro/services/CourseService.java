package com.example.crmsystempro.services;

import com.example.crmsystempro.entities.Course;
import com.example.crmsystempro.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository coursesRepository;

    public List<Course> getAllCourses() {
        return coursesRepository.findAll();
    }
}