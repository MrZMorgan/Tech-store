package com.example.techStore.reository;

import com.example.techStore.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {

}
