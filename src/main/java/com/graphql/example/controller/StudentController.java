package com.graphql.example.controller;


import com.graphql.example.models.Branch;
import com.graphql.example.models.Student;
import com.graphql.example.service.StudentServiceImpl;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller  //as not rest api hence not rest controller
public class StudentController {
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {


        this.studentService = studentService;
    }


    @QueryMapping   //maps to same name as in query type in .graphqls file
    public List<Student> findAll(){
        return this.studentService.findAll();
    }

    @QueryMapping
    public Optional<Student> findOne(@Argument Integer id){  //argument tells spring that id will be  path variable
        return this.studentService.findOne(id);

    }

    @MutationMapping
    public Student create(@Argument String name,@Argument Branch branch){
        return this.studentService.create(name,branch);

    }

    @MutationMapping
    public Student delete(@Argument Integer id){
        return this.studentService.delete(id);

    }

    @MutationMapping
    public Student update(@Argument Integer id,@Argument String name,@Argument Branch branch){
        return this.studentService.update(id,name,branch);

    }
}
