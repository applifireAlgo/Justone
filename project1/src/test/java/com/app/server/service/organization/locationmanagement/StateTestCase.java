package com.app.server.service.organization.locationmanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.State;
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
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class StateTestCase extends EntityTestCriteria {

    @Autowired
    private StateRepository<State> stateRepository;

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

    private State createState(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCapitalLatitude(7);
        country.setCountryCode2("pEj");
        country.setIsoNumeric(249);
        country.setCountryFlag("h4ynbkv9BgCBHVgCR8whShnGV7fVO6M5qLkLXE8Pi72FPiZfm5");
        country.setCurrencyCode("X4h");
        country.setCurrencySymbol("yLw2n3clz67BwGMvWjdVxFDbdELjSCYH");
        country.setCountryCode1("NXr");
        country.setCurrencyName("VXgMi3BD3PnuLMY9uATGykEHu5GTtDJbmJel7RsYmSDJJJjeB9");
        country.setCapital("yDvatqJcbW7cdqNdEDJ6fPeVTlCYFRh5");
        country.setCountryName("mEepi7wGzswD8WB1R3nEtYI4trPQsQqeEPgqr50wlY5xMisjCc");
        country.setCapitalLongitude(8);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateCodeChar3("vWsdeXlAscULeyanEMcbtw18TYFjZFww");
        state.setStateCapital("ws6LYwao05X9wp14gfhrHcigy7nTs9XU9ngvYomFlcFM8BIDnr");
        state.setStateName("ltFsRxrkwENdeVI75DjACnA6mYsnENEnsM5hH0hl6jYBfr6XDz");
        state.setStateFlag("QyoUOc861Atibpfj5L2rCHTu1Do2CeL72zFqau4jNyGplRxGiX");
        state.setStateDescription("noxTmH9lvr4Tpi1hiYeriRMHep5iznwdgYdgrTF9YHDXcLZLfP");
        state.setStateCapitalLongitude(9);
        state.setStateCodeChar2("zXEKqTy0RUq91Ox0wzWXngQuejGAW9j3");
        state.setStateCapitalLatitude(10);
        state.setStateCode(1);
        state.setEntityValidator(entityValidator);
        return state;
    }

    @Test
    public void test1Save() {
        try {
            State state = createState(true);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.isValid();
            stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            State state = stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
            state.setStateCodeChar3("kv4bu7RIOUkEMucHptOzTERbZQutNiP8");
            state.setStateCapital("DJSmEF2ID0Q6nHuljr9lN02y3Nrx5AKwnSPj8ufzrxMM45Vomu");
            state.setStateName("H0bE0fHB7Wx9pb3Qr47k970vChW4fPP1mtGljaaDIUp7QvOwKX");
            state.setStateFlag("DEUCsvyjF89NhfCsypmBA6bTjaYZio0Usi6HD6T0HvkcyxNHak");
            state.setStateDescription("6STsMnDcx5lftRf4t943LLBXssRBhJSWK1JgRG4Pb4OamoIKUX");
            state.setStateCapitalLongitude(4);
            state.setVersionId(1);
            state.setStateCodeChar2("VNcAtqxj1oHE6i1sryCMU1G7jG9dfscd");
            state.setStateCapitalLatitude(7);
            state.setStateCode(1);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<State> listofcountryId = stateRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateState(EntityTestCriteria contraints, State state) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            state.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            state.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            state.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            stateRepository.save(state);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "stateName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "aPgGt29dvwJ67xkPrJNnBEWI0AgWFS0VgKfnRZfav2NmXny1FnWXMXMCL15dM4n8engHLf4rxUDFkOFiitXap2E9MEAdqMwtxf05ql4FL5BDaByjn2Lm66vhVvS4eu45czDylxb22O8ExbCzrdyWZJciQb7OgOxiVUUswEyCiMG6muOQPkmUhEqqwc7auFyGuSkz3Sjt1KFYMl7IlJvUypg3wH0PJFuw2Qp0WeRv8b7H95ZIXn9tOLoiJie9HpceM"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 3));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "wWZnSz8CQkVxmDnwhdaUBtSFCr607DXxx"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "yyrN5JgKvaQL0hYGNJYpQMpRsUykJOu3V"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "A7yC8L0CJ0o1T3BPQx7cgGWhArQHPVR3qLfVgbXv7KLVsNKfVNJ9KpNAn6AuzTywm70VydIWIs3Gothij8f8Zy3Db8ZBoDlKQRvf03rlgAmjt6FAXQt1RldaoNJ3txjyrT0Zpun1ZDl32zum3hjapq0ihb6i2krabsO4CteCIdY5sEfLb0x5iO3L0IchEfSe44gAHCTngdZKF2YJ0GxGKnj3PMxVIi1ex3ufmzgBLz4gMm88Dr8YYHpc0g95iu1xx"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "GxqISS5p5pO64HPUkhFABIG156ej4Z5kpGQwRdwbOzZ1xwepEKqFOLiSEWk7soR22BzGdxSzEg0XSIxK4MET5O80xNIsV5UyEJiUHVSjL1SdzC6MANAh6I5vOawTgzhrf"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "e45oHcZHmQuPlv0wwWA2h03VaePBMXpthQQQPGpiBGCxylEsRzOSo04dpC5njOsPMBvuQlHjknIb8Iw3vM8g74VDoEhj2fHLm0RfTHZn8ISKuVVcGGYXJOJgr7JZoUuj1"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 18));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 20));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                State state = createState(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = state.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 2:
                        state.setStateName(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 3:
                        state.setStateCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 5:
                        state.setStateCodeChar2(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 6:
                        state.setStateCodeChar3(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 7:
                        state.setStateDescription(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 8:
                        state.setStateFlag(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 9:
                        state.setStateCapital(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 10:
                        state.setStateCapitalLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 11:
                        state.setStateCapitalLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
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
