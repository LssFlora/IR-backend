package IR.org.core.service.impl;

import IR.org.common.utils.R;
import IR.org.core.dao.DishonestyInfoMapper;
import IR.org.core.entity.DishonestyInfo;
import IR.org.core.service.DishonestyInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shuangshuang.li
 * @since 2023-04-14
 */
@Service
public class DishonestyInfoServiceImpl extends ServiceImpl<DishonestyInfoMapper, DishonestyInfo> implements DishonestyInfoService {

    @Autowired
    private DishonestyInfoMapper dishonestyInfoMapper;
    @Override
    public R getDishonestyInfo(Long id) {
        List<DishonestyInfo> infos = dishonestyInfoMapper.getDishonestyInfoByIdentityCard(id);
        return R.ok(200,"success").setData(infos);
    }
}
