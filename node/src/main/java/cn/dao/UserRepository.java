package cn.dao;

import cn.pojo.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository< UserEntity,Integer> {
    //通过userName查询
    Optional<UserEntity> findByUserName(String userName);
}
