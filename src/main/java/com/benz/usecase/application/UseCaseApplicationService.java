package com.benz.usecase.application;

import com.benz.framework.AssertionConcern;
import com.benz.usecase.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * Created by paulliu on 2016/12/12.
 */
@Service
public class UseCaseApplicationService {

    @Autowired
    private UseCaseRepository useCaseRepository;

    public String createUseCase(UseCaseCreateCommand command) {
        UseCase useCase =
                new UseCase(
                        new CaseSubject(command.getSubject()),
                        command.getValue(),
                        command.getScenario(),
                        command.getResult(),
                        command.getDataSource(),
                        command.getDataTypeDescription(),
                        command.getAnalysisModel(),
                        command.getContributionBU(),
                        command.getStage(),
                        new TimeFrame(command.getFromDate(), command.getToDate()),
                        command.getContact()
                );

        useCase.create();
        return useCase.getId();
    }

    public void updateUseCase(UseCaseUpdateCommand command) {
        UseCase useCase = existing(command.getId());
        useCase.update(
                new CaseSubject(command.getSubject()),
                command.getValue(),
                command.getScenario(),
                command.getResult(),
                command.getDataSource(),
                command.getDataTypeDescription(),
                command.getAnalysisModel(),
                command.getContributionBU(),
                command.getStage(),
                new TimeFrame(command.getFromDate(), command.getToDate()),
                command.getContact());
    }

    public void deleteUseCase(String id) {
        UseCase useCase = existing(id);
        useCase.delete();
    }

    private UseCase existing(String id) {
        UseCase useCase = useCaseRepository.getOne(id);
        System.out.println(useCase);
        AssertionConcern.assertArgumentNotNull(useCase, "use case does not exist");
        return useCase;
    }


    public void upload(HttpServletRequest request, HttpServletResponse response)throws Exception{
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
        MultipartFile multipartFile = multipartHttpServletRequest.getFile("file");

        if(multipartFile == null){

        }else {
            //重定义文件名
            String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
            Random random = new Random();
            for(int i = 0; i < 3; i++){
                newFileName = newFileName + random.nextInt(10);
            }

            //获得原始文件名
            String oriFileName = multipartFile.getOriginalFilename();
            //获得后缀名
            String suffix = oriFileName.substring(oriFileName.lastIndexOf(".")).toLowerCase();

            //图片的链接路径
//            String urlPath = PathUtil.getHttpPathUrl(PathUtil.IMAGE_PATH, request) + newFileName + suffix;
            //图片的名称
            String newImgName = newFileName + suffix;

//            String realPath = request.getSession().getServletContext().getRealPath("/");
            Date date = new Date();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            String year = sdf.format(date);

            SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
            String month = sdfMonth.format(date);

            SimpleDateFormat sdfDate = new SimpleDateFormat("dd");
            String dateString = sdfDate.format(date);

            String realPathFolder = pathUtil() + File.separator + year+ File.separator + month+ File.separator + dateString ;

            File file = new File(realPathFolder, newImgName);

            File fileParent = file.getParentFile();
            if(!fileParent.exists()){
                 fileParent.mkdirs();
            }

            //上传图片
            multipartFile.transferTo(file);

            response.getOutputStream().print("success");

        }
    }

    private String pathUtil(){
        return "C:\\Users\\hongying.fu\\Desktop";
    }

}
