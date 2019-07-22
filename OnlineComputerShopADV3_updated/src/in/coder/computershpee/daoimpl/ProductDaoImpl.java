package in.coder.computershpee.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.coder.computershpee.dao.ProductDao;
import in.coder.computershpee.pojo.Customer;
import in.coder.computershpee.pojo.Product;
import static in.coder.computershpee.utility.DBConnection.getConnection;

public class ProductDaoImpl implements ProductDao {
	
	Connection con =getConnection();
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	Product product = null;
	
	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		if(product!=null)//if product not(!) = null
		{
			try {
				pstmt=con.prepareStatement("insert into products(productname,productprice,productcategory,productdescription,productfeatures,productbrand) value(?,?,?,?,?,?)");
				pstmt.setString(1, product.getProductName());
				pstmt.setDouble(2, product.getProductPrice());
				pstmt.setString(3, product.getProductCategory());
				pstmt.setString(4, product.getProductDescription());
				pstmt.setString(5, product.getProductFeatures());
				pstmt.setString(6, product.getProductBrand());
				
				int recordInserted=pstmt.executeUpdate();
				if(recordInserted>0)
				{
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean productIsAlreadyAdded(Product product)
	{
		if(product!=null)
		{
			System.out.println("In productIsAlreadyAdded : "+product);
			try {
				pstmt=con.prepareStatement("select * from products where productname=? and productcategory=? and productbrand=?");
				pstmt.setString(1, product.getProductName());
				pstmt.setString(2, product.getProductCategory());
				pstmt.setString(3, product.getProductBrand());
				
				rs=pstmt.executeQuery();
				if(rs.next())
				{
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return false;
	}

	@Override
	public boolean editProduct(Product product) {
		// TODO Auto-generated method stub
		
		if(product!=null)
		{
			if(searchProductsById(product.getProductId()) != null)
			{
				try {
					pstmt=con.prepareStatement("update products set productname=?,productprice=?,productcategory=?,productdescription=?,productfeatures=?,productbrand=? where productid=?");
					
					pstmt.setString(1, product.getProductName());
					pstmt.setDouble(2, product.getProductPrice());
					pstmt.setString(3, product.getProductCategory());
					pstmt.setString(4, product.getProductDescription());
					pstmt.setString(5, product.getProductFeatures());
					pstmt.setString(6, product.getProductBrand());
					pstmt.setInt(7, product.getProductId());
					
					int RecordUpdated=pstmt.executeUpdate();
					if(RecordUpdated>0)
					{
						return true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("RECORD WITH THIS PRODUCT ID DOES NOT EXITS");
		}
		return false;
	}

	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		
		try {
			pstmt=con.prepareStatement("delete from products where productid=?");
			pstmt.setInt(1,productId);
						
			int RecordDeleted=pstmt.executeUpdate();
			if(RecordDeleted>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Product searchProductsById(int productId) {
		// TODO Auto-generated method stub
		
		//List<Product> listOfProducts = new ArrayList<>();
		
		try {
			
			pstmt=con.prepareStatement("select * from products where productid=?");
			pstmt.setInt(1,productId);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{				  
				  product = new Product();
				  
				  product.setProductId(rs.getInt(1));
				  product.setProductName(rs.getString(2));
				  product.setProductPrice(rs.getDouble(3));
				  product.setProductCategory(rs.getString(4));
				  product.setProductDescription(rs.getString(5));
				  product.setProductFeatures(rs.getString(6));
				  product.setProductBrand(rs.getString(7));
				  
				  return product;  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> searchProductsByName(String productName) {
		// TODO Auto-generated method stub
		
		List<Product> listOfProducts = new ArrayList<>();
		
		try {
			/*stmt = con.createStatement();
			rs=stmt.executeQuery("select * from products where productname=?");*/
			
			pstmt=con.prepareStatement("select * from products where productname like ?");
			pstmt.setString(1,"%"+productName+"%");
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{				  
				  product = new Product();
				  
				  product.setProductId(rs.getInt(1));
				  product.setProductName(rs.getString(2));
				  product.setProductPrice(rs.getDouble(3));
				  product.setProductCategory(rs.getString(4));
				  product.setProductDescription(rs.getString(5));
				  product.setProductFeatures(rs.getString(6));
				  product.setProductBrand(rs.getString(7));
				  
				  listOfProducts.add(product);  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfProducts;
	}

	@Override
	public List<Product> searchProductsByBrand(String productBrand) {
		// TODO Auto-generated method stub
		
		List<Product> listOfProducts = new ArrayList<>();
		
		try {
			pstmt=con.prepareStatement("select * from products where productbrand=?");
			pstmt.setString(1, productBrand);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{				  
				  product = new Product();
				  
				  product.setProductId(rs.getInt(1));
				  product.setProductName(rs.getString(2));
				  product.setProductPrice(rs.getDouble(3));
				  product.setProductCategory(rs.getString(4));
				  product.setProductDescription(rs.getString(5));
				  product.setProductFeatures(rs.getString(6));
				  product.setProductBrand(rs.getString(7));
				  
				  listOfProducts.add(product);  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfProducts;
	}

	@Override
	public List<Product> searchProductsByCategory(String productCategory) {
		// TODO Auto-generated method stub
		
		List<Product> listOfProducts = new ArrayList<>();
		
		try {
			pstmt=con.prepareStatement("select * from products where productcategory=?");
			pstmt.setString(1, productCategory);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{				  
				  product = new Product();
				  
				  product.setProductId(rs.getInt(1));
				  product.setProductName(rs.getString(2));
				  product.setProductPrice(rs.getDouble(3));
				  product.setProductCategory(rs.getString(4));
				  product.setProductDescription(rs.getString(5));
				  product.setProductFeatures(rs.getString(6));
				  product.setProductBrand(rs.getString(7));
				  
				  listOfProducts.add(product);  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfProducts;
	}

	@Override
	public List<Product> viewAllProducts() {
		// TODO Auto-generated method stub
		
		List<Product> listOfAllProducts = new ArrayList<>();
		
		try {
			stmt = con.createStatement();
			rs=stmt.executeQuery("select * from products");
			while(rs.next())
			{
				  product = new Product();
				  
				  product.setProductId(rs.getInt(1));
				  product.setProductName(rs.getString(2));
				  product.setProductPrice(rs.getDouble(3));
				  product.setProductCategory(rs.getString(4));
				  product.setProductDescription(rs.getString(5));
				  product.setProductFeatures(rs.getString(6));
				  product.setProductBrand(rs.getString(7));
				  
				  listOfAllProducts.add(product); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfAllProducts;
	}

	@Override
	public boolean addReviews(int productId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> searchProductByPrice(String productCategory, float sPrice, float ePrice) {
		// TODO Auto-generated method stub
		
		List<Product> listOfProducts = new ArrayList<>();
		
		try {			
			pstmt=con.prepareStatement("select * from products where productcategory=? and productprice between ? and ?");
			pstmt.setString(1, productCategory);
			pstmt.setFloat(2, sPrice);
			pstmt.setFloat(3, ePrice);
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{				  
				  product = new Product();
				  
				  product.setProductId(rs.getInt(1));
				  product.setProductName(rs.getString(2));
				  product.setProductPrice(rs.getDouble(3));
				  product.setProductCategory(rs.getString(4));
				  product.setProductDescription(rs.getString(5));
				  product.setProductFeatures(rs.getString(6));
				  product.setProductBrand(rs.getString(7));
				  
				  listOfProducts.add(product);  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfProducts;
	}

}
