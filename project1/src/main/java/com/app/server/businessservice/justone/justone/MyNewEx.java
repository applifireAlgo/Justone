package com.app.server.businessservice.justone.justone;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.athena.server.email.bean.EmailBean;

@Component
public class MyNewEx {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    public void myNewEx(EmailBean myNewEx) throws com.app.customexception.MyNewEx, Exception {
        if (myNewEx != null) {
            throw new com.app.customexception.MyNewEx();
        }
    }
}
