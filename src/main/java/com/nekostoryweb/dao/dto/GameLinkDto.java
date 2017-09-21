package com.nekostoryweb.dao.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Created by yujingyang on 2017/9/20.
 */
@Data
public class GameLinkDto {
    String iosDownloadUrl;
    String androidDownloadUrl;
    String pcDownloadUrl;
    String mainPageVideoUrl;
    String QRCodeUrl;
}
