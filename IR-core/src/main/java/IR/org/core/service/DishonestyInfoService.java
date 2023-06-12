package IR.org.core.service;

import IR.org.common.utils.R;
import IR.org.core.entity.DishonestyInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shuangshuang.li
 * @since 2023-04-14
 */
public interface DishonestyInfoService extends IService<DishonestyInfo> {

    R getDishonestyInfo(Long id);
}
