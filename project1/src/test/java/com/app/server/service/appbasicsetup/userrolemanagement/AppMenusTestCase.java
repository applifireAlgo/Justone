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
import com.app.server.repository.appbasicsetup.userrolemanagement.AppMenusRepository;
import com.app.shared.appbasicsetup.userrolemanagement.AppMenus;
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
public class AppMenusTestCase extends EntityTestCriteria {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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

    private AppMenus createAppMenus(Boolean isSave) throws Exception {
        AppMenus appmenus = new AppMenus();
        appmenus.setUiType("NxP");
        appmenus.setMenuIcon("4yhOnRTaK0S5szOfuMbgBzGotjhttQMuihIJKfxjJpe0EsK0dF");
        appmenus.setAppId("Letq0XsgoNbbceWEwK4Hrk5xqIMW0cpeMbCZaHxGbc2iw9vU7I");
        appmenus.setAutoSave(true);
        appmenus.setMenuAction("TNLrdCTRgzY4b9MNYsD3H0eRalfAc2JqLBzGq9GQsHAUcfgId8");
        appmenus.setMenuHead(true);
        appmenus.setMenuTreeId("9dI7i7LBUrPsKcWIisIUfphKdhR5fVZ3MI59rByrJ8XKDzESOb");
        appmenus.setMenuAccessRights(7);
        appmenus.setMenuCommands("I0rVFsJOil6jqxGAhEKct1evPvwueqzkgKCIexC1AhiWx9HGJN");
        appmenus.setAppType(1);
        appmenus.setMenuLabel("shONVfHC2osCOkT49NULXuNSluevEaag5RFvh7ypDnAGttvzfb");
        appmenus.setRefObjectId("JEGp73fWZZrKUY5aeomvaTKEj5MuUPuXyKPi6Qp1x1uucWU52Z");
        appmenus.setMenuDisplay(true);
        appmenus.setEntityValidator(entityValidator);
        return appmenus;
    }

