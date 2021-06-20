package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

//interface interfacei extend eder
public interface ProductDao extends JpaRepository<Product, Integer>{
	
	//<Product  : bu repository hangi tablo icin calısacak
	// Integer> : primary keyin veri turu
	
	Product getByProductName(String productName);
	//select * from products where product_name = abc 
	
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	//select * from products where product_name = abc and category_id = 1
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	//select * from products where product_name = abc or category_id = 1
	
	List<Product> getByCategoryIn(List<Integer> categories);
	//select * from products where category_id in(1,2,3,4)
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	//Jpql
	@Query("From Product where productName=:productName and category.categoryId=:categoryId") //veritabanını unut direk concrete üzerinden yapıyoruz sorguyu
	List<Product> getByNameAndCategory(String productName, int categoryId);
	//select * from products where product_name = bisey and categoru_if = bisey
	
	
	@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto"
			+ "(p.id, p.productName, c.categoryName) "
			+ " From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	//select p.productId, p.productName, c.categoryName from category c inner join Product p
	//on c.categoryId = p.categoryId
	
}
