package com.sixmac.service.abs;

import com.sixmac.core.Configue;
import com.sixmac.entity.vo.FileBo;
import com.sixmac.utils.FileUtil;
import com.sixmac.utils.UploadUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wangbin on 2014/12/6.
 */
public abstract class AbstractUploadService {




    public String getDesFileName(String origFileName){
        String ext =  FileUtil.getFileExt(origFileName);
        String fileName = String.valueOf(System.currentTimeMillis());
        String uploadPath = UploadUtil.getImagesUpladPath();
        String desFilePathName = uploadPath+fileName+ext;
        return desFilePathName;
    }

    public FileBo save(MultipartFile file) throws IOException{
        FileBo fileBo =  save(file,String.valueOf(System.currentTimeMillis()));
        return fileBo;
    }


    public FileBo save(MultipartFile file,String fileName) throws IOException{

        FileBo fileBo = new FileBo();
        InputStream inputStream = file.getInputStream();
        String origFileName = file.getOriginalFilename(); //ԭʼ����,��aa.jpg
        String ext =  FileUtil.getFileExt(origFileName); //��׺����jpg
        String uploadPath = UploadUtil.getImagesUpladPath(); //��������Ŀ¼ image/2014/7/21/
        String foreName = uploadPath+fileName;   //�ļ����� image/2014/7/21/221144144554
        String desFilePathName = uploadPath+fileName+ext;//�����ļ����� image/2014/7/21/221144144554.jpg
        File theFile = new File(Configue.getUploadPath(),desFilePathName); //���ɵ��ļ�����
        fileBo.setName(fileName);
        fileBo.setForeName(foreName);
        fileBo.setExt(ext);
        fileBo.setPath(desFilePathName);
        fileBo.setFile(theFile);
        FileUtils.copyInputStreamToFile(inputStream,theFile);

        return fileBo;
    }




}
