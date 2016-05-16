package com.app.server.service.organization.contactmanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organization.contactmanagement.CoreContactsRepository;
import com.app.shared.organization.contactmanagement.CoreContacts;
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
import com.app.shared.organization.contactmanagement.Title;
import com.app.server.repository.organization.contactmanagement.TitleRepository;
import com.app.shared.organization.locationmanagement.Timezone;
import com.app.server.repository.organization.locationmanagement.TimezoneRepository;
import com.app.shared.organization.locationmanagement.Language;
import com.app.server.repository.organization.locationmanagement.LanguageRepository;
import com.app.shared.organization.contactmanagement.Gender;
import com.app.server.repository.organization.contactmanagement.GenderRepository;
import com.app.shared.organization.locationmanagement.Address;
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.AddressType;
import com.app.server.repository.organization.locationmanagement.AddressTypeRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.contactmanagement.CommunicationData;
import com.app.shared.organization.contactmanagement.CommunicationType;
import com.app.server.repository.organization.contactmanagement.CommunicationTypeRepository;
import com.app.shared.organization.contactmanagement.CommunicationGroup;
import com.app.server.repository.organization.contactmanagement.CommunicationGroupRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase extends EntityTestCriteria {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    private CoreContacts createCoreContacts(Boolean isSave) throws Exception {
        Title title = new Title();
        title.setTitles("79FFBOeM4xPbKYMEbIQarpq3911qQx9YqU1uQ8GZeGtVUteGH9");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCountry("5yxo6f0uKaavctGPyE1JjZSOF6MqNtcYwEyI7NFiA2z3RjD9Jh");
        timezone.setCities("Lrk1ic9L1siJcpfcUGa1qpPqSDINnprMsFfABW5J9PtQeBlH5K");
        timezone.setTimeZoneLabel("PcBmsDJtM3u61Zu3MszuKbOxRqSOIr2UtPLMtKJHHK2uk1EGVc");
        timezone.setUtcdifference(5);
        timezone.setGmtLabel("flqRK7xjHK49A6KU6UCdxkGTKSJOw3feePtXwV5iy4C986Mhnv");
        Language language = new Language();
        language.setLanguageDescription("4y2AUaHZOa3S5dVKCUu6X8u54oHOKsg6TqBlhzOE6RMInXj4Wt");
        language.setLanguageIcon("m6cKZq6mgH4DPZAGNYlKOuG5p9MDVqe9DLuc1bBc06kEwFAlkO");
        language.setAlpha3("Ect");
        language.setLanguage("885aI2EKCW6L5qS8IUlCIpO3oKy07jStUlGDgG9jdGkmOoUjVj");
        language.setAlpha4("PpsT");
        language.setLanguageType("GzWp153lvGgeUpxkURYA0ZJaarZlDX00");
        language.setAlpha4parentid(8);
        language.setAlpha2("EL");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("2GHl9uv1NHTa79b994oxYEkzB9aFMw0oRAb837x0XUOROGR195");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setNativeFirstName("U1Mj7gFSogBvHhACZBB4TFgffks692U0HbNG0q2QFMhyxTolQL");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1463382484350l));
        corecontacts.setNativeLastName("5CgmL5M17o6abSb15IqbadfgBa2sjs8wVjTbpYJmr1C85oEzTo");
        corecontacts.setNativeMiddleName("CG4kUWhP5NOBis77MxXKoXtWVRwDHCrAJHL8yl9YnyojanwOiK");
        corecontacts.setLastName("uayovaVhIrHJkJlpHfzLPbckP1l1WBpsrL0s8HO9KFPFwVeU8A");
        corecontacts.setPhoneNumber("4KSdfVQ1lngRlbbhsMaj");
        corecontacts.setAge(6);
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setEmailId("Z46X4PkEvFQQ8UHeYZUW0GHf6l5ihbrx3PJNTKWyBLfHsXLNpj");
        corecontacts.setMiddleName("brnW4xkofhsN8wYsIMyFExewWa5HwCmHOm1blqZsfegsnB4hka");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1463382484416l));
        corecontacts.setFirstName("pNl63139wD4OrQwnHkGUyZXBuvaJJbjyjgspORsy87Caax2XI6");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("dd8gHZElRal3cagRLNhgITjMt69KonrmCmqdDAWV7fLXIUK6Di");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddressLabel("9IroAijomlD");
        address.setAddress3("0favXZNDrZPH2YVdYsTXnGAvwRh6bOlyKQay3hvCpo9x3qvW8j");
        State state = new State();
        Country country = new Country();
        country.setCapitalLatitude(2);
        country.setCountryCode2("6GD");
        country.setIsoNumeric(360);
        country.setCountryFlag("K0Y5h8PCtebgIoylqFlNbNtLccwEjaKtJRjlFDeGc03WSu4EH6");
        country.setCurrencyCode("jfv");
        country.setCurrencySymbol("ZAIWLkM9gnCa7UClTuiuXE7DbbGtlrvW");
        country.setCountryCode1("KtD");
        country.setCurrencyName("4nQXxyz9Fe4ggqwktmUFwCZ5DQwj2hgeVSq9SnmIPOMnF1edB5");
        country.setCapital("dVRLnXjdYTM4szUUIA16razWiDVJi9Ei");
        country.setCountryName("4TfS8slsdzVYMIIQPirVt5cpluscjvBmFEAGEX3aHd4iRGNe94");
        country.setCapitalLongitude(3);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("tawwNLwu3DE7tZymyG4JVrgbSGmemEQ2");
        state.setStateCapital("DWdpuwNN9RAnCHndBPjJGhHPdD1jfzhfa0znUm2WgIKaOBVaxZ");
        state.setStateName("PeIrujepcfgt0OFSVjTMLeT5KczOLT5KprJOHNu7WNMI9VFPMq");
        state.setStateFlag("NlI9ScPxh8gTFb2sreNgu0qPX1H5pOaDdTgKUrhhVBGnYLSo1z");
        state.setStateDescription("AuvIPoqxY9BrHB1E6d5wdgPCuNxGIMNtTK57SSuaMRicCfQbwR");
        state.setStateCapitalLongitude(9);
        state.setStateCodeChar2("rRcbpDlvxiBxJ5wxNCxMq2SHEMxRbT9E");
        state.setStateCapitalLatitude(10);
        state.setStateCode(2);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("JQg2df1dtRTZhgz1AaHsf0m3jeyGDKCN9UcLN7Kj1NPIxaAZLD");
        addresstype.setAddressTypeDesc("ZeRLyxL2ZKpQIQYcDBa4TNqiyJSjbITA7HpJwDobD41tNrqwiN");
        addresstype.setAddressType("WanP9f0ANiRQ8Gg6HkpVhZpNkQ5GMaHUv7vPVVQvgRRHTnxENf");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("Yr0IIckaJDVeJXVLkWWB63bO3d3W7HnB1VvXZqMYZevi3Ty42W");
        city.setCityCode(1);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("5OxnLi5G5xgLSgVDeSqdAZRjjcnCuczkWQ6TqhYf8NXBzWO6Ku");
        city.setCityLongitude(11);
        city.setCityLatitude(9);
        city.setCityCodeChar2("NViNFxGyPuQnqBJDuzSPzWGhqRudTeYM");
        city.setCityName("e3LPIeBfhLoAkil8tUiNjPC0VHmKgoIVKQfzYewf84mh4ll16t");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setAddressLabel("TGFI9isPVoD");
        address.setAddress3("LSmrp4lOvtiaqRNhV05umAp8A4u7BaiXhIk8xHaEd9Y6Ojwq9J");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("zpgaCWg8UDxC92FBIxVX9oqY1hlZeEDwo1WoM7f31SnQN0yyrs");
        address.setZipcode("F52tVT");
        address.setAddress1("52RjqkWFtCYd8vVVhrdcJJ7zjVglNxuG70864Y8FWrcdttQNvO");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("OdgTf7rhQLNZFMZioabFMVQOQZPLrP9cugC9Rr0nFt2tyDPLmE");
        address.setAddress2("PfkVjhgQRawEQQnE7XjbUhLcNEushadHKYKe9MUZDWBdLtr3Xd");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("SK9ZatpBqaoj3vrFr3cdae2mZRRP8PMOqznBZfWrIYEWQ6wEoN");
        communicationtype.setCommTypeDescription("2YzhYdsXW9VadPegMaSefGQxYWZUqoah4264u76qon8MiY7ina");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("7vj3OJLfXlSGc4CG2YuIFR8wdZhZP4cfy2rHRScG0wVmo7pUuL");
        communicationgroup.setCommGroupDescription("MVdkWlXFfbRaLksC6iV0M6K3r2JkhMWNOnXLbCYkOOxrxq7LQH");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeName("hMPclZeEtZMMN8qzOvqFFX3XpwAMPdUpbDwagvAQwqs86HTasq");
        communicationtype.setCommTypeDescription("WioZjW0KdybMP4udLFS34OkBjjq5Yj2l08NVzDG5DQGxb6G2UH");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey());
        communicationdata.setCommData("bWbtZuewyJ");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        corecontacts.setEntityValidator(entityValidator);
        return corecontacts;
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = createCoreContacts(true);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setNativeFirstName("9UFMtv3oQvy9iL0X7wA6Lv2S2BmMQ8slQCOX3x1aQVQbPdovL8");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1463382484815l));
            corecontacts.setNativeLastName("u0UyVbjIMF19PAb0rQz5Q2hOvlCuzuFMuCVoACVurWvHjFRNxw");
            corecontacts.setNativeMiddleName("4jUgL5OW3OfG6YyfEGlDfFodar0WOcthk0hA7REFTWael2kBjE");
            corecontacts.setLastName("i4gmKpfN5G1ztghxO8bgrLzh7o8evY8tK5n9b4ArC1Lr7OfWF1");
            corecontacts.setPhoneNumber("Q7MZjVwU5x5lFRrM0P0o");
            corecontacts.setAge(74);
            corecontacts.setEmailId("7KvOT7uuSNWkngJPv8BySGKKi8nhgca0lF5uKimtxH7AePTyyY");
            corecontacts.setMiddleName("ToGPaf4vxUYPRXkAsBqNLAAEHQcTzg6MAA4meVZdrzhX6W6ZKR");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1463382484886l));
            corecontacts.setFirstName("sPHEpQAQl33yVjByM5pKdSlcKSa2DTg8XpCkmkAo59GYP5mwqi");
            corecontacts.setVersionId(1);
            corecontacts.setNativeTitle("Yxxq4G5DKyNUq8sNaVQDw662bHMUVuFlHClMawri21ipMaO1PW");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCoreContacts(EntityTestCriteria contraints, CoreContacts corecontacts) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            corecontactsRepository.save(corecontacts);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "firstName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "13OboRrDWFTmt7VdGEpM5u3vGM9fwR5oKE49immTCrDqD6H58DEpuDCogpXDgX8vYLpneqZzMQuu8jTkn9d5NYZxAFSiPRoOEUhVLRRMQCjKQngsLeYPjw1Si8qUuQj39MCOiw6Rub1T263u5hZrkhpGqBuIJyfvvwX88IP7UiTXBbRJ5KjU9qhJalqoACgIHtW9MADrxsvze5kpA02o3f42ziezyF6BLSbjGf29PlZfeGSSsMkPO4pjlwt1Xxcyz"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "erqXm77SrKwwMRt5csfWAKPUXrx6Xyk7Um8ywLmi4uuh0qeOykWimep2cbRog8LuZ0XcsDa3x8fFbJTzEOUwxSQSUPhKWfKAiKnqkBXRBOL3vKhq37fTjjtIpBnWxAqV52A4kjUX8AX8Smwza37egNRzt5Fd4MyhHcSJbnNXMDIsvqJyZa0bdfjuyLf7jLTilSZgl8J5kXPQBpOls7HDLQcht2pGLkhHgBFQdgWPdifGcZgifU4yJGLsRIzOfsigM"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "xRy8LcHlc6Q7ZRwthcqXFpuGOLovlHOjCpkeOCe2M26zwShJSzMLozbQ4vMCGIqbTmj4S2eDuVYoy6BxyEdGNfrS6WaQsT1yosmKymNGuMTNKyXAMFRxeCo7ty1OvZE1BUwAVbLppaz83D6qdJPytmEhDsG5EMby90KvNAKHpRpzMSkZFFA12OZ08EllCrxG2GwAs75tgswgx0mqp5dfWWue8ZWsRoEBCWHuHYWbATjH9ye1yXJZBTrSI9nNeMCBW"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "bllJyTf82dUijKRuxZRZa4vWhPrIT33Imkx7B8MNYqsH7ZYV39Cbo1hE8nGO01pMP"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "mqsDFQgn50rvjqn1e9eHIIpYVR0ot8Uk7SCNZ4X6zaKHPm4fn2eRqlflt1xclrzMalglESg9lIYOuxXhLN2jFjmhfKOVJmbafmTEgItqamR0JnD1JjRSZ06C2eFahRms5B3s7rFjlM18Heuaxl8WO2cMhOh0gg1nLD2wXdZKIqIkib2ZItlnMdldGjfPeikGxpx2gjeOqxkn5GXkxM6OyYnPd1FPd3DLg1Gv6EQz03JjYftsplX8uYk8dpqnFFf7E"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "hXkMYz6CRZrZ559DOlSO3s3uZhZmw6G8aAgQBRlui04khP8OlS6MVprz02n4Iwl8V50stsID2ezoXmFs9uTa5e8B9KOXX8GY3gXpF1kxKhFxtO5ExWhRP1HIuMQAYOOHIHgBMj3JFgTII74HPlLuPcetYZaP70vt4aui8mQWHRka1F0z6Qzt4gn9Zx94ubt2KIOijwlUSYwMks90eU65hZLdX8EM2JeLrXRDZZhIT42xBjvTQl7zqlaS9Q7fe8SBJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "jIpNXAg36eDeTCYzQlVdXrNSkIYupROSD5IyZeQisbvcgMeJWPexNgNIaGWua1gkGdVyzRdM1XxBEho03opztj0moW7CTUbDsOAGr1yiyVPgDx6b2tOhYKV5VoV9uHubwzHOOUtPQty2Lp91VlXLqzLDqSXwOE2hDCqo4eZjQwcI1hXm1xmCHUZDerVHPizCaEZrhh5J84WxiaUbNqFSvp23M0xs5XVaFctnMHGYMG9S42VctH75jrsLQeXaNwVRF"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 175));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "PwPLvXMfZfRKKtAXIggAa4V4frVDDn3dycngUnIMwU6Vce0F6KltfPfpa5HNRFAH2zZ6QyA6OHaiP96PPRouuJR6pzmAp5ECMPSD8tu8Go8byv0ra4fFL9sajU0kJSkPdDFDQZAWRVSc3fpJPbqUJPbkScpLae2b8BkzjzkXksqLc6Ohb81osMFCbxnCT6B4QErbfECSMLS5ftQLzrbmhig9oo0He9EYwL11H8BVEKPwMkv8U6UXlRwY3SIkvgxCU"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "HwcREcohUye5SFCYei5co"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CoreContacts corecontacts = createCoreContacts(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = corecontacts.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 2:
                        corecontacts.setFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 3:
                        corecontacts.setMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 5:
                        corecontacts.setLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 6:
                        corecontacts.setNativeTitle(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 7:
                        corecontacts.setNativeFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 8:
                        corecontacts.setNativeMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 9:
                        corecontacts.setNativeLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 10:
                        corecontacts.setAge(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 12:
                        corecontacts.setEmailId(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 13:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 14:
                        corecontacts.setPhoneNumber(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
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
