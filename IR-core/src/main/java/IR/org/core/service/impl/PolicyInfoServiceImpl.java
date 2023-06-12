package IR.org.core.service.impl;

import IR.org.common.utils.R;
import IR.org.core.config.MyThreadLocal;
import IR.org.core.dao.*;
import IR.org.core.entity.AdminInfo;
import IR.org.core.entity.PolicyInfo;
import IR.org.core.entity.ReceiptInfo;
import IR.org.core.entity.ReimbursementInfo;
import IR.org.core.service.FileService;
import IR.org.core.service.PolicyInfoService;
import IR.org.core.vo.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shuangshuang.li
 * @since 2023-04-14
 */
@Service
public class PolicyInfoServiceImpl extends ServiceImpl<PolicyInfoMapper, PolicyInfo> implements PolicyInfoService {

    private String FILE_NAME = "receipt:";
    private static final String COMPANY_NAME = "平安保险公司";
    private static final Double CUT = 0.10;

    private static final Map<Integer,Double> map = new HashMap<>();

    static {
        map.put(1,0.75);
        map.put(2,0.75);
        map.put(3,0.70);
        map.put(4,0.80);
        map.put(5,1.00);
        map.put(6,0.60);
        map.put(7,0.80);
    }

    @Autowired
    private FileService fileService;
    @Autowired
    private MyThreadLocal threadLocal;

    @Autowired
    private AdminInfoMapper adminInfoMapper;
    @Autowired
    private ReceiptInfoMapper receiptInfoMapper;

    @Autowired
    private ReimbursementInfoMapper reimbursementInfoMapper;

    @Autowired
    private PolicyInfoMapper policyInfoMapper;


    @Override
    @Transactional
    public R setRegisterInfo(PolicInfoVo infoVo) {
        AdminInfo adminInfo = threadLocal.get();
        String[] str = adminInfo.getAuthority().split(",");
        for (String s:str){
            if (s.equals("1"))
                break;
            else
                return R.error(403,"权限不足！");
        }
        FILE_NAME+=infoVo.getInsurantId();
        String link = "";
        String receipt_id = "";
        int index = 0;
        ReceiptInfoVo[] infoVoList = infoVo.getReceiptInfoVoList();
//        MultipartFile[] files = infoVo.getFile();
        for (ReceiptInfoVo receiptInfoVo : infoVoList){
            MultipartFile file = null;
//            try {
//                if (files.length>=index)
//                     file = files[index++];
//                if (file!=null)
//                    link = fileService.fileupService(file.getInputStream(), file.getOriginalFilename(), FILE_NAME);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
            ReceiptInfo receiptInfo = new ReceiptInfo();
            receiptInfo.setReceiptFile(link);
            receiptInfo.setReceiptMoney(receiptInfoVo.getReceiptMoney());
            receiptInfo.setReceiptType(receiptInfoVo.getReceiptType());
            receiptInfoMapper.setReceiptInfo(receiptInfo);
            if (receipt_id.length()>0){
                receipt_id+=",";
            }
            receipt_id+= receiptInfo.getId();
        }
        PolicyInfo policInfo = new PolicyInfo();
        policInfo.setInsurantId(infoVo.getInsurantId());
        policInfo.setPolicyNumber("BD"+UUID.randomUUID().toString().replace("-","").substring(0,18));
        policInfo.setHospitalName(infoVo.getHospitalName());
        policInfo.setDesignatedHospitalStatus(infoVo.getDesignatedHospitalStatus());
        policInfo.setHospitalizationStatus(infoVo.getHospitalizationStatus());
//        Date date = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");String = dateFormat.format(date);
        policInfo.setDeclarationTime(new Date());
        policInfo.setEventDescription(infoVo.getEventDescription());
        policInfo.setReceiptId(receipt_id);
        if (infoVo.getStatus()==0)
            //保存
            policInfo.setPolicyStatus(1);
        else {
            //本流程处理完，到下一流程
            policInfo.setPolicyStatus(2);
        }
        policyInfoMapper.setRegisterInfo(policInfo);
        if (policInfo.getId()==0)
            return R.error(400,"登记失败！");
        adminInfoMapper.addProcessedPolicyId(adminInfo.getId(),String.valueOf(policInfo.getId()));
        return R.ok(200,"登记成功！");
    }


    @Override
    public R getProcessingInfo() {
        AdminInfo adminInfo = threadLocal.get();
        String str = adminInfo.getAuthority();
        List<viewInfoVo> policyInfo = policyInfoMapper.getProcessingInfo(str);
        return R.ok(200,"success！").setData(policyInfo);
    }

