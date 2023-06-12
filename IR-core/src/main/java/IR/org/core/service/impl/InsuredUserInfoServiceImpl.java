package IR.org.core.service.impl;

import IR.org.core.dao.InsuredUserInfoMapper;
import IR.org.core.entity.InsuredUserInfo;
import IR.org.core.service.InsuredUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shuangshuang.li
 * @since 2023-04-14
 */
@Service
public class InsuredUserInfoServiceImpl extends ServiceImpl<InsuredUserInfoMapper, InsuredUserInfo> implements InsuredUserInfoService {

    @Autowired
    private InsuredUserInfoMapper insuredUserInfoMapper;

    @Override
    public InsuredUserInfo getInfoByPhone(String s) {
        return insuredUserInfoMapper.getInfoByPhone(s);
    }
}
