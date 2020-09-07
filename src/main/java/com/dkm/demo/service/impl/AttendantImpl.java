package com.dkm.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dkm.demo.dao.DemoMapper;
import com.dkm.demo.entity.AttenDant;
import com.dkm.demo.service.IAttendantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 刘梦祺
 * @PROJECT_NAME: demo
 * @DESCRIPTION:
 * @DATE: 2020/6/11 14:13
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class AttendantImpl extends ServiceImpl<DemoMapper, AttenDant> implements IAttendantService {


    @Override
    public List<AttenDant> queryAllAttendant() {
        return baseMapper.selectList(null);
    }


}
