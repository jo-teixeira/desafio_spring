package com.meli.desafiospring.gateway.repository;

import com.meli.desafiospring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from user u " +
                    "inner join user_follower uf on uf.id_user = u.id " +
                    "where uf.id_user = :userId and uf.id_follower = :userIdFollower", nativeQuery = true)
    Optional<User> findByUserIdAndUserIdFollower(@Param("userId") Integer userId,
                                                 @Param("userIdFollower") Integer userIdFollower);

    @Query(value = " SELECT * FROM USER u " +
            " INNER JOIN USER_FOLLOWER uf ON uf.id_follower = u.id " +
            " WHERE uf.id_user = :userId", nativeQuery = true)
    Optional<List<User>> findAllFollowedByUserId(Integer userId);
}