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
    private CourseRepository courseRepository;


    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        Course existingCourse = courseRepository.findById(id).orElse(null);
        if (existingCourse != null) {
            existingCourse.setName(course.getName());
            existingCourse.setDescription(course.getDescription());
            existingCourse.setPrice(course.getPrice());
            return courseRepository.save(existingCourse);
        }
        return null;
    }

    @Override
    public boolean deleteCourse(Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
