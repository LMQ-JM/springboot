package com.dkm.demo.service;

import com.dkm.demo.entity.AttenDant;

import java.util.List;

/**
 * @author 刘梦祺
 * @PROJECT_NAME: demo
 * @DESCRIPTION:
 * @DATE: 2020/6/11 14:13
 */
public interface IAttendantService {

    List<AttenDant> queryAllAttendant();
}
