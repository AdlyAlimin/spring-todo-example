package net.pandanet.springboottodorestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.pandanet.springboottodorestapi.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
