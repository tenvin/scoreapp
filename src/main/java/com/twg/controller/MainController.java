package com.twg.controller;

import com.twg.dto.ScoreappResult;
import com.twg.entity.Score;
import com.twg.entity.Xueqi;
import com.twg.service.ScoreService;
import com.twg.service.XueqiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tenvin on 2017/7/26.
 */
@Controller
public class MainController {
    private final  Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private XueqiService xueqiService;
    @Autowired
    private ScoreService scoreService;

    @RequestMapping(value = "/main")
    public String main(){
        return "main";
    }

    @RequestMapping(value = "/score",method = RequestMethod.GET)
    public String scoreQuery(Model model){
        List<Xueqi> xueqis = xueqiService.findAll();
        model.addAttribute("xueqis", xueqis);
        return "score";
    }
    //上传
    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String uploadGet(Model model){
        List<Xueqi> xueqis = xueqiService.findAll();
        model.addAttribute("xueqis", xueqis);
        return "upload";
    }

    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public ScoreappResult<String> uploadPost(HttpServletRequest request) throws IllegalStateException, IOException
    {
        String xueqi = request.getParameter("XueqiMenu");
        System.out.println("xueqi------------------:"+xueqi);
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());

        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();

            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String path="E:/upload_"+file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }

            }

        }

        return null;
    }

    @RequestMapping(value = "/time/now",method = RequestMethod.GET)
    @ResponseBody
    public ScoreappResult<Long> time()
    {
        Date now=new Date();
        return new ScoreappResult<Long>(true,now.getTime());
    }

    @ResponseBody
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public ScoreappResult<List<Score>> query(){
        List<Score> scores = scoreService.findAll();
        return new ScoreappResult<List<Score>>(true,scores);
    }
}
