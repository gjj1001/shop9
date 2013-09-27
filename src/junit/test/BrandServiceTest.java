package junit.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itcast.bean.product.Brand;
import com.itcast.service.product.BrandService;

public class BrandServiceTest {
	private static ApplicationContext cxt;
	private static BrandService bs;
	private String name;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cxt = new ClassPathXmlApplicationContext("beans.xml");
		bs = (BrandService)cxt.getBean("brandServiceBean");
	}

	@Test
	public void testSave() {
		for(int i=0; i<15; i++) {
			name = "Ô¶Ñôè¤Ù¤"+i;
			bs.save(new Brand(name,"/image/brand/2013/03/04/17/pp.gif"));
		}
		
	}

}
