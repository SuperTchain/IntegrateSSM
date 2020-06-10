package com.lx.controller;

import com.github.pagehelper.PageInfo;
import com.lx.annotation.LogAnnotation;
import com.lx.model.Log;
import com.lx.service.LogService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName OperationController
 * @Description TODO
 * @Author ASUS
 * @Date 2020/6/5 12:55
 * @Version 1.0
 */
@Controller
@RequestMapping("/log")
public class LogController {

    /**
     * 引入日志
     */
    private static Logger logger = Logger.getLogger(LogController.class);

    /**
     * 引入service
     */
    @Autowired
    private LogService logService;

    /**
     * 跳转到日志界面
     *
     * @return 日志界面
     */
    @GetMapping("/toLogList")
    public String toLogList() {
        return "log-list";
    }

    /**
     * 跳转带查看界面
     *
     * @return 查看日志界面
     */
    @GetMapping("/toViewLog")
    public String toViewLog() {
        return "viewLog";
    }

    /**
     * 查询所有日志信息
     * @return 封装结果
     */
    @GetMapping("/findAllLog")
    @LogAnnotation(name = "查询所有日志", url = "/log/findAllLog")
    public String findAllLog(Model model) {
        List<Log> allLogByPage = logService.findAllLogByPage();
        logger.info("查询成功");
        model.addAttribute("allLogByPage", allLogByPage);
        return "log-list";
    }

    /**
     * 根据日志ID查询日志信息
     * @param id 日志ID
     * @return 封装结果
     */
    @PostMapping("/findLogById")
    @LogAnnotation(name = "根据Id查询日志信息",url = "/log/findLogById")
    public String findLogById(Integer id,Model model) {
        Log logById = logService.findLogById(id);
        logger.info("根据产品ID查询成功");
        model.addAttribute("logById", logById);
        return "log-list";
    }

    /**
     * 批量删除日志
     * @param ids 日志ID数组
     * @return 封装结果
     */
    @GetMapping("/batchDelete")
    @LogAnnotation(name = "批量删除日志", url = "/log/batchDelete")
    public String batchDeleteByLogId( String[] ids) {
        Integer integer = logService.batchDeleteByLogId(ids);
        logger.info("成功批量删除日志");
        return "log-list";
    }

    /**
     * 根据ID删除日志
     * @param id id
     * @return 封装结果
     */
    @GetMapping("/deleteById")
    @LogAnnotation(name="删除日志",url = "/log/deleteById")
    public String deleteById( Integer id) {
        Integer integer = logService.deleteById(id);
        logger.info("成功删除日志");
        return "redirect:findAllLog";
    }


    /**
     * 条件搜索日志
     * @param userName 用户姓名
     * @param timerange 时间范围
     * @return 封装结果
     */
    @GetMapping("/search")
    @LogAnnotation(name = "条件查询日志信息",url = "/log/search")
    public String serachLog(String userName, String timerange, Model model) {
        List<Log> list = logService.search(userName, timerange);
        model.addAttribute("list",list);
        logger.info("条件搜索查询成功");
        return "user-list";
    }

}
