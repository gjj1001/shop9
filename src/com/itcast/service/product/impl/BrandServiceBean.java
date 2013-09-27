package com.itcast.service.product.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itcast.bean.product.Brand;
import com.itcast.service.base.DaoSupport;
import com.itcast.service.product.BrandService;
@Service @Transactional
public class BrandServiceBean extends DaoSupport implements BrandService {

	@Override
	public void save(Object entity) {
		((Brand)entity).setCode(UUID.randomUUID().toString());
		super.save(entity);
	}
	
}
