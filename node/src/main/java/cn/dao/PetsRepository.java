package cn.dao;

import cn.pojo.PetsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetsRepository extends JpaRepository<PetsEntity,Integer> {
}
