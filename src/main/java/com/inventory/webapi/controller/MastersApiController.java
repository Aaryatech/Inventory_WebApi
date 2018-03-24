package com.inventory.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.webapi.model.CustomerMaster;
import com.inventory.webapi.model.Info;
import com.inventory.webapi.model.ItemCategory;
import com.inventory.webapi.model.ItemGroup;
import com.inventory.webapi.model.ItemMaster;
import com.inventory.webapi.model.ItemUom;
import com.inventory.webapi.model.SupplierMaster;
import com.inventory.webapi.model.User;
import com.inventory.webapi.repository.CustomerMasterRepository;
import com.inventory.webapi.repository.ItemCategoryRepository;
import com.inventory.webapi.repository.ItemGroupRepository;
import com.inventory.webapi.repository.ItemMasterRepository;
import com.inventory.webapi.repository.ItemUomRepository;
import com.inventory.webapi.repository.SupplierMasterRepository;
import com.inventory.webapi.repository.UserRepository; 


@RestController
public class MastersApiController {
	
	@Autowired
	ItemUomRepository itemUomRepository;
	
	@Autowired
	ItemGroupRepository itemGroupRepository;
	
	@Autowired
	ItemCategoryRepository itemCategoryRepository;
	
	@Autowired
	CustomerMasterRepository customerMasterRepository;
	
	@Autowired
	SupplierMasterRepository supplierMasterRepository;
	
