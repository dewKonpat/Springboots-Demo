package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.response.OrderResponseModel;
import com.example.demo.model.dto.response.TaskResponseModel;
import com.example.demo.model.hibernate.TblCustomerInstance;
import com.example.demo.repository.InstanceRepository;

@Service
public class OrderService {

	@Autowired
	private InstanceRepository instanceRepo;
	
	public OrderResponseModel getOrderById(String id) {
		
		TblCustomerInstance instance = instanceRepo.findById(id).get();
		
		return OrderResponseModel.builder()
								 .id(instance.getId())
								 .privateIdType(instance.getPrivateIdType())
								 .privateIdValue(instance.getPrivateIdValue())
								 .publicIdType(instance.getPublicIdType())
								 .publicIdValue(instance.getPublicIdValue())
								 .mobileNo(instance.getMobileNo()).build();
		
	}

	public List<OrderResponseModel> getOrderByMobileNo(String mobileNo) {
		
		List<TblCustomerInstance> instanceList = instanceRepo.findByMobileNoRaw(mobileNo);
		
		List<OrderResponseModel> responseList = new ArrayList<>();
		for(TblCustomerInstance _instance : instanceList) {
			
			List<TaskResponseModel> taskList = _instance.getTblCustomerTasks().stream().map(item -> TaskResponseModel.builder().id(item.getId()).name(item.getName()).build()).collect(Collectors.toList());
			
			responseList.add( OrderResponseModel.builder()
												 .id(_instance.getId())
												 .privateIdType(_instance.getPrivateIdType())
												 .privateIdValue(_instance.getPrivateIdValue())
												 .publicIdType(_instance.getPublicIdType())
												 .publicIdValue(_instance.getPublicIdValue())
												 .mobileNo(_instance.getMobileNo())
												 .tasks(taskList).build());
		}

		return responseList;
		
	}

}
