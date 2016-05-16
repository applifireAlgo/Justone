package com.app.shared.testproj1boundedcontext.proj;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.interfaces.CommonEntityInterface;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import java.sql.Timestamp;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import com.app.shared.EntityAudit;
import javax.persistence.Embedded;
import com.app.shared.SystemInfo;
import java.lang.Override;
import javax.persistence.NamedQueries;

@Table(name = "ast_Item_M")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "46", comments = "Item", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "Item.findById", query = "select e from Item e where e.systemInfo.activeStatus=1 and e.itemid =:itemid") })
public class Item implements Serializable, CommonEntityInterface, Comparator<Item> {

    @Column(name = "itemname")
    @JsonProperty("itemname")
    @NotNull
    @Size(min = 1, max = 255)
    private String itemname;

    @Column(name = "price")
    @JsonProperty("price")
    @NotNull
    @Min(-2147483648L)
    @Max(2147483647)
    private Integer price;

    @Column(name = "itemicon")
    @JsonProperty("itemicon")
    @NotNull
    private String itemicon;

    @Column(name = "quantity")
    @JsonProperty("quantity")
    @NotNull
    @Min(-2147483648L)
    @Max(2147483647)
    private Integer quantity;

    @Column(name = "itemsize")
    @JsonProperty("itemsize")
    @NotNull
    @Size(min = 1, max = 4)
    private String itemsize;

    @Column(name = "itemorderdate")
    @JsonProperty("itemorderdate")
    @NotNull
    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp itemorderdate;

    @Column(name = "homedelivery")
    @JsonProperty("homedelivery")
    @NotNull
    private Boolean homedelivery;

    @Column(name = "total")
    @JsonProperty("total")
    @NotNull
    @Min(-2147483648L)
    @Max(2147483647)
    private Integer total;

    @Transient
    private Integer primaryKey;

    @Id
    @GeneratedValue(generator = "ast_item_m_seq")
    @SequenceGenerator(name = "ast_item_m_seq", sequenceName = "AST_ITEM_M_seq", allocationSize = 1)
    @Column(name = "itemid")
    @JsonProperty("itemid")
    private Integer itemid;

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> entityValidator;

    @Version
    @Column(name = "versionId")
    @JsonProperty("versionId")
    private int versionId;

    @Embedded
    @JsonIgnore
    private EntityAudit entityAudit = new EntityAudit();

    @Embedded
    private SystemInfo systemInfo = new SystemInfo();

    @Transient
    private String primaryDisplay;

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String _itemname) {
        if (_itemname != null) {
            this.itemname = _itemname;
        }
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer _price) {
        if (_price != null) {
            this.price = _price;
        }
    }

    public String getItemicon() {
        return itemicon;
    }

    public void setItemicon(String _itemicon) {
        if (_itemicon != null) {
            this.itemicon = _itemicon;
        }
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer _quantity) {
        if (_quantity != null) {
            this.quantity = _quantity;
        }
    }

    public String getItemsize() {
        return itemsize;
    }

    public void setItemsize(String _itemsize) {
        if (_itemsize != null) {
            this.itemsize = _itemsize;
        }
    }

    public Timestamp getItemorderdate() {
        return itemorderdate;
    }

    public void setItemorderdate(Timestamp _itemorderdate) {
        if (_itemorderdate != null) {
            this.itemorderdate = _itemorderdate;
        }
    }

    public Boolean getHomedelivery() {
        return homedelivery;
    }

    public void setHomedelivery(Boolean _homedelivery) {
        if (_homedelivery != null) {
            this.homedelivery = _homedelivery;
        }
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer _total) {
        if (_total != null) {
            this.total = _total;
        }
    }

    public Integer getPrimaryKey() {
        return itemid;
    }

    public void setPrimaryKey(Integer _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public Integer _getPrimarykey() {
        return itemid;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer _itemid) {
        this.itemid = _itemid;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int _versionId) {
        this.versionId = _versionId;
    }

    public void setPrimaryDisplay(String _primaryDisplay) {
        this.primaryDisplay = _primaryDisplay;
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo _systemInfo) {
        this.systemInfo = _systemInfo;
    }

    @JsonIgnore
    public boolean isHardDelete() {
        if (this.systemInfo == null) {
            this.systemInfo = new SystemInfo();
        }
        if (this.systemInfo.getActiveStatus() == -1) {
            return true;
        } else {
            return false;
        }
    }

    @JsonIgnore
    @Override
    public boolean isValid() throws SecurityException {
        boolean isValid = false;
        if (this.entityValidator != null) {
            isValid = this.entityValidator.validateEntity(this);
            this.systemInfo.setEntityValidated(true);
        } else {
            throw new java.lang.SecurityException();
        }
        return isValid;
    }

    @Override
    public void setEntityValidator(EntityValidatorHelper<Object> _validateFactory) {
        this.entityValidator = _validateFactory;
    }

    @Override
    public void setEntityAudit(int customerId, String userId, RECORD_TYPE recordType) {
        System.out.println("Setting logged in user info for " + recordType);
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (recordType == RECORD_TYPE.ADD) {
            this.entityAudit.setCreatedBy(userId);
            this.entityAudit.setUpdatedBy(userId);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
        setSystemInformation(recordType);
    }

    @Override
    public void setEntityAudit(int customerId, String userId) {
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (getPrimaryKey() == null) {
            this.entityAudit.setCreatedBy(userId);
            this.entityAudit.setUpdatedBy(userId);
            this.systemInfo.setActiveStatus(1);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
    }

    @JsonIgnore
    public String getLoggedInUserInfo() {
        String auditInfo = "";
        if (this.entityAudit != null) {
            auditInfo = entityAudit.toString();
        }
        return auditInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemInformation(RECORD_TYPE recordType) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        if (recordType == RECORD_TYPE.DELETE) {
            this.systemInfo.setActiveStatus(0);
        } else {
            this.systemInfo.setActiveStatus(1);
        }
    }

    @JsonIgnore
    public void setSystemInformation(Integer activeStatus) {
        this.systemInfo.setActiveStatus(activeStatus);
    }

    @JsonIgnore
    public String getSystemInformation() {
        String systemInfo = "";
        if (this.systemInfo != null) {
            systemInfo = systemInfo.toString();
        }
        return systemInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemTxnCode(Integer transactionAccessCode) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        this.systemInfo.setTxnAccessCode(transactionAccessCode);
    }

    @Override
    public int compare(Item object1, Item object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (itemid == null) {
            return super.hashCode();
        } else {
            return itemid;
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.testproj1boundedcontext.proj.Item other = (com.app.shared.testproj1boundedcontext.proj.Item) obj;
            if (itemid == null) {
                return false;
            } else if (!itemid.equals(other.itemid)) {
                return false;
            }
        } catch (java.lang.Exception ignore) {
            return false;
        }
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEntityValidated() {
        return this.systemInfo.isEntityValidated();
    }

    public Integer caltotal() {
        return price * quantity;
    }
}
