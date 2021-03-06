package persistence;

import java.util.List;

public interface ProductDAO {

	void insert(ProductDTO pdto);
	
	List<ProductDTO> getList();
	
	ProductDTO getDetail(int pno);
	
	void update(ProductDTO pdto);
	
	void delete(int pno);
	
	void readCount(int pno);
	}
