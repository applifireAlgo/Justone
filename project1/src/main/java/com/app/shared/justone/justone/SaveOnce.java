package com.app.shared.justone.justone;
import com.athena.server.pluggable.interfaces.EntityValidatorInterface;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.lang.Override;
import java.util.List;

public class SaveOnce implements EntityValidatorInterface {

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> dtoValidator;

    private ArrayList<EntityA> gender;

    @Transient
    @JsonIgnore
    private boolean isDtoValidated = false;

    @JsonIgnore
    @Override
    public boolean isEntityValidated() {
        return isDtoValidated;
    }

    public ArrayList<EntityA> getGender() {
        return gender;
    }

    public void setGender(ArrayList<EntityA> _gender) {
        this.gender = _gender;
    }

    public SaveOnce addGender(EntityA _gender) {
        if (this.gender == null) {
            this.gender = new java.util.ArrayList<com.app.shared.justone.justone.EntityA>();
        }
        if (_gender != null) {
            this.gender.add(_gender);
        }
        return this;
    }

    public SaveOnce addAllGender(List<EntityA> _gender) {
        if (this.gender == null) {
            this.gender = new java.util.ArrayList<com.app.shared.justone.justone.EntityA>();
        }
        if (_gender != null) {
            this.gender.addAll(_gender);
        }
        return this;
    }

    public SaveOnce removeGender(EntityA _gender) {
        if (this.gender != null) {
            this.gender.remove(_gender);
        }
        return this;
    }

    public Integer sizeOfGender() {
        if (this.gender != null) {
            return this.gender.size();
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
