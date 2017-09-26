package com.nekostoryweb.service.impl;

import com.nekostoryweb.dao.dto.BreadCrumbDto;
import com.nekostoryweb.dao.dto.MenuDto;
import com.nekostoryweb.dao.mapper.AccountMapper;
import com.nekostoryweb.dao.mapper.MenuMapper;
import com.nekostoryweb.dao.po.Account;
import com.nekostoryweb.dao.po.AccountExample;
import com.nekostoryweb.dao.po.Menu;
import com.nekostoryweb.dao.po.MenuExample;
import com.nekostoryweb.service.SystemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yujingyang on 2017/9/18.
 */
@Service
public class SystemServiceImpl implements SystemService {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    AccountMapper accountMapper;

    @Override
    public Map<String, Object> getMenu(String URI) {
        MenuExample menuExample = new MenuExample();
        List<Menu> menuList = menuMapper.selectByExample(menuExample);
        Map<Integer, MenuDto> menuMap = new HashMap<>();
        Map<String, Object> returnResult = new HashMap<>();
        for (Menu menu : menuList) {
            MenuDto tmpDto = new MenuDto();
            BeanUtils.copyProperties(menu, tmpDto);
            tmpDto.setChildren(new ArrayList<>());
            tmpDto.setActive(false);
            tmpDto.setOpen(false);
            menuMap.put(menu.getId(), tmpDto);

        }
        for (Menu menu : menuList) {
            //TODO 可能需要更改

            if (menu.getFatherId() != 0) {
                List<MenuDto> tmp = menuMap.get(menu.getFatherId()).getChildren();
                MenuDto dto = menuMap.get(menu.getId());
                tmp.add(dto);
            }

        }
        List<MenuDto> result = new ArrayList<>();
        menuMap.forEach((k, v) -> {
            if (v.getFatherId() == 0)
                result.add(v);
            if (URI.equals(v.getMenuUrl())) {
                BreadCrumbDto breadCrumbDto = new BreadCrumbDto();
                BreadCrumbDto current = breadCrumbDto;
                breadCrumbDto.setName(v.getMenuName());
                breadCrumbDto.setUrl(v.getMenuUrl());
                v.setIsOpen(true);
                v.setIsActive(true);
                for (MenuDto row = menuMap.get(v.getFatherId()); row != null; row = menuMap.get(row.getFatherId())) {
                    BreadCrumbDto childBreadCrumbDto = new BreadCrumbDto();
                    childBreadCrumbDto.setUrl(row.getMenuUrl());
                    childBreadCrumbDto.setName(row.getMenuName());
                    childBreadCrumbDto.setChild(current);
                    row.setActive(true);
                    row.setOpen(true);
                    current = childBreadCrumbDto;
                }
                returnResult.put("breadCrumb", current);
            }
        });
        returnResult.put("menuResult", result);
        return returnResult;
    }

    @Override
    public Integer login(String userName, String password){
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andAccountNameEqualTo(userName).andPasswordEqualTo(password);
        List<Account> result = accountMapper.selectByExample(accountExample);
        if(result.size() != 1)
            return -1;
        return 1;
    }
}
