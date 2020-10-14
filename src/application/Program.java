package application;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println();
		System.out.println("=== TEST 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller sellers: list) {
			System.out.println(sellers);
		}
		
		System.out.println();
		System.out.println("=== TEST 3: seller findAll ===");
		list = sellerDao.findAll();
		for (Seller sellers: list) {
			System.out.println(sellers);
		}
		
		System.out.println();
		System.out.println("=== TEST 4: seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId());
		
		System.out.println();
		System.out.println("=== TEST 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("Update Completed!");
		
		System.out.println();
		System.out.println("=== TEST 6: seller delete ===");
		System.out.println("Enter Id For Seller Deletion Test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deletion Completed");
		
		System.out.println();
		System.out.println("=== TEST 7: department findAll ===");
		List<Department> departmentList = departmentDao.findAll();
		for (Department department2: departmentList) {
			System.out.println(department2);
		}
		
		System.out.println();
		System.out.println("=== TEST 8: department findById ===");
		System.out.println("Enter Id For Department findById Test: ");
		int departmentId = sc.nextInt();
		department = departmentDao.findById(departmentId);
		if(Objects.nonNull(department))
			System.out.println(department);
		
		System.out.println();
		System.out.println("=== TEST 9: Department delete ===");
		System.out.println("Enter Id For Department Deletion Test: ");
		id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deletion Completed");
		
		System.out.println();
		System.out.println("=== TEST 10: Department update ===");
		department = departmentDao.findById(1);
		department.setName("Books");
		departmentDao.update(department);
		System.out.println("Update Completed!");
		
		System.out.println();
		System.out.println("=== TEST 11: Department insert ===");
		Department newDepartment = new Department(null, "Computers");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Id = " + newDepartment.getId());
		
		sc.close();
	}
	
}
