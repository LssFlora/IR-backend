package IR.org.core.dao;

import IR.org.core.entity.DishonestyInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DishonestyInfoMapper extends BaseMapper<DishonestyInfo> {


    List<DishonestyInfo> getDishonestyInfoByIdentityCard(@Param("id") Long id);
}
