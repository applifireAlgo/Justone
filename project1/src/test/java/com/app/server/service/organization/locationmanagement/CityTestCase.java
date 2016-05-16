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
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.City;
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
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CityTestCase extends EntityTestCriteria {

    @Autowired
    private CityRepository<City> cityRepository;

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

    private City createCity(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCapitalLatitude(2);
        country.setCountryCode2("0R6");
        country.setIsoNumeric(400);
        country.setCountryFlag("BxDwfD2wLxDo0kS1jvOUkJTefKRJYFZ3SrAH21iXRgHJb8O0xl");
        country.setCurrencyCode("pnv");
        country.setCurrencySymbol("9YoPpnaSmoZIbVg9V8lKiajyRPHiHvQB");
        country.setCountryCode1("5Y9");
        country.setCurrencyName("JcbLHjor2mK6gJlC2qEzwwpOKTFagvGXdUrlZlqTwWq02WFa0N");
        country.setCapital("X15J1G9PHQnyofhXHVidx1x3IhoXugVZ");
        country.setCountryName("BEyfRbaEcOPbi5KLtQBzyjvIM0SMvMFoNqqRAjHEQrnvhruuL6");
        country.setCapitalLongitude(6);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("5bJSRG9dqV62iM1E1k8K6jiU74a1m5zR");
        state.setStateCapital("ItSHTQCHis8NAMkU8YSeEqZNQ3TmolCWrDNiVmNInGPNXqVcQ1");
        state.setStateName("IKttFCth1Rx7uOrBDdSzGxs1lwJiwumymiX3StNINtjpCU7dLp");
        state.setStateFlag("IMXbtJRQDhOrDSSakhdBfsfJfZwpqd8pvLNphYILiPYEZ18oaJ");
        state.setStateDescription("VV2HRZrnIfTW9MDpZ5Oah8MTVs1yF0fSGGggyFPmAxzw2sZ6Rr");
        state.setStateCapitalLongitude(8);
        state.setStateCodeChar2("3IBlPEyS55uVzjGSdHuBFkkuZpMTRfiX");
        state.setStateCapitalLatitude(10);
        state.setStateCode(1);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("FKeNEPDboI1AuPGeBDTzZDTq7qylesYWG7uTtZBjjk3Ky4qdti");
        city.setCityCode(3);
        city.setStateId((java.lang.String) StateTest._getPrimarykey());
        city.setCityFlag("u2NE3nFg68B4Ak2OVgmnxUaMMPvn6sruuUDwAjVEOFuhUM9HwL");
        city.setCityLongitude(6);
        city.setCityLatitude(10);
        city.setCityCodeChar2("rwHdPMp8tncQSqtEVzOsAT0t5QTiRXhS");
        city.setCityName("yRZeOJ9jp8TaJJ1yvL3lH0okdN6VjjHKCOVUGTF427J4NyhB75");
        city.setEntityValidator(entityValidator);
        return city;
    }

    @Test
    public void test1Save() {
        try {
            City city = createCity(true);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            city.isValid();
            cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            City city = cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
            city.setCityDescription("DRfaa2fOh6H0jzGoCt99k582H7DS1fl3Sm2Azx98T4WURBLMOa");
            city.setCityCode(1);
            city.setCityFlag("jyeqnXTwd8bQx1Bz8A0XJpZCXCKmQDCgX4sLkM8ImdiK6IAsQy");
            city.setCityLongitude(1);
            city.setCityLatitude(11);
            city.setVersionId(1);
            city.setCityCodeChar2("2RyPjGyR4Sc7gHVGiPBV1UIXDL6Q08Hb");
            city.setCityName("KN7JwBRDgtUW0OI7zgvDumuGRQphhXLiFLAXDedDC2gqnjV4zO");
            city.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cityRepository.update(city);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<City> listofcountryId = cityRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<City> listofstateId = cityRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCity(EntityTestCriteria contraints, City city) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            city.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            city.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            city.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            cityRepository.save(city);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "cityName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "cityName", "Ip5tFv7p6m09dcyVNXGgj2NHS2Vv8PFNyQUm1B3Mlf7DiWpx3QpCgo5EQ6XsAJMh6014FboxKSwBQIu30oWeQwGdDu0FLdFnalOK9McyruncFtsde1NpXZR0exA3y3U5ll511ugCMvp4ccYqQ4wOUtV8Ub7YBhPt6rCQWkzH7BcfyxlqljDy2JRVeyRJ54rDFo1D7Rbqz8V097H9bqpmzQIXJdON5mHXClb13RBGMZPTGXdeECHiRrVmNgAZVJfbx"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "cityCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "cityCodeChar2", "yBVK5JC8Kw3gjAdXnX3YqHmbhd8MbTLph"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "cityCode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "cityCode", 4));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "cityDescription", "RVGx1JPjRWp09FC9Gm0l6yPDxO8oQKoWguyocx8z279znidFrOlQgO7sukvoZsEqzGX5LTWSXRZkdg3xuAeAoLsG5bWnBTVdy754BpLwk6AUVpZ5WC9vWaJDamojEoPZk"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "cityFlag", "WVZBF6c7XgMDM9ptf31Zwa6miMzvB4JVm0GC6v2FLyWgRXqzBHfrG3PZQyTqWn1BbXODcY4W3C5ZzEgWwfbJSfAereJ2pYLkOzSrAudZEFwekP3aAyJhRuw5DWy5y9Vo8"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "cityLatitude", 19));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "cityLongitude", 15));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                City city = createCity(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = city.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 2:
                        city.setCityName(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 4:
                        city.setCityCodeChar2(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 6:
                        city.setCityCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 7:
                        city.setCityDescription(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 8:
                        city.setCityFlag(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 9:
                        city.setCityLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 10:
                        city.setCityLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
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
