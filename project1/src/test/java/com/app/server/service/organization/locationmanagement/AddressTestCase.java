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
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.Address;
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
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.AddressType;
import com.app.server.repository.organization.locationmanagement.AddressTypeRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase extends EntityTestCriteria {

    @Autowired
    private AddressRepository<Address> addressRepository;

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

    private Address createAddress(Boolean isSave) throws Exception {
        State state = new State();
        Country country = new Country();
        country.setCapitalLatitude(3);
        country.setCountryCode2("CYz");
        country.setIsoNumeric(670);
        country.setCountryFlag("fMtGxeVMF1PErgPEOUxpPJuP5aouPz1Q11mDCCIACFEnGoenPx");
        country.setCurrencyCode("j0d");
        country.setCurrencySymbol("RlFen4MGs21QPIk8SgzjKwKEcHmvvEel");
        country.setCountryCode1("tdv");
        country.setCurrencyName("L1WUa3O2e7EUsutD3txwO6t2huJl436LONdNuOxKg55n2TwpNl");
        country.setCapital("owDMmPL7QK9r2owg8zFbuQkGkCVjRENC");
        country.setCountryName("gcmjBApxOn2DWA0se3DADvP3NAyqzets1pYQQrLgxeJvA9ySKx");
        country.setCapitalLongitude(9);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("WOjFEY06hjK3OqWdmAhw1nGXZ0xSI9Ed");
        state.setStateCapital("zzeBr8ob46yWtABV8yyDDqEx3kzSVd1tgyoFUCgtBddPTYThM9");
        state.setStateName("xcWOSYXrPhUBFST5z9iNjTH35n0ktCIQh4O6DSV4lb4kjGxUG6");
        state.setStateFlag("iUvFXKph4XUpM26dSN6jNZiInht4pkEtA7hTFqJag8ts6IoaRN");
        state.setStateDescription("gjyLA1Du0zNhYM76lKdcim7i73m0PGpheJb8ZX9sK4Tv38hWxY");
        state.setStateCapitalLongitude(6);
        state.setStateCodeChar2("tSW8oN1i1Cm6487TeED2ZyI7ySJure0I");
        state.setStateCapitalLatitude(4);
        state.setStateCode(2);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("wEZLJWRXjqrzhSWK57pOOUWhECgBo5YHhAoq8K0fozOhdsYhlf");
        addresstype.setAddressTypeDesc("pSvFr0EC4ImSBBM3dGqtusJkFZnxVHBLoyMuI4r5s83pOAoWxD");
        addresstype.setAddressType("6GmWPWkGfqux90LVcX01itbjiiuxzWjCYMwVoXMoB9h5DYEuUx");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("abMMd1phIqX79PPKcJy6Ez7h63gX7DxKsvXT5KcMFj2ZuwXQzY");
        city.setCityCode(3);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("EBr9ebVuIHhrCQTRG9NqvpjzKgv7iVwySS7udPsS4Mfd3LOmZD");
        city.setCityLongitude(8);
        city.setCityLatitude(5);
        city.setCityCodeChar2("NcryNE1K0f5IQJCqgcr7rpAj6BN86A5G");
        city.setCityName("hITAIGV0eHRbwD0Fa8TAmE4pGYOUZhbpAiit1eiFejxwQhxZjW");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        Address address = new Address();
        address.setAddressLabel("q2Taccvhl2r");
        address.setAddress3("w0bMhHLdWBdMB3IiIUofZb7shBwbg4numVppoRkakRAE9DOlW7");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("uRwQ9AQ4eazRLA6dlqeFdmi6LohPGvAvjiwuBsxZL1XaGitaFV");
        address.setZipcode("J4MUHE");
        address.setAddress1("YGOV6DgNWlr5RMsFUavatfeAhXWH1fgd7pHWeRFcPkkeDPqs6n");
        address.setCityId((java.lang.String) CityTest._getPrimarykey());
        address.setLatitude("VaizGEKFbIFphsDsXBlcYeC0UGdVoBvAwi0cEtNOWm92awGF11");
        address.setAddress2("Z83UkLrTpJJSGQ1kIeHixqtOtEvbEJ9bppR1bMpHMR7sU6FLWM");
        address.setEntityValidator(entityValidator);
        return address;
    }

    @Test
    public void test1Save() {
        try {
            Address address = createAddress(true);
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddressLabel("fPu4DgOT2p4");
            address.setAddress3("Q7KaTqmqkwcnZqAzMfWhV7CniMa6MycGFUl8GgmQWIQ6Ah1r4a");
            address.setVersionId(1);
            address.setLongitude("ffmFJRZIibtnOUH2alU0UXgw70fQqPutURKzXCoY4mp7e9j61P");
            address.setZipcode("AMJj9A");
            address.setAddress1("FxOawfKbGtCyqRNJvPYXY6oydTuhqfYj7VDF6YGv0XGuTQVr95");
            address.setLatitude("cXgDQXWw0hioygJzC3G1Qs2yoAVqZyCxP4kNt1kCR9HEf7BMjk");
            address.setAddress2("bmSHHS3AuK6N8f1iLmO5LODpkifpYCZw0r2190YfnswIDhoZnL");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAddress(EntityTestCriteria contraints, Address address) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            address.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            address.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            address.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            addressRepository.save(address);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "WzLWtJEqWe83"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "iFY1I1vibPQEhz6X6f9p6weqzXJSpd6ms1kzBZ5MHSJ5LZ5wA4yQZjiDp"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "1CGk3XdqCYD1ugWrg6G7csxtfPzXTCnPny8XH5haoFmwaz4MFNjXx9APO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "FWZXKVJJqOzU8YFRwnbuGfwvXfTggdIGylekEv0rrVrvlIXe6qx8H8FmS"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "EsyjC31"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "xPen9rwzWOCTeSO5qnytdgRU9ZH7REDJc1EYPZGLkahQ7Vyjo5bEMmXnH9hWesydZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "F52Lb6bxvyhyLpq9vjqUI38fqf6swRdEiZB3watKxrOR2Ony5D2rwBuo2Z4YsDSkR"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Address address = createAddress(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = address.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        address.setAddressLabel(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 2:
                        address.setAddress1(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 3:
                        address.setAddress2(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 4:
                        address.setAddress3(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(address, null);
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 6:
                        address.setZipcode(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 7:
                        address.setLatitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 8:
                        address.setLongitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
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