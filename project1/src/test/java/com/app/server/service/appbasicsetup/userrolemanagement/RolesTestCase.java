package com.app.server.service.appbasicsetup.userrolemanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.userrolemanagement.RolesRepository;
import com.app.shared.appbasicsetup.userrolemanagement.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.app.server.service.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.springframework.mock.web.MockServletContext;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.server.pluggable.interfaces.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.appbasicsetup.userrolemanagement.RoleMenuBridge;
import com.app.shared.appbasicsetup.userrolemanagement.AppMenus;
import com.app.server.repository.appbasicsetup.userrolemanagement.AppMenusRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RolesTestCase extends EntityTestCriteria {

    @Autowired
    private RolesRepository<Roles> rolesRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        MockServletContext mockServletContext = new MockServletContext("file:src/main/webapp");
        try {
            String _path = mockServletContext.getRealPath("/WEB-INF/conf/");
            LogManagerFactory.createLogManager(_path, AppLoggerConstant.LOGGER_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo("customer", "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
        runtimeLogInfoHelper.setRequestHeaderBean(new RequestHeaderBean(new RuntimeLogUserInfoBean("AAAA", "AAAA", request.getRemoteHost(), 0, 0, 0), "", methodCallStack.getRequestId()));
    }

    private Roles createRoles(Boolean isSave) throws Exception {
        Roles roles = new Roles();
        roles.setRoleDescription("hph5c3FcoJUykraRda36wl4DfXMh42tVdBS1udDKLFAGBeQzUl");
        roles.setRoleHelp("hgGS6T2lZiKCkdKNbU0ZmAx5QPlAlZSdbnCctf5lEWKN52O114");
        roles.setRoleName("CNOvpWAnOddEiH1mSVzcOz7Yc2kBGYZKbluzc9dBoTkkRDHGKK");
        roles.setRoleIcon("fOApItcos0I3oEYPbJm6UJ2PNNRi7GFE4GmvuiBvt0hCqPdYYD");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setIsWrite(true);
        AppMenus appmenus = new AppMenus();
        appmenus.setUiType("w7j");
        appmenus.setMenuIcon("qUz2TLBtBN1r6dUM20rX9MEFtpy1oYifaazAwi8DqQpQL8cSKe");
        appmenus.setAppId("ZbF3zsWCbrOSFx0jI9Ut3AKYfzThYrPVV5CRwXNwoPG2aIHx2j");
        appmenus.setAutoSave(true);
        appmenus.setMenuAction("vh15uFniobZoLIN7ODCGQaG3aCeSIlbN9t92iVnk8RD07XCyPM");
        appmenus.setMenuHead(true);
        appmenus.setMenuTreeId("pfFuFTyh5rImJFITjifzmuZKvdxOJ8lJfxDnrXYVMTkk8JGmI7");
        appmenus.setMenuAccessRights(3);
        appmenus.setMenuCommands("rV5d3x9i6juFWFxtZqXlCdaXJvOdrJBWb9KNAZrU8QJQdZ2cx8");
        appmenus.setAppType(2);
        appmenus.setMenuLabel("FS8k57U88CzROUZ9dSs6HJyrNzc584nQRZaFXhKDMUTvdmWLHG");
        appmenus.setRefObjectId("DrJMLleyEeASMWO8yRfyU0k37Afih40ctVHqo8ksVTUhWTBI2o");
        appmenus.setMenuDisplay(true);
        AppMenus AppMenusTest = new AppMenus();
        if (isSave) {
            AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        }
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        rolemenubridge.setRoles(roles);
        rolemenubridge.setIsRead(true);
        listOfRoleMenuBridge.add(rolemenubridge);
        roles.addAllRoleMenuBridge(listOfRoleMenuBridge);
        roles.setEntityValidator(entityValidator);
        return roles;
    }

    @Test
    public void test1Save() {
        try {
            Roles roles = createRoles(true);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            roles.isValid();
            rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            Roles roles = rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
            roles.setRoleDescription("w9nfBgGE1DF012IewNVYU5Quv91XQAbfPXloDLaqnANB2uxf3O");
            roles.setRoleHelp("McJzLoMpm0RzxbsxnhssM3Ary19NL4H0al903L3wb2xRTZvHZK");
            roles.setVersionId(1);
            roles.setRoleName("Xg8dUNLoRNgIepS3o4JWFcdBm2LuTUYcHliUaFrfXIhtAEoZzd");
            roles.setRoleIcon("BDWAWsTecK7NCd8xUbHxbQxnE56emjUtpeOVVnIGYgxW4XyjF2");
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            rolesRepository.update(roles);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey")); /* Deleting refrenced data */
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRoles(EntityTestCriteria contraints, Roles roles) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            roles.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            roles.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            roles.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            rolesRepository.save(roles);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "RoleName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "LmipLK7tUAd14L5Uv1g05o87LffnyfMcZXFUahoX7IYqpkhfDZUwNE3E3nCKFxDODO4TcJIM2pgqnbnDAKYcVNRa9UyOfPAsr0iPEalABIxzNOjX75LytdY7fkqwmUmH8OHIk4Mul7Ebq5fAVuYpN66IkLFSBkYDL92wOR1vmHJmmCd4iH2LYHJWdVM7wbuajbFpbc6TCBN0PbQni0YKWihkAGcjRCdscDbpCPNpAdwx6XtW7SJQPxkTz2SvzfYhK"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "oySVQde90LYdCEVdvmO0RCPVplyPfxcq8sXugStwnzTTGGESPpsqmFrHly01ytFBKmys3D9Z4zQICBxlvnGtsCyMAGlTqGpqbgPDtaGGYWFsm8tuq8YhfGD68JmPt1pftOIh1bdxUVZml3uKdpaVIr5dNuGg70Amhcv7PFg8w7cB3XnaFKlSBiz8jd3RNsJ7uSTWnKpPJh6Ng23SKS9zohCY26amhbCtgRQ28L2tuMXax0J16bf3aS49TwnJcF0ie"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "VkjCEdizxnVMBDkaH0xFsUoGx57mKUYrCj6XGTBdth4x5shzHjdzBNV3nC3xCVX3f"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "9n1ho5FC6h4aukQ1hdzePCZL5v89qSxLQefjJouR2JxexsGvshzV1djWx95hP5a754pMhL74EJRBrGP0hr18HKM7qj2GlHdx2wr6eEmMahVxKm0tQLOLNzGzq4ZPbqGcPc4tHPDlNt8j5EyYHjW4tZcpaN9ACNEVoSEtu2XCDlwVipvtb6JNbB9wU6OwRLA7ZVMOQzDTXYxqyUMpbMKQyMVa8j0pgokiHvocpkmiAdHOcOc6BbL2QI9IWbs6Y53q8"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Roles roles = createRoles(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = roles.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 2:
                        roles.setRoleName(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 4:
                        roles.setRoleDescription(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 5:
                        roles.setRoleIcon(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 6:
                        roles.setRoleHelp(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
