package IR.org.core.service;


import IR.org.core.entity.OssProperties;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.InputStream;

public interface FileService extends IService<OssProperties> {
    public String fileupService(InputStream fileInputStream, String filename,String module);
}
