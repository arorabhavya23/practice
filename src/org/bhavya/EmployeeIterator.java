package org.bhavya;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeIterator {

  public static void main(String[] args){
    Employee emp1 = new Employee();
    Employee emp2 = new Employee();
    Employee emp3 = new Employee();

    Map<String, Employee> employeeMap = new HashMap<>();
    List<Employee> employeeList = new ArrayList<>();

    emp1.setId("2");
    emp2.setId("1");
    emp3.setId("4");

    emp1.setName("Bhavya");
    emp2.setName("Rohit");
    emp3.setName("Rohit");

    employeeList.add(emp1);
    employeeList.add(emp2);
    employeeList.add(emp3);

    System.out.println(employeeList);
    sortEmployees(employeeList).forEach(System.out::println);

  }

  private Map<String, Employee> addEmployeesToMap(List<Employee> employeeList){
    return employeeList.stream().collect(Collectors.toMap(employee -> employee.getName(), employee -> employee));
  }

  private static List<Employee> sortEmployees(List<Employee> employeeList){
    return employeeList.stream().sorted(
        Comparator.comparing(Employee::getId)).sorted(Comparator.comparing(Employee::getName)).collect(
        Collectors.toList());
//    return employeeList.stream().filter(employee -> employee.getName().equals("rohit")).collect(Collectors.toList());
  }
}
