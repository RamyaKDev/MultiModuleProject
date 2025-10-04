package com.productinventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productinventory.Repository.IInventoryRepository;
import com.productinventory.exception.InvalidProductIdException;
import com.productinventory.model.Inventory;
import com.productinventory.model.InventoryRequest;

@Service
public class InventoryServiceImpl implements IInventoryService {


	@Autowired
	private IInventoryRepository inventoryRepository;

	@Override
	public String addStock(InventoryRequest inventoryRequest) {
		// get the productId from the inventory
		int productId = inventoryRequest.getProductId();
		// check if it is in db
		Inventory inventory = inventoryRepository.findByProductId(productId) // return inventory if present
				.orElse(new Inventory()); // else create a new inventory object
		// get the productId, stock from inventoryrequest and set it
		// if the inventory exists already, get the old stock also
		inventory.setStock(inventoryRequest.getStock() + inventory.getStock());
		inventory.setProductId(productId);
		// save the inventory object
		inventoryRepository.save(inventory);
		return "stock added";
	}


	@Override
	public int checkStock(int productId) {
		Inventory inventory = inventoryRepository.findByProductId(productId)
				.orElseThrow(() -> new InvalidProductIdException("invalid id"));
		return inventory.getStock();
	}

	@Override
	public String updateStock(InventoryRequest inventoryRequest) {
		// get the productId from the inventory
		int productId = inventoryRequest.getProductId();
		// check if it is in db
		Inventory inventory = inventoryRepository.findByProductId(productId) // return inventory if present
				//.orElseThrow(() -> new InvalidProductIdException("invalid id"));
				.orElse(new Inventory()); // else create a new inventory object
				// get the productId, stock from inventoryrequest and set it
		// if the inventory exists already, get the old staock also
		inventory.setStock(inventoryRequest.getStock() + inventory.getStock());
		inventory.setProductId(productId);
		// update the inventory object
		inventoryRepository.save(inventory);
		return "stock updated";
	}

}
