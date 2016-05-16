package com.app.shared.testproj1boundedcontext.proj;
import com.athena.server.pluggable.interfaces.EntityValidatorInterface;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import java.lang.Override;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Testpropartial implements EntityValidatorInterface {

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> dtoValidator;

    @Min(1)
    @Max(65535)
    private String itemname;

    @Min(1)
    @Max(65535)
    private String itemicon;

    @Transient
    @JsonIgnore
    private boolean isDtoValidated = false;

    @JsonIgnore
    @Override
    public boolean isEntityValidated() {
        return isDtoValidated;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String _itemname) {
        this.itemname = _itemname;
    }

    public String getItemicon() {
        return itemicon;
    }

    public void setItemicon(String _itemicon) {
        this.itemicon = _itemicon;
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
