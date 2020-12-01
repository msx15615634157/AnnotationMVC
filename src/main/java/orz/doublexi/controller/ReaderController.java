package orz.doublexi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import orz.doublexi.pojo.Device;
import orz.doublexi.pojo.Story;

import java.util.HashMap;
import java.util.UUID;

/**
     * @author ：mengshx
     * @date ：Created in 2020/11/29 10:29
     * @description：阅读器
     */
    @Controller
    public class ReaderController {
      private HashMap<String, Device> takens = new HashMap<>();
        @Autowired
        Story story;

    @RequestMapping(value="nextPage.do",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String nextPage(@RequestParam("page") int page,@RequestParam(value = "taken",required = false) String taken) {
        Device device=null;
        if (taken != null) {
            device = takens.get(taken);
            if (device != null) {
                device.setNowPage(page);
            }

        }

        return  story.readPage(page);
    }
    @RequestMapping(value="queryPage.do")
    @ResponseBody
    public Device queryPage(@RequestParam("taken") String take) {
        Device device;
        if ((device=takens.get(take)) != null) {
            return device;
        }
        device = new Device();
        device.setTaken(UUID.randomUUID().toString());
        device.setNowPage(1);
        takens.put(device.getTaken(), device);
        return device;
    }

}
