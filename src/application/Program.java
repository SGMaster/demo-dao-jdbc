package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
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
		System.out.println("Enter Id For Deletion Test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deletion Completed");
		
		sc.close();
	}
	
}
