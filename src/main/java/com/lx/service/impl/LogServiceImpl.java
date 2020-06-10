package com.lx.service.impl;

import com.github.pagehelper.PageHelper;
import com.lx.dao.LogDao;
import com.lx.model.Log;
import com.lx.service.LogService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;

/**
 * @ClassName LogServiceImpl
 * @Description TODO
 * @Author ASUS
 * @Date 2020/6/5 13:09
 * @Version 1.0
 */
@Service
public class LogServiceImpl implements LogService {
    /**
     * 开启日志
     */
    private static Logger logger = Logger.getLogger(LogServiceImpl.class);

    /**
     * 引入dao
     */
    @Autowired
    private LogDao logDao;

    /**
     * 插入记录
     * @param username 用户名
     * @param methodOperation 操作
     * @param urlOperation 操作地址
     * @param operationTime 操作时间
     */
    @Override
    public Integer insertLog(String username, String methodOperation, String urlOperation, Date operationTime) {
        Integer integer= logDao.insertLog(username,methodOperation,urlOperation,operationTime);
        return integer==1?1:0;
    }

    /**
     * 查询所有日志信息
     * @return 封装结果
     */
    @Override
    public List<Log> findAllLogByPage() {
        return logDao.findAllLogByPage();
    }

    /**
     * 批量删除日志
     * @param ids 日志数组
     * @return 封装结果
     */
    @Override
    public Integer batchDeleteByLogId(String[] ids) {
        return logDao.batchDeleteByLogId(ids);
    }

    /**
     * 根据id查询日志
     * @param id id
     * @return 封装结果
     */
    @Override
    public Log findLogById(Integer id) {
        return logDao.findLogById(id);
    }

    /**
     * 根据id删除日志
     * @param id 日志id
     * @return 封装结果
     */
    @Override
    public Integer deleteById(Integer id) {
        return  logDao.deleteById(id);
    }

    /**
     * 条件查询
     * @param userName 用户姓名
     * @param timerange 时间范围
     * @return 封装结果
     */
    @Override
    public List<Log> search(String userName, String timerange) {
        //开始时间
        String startTime=null;
        //结束时间
        String endTime=null;
        String isNull="";
        //判断时间是否为空字符串
        if(!timerange.equals(isNull)){
            //根据开始时间和结束时间查询
            //使用split切割，返回数组 数组第一个元素：起始时间 数组第二个元素：结束时间
            String [] timeArray = timerange.split("~");
            //为其赋值,trim():去除前后的空格，
            startTime= timeArray[0].trim();
            endTime= timeArray[1].trim();
        }
        return logDao.search(userName, startTime,endTime);
    }
}
