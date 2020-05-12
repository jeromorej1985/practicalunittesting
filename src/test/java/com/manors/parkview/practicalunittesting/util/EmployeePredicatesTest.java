package com.manors.parkview.practicalunittesting.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import com.manors.parkview.practicalunittesting.model.Employee;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class EmployeePredicatesTest {
    Employee employee1 = new Employee(1,23,"M","Rick","Beethovan");
    Employee employee2 = new Employee(2,13,"F","Martina","Hengis");
    Employee employee3 = new Employee(3,43,"M","Ricky","Martin");
    Employee employee4 = new Employee(4,26,"M","Jon","Lowman");
    Employee employee5 = new Employee(5,19,"F","Cristine","Maria");
    Employee employee6 = new Employee(6,15,"M","David","Feezor");
    Employee employee7 = new Employee(7,68,"F","Melissa","Roy");
    Employee employee8 = new Employee(8,79,"M","Alex","Gussin");
    Employee employee9 = new Employee(9,15,"F","Neetu","Singh");
    Employee employee10 = new Employee(10,45,"M","Naveen","Jain");

    List<Employee> employees =  Arrays.asList( new Employee[]{employee1,           employee2, employee3, employee4, employee5, employee6, employee7, employee8, 
        employee9, employee10
    });

    @BeforeEach
    public void setup(){
        
    }

    @Test
    public void employeeShouldBeAnAdultMale(){
        List<Employee> result = Arrays.asList(new Employee[]{employee1, employee3,  employee4, employee8, employee10 });

        assertTrue(true);
        assertEquals("should be all male older than 21", EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAdultMale()), result);
    }

    @Test
    public void employeeShouldBeAdultFemale(){
        List<Employee> result = Arrays.asList(new Employee[]{
            employee5, employee7 
        });
      

        assertEquals("should be all females older than 18", EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAdultFemale()), result);
    }

    @Test
    public void employeeShouldBeOlderThanGivenAge(){
        Integer givenAge = 35;
        List<Employee> result = Arrays.asList(new Employee[]{
            employee3, employee7, employee8, employee10
        });

        assertEquals(String.format("employees older than %d ", givenAge), EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAgeMoreThan(givenAge)), result);
    }


    @Test
    public void employeeShouldBeYoungerThanGivenAge() {
        Integer givenAge = 40;
        List<Employee> result = Arrays.asList(new Employee[]{
            employee1, employee2, employee4, employee5, 
            employee6, employee9
        });

        assertEquals(String.format("employees younger than %d", givenAge), EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAgeMoreThan(givenAge).negate()), result);

    }

    
}