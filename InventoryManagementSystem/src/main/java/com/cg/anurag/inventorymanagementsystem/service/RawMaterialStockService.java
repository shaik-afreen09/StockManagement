package com.cg.anurag.inventorymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.anurag.inventorymanagementsystem.dao.RawMaterialStockDAO;
import com.cg.anurag.inventorymanagementsystem.dao.RawMaterialStockDAOImpl;
import com.cg.anurag.inventorymanagementsystem.dto.RawMaterialStock;
@Service
public class RawMaterialStockService {
	@Autowired
	RawMaterialStockDAO rmsdao;
	public void setpsdao(RawMaterialStockDAO psdao) { this.rmsdao=rmsdao;}
	@Transactional(readOnly=true)
	public RawMaterialStock getOrder(int orderId) {
		
		RawMaterialStock rms= new RawMaterialStock();
		try
		{
		rms=	rmsdao.findById(orderId).get();
		return rms;
		}catch(Exception ex)
		{
			//return rms;
		}
		return rms;
			}
	 @Transactional
	    public String updateProcessDate(RawMaterialStock rawMaterialStock)
	    {
		 RawMaterialStock rawMaterialStock1;
		 try
		 {
	    	 rawMaterialStock1 = rmsdao.findById(rawMaterialStock.getOrderId()).get();
		 }
		 catch(Exception ex)
		 {
			 return "Updation Failed"; 
		 }
		
	    	  rawMaterialStock1.setProcessDate(rawMaterialStock.getProcessDate());
	    	  return "Process Date Modified";
	    	
	    	
	    }
	 @Transactional
	public String updateStock(RawMaterialStock rawMaterialStock) {
		
		 RawMaterialStock rawMaterialStock1;
		try
		{
		 rawMaterialStock1 = rmsdao.findById(rawMaterialStock.getOrderId()).get();
		}catch(Exception ex)
		
		{
			return "Updation Failed";
		}
		
	    	  rawMaterialStock1.setManufacturingDate(rawMaterialStock.getManufacturingDate());
	    	  rawMaterialStock1.setExpiryDate(rawMaterialStock.getExpiryDate());
	    	  rawMaterialStock1.setQualityCheck(rawMaterialStock.getQualityCheck());
	    	  return "Updated Stock Sucessfully";
	    	
	    	
	}

}
