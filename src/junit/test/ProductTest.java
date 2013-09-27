package junit.test;



import java.util.Iterator;
import java.util.LinkedHashMap;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itcast.bean.QueryResult;
import com.itcast.bean.product.ProductType;
import com.itcast.service.product.ProductTypeService;
import com.itcast.web.action.product.ProductTypeManageAction;

public class ProductTest {
	private static ApplicationContext cxt;
	private static ProductTypeService ps;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cxt = new ClassPathXmlApplicationContext("beans.xml");
		ps = (ProductTypeService)cxt.getBean("productTypeServiceBean");
	}

	@Test
	public void testSave() {
		
		ProductType type = new ProductType();
		type.setName("篮球用品");
		type.setNote("好篮球");
		ps.save(type);
	}
	
	@Test
	public void testFind() {		
		ProductType type = ps.find(ProductType.class, 1);
		//Assert.assertNotNull("获取不到id为1的记录", type);
		Assert.assertNotNull("获取不到id为1的记录", type);
	}
	
	@Test
	public void testUpdate() {
		
		ProductType type = ps.find(ProductType.class, 1);
		type.setName("足球用品");
		type.setNote("好足球");
		ps.update(type);
	}
	
	@Test
	public void testDelete() {		
		ps.delete(ProductType.class, 2);
	}
	
	@Test
	public <T> void testGetScrollData() {				
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("typeId", "desc");
		QueryResult<ProductType> qr = ps.getScrollData(ProductType.class, 0, 5,
				"o.typeId=?1",new Object[]{5}, orderby);
		Iterator<ProductType> iterator = qr.getResultList().iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getName());
		}
		//System.out.println(qr.getResultList());
		System.out.println(qr.getTotalNumber().intValue());
	}
	
	@Test
	public void testAddProductType() {
		ProductTypeManageAction manager = new ProductTypeManageAction();
		System.out.println(manager.add());
	}

}
