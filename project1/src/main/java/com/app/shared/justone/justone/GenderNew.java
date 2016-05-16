package com.app.shared.justone.justone;
import com.athena.server.pluggable.interfaces.EntityValidatorInterface;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Transient;
import com.app.shared.organization.contactmanagement.Gender;
import java.util.ArrayList;
import java.lang.Override;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GenderNew implements EntityValidatorInterface {

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> dtoValidator;

    private ArrayList<Gender> genList;

    @Transient
    @JsonIgnore
    private boolean isDtoValidated = false;

    @JsonIgnore
    @Override
    public boolean isEntityValidated() {
        return isDtoValidated;
    }

    public ArrayList<Gender> getGenList() {
        return genList;
    }

    public void setGenList(ArrayList<Gender> _genList) {
        this.genList = _genList;
    }

    public GenderNew addGenList(Gender _genList) {
        if (this.genList == null) {
            this.genList = new java.util.ArrayList<com.app.shared.organization.contactmanagement.Gender>();
        }
        if (_genList != null) {
            this.genList.add(_genList);
        }
        return this;
    }

    public GenderNew addAllGenList(List<Gender> _genList) {
        if (this.genList == null) {
            this.genList = new java.util.ArrayList<com.app.shared.organization.contactmanagement.Gender>();
        }
        if (_genList != null) {
            this.genList.addAll(_genList);
        }
        return this;
    }

    public GenderNew removeGenList(Gender _genList) {
        if (this.genList != null) {
            this.genList.remove(_genList);
        }
        return this;
    }

    public Integer sizeOfGenList() {
        if (this.genList != null) {
            return this.genList.size();
        }
        return 0;
    }

    @Override
    public void setEntityValidator(EntityValidatorHelper<Object> _validateFactory) {
        this.dtoValidator = _validateFactory;
    }

    @JsonIgnore
    @Override
    public boolean isValid() throws SecurityException {
        boolean isValid = false;
        if (this.dtoValidator != null) {
            isValid = this.dtoValidator.validateEntity(this);
            this.isDtoValidated = true;
        } else {
            throw new SecurityException();
        }
        return isValid;
    }
}
