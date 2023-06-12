package IR.org.core.controller;


import IR.org.common.utils.R;
import IR.org.core.service.DishonestyInfoService;
import IR.org.core.service.PolicyInfoService;
import IR.org.core.vo.PolicInfoVo;
import IR.org.core.vo.ReimbursementVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shuangshuang.li
 * @since 2023-04-14
 */
@RestController
@Api(tags = "保单流程")
@RequestMapping("/policyInfo")
public class PolicyInfoController {

    @Autowired
    private PolicyInfoService policyInfoService;

    @Autowired
    private DishonestyInfoService dishonestyInfoService;




    @PutMapping("/register")
    @ApiOperation("保单登记")
    public R setRegisterInfo(@RequestBody PolicInfoVo infoVo){
        return policyInfoService.setRegisterInfo(infoVo);
    }

    @GetMapping("/getProcessingInfo")
    @ApiOperation("获取待处理保单")
    public R getProcessingInfo(){
        return policyInfoService.getProcessingInfo();
    }

    @GetMapping("/getCompletedInfo")
    @ApiOperation("获取已处理保单")
    public R getCompletedInfo(){
        return policyInfoService.getCompletedInfo();
    }

    @GetMapping("/getEndingInfo")
    @ApiOperation("获取已完成保单")
    public R getEngingInfo(){
        return policyInfoService.getEngingInfo();
    }

    @GetMapping("/getHistorical")
    @ApiOperation("获取历史保单信息")
    public R getHistorical(@RequestParam("insurantId") Long id){
        String date = LocalDate.now().toString();
        return policyInfoService.getHistorical(id,date);
    }

    @GetMapping("/getHistoricalSelf")
    @ApiOperation("获取本公司历史保单信息")
    public R getHistoricalSelf(@RequestParam("insurantId") Long id){
        String date = LocalDate.now().toString();
        return policyInfoService.getHistoricalSelf(id,date);
    }

    @PostMapping("/setEvaluationResults")
    @ApiOperation("设置评估状态，0.未通过 1.通过")
    public R setEvaluationResults(@RequestParam("id") Long id,@RequestParam("status") Integer status,@RequestParam("reason")String reason){
        return policyInfoService.setEvaluationResults(id,status,reason);
    }

    @GetMapping("/getAmount")
    @ApiOperation("获取报销金额")
    public R getAmount(@RequestParam("id") Long id){
        return policyInfoService.getAmount(id);
    }

    @PutMapping("/setReimbursement")
    @ApiOperation("创建报销单")
    public R setReimbursement(@RequestBody ReimbursementVo info){
        return policyInfoService.setReimbursement(info);
    }

    @GetMapping("/getOverViewInfo")
    @ApiOperation("获取总览信息")
    public R getOverViewInfo(@RequestParam("id") Long id){
        return policyInfoService.getOverViewInfo(id);
    }

    @GetMapping("/getPolicyInfo/{id}")
    @ApiOperation("获取登记信息")
    public R getPolicyInfo(@PathVariable("id") Long id){
        return policyInfoService.getPolicyInfo(id);
    }

    @GetMapping("/getDishonestyInfo/{id}")
    @ApiOperation("获取失信信息")
    public R getDishonestyInfo(@PathVariable("id") Long id){
        return dishonestyInfoService.getDishonestyInfo(id);
    }

}