    @Test
    public void test1Save() {
        try {
            AppMenus appmenus = createAppMenus(true);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setUiType("WfS");
            appmenus.setMenuIcon("nsxejs0NlUMP1sDsuTGLnOBvQIGXUqoqbVPPbHraIVXcdM4q7V");
            appmenus.setAppId("XV1ZZczCSHvGrApCJVY7J4sFLfFpM2BbbUIwB2rDHKdygbiW4m");
            appmenus.setMenuAction("KRu73FJUVvglCAqgMzvJw8QY59tRzMnkl50iI88vhpKsqb87Z4");
            appmenus.setMenuTreeId("m6Nf3sjDQxy0EVbbnGENzawRxydduoKoowZBfk3ECfuKywh41Z");
            appmenus.setVersionId(1);
            appmenus.setMenuAccessRights(10);
            appmenus.setMenuCommands("72vevkYLtMyBHrO41Tkq33pQCe1RG8RencpvUC7qizMfQ5QXHr");
            appmenus.setAppType(2);
            appmenus.setMenuLabel("dy8sknafGa4By43WaTf59Ja31N04MoP8PEXJ58glAntduK2vWl");
            appmenus.setRefObjectId("rJ66cIg0C8YsxNtW86t69o8e8RMF7DAFG2i50xGdueHV1DU1rG");
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAppMenus(EntityTestCriteria contraints, AppMenus appmenus) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            appmenusRepository.save(appmenus);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "menuTreeId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "WuI1CABfw0GUUJSNDrprmk2izOJ2bHRX4zFSp7IDxbbKK5OKLEw0VYrOREmYPAmvp6nbAsMqPTwstJJ6O2LXi1IB0bedOPY5BJSM2IiufFVgFzDbuOkr3Phyi0sATzepEBVUhcGy9W4eKLCBVxYRlesJUWnJMAfVwk1A5vQiNBshpKVtNnoF43k7Tols2THk3u255bLk9YvsBo6ZuIqlTurvxXHkJ2kiVTnhAhMwD0WlvrGfmatNqPj8uAZq695ta"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "fYzpF5SpEmPCrhrR6AsWUF8wKf5P4fYYDPPv78LzbDpxuRY1b5mRxcRbXfbf0IJAzv6I2YxZc3qzpRwUFux6dOXfGVvqTisMExvMRXltUnLoivzLOeEZbBnEWJ2thcRFNT0WsD3b3oCFdW2O7AGHdJ13uwmzWEf73SHnuX3XobGyIvTUYY4piHLbrx69A61NNlIg5DwA6ITmlSouH3IuZCQcl9DYgdgxtytHQhE4MPUj5Jgk4mjrWq6zvM8RE0AZu"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "akNTX1knlm40WlFsLqRCjbCQgFJyX4Rjl35DTrgzLNxQWDqFCVFesjVDG87kSpeqXDGtnzd1hW3Hm1BqYRTEmxFfAkgUJR9UodWpyhH65esnY76YaPB0jS2S7dnajKQnQt9lyxuN9q1VCFJYqmumHs5BELvQf5nUT8CS7kalPc7TDR40wimmaHIlJESPFHGBC47va8M0LPp7zgjldu3zVbnDhKN1jT74Wm4Sb57H0ICZYq8dyBGrRQusENqEamzWz"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "jxs2az1bLRTNpwg8BL4IIhk29x3B1hfJxC6bdqFKBzDlyg9v6nO0A2w62JSqXj8Wp"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "u864PiNRhjGvwLJfrW4X3f3i0Of4CpKyRZRarS15eoCUB6V0GWwhCSa7S9GmWjbZZx6foSnk6ncyZJ2nVZGgsGpRKrc8knkzdJWJGMEBkvUjfzNCNefIHLskZSswWj8s64gy3e6GGqlv5TWHDn0p8Cr8SR4Pd8ZGtRdfScVST5CbiuN6AerwfPCtqOox9LzKe0K6xucmHYw5CDrFRCA0BKZFCQ1UIhlRCeOBYvoCRzYV5Ae4TRiv2x7V5rVLsNaCA"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "HxXs"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "btLNGHmzo7XxLKFJEyYOJiPNnnQ37xy7BewRvSgKMTRys6mroTOknF9hmKn8GpYaS3U8e2NQ1ITpuKSkRZu1NVsKkBMoo8O9kYWRUiuzcThCmHgaMYsuj8dYzR0xuWiKcPERNmLrzugiGx4jYZDT7ghrHjblyRIFA6Y9Rd2S9M81LUeq28MrXyOJ2F7M4QbAwLr4SAr4NVCIWjFyxLo4Fke8tTPw0nT3rbqTygJ4uYPBe9T4rKAfLpsdEGvyeIoaI"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 19));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 4));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "RAYymG8jkw7eE6FP9wneqRmiPRhP0I5NULPydY7gNpHU6f9YCy3sPnQux5UR4OGRs6tQME14GJa7VUKKufU1WrH3utxywXWdlK7wkkZI5JlZATWauuhqzAIaWbc28EFq2J0i4m5vQzBKad8kbg12ZNr72bQXjbaZwaMfIpi6gAXdxaSV3OZpSMP75hlnTsH7LC6tDlzEkBwsdG7FYsmkKp9vWVGPDxvwhEyeHo4rTeNIrmTiB5XzfUbWtvUPPVIHV"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 18, "autoSave", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 19, "autoSave", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AppMenus appmenus = createAppMenus(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = appmenus.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 2:
                        appmenus.setMenuTreeId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 3:
                        appmenus.setMenuIcon(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 4:
                        appmenus.setMenuAction(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 5:
                        appmenus.setMenuCommands(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 7:
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 9:
                        break;
                    case 10:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 11:
                        appmenus.setMenuLabel(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 12:
                        appmenus.setUiType(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 13:
                        appmenus.setRefObjectId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 14:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 15:
                        appmenus.setMenuAccessRights(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 16:
                        appmenus.setAppType(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 17:
                        appmenus.setAppId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 18:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 19:
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
