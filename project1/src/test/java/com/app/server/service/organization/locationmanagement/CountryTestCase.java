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
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.Country;
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
public class CountryTestCase extends EntityTestCriteria {

    @Autowired
    private CountryRepository<Country> countryRepository;

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

    private Country createCountry(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCapitalLatitude(10);
        country.setCountryCode2("tsZ");
        country.setIsoNumeric(842);
        country.setCountryFlag("XBjqk83fhctrafS46F1wKNW8tPQs7vprVOfOmbY5VHqjKG4Bi0");
        country.setCurrencyCode("dqV");
        country.setCurrencySymbol("L3dS81bmigj2erJKTVjBbVCZwT3D2mnh");
        country.setCountryCode1("QoA");
        country.setCurrencyName("UAq6BxidheDQTBI1OlVUwyanfcquczy48iPYD2vKmxu3Ij9LCu");
        country.setCapital("Jw8RpRuujs1MN2hdA1arL0y8TDse83MY");
        country.setCountryName("r5kVx58z1hAMJ3TMNwzoZNDE2NUX3rIM3tZio5ueYcgWPzU9jY");
        country.setCapitalLongitude(4);
        country.setEntityValidator(entityValidator);
        return country;
    }

    @Test
    public void test1Save() {
        try {
            Country country = createCountry(true);
            country.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            country.isValid();
            countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CountryPrimaryKey"));
            Country country = countryRepository.findById((java.lang.String) map.get("CountryPrimaryKey"));
            country.setCapitalLatitude(10);
            country.setCountryCode2("8Hw");
            country.setIsoNumeric(52);
            country.setCountryFlag("ahyWO1nC4uhWvuzY0WGD61r484zCV0r9ZuCrscpgGDsTaS628h");
            country.setCurrencyCode("A5w");
            country.setCurrencySymbol("1K0ijKLs1SzsyPPoSbTyH6rsLnJ5hsaJ");
            country.setCountryCode1("9hZ");
            country.setCurrencyName("4m2zGO7J1w2AhYSfQfxSqUsbuqHS5BXh267K6eFdVEF2ZGUta1");
            country.setVersionId(1);
            country.setCapital("sSBZVA1PXR2H43yrSUCkBn3NNX3F7mPd");
            country.setCountryName("mlVlMb6gcdJUIsjE9WQ3xmkias2N1Ytf30zKfQQxwuthOUl7Kb");
            country.setCapitalLongitude(7);
            country.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            countryRepository.update(country);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CountryPrimaryKey"));
            countryRepository.findById((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CountryPrimaryKey"));
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCountry(EntityTestCriteria contraints, Country country) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            country.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            country.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            country.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            countryRepository.save(country);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "countryName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "countryName", "jU6FKDegCHVZaQU1SBZdH4br9xmzczMxESyGIacKWHLDEuREtw2fvGSgOXxWwUMreUClFHdcNaifQUTZgG6dXa1kizaYqLQMozDI9vvCnaZ0IHY7oNyfXA74hwjvXusAS"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "countryCode1", "9ROY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "countryCode2", "dOLD"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "countryFlag", "Nlwo7EA184JJqTMOM6hY7L99l7CzQuPCMpPfM8R0C9g1qrD70SyD6v2aLwwB56fBI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "capital", "jMhaMKaeRCmEOdiZFbg76gr8aOYmVugGk"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "currencyCode", "WCkd"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "currencyName", "TbxT10X9jVFzRz6jj94b9S1dIczgVjTjM10WR9g90XPOk3dqcVEWOZk8yOERZQe980oGiiXZQxFqQbaQ0rsAtNSu8ea86JGuVaIyoNhKLIRhok15dErJaWSgdFDLX1XU1"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "currencySymbol", "tPZfYZvIyS2nookfFxSnIKtzXtnx0ByCf"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "capitalLatitude", 15));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "capitalLongitude", 18));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "isoNumeric", 1702));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Country country = createCountry(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = country.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(country, null);
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 2:
                        country.setCountryName(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 3:
                        country.setCountryCode1(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 4:
                        country.setCountryCode2(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 5:
                        country.setCountryFlag(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 6:
                        country.setCapital(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 7:
                        country.setCurrencyCode(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 8:
                        country.setCurrencyName(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 9:
                        country.setCurrencySymbol(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 10:
                        country.setCapitalLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 11:
                        country.setCapitalLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 12:
                        country.setIsoNumeric(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCountry(contraints, country);
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
