package com.hz.yk.salary.database;

import com.hz.yk.salary.entity.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {

	public static Map<Integer, Employee> itsEmployees = new HashMap<Integer, Employee>();
	public static Map<Integer, Employee> itsUnionEmployees = new HashMap<Integer, Employee>();

	public static Employee getEmployee(int empid) {
		return itsEmployees.get(empid);
	}

	public static void addEmployee(int empid, Employee employee) {
		System.out.println(employee);
		itsEmployees.put(empid, employee);
	}

	public static void deleteEmployee(int empid) {
		itsEmployees.remove(empid);
	}

	public static Employee getUnionMember(int memberId) {
		return itsUnionEmployees.get(memberId);
	}

	public static void addUnionMember(int memberId, Employee e) {
		itsUnionEmployees.put(memberId, e);
	}

	public static void removeUnionMember(int memberId) {
		itsUnionEmployees.remove(memberId);
	}

	public static Collection<Integer> getAllEmployeeId() {
		return itsEmployees.keySet();
	}

}
