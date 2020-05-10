package com.cg.anurag.inventorymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.anurag.inventorymanagementsystem.dto.RawMaterialStock;
import com.cg.anurag.inventorymanagementsystem.service.RawMaterialStockService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RawMaterialStockController {
 

		@Autowired
		RawMaterialStockService rawMaterialStockService;
		public void setRawMaterialStockService(RawMaterialStockService rawMaterialStockService)
		{
			this.rawMaterialStockService=rawMaterialStockService;
		}
		
	   @GetMapping("rawmaterial/getOrder/{orderId}")
	   public RawMaterialStock getOrder(@PathVariable int orderId)
	   {
		   return rawMaterialStockService.getOrder(orderId);
	   }
	   @PutMapping(value="rawmaterial/updateProcessDate",consumes="application/json")
	   public String updateProcessDate(@RequestBody()RawMaterialStock rawMaterialStock )
	   {
		   String message=rawMaterialStockService.updateProcessDate(rawMaterialStock);
		   return message;
	   }
	   @PutMapping(value="rawmaterial/updateStock",consumes="application/json")
	   public String updateStock(@RequestBody()RawMaterialStock rawMaterialStock)
	   {
		   String message=rawMaterialStockService.updateStock(rawMaterialStock);
		   return message;
	   }
	  
	}


