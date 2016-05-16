package com.app.server.service.appbasicsetup.usermanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class UserAccessDomainTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

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

    private UserAccessDomain createUserAccessDomain(Boolean isSave) throws Exception {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainName("cPXmMnKgRgoCxNOI4KIA3g3SGGvfpVoy7BTl4MMBMEnna12Exs");
        useraccessdomain.setDomainDescription("oVUEDgTiItoTVZnsInWKSOTOVefs5cSN47qwDYN7aA1YPMY7Vq");
        useraccessdomain.setDomainIcon("VBklhs8xc48u3MfqWcKQiOxR7Fu06gAIoYvMFsmOAQtv0ifypb");
        useraccessdomain.setDomainHelp("ON07RlifHH2MRT3Asg9eKferLLkuc7m8WftadsJkXoQl1zvpQ4");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setEntityValidator(entityValidator);
        return useraccessdomain;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessDomain useraccessdomain = createUserAccessDomain(true);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccessdomain.isValid();
            useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            UserAccessDomain useraccessdomain = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            useraccessdomain.setDomainName("ew4A04tqr8j9pFbZqmXuRqI5G7IO3RhpHq4pFLYxJ3IwDpDltw");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainDescription("1jUY1Dkz6oX9aA6Kn6kYxvLZYrN5xqAYcpv7K021y0iEcYVIxj");
            useraccessdomain.setDomainIcon("E8SE2kZKs5sqHMYei8W36aa0rT9C1LS2KY56k9h6JxrYq5TMTr");
            useraccessdomain.setDomainHelp("apxVKdB8yg7zJ3nZTeuHyfws3q8JIIqctrtfqNTJ6fTeyUhxrw");
            useraccessdomain.setUserAccessDomain(92236);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessdomainRepository.update(useraccessdomain);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessDomain(EntityTestCriteria contraints, UserAccessDomain useraccessdomain) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccessdomainRepository.save(useraccessdomain);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessDomain", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 193907));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "ME2ACfitxdXfPwg3IXT1A39Ha1lPnCmo8cERskaUFREBrqBvLwitHeUxwLAgyS5hnkt1H8s2QdmVqoV8BU2oS1eE5wh0Lcgr7u3l0i1iCGl25n9lC3HV0vz4cWazbZ0tXxOVe8eZ2lhUr2T4lPIk0Sgo99biiWCneFEWEcWMCKPQ1yLlmcW9ZPA6mePMhcIvmKF7YJnXZzjwYqC10WlW0glGtgX5Tj4gHdwc5cv0mTfKCPAz91j13skNOVuG1DZAK"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "ajh2BB6I6qcqGHgWmlYPae86BE2gxdV3SFIt0l7rHOGFYJegDSJlI7QwPnlejI8CAihxgV5iGJs44FCd2dQcaeSq59JcLKgPcw7RA1NF55eShU6lajlP7IfhN8sVPZwqsCPqjeHU7rE4Qtvi5ntMuwMBBvoagHVLmgjX3lQzllAKVGtkfExmRsw7pL3aGS97j0ob4rJbh1kVRsFw2U3w1RuFN1L1N6BstCJ9NAdQFuaYtKOEK3QbnQWMbLBobRXMA"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "JqGwgm6RHVRdJXeDjotjtIvKJ3inLa0hd1Swh4Oiechn0slc8f6l11goQPJdYZisW88vk56Qm133bo4mMjY4DYHIYAEc876tk6RwaWgYk17yzms3vofJDC8ESM97xtwyNInE4XKYoLJaTDnRh8BF4Q1uM40CANgVFEapHhz6P7aIQTrewXErCMX9yCWgbPQ0rhHAoqLX1TsmfkBQyloGJYr1pYYYgfpOzyjswQTHBEWB4bfYdfwoWYNpb0voQOXNx"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        UserAccessDomain useraccessdomainUnique = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessDomain useraccessdomain = createUserAccessDomain(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccessdomain.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 2:
                        useraccessdomain.setUserAccessDomain(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 4:
                        useraccessdomain.setDomainName(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 6:
                        useraccessdomain.setDomainDescription(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 7:
                        useraccessdomain.setDomainHelp(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 8:
                        useraccessdomain.setDomainIcon(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 9:
                        useraccessdomain.setUserAccessDomain(useraccessdomainUnique.getUserAccessDomain());
                        validateUserAccessDomain(contraints, useraccessdomain);
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
