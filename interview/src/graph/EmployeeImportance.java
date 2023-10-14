/**
 * https://leetcode.com/problems/employee-importance/description/
 *
 * Time Complexity: O(V)
 * Space Complexity: O(V)
 * */
package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {

    // Definition for Employee.
    private static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }

    private int getImportanceUtil(Map<Integer, Employee> map, int id) {
        // Get the employee
        Employee employee = map.get(id);
        int importance = employee.importance;
        // Add importance of subordinates to employee importance
        for (int subordinate : employee.subordinates) {
            importance += getImportanceUtil(map, subordinate);
        }
        return importance;
    }

    private int getImportance(List<Employee> employees, int id) {
        // Construct HashMap as getting the employee from id is difficult in a list
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return getImportanceUtil(map, id);
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, 5, new ArrayList<>(Arrays.asList(2, 3))));
        employees.add(new Employee(2, 3, new ArrayList<>()));
        employees.add(new Employee(3, 3, new ArrayList<>()));
        int id = 1;
        System.out.println(new EmployeeImportance().getImportance(employees, id));
    }
}
