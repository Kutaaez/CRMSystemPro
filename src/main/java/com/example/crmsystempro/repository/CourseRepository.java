package com.example.crmsystempro.repository;

import com.example.crmsystempro.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
