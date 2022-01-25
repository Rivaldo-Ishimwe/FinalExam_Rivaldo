package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Passenger;
import net.javaguides.springboot.repository.PassengerRepository;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepository passengerRepository;

	@Override
	public List<Passenger> getAllPassenger() {
		return passengerRepository.findAll();
	}

	@Override
	public void savePassenger(Passenger passenger) {
		this.passengerRepository.save(passenger);
	}

	@Override
	public Passenger getPassengerById(long id) {
		Optional<Passenger> optional = passengerRepository.findById(id);
		Passenger passenger = null;
		if (optional.isPresent()) {
			passenger = optional.get();
		} else {
			throw new RuntimeException(" Passenger not found for id :: " + id);
		}
		return passenger;
	}

	@Override
	public void deletePassengerById(long id) {
		this.passengerRepository.deleteById(id);
	}

	@Override
	public Page<Passenger> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.passengerRepository.findAll(pageable);
	}
}