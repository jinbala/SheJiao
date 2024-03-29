/**
 * -----------------------------------
 * 林风社交论坛开源版本请务必保留此注释头信息
 * 开源地址: https://gitee.com/virus010101/linfeng-community
 * 可正常分享和学习源码，不得用于非法牟利！
 * 商业版购买联系技术客服 QQ: 3582996245
 * Copyright (c) 2021-2023 linfeng all rights reserved.
 * 演示站点:https://www.linfeng.tech
 * 版权所有，侵权必究！
 * -----------------------------------
 */
package io.linfeng.modules.app.controller;

import io.linfeng.common.utils.R;
import io.linfeng.modules.admin.entity.SystemEntity;
import io.linfeng.modules.admin.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linfeng
 * @date 2022/8/17 12:07
 */

@RestController
@RequestMapping("app/system")
public class AppSystemConfigController {

    @Autowired
    private SystemService systemService;

    @GetMapping("/miniConfig")
    public R miniConfig(){
        SystemEntity system = systemService.lambdaQuery()
                .eq(SystemEntity::getConfig, "miniapp")
                .one();
        return R.ok().put("logo",system.getIntro());
    }

}
