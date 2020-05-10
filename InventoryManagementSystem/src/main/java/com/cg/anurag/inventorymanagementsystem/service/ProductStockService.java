package com.cg.anurag.inventorymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.anurag.inventorymanagementsystem.dao.ProductStockDAO;
import com.cg.anurag.inventorymanagementsystem.dto.ProductStock;
@Service
public class ProductStockService {
	@Autowired
    ProductStockDAO psdao;
	public void setpsdao(ProductStockDAO psdao) { this.psdao=psdao;}
	@Transactional(readOnly=true)
	public ProductStock getOrder(int orderId)
	{
		ProductStock ps;
		try
		{
			ps=psdao.findById(orderId).get();
		}catch(Exception ex)
		{
			return psdao.findById(orderId).get();
		}
		return psdao.findById(orderId).get();
	}
	 @Transactional
	    public String updateExitDate(ProductStock productStock)
	    {
		 ProductStock productStock1 ;
		 try
		 {
	    productStock1 = psdao.findById(productStock.getOrderId()).get();
		 }catch(Exception ex)
		 {
			 return "Updation Failed"; 
		 }
		 
	    	  productStock1.setExitDate(productStock.getExitDate());
	    	  return "Exit Date Modified";
	    	
	    	
	    }
	 @Transactional
	    public String updateStock(ProductStock productStock)
	    {
		 ProductStock productStock2 ;
		 try
		 {
		 productStock2 = psdao.findById(productStock.getOrderId()).get();
		 }
		 catch(Exception ex)
		 {
			 return "Updation Failed";
		 }
			 productStock2.setManufacturingDate(productStock.getManufacturingDate());
			 productStock2.setExpiryDate(productStock.getExpiryDate());
			 productStock2.setQualityCheck(productStock.getQualityCheck());
			 return " Updated Stock Sucessfully";
		 
		
	    }

	 

}
