package ch.bbw.df.jsonmashup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.bbw.df.jsonmashup.models.User;

public interface UserRepository extends JpaRepository<User, Integer> { }