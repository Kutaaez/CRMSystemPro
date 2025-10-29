package com.example.crmsystempro.services;

import com.example.crmsystempro.entities.Course;
import java.util.List;

public interface CourseService {
    // крит
    Course addCourse(Course course);

    // рид
    List<Course> getAllCourses();
    Course getCourseById(Long id);

    // эпэдейдә
    Course updateCourse(Course course);

    // деледе
    void deleteCourse(Long id);

    //іба чотко
}
