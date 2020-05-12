package com.manors.parkview.practicalunittesting.util;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.manors.parkview.practicalunittesting.model.Employee;

public class EmployeePredicates {

    public static Predicate<Employee> isAdultMale(){
        return employee -> employee.getAge() > 21 && employee.getGender().equalsIgnoreCase("M");
    }

    public static Predicate<Employee> isAdultFemale(){
        return employee -> employee.getAge() > 18 && employee.getGender().equalsIgnoreCase("F");
    }

    public static Predicate<Employee> isAgeMoreThan(Integer givenAge){
        return employee -> employee.getAge() > givenAge;
    }

    public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate){
        return employees.stream()
            .filter(predicate::test)
            .collect(Collectors.toList());
    }
    
}