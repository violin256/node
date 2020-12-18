package cn.Service;

import cn.pojo.PetsEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PetService {
    public Page<PetsEntity> findAll(int page, int size);
}
