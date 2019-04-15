package com.example.practice.JsonApi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

  @Modifying
  @Query(nativeQuery = true, value = "delete from user_table u where u.id = ?1")
  void deleteById(Long id);

  @Query(nativeQuery = true, value = "select * from user_table u where u.id in ?1")
  Iterable<User> findAllByIds(Iterable<Long> ids);

}
