package cn.xudazhu.api.controller;

import cn.xudazhu.api.bean.Danma;
import cn.xudazhu.api.service.DanmaService;
import cn.xudazhu.api.utils.FormatDanma;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"v3" , "V3"})
public class DanmaController {

    private DanmaService danmaService;

    @Autowired
    public void setDanmaService(DanmaService danmaService) {
        this.danmaService = danmaService;
    }

    /**
     * 上传弹幕
     * @param danma 接收前台来的弹幕信息(自动封装成实例)
     * @return 返回成功或者失败
     */
    @PostMapping
    public String post(@RequestBody Danma danma) {
        if ( danma != null ) {
            if ( danmaService.add(danma) ) {
                JSONObject jsonObject  = new JSONObject();
                jsonObject.put("code", 0);
                jsonObject.put("data" , danma);
                return jsonObject.toString();
            } else {
                return "error";
            }
        } else {
            return "error";
        }

    }

    /**
     * 获取弹幕
     * @param id
     * @return
     */
    @GetMapping
    public String get( @RequestParam String id )  {
        List<Object[]> format_danma = FormatDanma.format_danma(danmaService.select(id));
        JSONObject jsonObject  = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("data" , format_danma );
        return jsonObject.toString();
    }
    
}
