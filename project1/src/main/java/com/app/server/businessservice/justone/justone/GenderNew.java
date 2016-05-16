package com.app.server.businessservice.justone.justone;
import com.app.server.repository.organization.contactmanagement.GenderRepository;
import com.app.shared.organization.contactmanagement.Gender;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenderNew {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    public void genderNew() throws Exception {
        java.util.List<com.app.shared.organization.contactmanagement.Gender> genderList = genderRepository.findAll();
        for (com.app.shared.organization.contactmanagement.Gender genderListElement : genderList) {
        }
    }
}
