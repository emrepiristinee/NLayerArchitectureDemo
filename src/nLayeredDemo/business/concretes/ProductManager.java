package nLayeredDemo.business.concretes;

import java.util.List;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.core.LoggerService;
import nLayeredDemo.dataAccess.abstracts.ProductDao;
import nLayeredDemo.dataAccess.concretes.HibernateProductDao;
import nLayeredDemo.entities.concretes.Product;

public class ProductManager implements ProductService {

	private ProductDao productDao;
	private LoggerService loggerService;

	public ProductManager(ProductDao productDao, LoggerService loggerService) {
		super();
		this.productDao = productDao;
		this.loggerService = loggerService;
	}

	@Override
	public void add(Product product) {
		if (product.getCategoryId() == 1) {
			System.out.println("Bu kategoride ürün kabul edilmiyor");
			return;
		}

//		HibernateProductDao hibernateDao = new HibernateProductDao();
//		hibernateDao.add(product);
// 		bunu kullanýp baðýmlý hale gelmek yerine constructor oluþturup 
//		ProductDao'ya eriþerek Hibernate veya Abc'ye baðýmsýz eriþebiliyoruz

		this.productDao.add(product);
		this.loggerService.logToSystem("J logger eklendi");
		
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
