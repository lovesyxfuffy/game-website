package com.nekostoryweb.service.front.impl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.nekostoryweb.dao.mapper.OrderInfoMapper;
import com.nekostoryweb.dao.po.OrderInfo;
import com.nekostoryweb.dao.po.OrderInfoExample;
import com.nekostoryweb.service.front.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by yujingyang on 2017/9/27.
 */
@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    OrderInfoMapper orderInfoMapper;

    private void sendSms(String telephone, String code) throws ClientException {

        //设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
//初始化ascClient需要的几个参数
        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
//替换成你的AK
        final String accessKeyId = "LTAI3l1v3iFwoEXE";//你的accessKeyId,参考本文档步骤2
        final String accessKeySecret = "oh1qqUc2NvMYBDrO6OV6yo2cnI8VsZ";//你的accessKeySecret，参考本文档步骤2
//初始化ascClient,暂时不支持多region
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
        request.setPhoneNumbers(telephone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("萌猫物语");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_90530007");
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        request.setTemplateParam("{\"code\":\"" + code + "\"}");
        //可选-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        //请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {

        }
    }

    @Override
    public String sendVerifyCode(String telephone) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <6;i++){
            stringBuilder.append(random.nextInt(10));
        }
        try {
            sendSms(telephone,stringBuilder.toString());
            return stringBuilder.toString();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return telephone;
    }

    @Override
    public int insertOrderInfo(String telephone, String phoneType){
        OrderInfoExample orderInfoExample = new OrderInfoExample();
        orderInfoExample.createCriteria().andTelephoneEqualTo(telephone);
        List<OrderInfo> result = orderInfoMapper.selectByExample(orderInfoExample);
        if(result.size() >0)
            return 2;
        else{
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setTelephone(telephone);
            orderInfo.setPhoneType(phoneType);
            orderInfo.setAddTime(new Date());
            orderInfoMapper.insert(orderInfo);
            return 1;
        }
    }
}
