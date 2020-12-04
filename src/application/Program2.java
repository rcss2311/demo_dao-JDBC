package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1 department findById ===");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n=== Test 2 department findAll ===");
		List <Department> list = departmentDao.findAll();
		for(Department obj: list) {
			System.out.println(obj);
		}
		

		System.out.println("\n=== Test 3: department insert ===");
		Department newDepartment = new Department(8, "Magic School");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n=== Test 4: department Update ===");
		department = departmentDao.findById(6);
		department.setName("Programing Factory");
		departmentDao.update(department);
		System.out.println("Up to date");
		
		System.out.println("\n=== Test 5: department Delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deleted");
		
		sc.close();

	}

}