	@Autowired
	ItemMasterRepository itemMasterRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = { "/postUom" }, method = RequestMethod.POST)
	public @ResponseBody ItemUom postUom(@RequestBody ItemUom itemUom)
	{
		System.out.println("itemUom :"+itemUom.toString()); 
		ItemUom response = new ItemUom();
		try {
			  
			response = itemUomRepository.save(itemUom);
			System.out.println(response.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return response;

	}
	
	@RequestMapping(value = { "/getAllUomList" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemUom> getAllUomList(@RequestParam ("flag") int flag)
	{
		 
		List<ItemUom> gelAllUomList = new ArrayList<ItemUom>();
		try {
			  if(flag==0)
				  gelAllUomList = itemUomRepository.findAllByDelStatus(0);
			  else
				  gelAllUomList = itemUomRepository.findAll();
			System.out.println(gelAllUomList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return gelAllUomList;

	}
	@RequestMapping(value = { "/getUomById" }, method = RequestMethod.POST)
	public @ResponseBody ItemUom getUomById(@RequestParam ("uomId") int uomId)
	{
		 
		ItemUom getAllUomById = new ItemUom();
		try {
			  
			getAllUomById = itemUomRepository.findByUomId(uomId);
			System.out.println(getAllUomById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return getAllUomById;

	}
	@RequestMapping(value = { "/deleteUom" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteUom(@RequestParam ("uomId") int uomId)
	{
		 
		Info info = new Info();
		try {
			  
			int delete = itemUomRepository.deleteUom(uomId);
			if(delete==1)
			{
				info.setError(false);
				info.setMessage("successfully Deleted ");
			}
			else
			{
				info.setError(true);
				info.setMessage("Unsuccessfully Deleted ");
			}
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
         
		return info; 
	}
	
	//----------------------------------------------------------------------------------------------------
	
	@RequestMapping(value = { "/postGroup" }, method = RequestMethod.POST)
	public @ResponseBody ItemGroup postGroup(@RequestBody ItemGroup itemGroup)
	{
		System.out.println("itemGroup :"+itemGroup.toString()); 
		ItemGroup response = new ItemGroup();
		try {
			  
			response = itemGroupRepository.save(itemGroup);
			System.out.println(response.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return response;

	}
	
	@RequestMapping(value = { "/getAllGroupList" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemGroup> getAllGroupList(@RequestParam ("flag") int flag)
	{
		 
		List<ItemGroup> getAllGroupList = new ArrayList<ItemGroup>();
		try {
			System.out.println("flag" + flag);
			  if(flag==0)
				  getAllGroupList = itemGroupRepository.findAllByDelStatus(0);
			  else
				  getAllGroupList = itemGroupRepository.findAll();
			
			System.out.println(getAllGroupList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return getAllGroupList;

	}
	
	@RequestMapping(value = { "/getGroupById" }, method = RequestMethod.POST)
	public @ResponseBody ItemGroup getGroupById(@RequestParam ("groupId") int groupId)
	{
		 
		ItemGroup getAllUomById = new ItemGroup();
		try {
			  
			getAllUomById = itemGroupRepository.findBygroupId(groupId);
			System.out.println(getAllUomById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return getAllUomById;

	}
	
	@RequestMapping(value = { "/deleteGroup" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteGroup(@RequestParam ("groupId") int groupId)
	{
		 
		Info info = new Info();
		try {
			  
			int delete = itemGroupRepository.deleteGroup(groupId);
			if(delete==1)
			{
				info.setError(false);
				info.setMessage("successfully Deleted ");
			}
			else
			{
				info.setError(true);
				info.setMessage("Unsuccessfully Deleted ");
			}
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
         
		return info; 
	}
	//----------------------------------------------------------------------------------------------------
	
	@RequestMapping(value = { "/postCategory" }, method = RequestMethod.POST)
	public @ResponseBody ItemCategory postCategory(@RequestBody ItemCategory itemCategory)
	{
		System.out.println("itemCategory :"+itemCategory.toString()); 
		ItemCategory response = new ItemCategory();
		try {
			  
			response = itemCategoryRepository.save(itemCategory);
			System.out.println(response.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return response;

	}
	
	@RequestMapping(value = { "/getCategoryList" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemCategory> getCategoryList(@RequestParam ("flag") int flag)
	{
		 
		List<ItemCategory> getCategoryList = new ArrayList<ItemCategory>();
		try {
			  if(flag==0)
				  getCategoryList = itemCategoryRepository.findAllByDelStatus(0);
			  else
				  getCategoryList = itemCategoryRepository.findAll();
			System.out.println(getCategoryList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return getCategoryList;

	}
	
	@RequestMapping(value = { "/getCategoryById" }, method = RequestMethod.POST)
	public @ResponseBody ItemCategory getCategoryById(@RequestParam ("catId") int catId)
	{
		 
		ItemCategory getCategoryById = new ItemCategory();
		try {
			  
			getCategoryById = itemCategoryRepository.findByCatId(catId);
			System.out.println(getCategoryById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return getCategoryById;

	}
	
	@RequestMapping(value = { "/deleteCategory" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteCategory(@RequestParam ("catId") int catId)
	{
		 
		Info info = new Info();
		try {
			  
			int delete = itemCategoryRepository.deleteCategory(catId);
			if(delete==1)
			{
				info.setError(false);
				info.setMessage("successfully Deleted ");
			}
			else
			{
				info.setError(true);
				info.setMessage("Unsuccessfully Deleted ");
			}
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
         
		return info; 
	}
	
	@RequestMapping(value = { "/getCatListByGroupId" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemCategory> getCatListByGroupId(@RequestParam ("groupId") int groupId)
	{
		 
		List<ItemCategory> getCatListByGroupId = new ArrayList<ItemCategory>();
		try {
			getCatListByGroupId = itemCategoryRepository.findByGroupIdAndDelStatus(groupId,0);
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return getCatListByGroupId;

	}
	
//--------------------------------------------------------------------------------------------------------------
	
	@RequestMapping(value = { "/postCustomer" }, method = RequestMethod.POST)
	public @ResponseBody CustomerMaster postCustomer(@RequestBody CustomerMaster customerMaster)
	{
		System.out.println("customerMaster :"+customerMaster.toString()); 
		CustomerMaster response = new CustomerMaster();
		try {
			  
			response = customerMasterRepository.save(customerMaster);
			System.out.println(response.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return response;

	}
	
	@RequestMapping(value = { "/getCustomerList" }, method = RequestMethod.POST)
	public @ResponseBody List<CustomerMaster> getCustomerList(@RequestParam ("flag") int flag)
	{
		 
		List<CustomerMaster> getCustomerList = new ArrayList<CustomerMaster>();
		try {
			  if(flag==0) 
				  getCustomerList = customerMasterRepository.findAllByDelStatus(0);
			  else
				  getCustomerList = customerMasterRepository.findAll();
			System.out.println(getCustomerList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return getCustomerList;

	}
	
	@RequestMapping(value = { "/getCustomerById" }, method = RequestMethod.POST)
	public @ResponseBody CustomerMaster getCustomerById(@RequestParam ("custId") int custId)
	{
		 
		CustomerMaster getCustomerById = new CustomerMaster();
		try {
			  
			getCustomerById = customerMasterRepository.findByCustId(custId);
			System.out.println(getCustomerById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return getCustomerById;

	}
	
	@RequestMapping(value = { "/deleteCustomer" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteCustomer(@RequestParam ("custId") int custId)
	{
		 
		Info info = new Info();
		try {
			  
			int delete = customerMasterRepository.deleteCustomer(custId);
			if(delete==1)
			{
				info.setError(false);
				info.setMessage("successfully Deleted ");
			}
			else
			{
				info.setError(true);
				info.setMessage("Unsuccessfully Deleted ");
			}
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
         
		return info; 
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	
	@RequestMapping(value = { "/postSuppllier" }, method = RequestMethod.POST)
	public @ResponseBody SupplierMaster postSuppllier(@RequestBody SupplierMaster supplierMaster)
	{
		System.out.println("supplierMaster :"+supplierMaster.toString()); 
		SupplierMaster response = new SupplierMaster();
		try {
			  
			response = supplierMasterRepository.save(supplierMaster);
			System.out.println(response.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return response;

	}
	
	@RequestMapping(value = { "/getSuppllierList" }, method = RequestMethod.POST)
	public @ResponseBody List<SupplierMaster> getSuppllierList(@RequestParam ("flag") int flag)
	{
		 
		List<SupplierMaster> getSuppllierList = new ArrayList<SupplierMaster>();
		try {
			  if(flag==0)
				  getSuppllierList = supplierMasterRepository.findAllByDelStatus(0);
			  else
				  getSuppllierList = supplierMasterRepository.findAll();
			
			System.out.println(getSuppllierList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return getSuppllierList;

	}
	
	@RequestMapping(value = { "/getSuppllierById" }, method = RequestMethod.POST)
	public @ResponseBody SupplierMaster getSuppllierById(@RequestParam ("suppId") int suppId)
	{
		 
		SupplierMaster getSuppllierById = new SupplierMaster();
		try {
			  
			getSuppllierById = supplierMasterRepository.findBySuppId(suppId);
			System.out.println(getSuppllierById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return getSuppllierById;

	}
	
	@RequestMapping(value = { "/deleteSuppllier" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSuppllier(@RequestParam ("suppId") int suppId)
	{
		 
		Info info = new Info();
		try {
			  
			int delete = supplierMasterRepository.deleteSuppllier(suppId);
			if(delete==1)
			{
				info.setError(false);
				info.setMessage("successfully Deleted ");
			}
			else
			{
				info.setError(true);
				info.setMessage("Unsuccessfully Deleted ");
			}
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
         
		return info; 
	}
	
	//--------------------------------------item---------------------------------------------------
	
	@RequestMapping(value = { "/postItem" }, method = RequestMethod.POST)
	public @ResponseBody ItemMaster postItem(@RequestBody ItemMaster itemMaster)
	{
		System.out.println("itemMaster :"+itemMaster.toString()); 
		ItemMaster response = new ItemMaster();
		try {
			  
			response = itemMasterRepository.save(itemMaster);
			System.out.println(response.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return response;

	}
	
	@RequestMapping(value = { "/getItemList" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemMaster> getItemList(@RequestParam ("flag") int flag)
	{
		 
		List<ItemMaster> getItemList = new ArrayList<ItemMaster>();
		try {
			  if(flag==0)
				  getItemList = itemMasterRepository.findAllByDelStatus(0);
			  else
				  getItemList = itemMasterRepository.findAll();
			
			System.out.println(getItemList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return getItemList;

	}
	
	@RequestMapping(value = { "/getItemById" }, method = RequestMethod.POST)
	public @ResponseBody ItemMaster getItemById(@RequestParam ("itemId") int itemId)
	{
		 
		ItemMaster getItemById = new ItemMaster();
		try {
			  
			getItemById = itemMasterRepository.findByItemId(itemId);
			System.out.println(getItemById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return getItemById;

	}
	
	@RequestMapping(value = { "/deleteItem" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteItem(@RequestParam ("itemId") int itemId)
	{
		 
		Info info = new Info();
		try {
			  
			int delete = itemMasterRepository.deleteItem(itemId);
			if(delete==1)
			{
				info.setError(false);
				info.setMessage("successfully Deleted ");
			}
			else
			{
				info.setError(true);
				info.setMessage("Unsuccessfully Deleted ");
			}
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
         
		return info; 
	}
	
	//----------------------------------------User----------------------------------
	
	@RequestMapping(value = { "/postUser" }, method = RequestMethod.POST)
	public @ResponseBody User postUser(@RequestBody User user)
	{
		System.out.println("user :"+user.toString()); 
		User response = new User();
		try {
			  
			response = userRepository.save(user);
			System.out.println(response.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return response;

	}
	
	@RequestMapping(value = { "/getUserList" }, method = RequestMethod.POST)
	public @ResponseBody List<User> getUserList(@RequestParam ("flag") int flag)
	{
		 
		List<User> getUserList = new ArrayList<User>();
		try {
			  if(flag==0)
				  getUserList = userRepository.findAllByDelStatus(0);
			  else
				  getUserList = userRepository.findAll();
			
			System.out.println(getUserList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return getUserList;

	}
	
	@RequestMapping(value = { "/getUserById" }, method = RequestMethod.POST)
	public @ResponseBody User getUserById(@RequestParam ("userId") int userId)
	{
		 
		User getUserById = new User();
		try {
			  
			getUserById = userRepository.findByUserId(userId);
			System.out.println(getUserById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return getUserById;

	}
	
	@RequestMapping(value = { "/deleteUser" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteUser(@RequestParam ("userId") int userId)
	{
		 
		Info info = new Info();
		try {
			  
			int delete = userRepository.deleteUser(userId);
			if(delete==1)
			{
				info.setError(false);
				info.setMessage("successfully Deleted ");
			}
			else
			{
				info.setError(true);
				info.setMessage("Unsuccessfully Deleted ");
			}
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
         
		return info; 
	}

}
