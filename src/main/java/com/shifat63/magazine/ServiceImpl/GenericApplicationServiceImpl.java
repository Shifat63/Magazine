package com.shifat63.magazine.ServiceImpl;

import com.shifat63.magazine.Service.GenericApplicationService;
import org.springframework.stereotype.Service;
import org.apache.commons.io.FileUtils;
import java.io.File;

@Service
public class GenericApplicationServiceImpl implements GenericApplicationService {
    @Override
    public String GetStorageLocation() {
        return "C:/Users/ehaque/MagazineFiles/";
    }

    @Override
    public boolean DeleteFile(String filePath) {
        File file = new File(filePath);
        if(file.exists())
        {
            if(file.isDirectory())
            {
                try
                {
                    FileUtils.deleteDirectory(file);
                }
                catch (Exception e)
                {

                }
            }
            else
            {
                return file.delete();
            }
        }
        return true;
    }
}
