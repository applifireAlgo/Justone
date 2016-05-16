package com.app.server.service.justone.justone;
import com.app.server.businessservice.justone.justone.MyNewEx;
import com.athena.server.email.bean.EmailBean;
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
@RequestMapping("/MyNewExWS")
public class MyNewExWS {

    @Autowired
    private MyNewEx mynewex;

    @RequestMapping(value = "/myNewEx", consumes = "application/json", method = RequestMethod.POST)
    public HttpEntity<ResponseBean> myNewEx(@RequestBody EmailBean myNewEx) throws Exception {
        com.athena.server.pluggable.utils.bean.ResponseBean responseBean = new com.athena.server.pluggable.utils.bean.ResponseBean();
        org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.CREATED;
        mynewex.myNewEx(myNewEx);
        responseBean.add("success", true);
        responseBean.add("message", "Successfully executed ");
        return new org.springframework.http.ResponseEntity<com.athena.server.pluggable.utils.bean.ResponseBean>(responseBean, httpStatus);
    }
}
