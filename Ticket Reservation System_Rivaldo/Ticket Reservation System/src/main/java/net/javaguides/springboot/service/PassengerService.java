package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.javaguides.springboot.model.Passenger;

public interface PassengerService {
	List<Passenger> getAllPassenger();
	void savePassenger(Passenger passenger);
	Passenger getPassengerById(long id);
	void deletePassengerById(long id);
	Page<Passenger> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