    @Override
    public R getCompletedInfo() {
        AdminInfo adminInfo = adminInfoMapper.selectById(threadLocal.get().getId());
        String str = adminInfo.getProcessedPolicyId();
        if(str!=null&&str.length()>0) {
            List<viewInfoVo> completedInfo = policyInfoMapper.getCompletedInfo(str);
            return R.ok(200,"success!").setData(completedInfo);
        }
        return R.ok(200,"success!");
    }

    @Override
    public R getEngingInfo() {
        List<viewInfoVo> endingInfo = policyInfoMapper.getEngingInfo();
        return R.ok(200,"success!").setData(endingInfo);
    }

    @Override
    public R getOverViewInfo(Long id) {
        OverviewVo info = policyInfoMapper.getOverViewInfo(id);
        if (info==null)
            info = policyInfoMapper.getOverViewInfo1(id);
        ReceiptInfoVo receiptInfo= policyInfoMapper.getReceiptInfo(id);
        info.setReceiptInfo(receiptInfo);
        return R.ok(200,"success!").setData(info);
    }

    @Override
    @Transactional
    public R setReimbursement(ReimbursementVo info) {
        AdminInfo adminInfo = threadLocal.get();
        String[] str = adminInfo.getAuthority().split(",");
        for (String s:str){
            if (s.equals("3"))
                break;
            else
                return R.error(403,"权限不足！");
        }
        ReimbursementInfo reimbursement = new ReimbursementInfo();
        reimbursement.setInsurantId(info.getInsurantId());
        reimbursement.setReimbursementNumber("RE"+UUID.randomUUID().toString().replace("-","").substring(0,18));
        reimbursement.setPayeeCity(info.getCity());
        reimbursement.setPayeeSex(info.getSex());
        reimbursement.setReimbursementAmount(info.getReimbursementAmount());
        reimbursement.setReimbursementCompany(COMPANY_NAME);
        reimbursement.setPayeeName(info.getPayeeName());
        reimbursement.setCollectionAccount(info.getCollectionAccount());
        reimbursement.setPayeePhone(info.getPhone());
        reimbursement.setPaymentMethod(info.getPaymentMethod());
        reimbursement.setReimbursementStatus(1);
        reimbursementInfoMapper.setReimbursementInfo(reimbursement);
        policyInfoMapper.setReimbursementId(reimbursement.getId(),info.getPolicyId());
        //设置用户已处理保单id
        adminInfoMapper.addProcessedPolicyId(adminInfo.getId(),info.getPolicyId().toString());
        return R.ok(200,"success!");
    }

    @Override
    public R getAmount(Long id) {
        BigDecimal amount =  policyInfoMapper.getAmount(id);
        int type = policyInfoMapper.getInsureType(id);
        int count = policyInfoMapper.countPolicyInfo(id);
        double rate = map.get(type);
        amount.multiply(new BigDecimal(rate-count*CUT));
        return R.ok(200,"success!").setData(amount);
    }

    @Override
    public R getPolicyInfo(Long id) {
        OverviewVo info = policyInfoMapper.getOverViewInfo1(id);
        ReceiptInfoVo receiptInfo= policyInfoMapper.getReceiptInfo(id);
        info.setReceiptInfo(receiptInfo);
        return R.ok(200,"success!").setData(info);
    }

    @Override
    @Transactional
    public R setEvaluationResults(Long id, Integer status,String reason) {
        AdminInfo adminInfo = threadLocal.get();
        String[] str = adminInfo.getAuthority().split(",");
        for (String s:str){
            if (s.equals("2"))
                break;
            else
                return R.error(403,"权限不足！");
        }
        int state = 3;
        if (status==0)
            state = 5;
        else {
            reason = "";
        }
        int row = policyInfoMapper.setEvaluationResults(id, status, state, reason);
        if (row>0){
            //设置用户已处理保单id
            adminInfoMapper.addProcessedPolicyId(adminInfo.getId(),id.toString());
            return R.ok(200,"success!");
        }
        return R.error(400,"error!");

    }

    @Override
    public R getHistoricalSelf(Long id, String date) {
        List<HistoricalSelfVo> historical = policyInfoMapper.getHistoricalSelf(id,date,COMPANY_NAME);
        return R.ok(200,"success!").setData(historical);
    }

    @Override
    public R getHistorical(Long id, String date) {
        List<HistoricalVo> historical = policyInfoMapper.getHistorical(id,date,COMPANY_NAME);
        return R.ok(200,"success!").setData(historical);
    }

}
