package com.dkm.demo.controller;

import com.dkm.demo.common.constanct.CodeType;
import com.dkm.demo.common.exception.ApplicationException;
import com.dkm.demo.common.utils.FilesUtils;
import com.dkm.demo.entity.AttenDant;
import com.dkm.demo.service.IAttendantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author MQ
 * @PROJECT_NAME: demo
 * @DESCRIPTION:
 * @DATE: 2020/6/11 10:37
 */
@Api(tags = "跟班Api")
@RestController
@Slf4j
@RequestMapping("/DemoController")
public class DemoController {

    @Autowired
    private IAttendantService iAttendantService;




    /**
     * 随机查询用户表9条数
     * @return
     */
    @ApiOperation(value = "随机查询用户表9条数",notes = "成功返回数据 反则为空")
    @ApiImplicitParam(paramType = "query",dataType = "String",name = "status",value = "被抓人id")
    @GetMapping("/demoUtil")
    public List<AttenDant> demoUtil(@RequestParam(value = "status") Integer status){
        if(status==null){
            throw new ApplicationException(CodeType.PARAMETER_ERROR,"参数不能为空");
        }
        System.out.println("status = " + status);
        List<AttenDant> attenDants = iAttendantService.queryAllAttendant();
        System.out.println("attenDants = " + attenDants.size());
        return attenDants;
    }

    @PostMapping("/storeFile")
    @CrossOrigin
    public void storeFile(@RequestBody MultipartFile file){
        if (file == null) {
            throw new ApplicationException(CodeType.PARAMETER_ERROR, "未上传文件");
        }

        FilesUtils filesUtils=new FilesUtils();
        filesUtils.upload(file,"jj");

    }



}
