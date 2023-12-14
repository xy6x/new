package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.ApiException.ApiException;
import com.example.schoolmanagement.Model.Course;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.CourseRepository;
import com.example.schoolmanagement.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService {
    private  final CourseRepository courseRepository;
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }
    public void addCourse(Course course){
        courseRepository.save(course);
    }
    public void updateCourse(Integer id ,Course course){
        Course oldCourse =courseRepository.findCourseById(id);
        if (oldCourse == null) {
            throw new ApiException("the id not found");
        }
        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
    }
    public void deleteCourse(Integer id){
        Course course =courseRepository.findCourseById(id);
        if (course == null) {
            throw new ApiException("the id not found");
        }
        courseRepository.delete(course);
    }
    public  Teacher  searchTeacher(Integer id){
        Course course =courseRepository.findCourseById(id);
        if (course == null) {
            throw new ApiException("the id not found");
        }
       return course.getTeach();
    }


}
