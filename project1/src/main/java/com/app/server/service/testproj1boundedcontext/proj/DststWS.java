package com.app.server.service.testproj1boundedcontext.proj;
import com.app.server.businessservice.testproj1boundedcontext.proj.Dstst;
import com.app.shared.testproj1boundedcontext.proj.Item;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequestMapping("/DststWS")
public class DststWS {

    @Autowired
    private Dstst dstst;

    @RequestMapping(value = "/dms", consumes = "application/json", method = RequestMethod.POST)
    public HttpEntity<ResponseBean> dms(@RequestBody Item item) throws Exception {
        com.athena.server.pluggable.utils.bean.ResponseBean responseBean = new com.athena.server.pluggable.utils.bean.ResponseBean();
        org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.CREATED;
        dstst.dms(item);
        responseBean.add("success", true);
        responseBean.add("message", "Successfully executed ");
        return new org.springframework.http.ResponseEntity<com.athena.server.pluggable.utils.bean.ResponseBean>(responseBean, httpStatus);
    }
}
