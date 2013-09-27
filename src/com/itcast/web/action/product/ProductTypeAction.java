package com.itcast.web.action.product;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itcast.bean.QueryResult;
import com.itcast.bean.product.ProductType;
import com.itcast.service.product.ProductTypeService;
import com.opensymphony.xwork2.ActionContext;

@Controller @Scope("prototype")
public class ProductTypeAction { 
	
	@Resource 
	private ProductTypeService pts;
	
	private QueryResult<ProductType> qr;
	private int firstIndex = 0;
	private int maxResult = 4;
	private Integer parentId = 0;
	private boolean query;
	private String name;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isQuery() {
		return query;
	}

	public void setQuery(boolean query) {
		this.query = query;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public QueryResult<ProductType> getQr() {
		return qr;
	}

	public void setQr(QueryResult<ProductType> qr) {
		this.qr = qr;
	}

	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public int getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

	public String execute() throws Exception {
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("typeId", "asc");
		int pageIndex = firstIndex*maxResult;
		StringBuffer jpql = new StringBuffer("o.visable=?1");
		List<Object> params = new ArrayList<Object>();
		params.add(true);
		if(true==query) {
			jpql.append(" and o.name like ?"+(params.size()+1));
			params.add("%"+name+"%");
		}
		else {
			if(parentId!=null&&parentId>0) {
				jpql.append(" and o.parent.typeId=?"+(params.size()+1));
				params.add(parentId);
			}
			else{
				jpql.append(" and o.parent is null");
			}
		}
		qr = pts.getScrollData(ProductType.class, pageIndex, maxResult, jpql.toString(), params.toArray(), orderby);
		List<ProductType> producttype = qr.getResultList();
		int totalPage = (int) (qr.getTotalNumber()%maxResult==0? qr.getTotalNumber()/maxResult: qr.getTotalNumber()/maxResult+1);
		ActionContext.getContext().put("productType", producttype);		
		ActionContext.getContext().put("currentPage", firstIndex);
		ActionContext.getContext().put("totalPage", totalPage);
		return "list";
	}
	
}
