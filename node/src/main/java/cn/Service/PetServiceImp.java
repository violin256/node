package cn.Service;

import cn.dao.PetsRepository;
import cn.pojo.PetsEntity;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImp implements PetService {

    @Autowired
    private PetsRepository dao;
    @Override
    public Page<PetsEntity> findAll(int page, int size) {
        //定义一个pageable,根据ID查询
        Pageable pageable=new PageRequest(page,size, Sort.Direction.ASC,"id");
        return dao.findAll(pageable);
    }
}
