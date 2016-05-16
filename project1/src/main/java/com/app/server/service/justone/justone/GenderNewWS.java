package com.app.server.service.justone.justone;
import com.app.server.businessservice.justone.justone.GenderNew;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequestMapping("/GenderNewWS")
public class GenderNewWS {

    @Autowired
    private GenderNew gendernew;

    @RequestMapping(value = "/genderNew", consumes = "application/json", method = RequestMethod.POST)
    public HttpEntity<ResponseBean> genderNew() throws Exception {
        com.athena.server.pluggable.utils.bean.ResponseBean responseBean = new com.athena.server.pluggable.utils.bean.ResponseBean();
        org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.CREATED;
        gendernew.genderNew();
        responseBean.add("success", true);
        responseBean.add("message", "Successfully executed ");
        return new org.springframework.http.ResponseEntity<com.athena.server.pluggable.utils.bean.ResponseBean>(responseBean, httpStatus);
    }
}
