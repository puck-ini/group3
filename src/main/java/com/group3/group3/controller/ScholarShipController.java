package com.group3.group3.controller;

import com.group3.group3.entity.Result;
import com.group3.group3.entity.ScholarShip;
import com.group3.group3.service.impl.ScholarShipServiceImpl;
import com.group3.group3.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/scholarship")
public class ScholarShipController {

    @Autowired
    private ScholarShipServiceImpl scholarShipService;

    @PostMapping("/insert")
    public Result insert(HttpServletRequest request,
                         @RequestParam(value = "name",required = false) String name,
                         @RequestParam(value = "type",required = false) String type,
                         @RequestParam(value = "ssMoney",required = false) Double ssMoney){
        ScholarShip scholarShip = new ScholarShip();
        scholarShip.setName(name);
        scholarShip.setType(type);
        scholarShip.setSsMoney(ssMoney);
        scholarShipService.insertScholarShip(scholarShip);
        return ResultUtil.success(scholarShip);
    }

    @PostMapping("/find")
    public Result find(HttpServletRequest request,
                       @RequestParam(value = "name",required = false) String name,
                       @RequestParam(value = "type",required = false) String type){
        List<ScholarShip> scholarShips = scholarShipService.getScholarShip(type,name);
        return ResultUtil.success(0,"success",scholarShips);
    }

    @GetMapping("/delete")
    public Result delete(HttpServletRequest request,
                         @RequestParam(value = "ssid",required = false) Integer ssid){
        scholarShipService.deleteScholarShip(ssid);

        return ResultUtil.success(null);
    }

    @PostMapping("/update")
    public Result update(HttpServletRequest request,
                         @RequestParam(value = "name",required = false) String name,
                         @RequestParam(value = "type",required = false) String type,
                         @RequestParam(value = "ssMoney",required = false) Double ssMoney){
        List<ScholarShip> scholarShips = scholarShipService.getScholarShip(type,name);
        ScholarShip scholarShip = scholarShips.get(0);
        if (name != null){
            scholarShip.setName(name);
        }
        if (type != null) {
            scholarShip.setType(type);
        }
        if (ssMoney != null) {
            scholarShip.setSsMoney(ssMoney);
        }
        scholarShipService.updateScholarShip(scholarShip);
        return ResultUtil.success(scholarShip);
    }

    @GetMapping("/findAll")
    public Result findAll(HttpServletRequest request) {
        List<ScholarShip> scholarShips = scholarShipService.getAll();
        return ResultUtil.success(scholarShips);
    }
}
