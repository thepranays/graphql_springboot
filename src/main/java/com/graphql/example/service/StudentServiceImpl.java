package com.graphql.example.service;

import com.graphql.example.models.Branch;
import com.graphql.example.models.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentServiceImpl {
    private List<Student> students = new ArrayList<>();
    private AtomicInteger id = new AtomicInteger(0);


    public List<Student> findAll(){
        return students;
    }

    public Optional<Student> findOne(Integer id){
        return this.students.stream()
                .filter(s-> Objects.equals(s.getId(), id)).findFirst();

    }
    public Student create(String name, Branch branch){
        Student newStudent = new Student(name,branch,this.id.incrementAndGet());
        students.add(newStudent);
        return newStudent;

    }

    public Student delete(Integer id){
        Student st=this.students.stream()
                .filter(s-> Objects.equals(s.getId(), id)).findFirst().orElseThrow(IllegalArgumentException::new);
        students.remove(st);
        return st;

    }
    public Student update(Integer id,String name, Branch branch){
        Student updated = new Student(name,branch,id);
        Student st=this.students.stream()
                .filter(s-> Objects.equals(s.getId(), id)).findFirst().orElseThrow(IllegalArgumentException::new);
        students.set(students.indexOf(st),updated);
        return updated;

    }

    //Executed after service is injected and constructed in spring bean factory
    @PostConstruct
    private void init(){
        students.add(new Student("Pranay",Branch.CSAI,this.id.incrementAndGet()));
        students.add(new Student("Omkar",Branch.CSE,this.id.incrementAndGet()));
        students.add(new Student("Devesh",Branch.EEE,this.id.incrementAndGet()));
        students.add(new Student("Tanmay",Branch.ECE,this.id.incrementAndGet()));
        students.add(new Student("Sahil",Branch.ITNS,this.id.incrementAndGet()));
        students.add(new Student("Prasanna",Branch.IT,this.id.incrementAndGet()));
        students.add(new Student("Ninad",Branch.MAC,this.id.incrementAndGet()));
    }


}
